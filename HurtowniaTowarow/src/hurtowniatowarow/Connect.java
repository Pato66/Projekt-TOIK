package hurtowniatowarow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
/**
 * Klasa zawierająca metody pozwalajece na wykonywaniwe działań na bazie danych.
 * @author student
 */
public class Connect {
    public String driver = "org.postgresql.Driver";
    public String host ="193.193.92.209:5434"; //"localhost";
    public String dbname = "2015_hudy_patryk";//"Kienci";
    public String user = "2015_hudy_patryk";//postgresql
    public String url = "jdbc:postgresql://" + host + "/" + dbname;
    private final String pass = "25930";//"gothic66"
    /*
    public String host ="localhost";
    public String dbname = "Klienci";
    public String user = "postgresql";
    public String url ="jdbc:postgresql://" + host + "/" + dbname;
    private final String pass = "gothic66";*/
    public Connection connection;
    /**
     * Konstruktor bezargumentowy przypisujący referencje z metody makeConnection()
     */
    public Connect() {
        connection = makeConnection();
    }
    /**
     * Metoda zwracająca połączenie do bazy danych
     * @return 
     */
    public Connection getConnection() {
        return(connection); 
    }
    /**
     * Metoda zamykajaca aktualne połaczenie z baza danych
     * @throws SQLException 
     */
    public void close() throws SQLException {
        connection.close();
    }
    //--------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalajaca na połączenie sie z baza danych na serwerze zwracająca utworzone połączenie.
     * W przypadku niepowodzenia zwracany jest null.
     * @return 
     */
    public Connection makeConnection() {
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Połączono z bazą " + dbname);
            Statement st = connection.createStatement();
            return(connection);
        }
        catch(ClassNotFoundException cnfe) {
            System.err.println("Blad ladowania sterownika: " + cnfe);
            return(null);
        }
        catch(SQLException sqle) {
            System.err.println("Blad przy nawiązywaniu polaczenia: " + sqle);
            return(null);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------

    /**
     * Metoda pozwalajaca wybrac z bazy danych wszystkich zarejestrowanych klientów oraz wyświetlić
     * w konsoli ich pełnaliste wraz z id, loginem, hasłem oraz emailem
     * @throws SQLException
     */
    public void selectFromDatabase() throws SQLException{
            int id;
            String imie,nazwisko,login,haslo,email;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM hurtownia.klienci");
            while (rs.next()) {
                id = rs.getInt("id_klienta");
                imie = rs.getString("imie");
                nazwisko = rs.getString("nazwisko");
                login=rs.getString("login");
                haslo=rs.getString("haslo");
                email=rs.getString("email");
                
                System.out.print("ID: " + id);
                System.out.print(", Name: " + imie);
                System.out.print(", Surname: " + nazwisko);
                System.out.print("Login: " + login);
                System.out.print("haslo: " + haslo);
                System.out.print("email: " + email);
            }
            rs.close();
            st.close();
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda zwracająca typ boolean pozwalajaca na sprawdzenie przy logowaniu czy podany login i hasło śa prawidłowe tzn.
     * czy uzytkownik o podanym loginie i hasle istnieje w bazie danych.
     * @param nick login pobrany z pola tekstowego przekazany do metody
     * @param password hasło pobrane z pola tekstowego przekazane do metody
     * @return
     * @throws SQLException 
     */
    public boolean checkUser(String nick,String password) throws SQLException{
        String dNick="",dPass="";
        Statement st= connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM hurtownia.klienci WHERE login='"+nick+"';");
        while(rs.next()){
            dNick=rs.getString("login");
            dPass=rs.getString("haslo");
        }
        if(dNick=="" || dPass==""){
            return false;
        }
        if(nick.equals(dNick) && password.equals(dPass)){
            System.out.println("Znaleziono usera");
             st.close();
            return true;
        }
        else{
            System.out.println("Nie znaleziono usera");
             st.close();
            return false;
        }              
    }
    //--------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalajaca sprawdzić przy rejestracji nowego klienta czy login który dla
     * siebie wybrał nie jest juz zajety w bazie
     * @param log login pobrany z pola tekstowego przekazany do metody
     * @return
     * @throws SQLException 
     */
    public boolean checkLogin(String log)throws SQLException{
        boolean flaga=true;
        try{
            Statement st = connection.createStatement();
            ResultSet rs= st.executeQuery("SELECT login FROM hurtownia.klienci");
            while(rs.next()){
                if(log.equals(rs.getString("login"))){
                    flaga=false;
                }
            }
         }catch (SQLException ex) {
            System.out.println("Login zajety");
        }
        return flaga;
    }
    //-------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalająca na dodanie do bazy nowego uzytkownika zwracajaaca komunikat tekstowy w konsoli o powodzeniu badz niepowodzeniu dodania.
     * @param login login nowego uzytkownika
     * @param haslo hasło nowego uzytkownika
     * @param nowe_imie imie nowego użytkowniak
     * @param nowe_nazwisko nazwisko nowego użytkownika
     * @param email adres email nowego użytkowniaka
     * @param adres id adresu nowego użytkownika w tabeli Adresy 
     * @throws SQLException 
     */
    public void  addToDatabase(String login,String haslo,String nowe_imie, String nowe_nazwisko,String email,int adres) throws SQLException
    {
        try{
            Statement st = connection.createStatement();
            String liczba="";
            int max=0;
            ResultSet rs= st.executeQuery("SELECT id_klienta FROM hurtownia.klienci ORDER BY id_adresu DESC LIMIT 1");
            while(rs.next()){
                liczba=rs.getString("id_klienta");
            }
              max=Integer.parseInt(liczba)+1;
            st.executeUpdate("INSERT INTO hurtownia.klienci (id_klienta,login, haslo, imie, nazwisko,email,id_adresu)"
                            + " VALUES ("+max+",'"+login+"','"+haslo+"','"+ nowe_imie+"','"+ nowe_nazwisko+"','"+email+"',"+adres+");");
            st.close();
            System.out.println("Dodano klienta");
        }catch (SQLException ex) {
            System.out.println("Nie dodano klienta");
        }
    }
     //--------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalająca na dodanie adresu dla nowo zarejestrowanego użytkownika.
     * @param kraj kraj z którego pochodzi nowy uzytkownik
     * @param wojewodztwo opcjonalne wojewodztwo z którego pochodzi nowy użytkownik
     * @param miejscowosc miejscowośc z której pochodzi nowy uzytkownik
     * @param ulica ulica na której mieszka nowy użytkownik
     * @param numerDomu numer domu nowego uzytkowniaka
     * @return
     * @throws SQLException 
     */
    public int  addToAddress(String kraj,String wojewodztwo,String miejscowosc, String ulica,String numerDomu)throws SQLException
    {
        int max=0;
        try{
            System.out.println("--------------addToAdress--------------------");
            Statement st = connection.createStatement();
            String liczba="";
             System.out.println("przed result set");
            ResultSet rs= st.executeQuery("SELECT id_adresu FROM hurtownia.adresy ORDER BY id_adresu DESC LIMIT 1");
            System.out.println("po result set");
            while(rs.next()){
                liczba=rs.getString("id_adresu");
            }
            max=Integer.parseInt(liczba)+1;
            ResultSet rs2= st.executeQuery("INSERT INTO hurtownia.adresy (id_adresu,kraj,wojewodztwo,miejscowosc,ulica,nr_domu) "
                    + "VALUES ("+max+",'"+kraj+"','"+ wojewodztwo+"','"+miejscowosc +"','"+ ulica+"','"+numerDomu +"');");
            st.close();
            return max;
        }catch (SQLException ex) {
            //System.out.println("Nie dodano adresu");
            return max;
        }
       
    }
    //---------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalająca na znalezienie w bazie danych towarów zawierających podana fraze
     * @param doWyszukania fraza która ma zostac wyszukana w bazie danych w tabeli Towary
     * @return
     * @throws SQLException 
     */
    public Towar searchPhrase(String doWyszukania) throws SQLException{
        String nazwa="",ilosc="",cena="";
        Statement st= connection.createStatement();
        //ResultSet rs = st.executeQuery("SELECT * FROM hurtownia.towary WHERE nazwa_towaru='"+doWyszukania+"';");
         ResultSet rs = st.executeQuery("SELECT * FROM hurtownia.towary WHERE nazwa_towaru LIKE '%"+doWyszukania+"%';");
        while(rs.next()){
            nazwa=rs.getString("nazwa_towaru");
            ilosc=rs.getString("ilosc");
            cena=rs.getString("cena");
        }
        Towar t=new Towar(nazwa,ilosc,cena);
        return t;
    }
    //---------------------------------------------------------------------------------------------------------------------
    /**
     * 
     * @param nazwa nazwa towaru dla którego ma byc sprawdzona dostępność
     * @param ilosc ilość towaru dla którego ma byc wykonane sprawdzenie
     * @return
     * @throws SQLException 
     */
    public boolean checkAvailability(String nazwa,String ilosc) throws SQLException{
        String ileMagazyn="";
        Statement st= connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT ilosc FROM hurtownia.towary WHERE nazwa_towaru='"+nazwa+"';");
        while(rs.next()){
             ileMagazyn=rs.getString("ilosc");
         }
        if(Integer.parseInt(ileMagazyn)>= Integer.parseInt(ilosc)){
            st.executeUpdate("UPDATE hurtownia.towary SET ilosc="+(Integer.parseInt(ileMagazyn)-Integer.parseInt(ilosc))+
                             "WHERE nazwa_towaru='"+nazwa+"';");
            return true;
        }
        else{
            return false;
        }
         
    }
    //---------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalająca na usunięcie towarów z koszyka podczas składania zamowienia
     * @param nazwa nazwa towaru do usuniecia z koszyka
     * @param ilosc ilośc towaru do usuniecia z koszyka
     * @throws SQLException 
     */
    public void removeFromBasket(String nazwa,String ilosc) throws SQLException{
        String ileMagazyn="";
        Statement st= connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT ilosc FROM hurtownia.towary WHERE nazwa_towaru='"+nazwa+"';");
        while(rs.next()){
             ileMagazyn=rs.getString("ilosc");
        }
        st.executeUpdate("UPDATE hurtownia.towary SET ilosc="+(Integer.parseInt(ileMagazyn)+Integer.parseInt(ilosc))+
                         "WHERE nazwa_towaru='"+nazwa+"';");
    }
    //---------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalająca na znalezienie w bazie danych towarów zawierających podana fraze
     * @param doWyszukania fraza która ma zostac wyszukana w bazie danych w tabeli Towary
     * @return
     * @throws SQLException 
     */ 
    public ArrayList searchPhrase2(String doWyszukania) throws SQLException{
        String nazwa="",ilosc="",cena="";
        ArrayList<Towar> towary=new ArrayList<Towar>();
        Statement st= connection.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM hurtownia.towary WHERE nazwa_towaru LIKE '%"+doWyszukania+"%';");
        while(rs.next()){
            nazwa=rs.getString("nazwa_towaru");
            ilosc=rs.getString("ilosc");
            cena=rs.getString("cena");
            Towar t=new Towar(nazwa,ilosc,cena);
            towary.add(t);
        }
        System.out.println(towary.size());
        return towary;
    }
    //---------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalajaca wykonac zapytanie do bazy i złożyć zamówienie. 
     * @param wyniki lista towarów do zamówienia
     * @param login login osoby zarabiającej
     * @throws SQLException 
     */ 
    public void makeOrder(ArrayList<Towar> wyniki, String login) throws SQLException{
         Statement st= connection.createStatement();
         int max=0;
         String liczba="",id="",id_towaru="";
         ResultSet rs= st.executeQuery("SELECT id_zamowienia FROM hurtownia.zamowienia ORDER BY id_zamowienia DESC LIMIT 1");
         while(rs.next()){
             liczba=rs.getString("id_zamowienia");
         }
         max=Integer.parseInt(liczba)+1;
         System.out.println("MAX: "+max);
         ResultSet rs2=st.executeQuery("SELECT * FROM hurtownia.klienci WHERE login='"+login+"';");
         while(rs2.next()){
            id=rs2.getString("id_klienta");
         }
         st.execute("INSERT INTO hurtownia.zamowienia VALUES("+max+","+Integer.parseInt(id)+",CURRENT_DATE,'w realizacji');");

         System.out.println("Przed for size="+wyniki.size());
         for(int k=0;k<wyniki.size();k++){
            System.out.println("pocz");
            ResultSet rs3=st.executeQuery("SELECT * FROM hurtownia.towary WHERE nazwa_towaru='"+wyniki.get(k).nazwa+"';");
            System.out.println("przed while");
            while(rs3.next()){
               System.out.println("petla...");
               id_towaru=rs3.getString("id_towaru");
               System.out.println("po id_towaru... "+id_towaru);
            }
            //id_towaru=Integer.toString(k);
            System.out.println("ID_TOWARU: "+id_towaru);
            st.execute("INSERT INTO hurtownia.szczegoly_zamowienia VALUES("+max+","+Integer.parseInt(id_towaru)
                      +","+Integer.parseInt(id)+","+wyniki.get(k).ilosc+","+wyniki.get(k).cena+");");
         }
         System.out.println("--------------KONIEC-----------");
     }
    //--------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalająca sprawdzic istnienie użytkownika o podanym email, ulicy i numerze domu.
     * Przydatna przy odzyskiwaniu loginu/hasła
     * @param email adres email uzytkownika
     * @param ulica ulica podana przez użytkownika
     * @param nrDomu numer domu podany przez użytkownika
     * @return
     * @throws SQLException 
     */
    public boolean CheckData(String email,String ulica, String nrDomu) throws SQLException{
         Statement st= connection.createStatement();
         String adresEmail="";
         ResultSet rs= st.executeQuery("SELECT email,ulica,nr_domu FROM hurtownia.klienci,hurtownia.adresy "
                 + "WHERE klienci.id_adresu=adresy.id_adresu and email='"+email+"' and ulica='"+ulica+"' and nr_domu='"+nrDomu+"';");
         while(rs.next()){
             adresEmail=rs.getString("email");
         }
         if(adresEmail == ""){
             return false;
         }
         else{
             return true;
         }
    }
    //------------------------------------------------------------------------------------------------------------
    /**
     * Metoda zwracająca login oraz hasło dla klienta o podanym emailu, ulicy i numerze domu
     * @param email email uzytkownika chcącego odzyskać login/hasło
     * @param ulica ulica uzytkownika chcącego odzyskać login/hasło
     * @param nrDomu numer domu uzytkownika chcącego odzyskać login/hasło
     * @return
     * @throws SQLException 
     */
    public DaneLogowania giveLOginAndPassword(String email,String ulica, String nrDomu) throws SQLException{
        Statement st= connection.createStatement();
         String log="",pass="";
         ResultSet rs= st.executeQuery("SELECT login,haslo FROM hurtownia.klienci,hurtownia.adresy "
                 + "WHERE klienci.id_adresu=adresy.id_adresu and email='"+email+"' and ulica='"+ulica+"' and nr_domu='"+nrDomu+"';");
         while(rs.next()){
             log=rs.getString("login");
             pass=rs.getString("haslo");
         }
        return new DaneLogowania(log,pass);
    }
    //---------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda wybierająca z bazy wszystkie podstawowe dane klienta oraz zwraca tablice z tymi elementami w kolejności:
     * hasło, imie, nazwisko, email, numer domu, ulica, miejscowosc, wojewodztwo, kraj
     * 
     * @param log login klienta dla którego chcemy wybrac dane
     * @return
     * @throws SQLException 
     */
    public String[] fillField(String log) throws SQLException{
        String[] tab=new String[9];
        Statement st= connection.createStatement();
        ResultSet rs= st.executeQuery("SELECT * FROM hurtownia.klienci INNER JOIN hurtownia.adresy USING(id_adresu) WHERE login='"+log+"';");
        while(rs.next()){
            tab[0]=rs.getString("haslo");
            tab[1]=rs.getString("imie");
            tab[2]=rs.getString("nazwisko");
            tab[3]=rs.getString("email");
            tab[4]=rs.getString("nr_domu");
            tab[5]=rs.getString("ulica");
            tab[6]=rs.getString("miejscowosc");
            tab[7]=rs.getString("wojewodztwo");
            tab[8]=rs.getString("kraj");
        }
        return tab;
    }
    //-----------------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalająca dokonać aktualizacji danych klienta w bazie danych
     * @param log login klienta dla którego wykonujemy update danych
     * @param noweDane tablica z nowymi danymi pobranymi z formularza
     * @return
     * @throws SQLException 
     */
    public boolean updateMyData(String log, String noweDane[]) throws SQLException{

        Statement st= connection.createStatement();
        int id_adresu=0;
        ResultSet rs3= st.executeQuery("SELECT id_adresu FROM hurtownia.klienci WHERE login='"+log+"';");
        while(rs3.next()){
          id_adresu=rs3.getInt("id_adresu");
        }
        int rs= st.executeUpdate("UPDATE hurtownia.adresy SET nr_domu='"+noweDane[4]+"',ulica='"+noweDane[5]+"',miejscowosc='"+noweDane[6]+
                "',wojewodztwo='"+noweDane[7]+"',kraj='"+noweDane[8]+"' WHERE id_adresu="+id_adresu+";");       
        int rs2= st.executeUpdate("UPDATE hurtownia.klienci SET haslo='"+noweDane[0]+"',imie='"+noweDane[1]+"',nazwisko='"+noweDane[2]+
                "',email='"+noweDane[3]+"' WHERE login='"+log+"';");
        System.out.println("RS1="+rs+" , RS2="+rs2);
        if(rs ==1 && rs2==1){
            return true;
        }
        else{
            return false;
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalająca wybrać historię rezerwacji dla klienta o podanym loginie z ostatnich 60 dni
     * @param log login klienta dla którego wybieramy z bazy historię
     * @return
     * @throws SQLException 
     */ 
    public ArrayList zwroc_rezerwacje(String log) throws SQLException{
        
        String id_zamowienia;
        String towar;
        String ilosc;
        String cena; 
        String data;
        //String[] zwroc = new String[4];
        ArrayList<ZwroconeRezerwacje> tablica= new ArrayList<ZwroconeRezerwacje>();
        
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("SELECT zamowienia.id_zamowienia,towary.nazwa_towaru,szczegoly_zamowienia.ilosc,szczegoly_zamowienia.cena,zamowienia.data_zamowienia \n" +
                                     "FROM hurtownia.klienci INNER JOIN hurtownia.zamowienia\n" +
                                     "ON klienci.id_klienta=zamowienia.id_klienta INNER JOIN hurtownia.szczegoly_zamowienia\n" +
                                     "ON zamowienia.id_zamowienia=szczegoly_zamowienia.id_zamowienia INNER JOIN hurtownia.towary\n" +
                                     "ON szczegoly_zamowienia.id_towaru=towary.id_towaru WHERE klienci.login='"+log+"' AND data_zamowienia > CURRENT_DATE - interval'60 days'\n" +
                                     "ORDER BY zamowienia.data_zamowienia DESC,zamowienia.id_zamowienia DESC");
        
        while(rs.next()){
            id_zamowienia=rs.getString("id_zamowienia");
            towar=rs.getString("nazwa_towaru");
            ilosc=rs.getString("ilosc");
            cena=rs.getString("cena");
            data=rs.getString("data_zamowienia");
            ZwroconeRezerwacje zr=new ZwroconeRezerwacje(id_zamowienia,towar,ilosc,cena,data);
            tablica.add(zr);
        
       }
        return tablica; 
    }
    //-----------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda sprawdzająca czy nowo zarejestrowany uzytkownik dokonał uzupełnienia danych
     * brakujących do możliwości złożenia zamówienia
     * @param log login klienta dla którego dokonujemy sprawdzenia czy uzupełnił dane
     * @return
     * @throws SQLException 
     */ 
    public boolean czy_uzupelnione(String log) throws SQLException{
         Statement st=connection.createStatement();
         String imie="",nazwisko="",miejscowosc="",ulica="",nrDomu="";
         System.out.println(log);
         ResultSet rs=st.executeQuery("SELECT imie,nazwisko,miejscowosc,ulica,nr_domu FROM hurtownia.klienci INNER JOIN hurtownia.adresy"
                 + " USING(id_adresu) WHERE login='"+log+"';");
         while(rs.next()){
             imie=rs.getString("imie");
             nazwisko=rs.getString("nazwisko");
             miejscowosc=rs.getString("miejscowosc");
             ulica=rs.getString("ulica");
             nrDomu=rs.getString("nr_domu");
         }
         System.out.println(imie+", "+nazwisko+", "+nrDomu);
         if(imie.equals("podaj imie") || nazwisko.equals("podaj nazwisko") || miejscowosc.equals("podaj miejscowosc") ||ulica.equals("podaj ulice")
                 || nrDomu.equals("00")){
             System.out.println("Uzupelnij!");
             return false;
         }
         else{
             System.out.println("Ok");
            return true;
         }
     }
    //----------------------------------------------------------------------------------------------------------------------- 
    public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Connect  okienko = new Connect();
                okienko.makeConnection();
                try {                          
                    okienko.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
