package main;

import db_objs.Logs;
import db_objs.MyJDBC;
import db_objs.User;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class login_frame extends javax.swing.JFrame {

    protected static User user;
    Logs logs;

    public login_frame(User user) {
        initComponents();
        this.user = user;
    }
    ImageIcon icon = new ImageIcon("C:\\Users\\gilbert\\Downloads\\aaaa.png");
    Image img = icon.getImage().getScaledInstance(50, 55, Image.SCALE_SMOOTH);
    ImageIcon i = new ImageIcon(img);

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        username_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        cancel_button = new javax.swing.JButton();
        login_button1 = new javax.swing.JButton();
        registerButton = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        registerButton1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 243, 236));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("<html><style> b.big{ line_height:0.5; } </style> <body > <p style=\"font-size:25px;\"><b>Welcome</b></p>  <p style=\"font-size:40px;\">Nationalian!</p> </body> </html>");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(248, 245, 242));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username_field.setBackground(new java.awt.Color(248, 245, 242));
        username_field.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username_field.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USERNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(85, 68, 61))); // NOI18N
        username_field.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        username_field.setSelectedTextColor(new java.awt.Color(248, 245, 242));
        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });
        username_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                username_fieldKeyPressed(evt);
            }
        });
        jPanel1.add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 430, 60));

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("show");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 40, 30));

        password_field.setBackground(new java.awt.Color(248, 245, 242));
        password_field.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        password_field.setForeground(new java.awt.Color(0, 0, 0));
        password_field.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(85, 68, 61))); // NOI18N
        password_field.setEchoChar('•');
        password_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_fieldKeyPressed(evt);
            }
        });
        jPanel1.add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 430, 60));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(85, 68, 61));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LOGIN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1000, 40));

        cancel_button.setBackground(new java.awt.Color(85, 68, 61));
        cancel_button.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cancel_button.setForeground(new java.awt.Color(255, 255, 255));
        cancel_button.setText("CANCEL");
        cancel_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(cancel_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 430, 40));

        login_button1.setBackground(new java.awt.Color(85, 68, 61));
        login_button1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        login_button1.setForeground(new java.awt.Color(255, 255, 255));
        login_button1.setText("LOGIN");
        login_button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        login_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_button1ActionPerformed(evt);
            }
        });
        login_button1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                login_button1KeyPressed(evt);
            }
        });
        jPanel1.add(login_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 430, 40));

        registerButton.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        registerButton.setForeground(new java.awt.Color(153, 153, 153));
        registerButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerButton.setText("FORGOT PASSWORD");
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButtonMouseEntered(evt);
            }
        });
        jPanel1.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 1000, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(85, 68, 61));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(i);
        jLabel15.setText("<html> <head> <style> p.small {   line-height:-10; } </style> </head> <body>  <p class=\"small\"> <b>NATIONAL UNIVERSITY</b><p style=\"font-size: 12;\"> Education That Works | ig: saryu4u</p> </p>  </body>");
        jLabel15.setIconTextGap(15);
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 310, 80));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(85, 68, 61));
        jLabel3.setText("INVENTORY");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 220, 40));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(85, 68, 61));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html><body style=\"text-align:center;\">This is a project in Object Oriented Programming. A Inventory System integrated with MySQL database. <br> \nThis was developed by Laurence Ian using Apache NeatBeans and MySQL</body> </html>");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 1000, 50));

        registerButton1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        registerButton1.setForeground(new java.awt.Color(0, 51, 255));
        registerButton1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerButton1.setText("<html><a href=\"#\">not registered yet? click here</a></html>"

        );
        registerButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerButton1MouseEntered(evt);
            }
        });
        jPanel1.add(registerButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 1000, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(85, 68, 61));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(i);
        jLabel14.setText("<html> <head> <style> p.small {   line-height:-10; } </style> </head> <body>  <p class=\"small\"> <b>NATIONAL UNIVERSITY</b><p style=\"font-size: 12;\"> Education That Works | ig: saryu4u</p> </p>  </body>");
        jLabel14.setIconTextGap(15);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 80));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_fieldActionPerformed

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new forgot_password(user).setVisible(true);
    }//GEN-LAST:event_registerButtonMouseClicked
    public static int lives = 3;
    private void login_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_button1ActionPerformed
        // TODO add your handling code here:

        String username = username_field.getText();
        String password = String.valueOf(password_field.getPassword());

        User user1 = MyJDBC.validateLogin(username, password);

        if (username.isEmpty() && password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username and password", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter username", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter password", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else {
            if (user1 != null && MyJDBC.validateUsername(username)) {
                JOptionPane.showMessageDialog(this, "Login Successfully");
                this.dispose();
                new main_interface(user1).setVisible(true);
            } else if (!MyJDBC.validateUsername(username)) {
                JOptionPane.showMessageDialog(this, "The Username you entered does not exist\nPlease check your Username and try again.", "Log in Warning", JOptionPane.ERROR_MESSAGE);
            } else {
                lives--;
                JOptionPane.showMessageDialog(this, "The Password you entered is incorrect\nPlease check your Password and try again.", "Log in Warning", JOptionPane.ERROR_MESSAGE);
                if (lives < 1) {
                    int response = JOptionPane.showConfirmDialog(this, "You Have Reached the Maximum Attempt! Please Change Your Password", "Log in Warning", JOptionPane.YES_NO_OPTION);
                    if (response == JOptionPane.YES_OPTION) {

                        this.dispose();
                        new forgot_password(user).setVisible(true);
                    }
                }
            }
        }
    }//GEN-LAST:event_login_button1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if (jLabel6.getText().equals("show")) {
            password_field.setEchoChar((char) 0); // Show password
            password_field.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            jLabel6.setText("hide");
        } else {
            password_field.setEchoChar('•'); // Hide password
             password_field.setFont(new Font("Segoe UI", Font.PLAIN, 25));
            jLabel6.setText("show");
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void registerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButtonMouseEntered

    private void registerButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButton1MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new registered_frame(user).setVisible(true);
    }//GEN-LAST:event_registerButton1MouseClicked

    private void registerButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButton1MouseEntered

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "are you sure you want to exit?", "warning", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void login_button1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_login_button1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String username = username_field.getText();
            //String password = password_field.getText();
            String password = String.valueOf(password_field.getPassword());

            User user1 = MyJDBC.validateLogin(username, password);

            if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter username and password", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter username", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter password", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else {
                if (user1 != null && MyJDBC.validateUsername(username)) {
                    JOptionPane.showMessageDialog(this, "Login Successfully");
                    this.dispose();
                    new main_interface(user1).setVisible(true);
                } else if (!MyJDBC.validateUsername(username)) {
                    JOptionPane.showMessageDialog(this, "The Username you entered does not exist\nPlease check your Username and try again.", "Log in Warning", JOptionPane.ERROR_MESSAGE);
                } else {
                    lives--;
                    JOptionPane.showMessageDialog(this, "The Password you entered is incorrect\nPlease check your Password and try again.", "Log in Warning", JOptionPane.ERROR_MESSAGE);
                    if (lives < 1) {
                        int response = JOptionPane.showConfirmDialog(this, "You Have Reached the Maximum Attempt! Please Change Your Password", "Log in Warning", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            this.dispose();
                            new forgot_password(user).setVisible(true);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_login_button1KeyPressed

    private void password_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_password_fieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String username = username_field.getText();
            //String password = password_field.getText();
            String password = String.valueOf(password_field.getPassword());

            User user1 = MyJDBC.validateLogin(username, password);

            if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter username and password", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter username", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter password", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else {
                if (user1 != null && MyJDBC.validateUsername(username)) {
                    JOptionPane.showMessageDialog(this, "Login Successfully");

                    this.dispose();
                    new main_interface(user1).setVisible(true);
                } else if (!MyJDBC.validateUsername(username)) {
                    JOptionPane.showMessageDialog(this, "The Username you entered does not exist\nPlease check your Username and try again.", "Log in Warning", JOptionPane.ERROR_MESSAGE);
                } else {
                    lives--;
                    JOptionPane.showMessageDialog(this, "The Password you entered is incorrect\nPlease check your Password and try again.", "Log in Warning", JOptionPane.ERROR_MESSAGE);
                    if (lives < 1) {
                        int response = JOptionPane.showConfirmDialog(this, "You Have Reached the Maximum Attempt! Please Change Your Password", "Log in Warning", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            this.dispose();
                            new forgot_password(user).setVisible(true);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_password_fieldKeyPressed

    private void username_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_username_fieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String username = username_field.getText();
            //String password = password_field.getText();
            String password = String.valueOf(password_field.getPassword());

            User user1 = MyJDBC.validateLogin(username, password);

            if (username.isEmpty() && password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter username and password", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter username", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter password", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else {
                if (user1 != null && MyJDBC.validateUsername(username)) {
                    JOptionPane.showMessageDialog(this, "Login Successfully");

                    this.dispose();
                    new main_interface(user1).setVisible(true);
                } else if (!MyJDBC.validateUsername(username)) {
                    JOptionPane.showMessageDialog(this, "The Username you entered does not exist\nPlease check your Username and try again.", "Log in Warning", JOptionPane.ERROR_MESSAGE);
                } else {
                    lives--;
                    JOptionPane.showMessageDialog(this, "The Password you entered is incorrect\nPlease check your Password and try again.", "Log in Warning", JOptionPane.ERROR_MESSAGE);
                    if (lives < 1) {
                        int response = JOptionPane.showConfirmDialog(this, "You Have Reached the Maximum Attempt! Please Change Your Password", "Log in Warning", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {

                            this.dispose();
                            new forgot_password(user).setVisible(true);
                        }
                    }
                }

            }
        }
    }//GEN-LAST:event_username_fieldKeyPressed

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
            java.util.logging.Logger.getLogger(login_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_frame(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login_button1;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JLabel registerButton;
    private javax.swing.JLabel registerButton1;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
