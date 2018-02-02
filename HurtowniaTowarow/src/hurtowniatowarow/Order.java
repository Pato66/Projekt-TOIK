package hurtowniatowarow;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 * Klasa pozwalająca na przeszukiwanie bazy danych oraz dodawanie do koszyka nowych towarów
 * @author Patryk
 */
public class Order extends javax.swing.JFrame {
    String log,doWyszukania;
    JFrame j3;
    Integer i=0;
    ArrayList<Towar> towary=new ArrayList<Towar>();
    ArrayList<Towar> wyniki=new ArrayList<Towar>();
    
        //--------------------------------------------------------------------------
    /**
     * Metoda pokazująca wyszukane wczesniej towary z bazy danych
     * @param i
     * @return 
     */
    public Integer pokaz(Integer i){   
        int a=0;
        System.out.println("pokaz() i="+i);
        for(a=0;i<wyniki.size() && a<5;i++,a++){ 
            if(i%5==0){
                nazwa1.setText(wyniki.get(i).nazwa);
                cena1.setText(wyniki.get(i).cena);
                ilosc1.setVisible(true);
                dodaj.setVisible(true);
                cena1.setVisible(true);
                nazwa1.setVisible(true);
               // i++;
               // a++;
            }
            if(i%5==1){
                nazwa2.setText(wyniki.get(i).nazwa);
                cena2.setText(wyniki.get(i).cena);
                ilosc2.setVisible(true);
                dodaj2.setVisible(true);
                cena2.setVisible(true);
                nazwa2.setVisible(true);
               // i++;
               // a++;
            }
            if(i%5==2){
                nazwa3.setText(wyniki.get(i).nazwa);
                cena3.setText(wyniki.get(i).cena);
                ilosc3.setVisible(true);
                dodaj3.setVisible(true);
                cena3.setVisible(true);
                nazwa3.setVisible(true);
               // i++;
               // a++;
            }
            if(i%5==3){
                nazwa4.setText(wyniki.get(i).nazwa);
                cena4.setText(wyniki.get(i).cena);
                ilosc4.setVisible(true);
                dodaj4.setVisible(true);
                cena4.setVisible(true);
                nazwa4.setVisible(true);
               // i++;
               // a++;
            }
            if(i%5==4){
                nazwa5.setText(wyniki.get(i).nazwa);
                cena5.setText(wyniki.get(i).cena);
                ilosc5.setVisible(true);
                dodaj5.setVisible(true);
                cena5.setVisible(true);
                nazwa5.setVisible(true);
               // i++;
              //  a++;
            }
        } 
            System.out.println("PO pokaz() i="+i+" a:"+a);
            for(;a<5;a++){
                if(a==1){
                    ilosc2.setVisible(false);
                    dodaj2.setVisible(false);
                    cena2.setVisible(false);
                    nazwa2.setVisible(false);
                }
                 if(a==2){
                    ilosc3.setVisible(false);
                    dodaj3.setVisible(false);
                    cena3.setVisible(false);
                    nazwa3.setVisible(false);
                }
                  if(a==3){
                    ilosc4.setVisible(false);
                    dodaj4.setVisible(false);
                    cena4.setVisible(false);
                    nazwa4.setVisible(false);
                }
                   if(a==4){
                    ilosc5.setVisible(false);
                    dodaj5.setVisible(false);
                    cena5.setVisible(false);
                    nazwa5.setVisible(false);
                }
            }
        return i;
    }
    //--------------------------------------------------------------------------
    
