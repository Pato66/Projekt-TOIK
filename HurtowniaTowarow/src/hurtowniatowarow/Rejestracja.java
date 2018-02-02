/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurtowniatowarow;

import hurtowniatowarow.Connect;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Klasa umożliwiajaca zarejestrowanie się nowego yżytkownika do bazy danych i rozpoczęcie kupowania towarów w sklepie.
 * @author Mati
 */
public class Rejestracja extends javax.swing.JFrame {

    Connect polaczenie = new Connect();
    String Login,Haslo,Imie,Nazwisko,Email,Nrdomu,Ulica,Miejscowosc,Wojewodztwo,Kraj;
    String wstaw;
    Connection c = null;
    Statement stmt = null;
    ResultSet rs=null;
    JFrame oknoRodzic;
    
    /**
     * Konstruktor bezargumentowy na potrzeby testów
     */
    public Rejestracja() {
        initComponents();
        getContentPane().setBackground(new Color(70,160,250));
        this.setVisible(true);
    } 
    /**
     * Konstruktor jednoaagumentowy przyjmujacy uchwyt do okna rodzica
     * @param okno 
     */
    public Rejestracja(JFrame okno) {
        oknoRodzic=okno;
        initComponents();
        getContentPane().setBackground(new Color(70,160,250));
        this.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bWroc = new javax.swing.JButton();
        bZarejestruj = new javax.swing.JButton();
        laLogin = new javax.swing.JLabel();
        tLogin = new javax.swing.JTextField();
        tHaslo = new javax.swing.JTextField();
        laHaslo = new javax.swing.JLabel();
        tEmail = new javax.swing.JTextField();
        laEmail = new javax.swing.JLabel();
        tInformacja = new javax.swing.JTextField();
        laInformacja = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bWroc.setText("Wróć");
        bWroc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bWrocActionPerformed(evt);
            }
        });

        bZarejestruj.setText("Zarejestruj");
        bZarejestruj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZarejestrujActionPerformed(evt);
            }
        });

        laLogin.setText("* Login:");

        laHaslo.setText("* Hasło:");

        laEmail.setText("* Email:");

        laInformacja.setText("Informacja:");

        jLabel1.setText("Pola oznaczone * są obowiązkowe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(laInformacja)
                                .addGap(18, 18, 18)
                                .addComponent(tInformacja, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(laLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(laHaslo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(laEmail, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(tHaslo)
                                    .addComponent(tLogin))))
                        .addGap(18, 18, 18)
                        .addComponent(bZarejestruj))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(bWroc))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bWroc)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laLogin)
                    .addComponent(tLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laHaslo)
                    .addComponent(tHaslo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laEmail)
                    .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tInformacja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bZarejestruj)
                    .addComponent(laInformacja))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metoda pozwalająca powrócić do okna rodzica
     * @param evt 
     */
    private void bWrocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bWrocActionPerformed
        this.dispose();
        oknoRodzic.setVisible(true);
        
    }//GEN-LAST:event_bWrocActionPerformed
    /**
     * Metoda wykonująca rejestracje nowego użytkonika do bazy danych
     * @param evt 
     */
    private void bZarejestrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZarejestrujActionPerformed
        
        Login = tLogin.getText();
        Haslo = tHaslo.getText();
        Imie = "podaj imie";
        Nazwisko = "podaj nazwisko";
        Email = tEmail.getText();
        Nrdomu = "00";
        Ulica = "podaj ulice";
        Miejscowosc = "podaj miejscowosc";
        Wojewodztwo = "podaj wojewodztwo";
        Kraj = "podaj kraj";
        
        
        
      try{  
              boolean czy_wypelnione=true;    
              if(Login.equals("") || Haslo.equals("") || Imie.equals("") || Nazwisko.equals("") || Email.equals("") ||Nrdomu.equals("")
                 || Ulica.equals("") || Miejscowosc.equals("") || Kraj.equals("")){
                  czy_wypelnione=false;
              }
              boolean czy_wolny=polaczenie.checkLogin(Login);
              System.out.println("czy_puste= "+czy_wypelnione+" czy_zajety= "+czy_wolny);
              if(czy_wolny==true && czy_wypelnione==true){
                tInformacja.setText("Zostales zarejestrowany");
                int id_adres=polaczenie.addToAddress(Kraj, Wojewodztwo, Miejscowosc, Ulica,Nrdomu);
                polaczenie.addToDatabase(Login, Haslo, Imie, Nazwisko,Email,id_adres);
                //tInformacja.setText("Zostales zarejestrowany");
                //System.out.println("Adres: "+id_adres);
                SendMail wyslij=new SendMail(Email,"Rejestracja w sklepie internetowym XXX",
                        "Drogi "+Imie+" "+Nazwisko+"\nDziękujemy, Paanu/Pani za rejestrację w naszym sklepie internetowym XXX. Aby dokonywać rezerwacji uziupelnij swoj profil w Edytuj profil"
                                +"\n\n\t\t\t\t Z poważaniem, Biuro Obsługi Klinta");
                wyslij.send();
                Thread t = null;
                t.sleep(3000);
                this.dispose();
                MainWindow mainW= new MainWindow(1); 
              }
              else if(czy_wypelnione ==false){
                 tInformacja.setText("Pola oznaczone gwiazdka sa obowiazkowe"); 
              }
              else if(czy_wolny==false){
                  tInformacja.setText("Login zajety");
              }
               
          }
      catch(Exception e){
          System.err.println(e.getClass().getName()+": "+e.getMessage());
          System.exit(0);
           } 
    }//GEN-LAST:event_bZarejestrujActionPerformed

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
            java.util.logging.Logger.getLogger(Rejestracja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rejestracja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rejestracja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rejestracja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rejestracja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bWroc;
    private javax.swing.JButton bZarejestruj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel laEmail;
    private javax.swing.JLabel laHaslo;
    private javax.swing.JLabel laInformacja;
    private javax.swing.JLabel laLogin;
    private javax.swing.JTextField tEmail;
    private javax.swing.JTextField tHaslo;
    private javax.swing.JTextField tInformacja;
    private javax.swing.JTextField tLogin;
    // End of variables declaration//GEN-END:variables
}
