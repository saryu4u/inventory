/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import db_objs.Logs;
import db_objs.MyJDBC;
import static db_objs.MyJDBC.checkUser;
import db_objs.User;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author gilbert
 */
public class forgot_password extends javax.swing.JFrame {

    public static User user;
    public static Logs logs;

    /**
     * Creates new form login_frame
     */
    public static forgot_password registerFrame;

    public forgot_password(User user) {
        initComponents();
        registerFrame = this;

    }
    ImageIcon icon = new ImageIcon("C:\\Users\\gilbert\\Downloads\\aaaa.png");
    Image img = icon.getImage().getScaledInstance(40, 45, Image.SCALE_SMOOTH);
    ImageIcon i = new ImageIcon(img);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        username_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        repassword_field = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        cancel_button = new javax.swing.JButton();
        register_button = new javax.swing.JButton();
        password_field1 = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(85, 68, 61));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(i);
        jLabel15.setText("<html> <head> <style> p.small {   line-height:-10; } </style> </head> <body>  <p class=\"small\"> <b>NATIONAL UNIVERSITY</b><p style=\"font-size: 12;\"> Education That Works | ig: saryu4u</p> </p>  </body>");
        jLabel15.setIconTextGap(15);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(85, 68, 61));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html><body style=\"text-align:center;\">This is a project in Object Oriented Programming. A Inventory System integrated with MySQL database. <br> \nThis was developed by Laurence Ian using Apache NeatBeans and MySQL</body> </html>");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(248, 245, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username_field.setBackground(new java.awt.Color(248, 245, 242));
        username_field.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username_field.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USERNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(85, 68, 61))); // NOI18N
        username_field.setSelectedTextColor(new java.awt.Color(248, 245, 242));
        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 430, 60));

        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("show");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, -1, 30));

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("show");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, -1, 30));

        repassword_field.setBackground(new java.awt.Color(248, 245, 242));
        repassword_field.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "RE-TYPE PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(85, 68, 61))); // NOI18N
        repassword_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repassword_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(repassword_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 430, 60));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 68, 61));
        jLabel2.setText("FORGOT PASSWORD");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 470, 40));

        cancel_button.setBackground(new java.awt.Color(85, 68, 61));
        cancel_button.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cancel_button.setForeground(new java.awt.Color(255, 255, 255));
        cancel_button.setText("BACK");
        cancel_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(cancel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 430, 40));

        register_button.setBackground(new java.awt.Color(85, 68, 61));
        register_button.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        register_button.setForeground(new java.awt.Color(255, 255, 255));
        register_button.setText("FORGOT PASSWORD");
        register_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        register_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(register_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 430, 40));

        password_field1.setBackground(new java.awt.Color(248, 245, 242));
        password_field1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NEW PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(85, 68, 61))); // NOI18N
        password_field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_field1ActionPerformed(evt);
            }
        });
        jPanel1.add(password_field1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 430, 60));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(85, 68, 61));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(i);
        jLabel16.setText("<html> <head> <style> p.small {   line-height:-10; } </style> </head> <body>  <p class=\"small\"> <b>NATIONAL UNIVERSITY</b><p style=\"font-size: 12;\"> Education That Works | ig: saryu4u</p> </p>  </body>");
        jLabel16.setIconTextGap(15);
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 310, 80));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(85, 68, 61));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("<html><body style=\"text-align:center;\">Sponsored By <br>Coca-Cola </body> </html>");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 280, 60));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(85, 68, 61));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("<html><body style=\"text-align:center;\">Sponsored By <br>Lola Remedios</body> </html>");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 280, 60));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(85, 68, 61));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("<html><body style=\"text-align:center;\">Powered By <br>Cobra Energy Drink</body> </html>");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, 280, 60));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(85, 68, 61));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("<html><body style=\"text-align:center;\">Sponsored By <br> IKEA</body> </html>");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 280, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_fieldActionPerformed

    private void repassword_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repassword_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repassword_fieldActionPerformed

    private void password_field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_field1ActionPerformed

    private void register_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_buttonActionPerformed
        // TODO add your handling code here:

        String username = username_field.getText();
        String password = String.valueOf(password_field1.getPassword());
        String rePassword = String.valueOf(repassword_field.getPassword());
        String status = "member";

        if (username.isEmpty() && password.isEmpty() && rePassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the information to Forget Password", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your Username", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your Password", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (rePassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please re-enter your Password", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!password.equals(rePassword)) {
                JOptionPane.showMessageDialog(this, "Please make sure to to match your Password", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (!MyJDBC.checkUser(username)) {
                JOptionPane.showMessageDialog(this, "Check your Username", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (password.equals(rePassword) && password.length() < 6) {
                JOptionPane.showMessageDialog(this, "The Password must be ATLEAST 6 Characters", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else {
                if (MyJDBC.forgotPassword(username, password)) {
                    JOptionPane.showMessageDialog(this, "Forgot password Successfully");
                    logs = new Logs(0, "FORGOT PASSWORD", username, null, null);
                    MyJDBC.addLogsToDatabase(logs);

                    this.dispose();
                    new login_frame(user).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Forgot password Failed");
                }
            }
        }
    }//GEN-LAST:event_register_buttonActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        if (jLabel8.getText().equals("show")) {
            password_field1.setEchoChar((char) 0); // Show password
            jLabel8.setText("hide");
        } else {
            password_field1.setEchoChar('•'); // Hide password
            jLabel8.setText("show");
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        if (jLabel9.getText().equals("show")) {
            repassword_field.setEchoChar((char) 0); // Show password
            jLabel9.setText("hide");
        } else {
            repassword_field.setEchoChar('•'); // Hide password
            jLabel9.setText("show");
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new login_frame(user).setVisible(true);
    }//GEN-LAST:event_cancel_buttonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password_field1;
    private javax.swing.JButton register_button;
    private javax.swing.JPasswordField repassword_field;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