    /**
     * Konstruktor dwuargumentowy przyjmujący uchwyt do okna rodzica oraz login klienta
     */
    public Order(JFrame j3,String log) {
        initComponents();
        getContentPane().setBackground(new Color(70,160,250));
        this.log=log;
        this.j3=j3;
        etykieta1.setText("Jesteś zalogowany jako "+log);
        dodaj.setVisible(false);
        dodaj2.setVisible(false);
        dodaj3.setVisible(false);
        dodaj4.setVisible(false);
        dodaj5.setVisible(false);
        ilosc1.setVisible(false);
        ilosc2.setVisible(false);
        ilosc3.setVisible(false);
        ilosc4.setVisible(false);
        ilosc5.setVisible(false);
        /*nazwa1.setVisible(false);
        nazwa2.setVisible(false);
        nazwa3.setVisible(false);
        nazwa4.setVisible(false);
        nazwa5.setVisible(false);
        cena1.setVisible(false);
        cena2.setVisible(false);
        cena3.setVisible(false);
        cena4.setVisible(false);
        cena5.setVisible(false);*/
        
        setVisible(true);
       
    }
    /**
     * Konstruktor bezargumentowy na potrzeby testów
     */
    private Order() {
        initComponents();
        getContentPane().setBackground(new Color(70,160,250));
        setVisible(true);
        dodaj.setVisible(false);
        dodaj2.setVisible(false);
        dodaj3.setVisible(false);
        dodaj4.setVisible(false);
        dodaj5.setVisible(false);
        ilosc1.setVisible(false);
        ilosc2.setVisible(false);
        ilosc3.setVisible(false);
        ilosc4.setVisible(false);
        ilosc5.setVisible(false);
        /*nazwa1.setVisible(false);
        nazwa2.setVisible(false);
        nazwa3.setVisible(false);
        nazwa4.setVisible(false);
        nazwa5.setVisible(false);
        cena1.setVisible(false);
        cena2.setVisible(false);
        cena3.setVisible(false);
        cena4.setVisible(false);
        cena5.setVisible(false);*/
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        wyszukiwanie = new javax.swing.JTextField();
        szukaj = new javax.swing.JButton();
        cofnij = new javax.swing.JButton();
        etykieta1 = new javax.swing.JLabel();
        nazwa1 = new javax.swing.JLabel();
        cena1 = new javax.swing.JLabel();
        dodaj = new javax.swing.JButton();
        pokaz = new javax.swing.JButton();
        ilosc1 = new javax.swing.JTextField();
        nazwa2 = new javax.swing.JLabel();
        nazwa4 = new javax.swing.JLabel();
        nazwa5 = new javax.swing.JLabel();
        nazwa3 = new javax.swing.JLabel();
        ilosc5 = new javax.swing.JTextField();
        ilosc4 = new javax.swing.JTextField();
        ilosc2 = new javax.swing.JTextField();
        ilosc3 = new javax.swing.JTextField();
        cena2 = new javax.swing.JLabel();
        cena3 = new javax.swing.JLabel();
        cena4 = new javax.swing.JLabel();
        cena5 = new javax.swing.JLabel();
        dodaj2 = new javax.swing.JButton();
        dodaj3 = new javax.swing.JButton();
        dodaj4 = new javax.swing.JButton();
        dodaj5 = new javax.swing.JButton();
        poprzedni = new javax.swing.JButton();
        nastepny = new javax.swing.JButton();
        komunikat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Wyszukaj");

        wyszukiwanie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyszukiwanieActionPerformed(evt);
            }
        });
        wyszukiwanie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                wyszukiwanieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                wyszukiwanieKeyTyped(evt);
            }
        });

        szukaj.setText("Szukaj");
        szukaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szukajActionPerformed(evt);
            }
        });

        cofnij.setText("Cofnij");
        cofnij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cofnijActionPerformed(evt);
            }
        });

        etykieta1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        etykieta1.setText("...");

        nazwa1.setText(".");

        cena1.setText(".");

        dodaj.setText("Dodaj");
        dodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajActionPerformed(evt);
            }
        });

        pokaz.setText("Pokaż koszyk");
        pokaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokazActionPerformed(evt);
            }
        });

        ilosc1.setText("0");

        nazwa2.setText(".");

        nazwa4.setText(".");

        nazwa5.setText(".");

        nazwa3.setText(".");

        ilosc5.setText("0");

        ilosc4.setText("0");

        ilosc2.setText("0");

        ilosc3.setText("0");
        ilosc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilosc3ActionPerformed(evt);
            }
        });

        cena2.setText(".");

        cena3.setText(".");

        cena4.setText(".");

        cena5.setText(".");

        dodaj2.setText("Dodaj");
        dodaj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodaj2ActionPerformed(evt);
            }
        });

        dodaj3.setText("Dodaj");
        dodaj3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodaj3ActionPerformed(evt);
            }
        });

        dodaj4.setText("Dodaj");
        dodaj4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodaj4ActionPerformed(evt);
            }
        });

        dodaj5.setText("Dodaj");
        dodaj5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodaj5ActionPerformed(evt);
            }
        });

        poprzedni.setText("Poprzedni");
        poprzedni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poprzedniActionPerformed(evt);
            }
        });

        nastepny.setText("Nastepny");
        nastepny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nastepnyActionPerformed(evt);
            }
        });

        komunikat.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        komunikat.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etykieta1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(komunikat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nazwa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nazwa1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(nazwa4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nazwa5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nazwa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(poprzedni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nastepny)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(ilosc1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(ilosc5)
                                            .addComponent(ilosc4)
                                            .addComponent(ilosc3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addComponent(ilosc2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cena2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(dodaj2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cena3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(dodaj3))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cena1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(dodaj))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cena4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(dodaj4))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(cena5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(dodaj5)))
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(wyszukiwanie, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cofnij, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pokaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(szukaj, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etykieta1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(wyszukiwanie, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cena1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(nazwa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dodaj)
                    .addComponent(ilosc1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ilosc2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nazwa2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cena2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dodaj2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazwa3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ilosc3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cena3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dodaj3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ilosc4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cena4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dodaj4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nazwa4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nazwa5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ilosc5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cena5)
                            .addComponent(dodaj5))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(poprzedni)
                    .addComponent(nastepny))
                .addGap(22, 22, 22)
                .addComponent(komunikat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cofnij, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(szukaj, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pokaz, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wyszukiwanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyszukiwanieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wyszukiwanieActionPerformed
    /**
     * Metoda pozwalająca cofnąć do okna rodzica
     * @param evt 
     */
    private void cofnijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cofnijActionPerformed
        j3.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cofnijActionPerformed
    /**
     * Medoda wyszukująca w bazie towary w których wystepuje podana fraza
     * @param evt 
     */
    private void szukajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szukajActionPerformed
        Towar wynik=new Towar("","","");
        i=0;
        //System.out.println("Po pokaz() i="+i);
        while(wyniki.size()!=0){
                System.out.println("usuwam"+ wyniki.get(0));
                wyniki.remove(0);
            }
        if(wyniki.size()==0){
            System.out.println("ROZMIAR ZERO");
        }
        try {
            doWyszukania=wyszukiwanie.getText();
            Connect con1=new Connect();
            wyniki=con1.searchPhrase2(doWyszukania);
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("ZACZYNAMY");
        i=pokaz(i);
        System.out.println(" szukaj PO WYJSCIU Z FUNKCJI i="+i);      
    }//GEN-LAST:event_szukajActionPerformed
    /**
     * Metoda pozwalająca dodać do koszyka nowy towar
     * @param evt 
     */
    private void dodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajActionPerformed
        Connect polaczenie=new Connect();
        try {
            if(polaczenie.checkAvailability(nazwa1.getText(),ilosc1.getText())){
                Towar t=new Towar(nazwa1.getText(),ilosc1.getText(),cena1.getText());
                towary.add(t);
                komunikat.setText("Dodano do koszyka towar: "+nazwa1.getText());
            }
            else{
                komunikat.setText("Za mało towaru: "+nazwa1.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dodajActionPerformed
    /**
     * Metoda wywołująca okno, które pokazuje szczegóły zamówienia
     * @param evt 
     */
    private void pokazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokazActionPerformed
        Details koszyk =new Details(towary,log);
    }//GEN-LAST:event_pokazActionPerformed

    private void ilosc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilosc3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ilosc3ActionPerformed
    /**
     * Metoda dodająca do koszyka nowy towar
     * @param evt 
     */
    private void dodaj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodaj2ActionPerformed
        Connect polaczenie=new Connect();
        try {
            if(polaczenie.checkAvailability(nazwa2.getText(),ilosc2.getText())){
                Towar t=new Towar(nazwa2.getText(),ilosc2.getText(),cena2.getText());
                towary.add(t);
                komunikat.setText("Dodano do koszyka towar: "+nazwa2.getText());
            }
            else{
                komunikat.setText("Za mało towaru: "+nazwa2.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dodaj2ActionPerformed
    /**
     * Metoda dodająca do koszyka nowy towar
     * @param evt 
     */
    private void dodaj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodaj3ActionPerformed
       Connect polaczenie=new Connect();
        try {
            if(polaczenie.checkAvailability(nazwa3.getText(),ilosc3.getText())){
                Towar t=new Towar(nazwa3.getText(),ilosc3.getText(),cena3.getText());
                towary.add(t);
                komunikat.setText("Dodano do koszyka towar: "+nazwa3.getText());
            }
            else{
                komunikat.setText("Za mało towaru: "+nazwa3.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dodaj3ActionPerformed
    /**
     * Metoda dodająca do koszyka nowy towar
     * @param evt 
     */
    private void dodaj4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodaj4ActionPerformed
       Connect polaczenie=new Connect();
        try {
            if(polaczenie.checkAvailability(nazwa4.getText(),ilosc4.getText())){
                Towar t=new Towar(nazwa4.getText(),ilosc4.getText(),cena4.getText());
                towary.add(t);
                komunikat.setText("Dodano do koszyka towar: "+nazwa4.getText());
            }
            else{
                komunikat.setText("Za mało towaru: "+nazwa4.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dodaj4ActionPerformed
    /**
     * Metoda dodająca do koszyka nowy towar
     * @param evt 
     */
    private void dodaj5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodaj5ActionPerformed
       Connect polaczenie=new Connect();
        try {
            if(polaczenie.checkAvailability(nazwa5.getText(),ilosc5.getText())){
                Towar t=new Towar(nazwa5.getText(),ilosc5.getText(),cena5.getText());
                towary.add(t);
                komunikat.setText("Dodano do koszyka towar: "+nazwa5.getText());
            }
            else{
                komunikat.setText("Za mało towaru: "+nazwa5.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dodaj5ActionPerformed
//-------------------------------------------------------------------------------------------------------------------------
    /**
     * Metoda pozwalająca wczytać kolejne dane z bazy danych wyszukane dla danej frazy
     * @param evt 
     */
    private void nastepnyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nastepnyActionPerformed
        System.out.println("NEXT:"+i);
        int a=0;
        if(i%5==0){
            i=pokaz(i);
        }
        System.out.println("nastepny PO WYJSCIU Z FUNKCJI i="+i);
    }//GEN-LAST:event_nastepnyActionPerformed
    /**
     * Metoda pozwalająca wczytać poprzednie dane z bazy danych wyszukane dla danej frazy
     * @param evt 
     */
    private void poprzedniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poprzedniActionPerformed
         System.out.println("PREV:"+i);
        int a=0;
        System.out.println("prev przed while i:"+i);
        if(i>4){
            i-=5;
            System.out.println("i%5="+(i%5));
            while( (i%5) != 0){
                System.out.println(i%5);
                i--;
            }
            System.out.println("prev po while i:"+i);
            i=pokaz(i);
            System.out.println("poprzedni PO WYJSCIU Z FUNKCJI i="+i);
        }
    }//GEN-LAST:event_poprzedniActionPerformed

    private void wyszukiwanieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wyszukiwanieKeyTyped
        
    }//GEN-LAST:event_wyszukiwanieKeyTyped

    private void wyszukiwanieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wyszukiwanieKeyReleased
         Towar wynik=new Towar("","","");
        i=0;
        //System.out.println("Po pokaz() i="+i);
        while(wyniki.size()!=0){
                System.out.println("usuwam"+ wyniki.get(0));
                wyniki.remove(0);
            }
        if(wyniki.size()==0){
            System.out.println("ROZMIAR ZERO");
        }
        try {
            doWyszukania=wyszukiwanie.getText();
            Connect con1=new Connect();
            wyniki=con1.searchPhrase2(doWyszukania);
        } catch (SQLException ex) {
            Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("ZACZYNAMY");
        i=pokaz(i);
        System.out.println(" szukaj PO WYJSCIU Z FUNKCJI i="+i);  
    }//GEN-LAST:event_wyszukiwanieKeyReleased
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cena1;
    private javax.swing.JLabel cena2;
    private javax.swing.JLabel cena3;
    private javax.swing.JLabel cena4;
    private javax.swing.JLabel cena5;
    private javax.swing.JButton cofnij;
    private javax.swing.JButton dodaj;
    private javax.swing.JButton dodaj2;
    private javax.swing.JButton dodaj3;
    private javax.swing.JButton dodaj4;
    private javax.swing.JButton dodaj5;
    private javax.swing.JLabel etykieta1;
    private javax.swing.JTextField ilosc1;
    private javax.swing.JTextField ilosc2;
    private javax.swing.JTextField ilosc3;
    private javax.swing.JTextField ilosc4;
    private javax.swing.JTextField ilosc5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel komunikat;
    private javax.swing.JButton nastepny;
    private javax.swing.JLabel nazwa1;
    private javax.swing.JLabel nazwa2;
    private javax.swing.JLabel nazwa3;
    private javax.swing.JLabel nazwa4;
    private javax.swing.JLabel nazwa5;
    private javax.swing.JButton pokaz;
    private javax.swing.JButton poprzedni;
    private javax.swing.JButton szukaj;
    private javax.swing.JTextField wyszukiwanie;
    // End of variables declaration//GEN-END:variables
}
