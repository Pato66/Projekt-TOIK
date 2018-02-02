/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurtowniatowarow;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Klasa pozwalająca na zalogowanie sie do systemu sprzedaży towarów
 * @author Patryk
 */
public class LogForm extends javax.swing.JFrame {
    JFrame uchwyt;
    String login;
    /**
     * Konstruktor bezargumentowy na potrrzeby testów
     */
    public LogForm() {
        initComponents();
        getContentPane().setBackground(new Color(70,160,250));
        setVisible(true); 
        setResizable(false);
    }
    /**
     * Konstruktor jednoargumentowy zawierający uchwyt do okna rodzica
     * @param jf uchwyt do okna rodzica
     */
    public LogForm(JFrame jf){
        initComponents();
        getContentPane().setBackground(new Color(70,160,250));
        setVisible(true);
        setResizable(false);
        uchwyt=jf;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        loguj = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        komunikat = new javax.swing.JLabel();
        cofnij = new javax.swing.JButton();
        przypomnienie = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loguj.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        loguj.setText("Zaloguj sie");
        loguj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logujActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Login");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Password");

        komunikat.setBackground(new java.awt.Color(255, 0, 51));
        komunikat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        cofnij.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        cofnij.setText("Cofnij");
        cofnij.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cofnijActionPerformed(evt);
            }
        });

        przypomnienie.setText("Zapomniałem loginu / hasła");
        przypomnienie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                przypomnienieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(komunikat, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cofnij, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(loguj, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(przypomnienie)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(loginField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(komunikat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(przypomnienie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loguj, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cofnij, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metoda pozwalająca na zalogowanie do systemu po wprowadzeniu poprawnych danych 
     * @param evt 
     */
    private void logujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logujActionPerformed
       Connect okno2=new Connect();
        try {
            String log1=loginField.getText();
            if(okno2.checkUser(loginField.getText(),passField.getText())){
                JFrame jf2 = this; 
                komunikat.setText("");
                login=loginField.getText();
                passField.setText("");
                loginField.setText("");
                jf2.setVisible(false);
                boolean uzupelnione= okno2.czy_uzupelnione(log1);
                if(uzupelnione == true){
                    AfterLogin okno3=new AfterLogin(login,jf2);
                }
                else{
                    AfterLogin okno3=new AfterLogin(login,jf2,1);
                }
            }
            else{
                komunikat.setText("Błędny login lub hasło!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_logujActionPerformed
    /**
     * Metoda pozwalająca cofnąć sie do okna rodzica
     * @param evt 
     */
    private void cofnijActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cofnijActionPerformed
        uchwyt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cofnijActionPerformed
    /**
     * Metoda pozwalajaca rozpocząć proces odzyskiwania zapomnianego loginu/hasła
     * @param evt 
     */
    private void przypomnienieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_przypomnienieActionPerformed
        JFrame j4 =this;
        this.setVisible(false);
        LogHelp poboczne=new LogHelp(j4);
        
    }//GEN-LAST:event_przypomnienieActionPerformed

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
            java.util.logging.Logger.getLogger(LogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cofnij;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel komunikat;
    private javax.swing.JTextField loginField;
    private javax.swing.JButton loguj;
    private javax.swing.JPasswordField passField;
    private javax.swing.JButton przypomnienie;
    // End of variables declaration//GEN-END:variables
}