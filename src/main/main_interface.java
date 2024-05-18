package main;

import db_objs.MyJDBC;
import db_objs.Stocks;
import db_objs.Transaction;
import java.awt.Color;
import java.awt.Font;
import db_objs.User;
import java.awt.Image;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import db_objs.Logs;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class main_interface extends javax.swing.JFrame {

    ImageIcon icon = new ImageIcon("C:\\Users\\gilbert\\Downloads\\aaaa.png");
    Image img = icon.getImage().getScaledInstance(50, 55, Image.SCALE_SMOOTH);
    ImageIcon i = new ImageIcon(img);

    Logs logs;
    public static main_interface mainInterface;

    public static User user;
    public static Transaction transaction;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/inventory_system?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "saryuisagod1123";
    public static ArrayList<Logs> pastLogs = new ArrayList<>();
    public static ArrayList<Logs> pastLogs1 = new ArrayList<>();
    Date currentDate;
    Date targetDate;

    public main_interface(User user) {

        this.user = user;

        initComponents();

        mainInterface = this;
        productHistoryLog_panel.setVisible(false);
        manage_profile.setVisible(false);
        orderPanel.setVisible(false);
        add_user.setVisible(false);
        manage_user.setVisible(false);
        stock_control_panel.setVisible(false);
        supplierPanel.setVisible(false);
        view_product_panel.setVisible(false);
        auditLog_panel.setVisible(false);

        //allRadioAdminButton.setSelected (true);
        //allRadioAdminButton1.setSelected (true);
        if (user.getStatus().equalsIgnoreCase("member")) {
            adminAuditLog.setVisible(false);
            viewUsers.setVisible(false);
            jLabel5.setVisible(false);
            manage_user.setVisible(false);
            manageUserButton2.setVisible(false);
        } else if (user.getStatus().equalsIgnoreCase("not verified")) {
            logs = new Logs(user.getId(), "CREATED AN ACCOUNT", user.getName(), null, null);
            MyJDBC.addLogsToDatabase(logs);

            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE users SET status = ? WHERE id = ?");
                preparedStatement.setString(1, "member");
                preparedStatement.setInt(2, user.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logs = new Logs(user.getId(), "LOGIN", user.getName(), null, null);
        MyJDBC.addLogsToDatabase(logs);

    }

    Stocks stocks;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        main_menu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        historyButton = new javax.swing.JLabel();
        customerButton = new javax.swing.JLabel();
        productButton = new javax.swing.JLabel();
        settingsButton = new javax.swing.JLabel();
        reportingButton = new javax.swing.JLabel();
        homeButton = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        home_panel = new javax.swing.JPanel();
        customers_panel = new javax.swing.JPanel();
        customer_menu = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        customer_panel_frame = new javax.swing.JPanel();
        product_panel = new javax.swing.JPanel();
        product_menu = new javax.swing.JPanel();
        view_products = new javax.swing.JLabel();
        stockControlButton = new javax.swing.JLabel();
        orderTransactionButton = new javax.swing.JLabel();
        supplierButton = new javax.swing.JLabel();
        product_panel_frame = new javax.swing.JPanel();
        orderPanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        cancelOrderButton = new javax.swing.JButton();
        payNowButton = new javax.swing.JButton();
        supplierPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        supplierTable = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        quantityField = new javax.swing.JTextField();
        itemPriceField = new javax.swing.JTextField();
        itemField = new javax.swing.JTextField();
        categoryField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        stock_control_panel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        stockControlTable = new javax.swing.JTable();
        categoyField = new javax.swing.JTextField();
        descField = new javax.swing.JTextField();
        qtyField = new javax.swing.JTextField();
        itemNameField = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        updateStockButton = new javax.swing.JButton();
        priceField = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        view_product_panel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        reporting_panel = new javax.swing.JPanel();
        reporting_menu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        reporting_panel_frame = new javax.swing.JPanel();
        history_panel = new javax.swing.JPanel();
        history_menu = new javax.swing.JPanel();
        userAuditLog = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        adminAuditLog = new javax.swing.JLabel();
        history_panel_frame = new javax.swing.JPanel();
        auditLog_panel = new javax.swing.JPanel();
        jScrollPane7 =  new JScrollPane(jPanel2);
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        productHistoryLog_panel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        setting_panel = new javax.swing.JPanel();
        setting_menu = new javax.swing.JPanel();
        viewUsers = new javax.swing.JLabel();
        manageProfile = new javax.swing.JLabel();
        manageUserButton2 = new javax.swing.JLabel();
        setting_panel_frame = new javax.swing.JPanel();
        manage_profile = new javax.swing.JPanel();
        profNameField = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        profEditButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        profNameField1 = new javax.swing.JTextField();
        profNameField2 = new javax.swing.JTextField();
        profNameField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        manage_user = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        statusField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox<>();
        add_user = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        name = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 0, 102));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(i);
        jLabel14.setText("<html> <head> <style> p.small {   line-height:-10; } </style> </head> <body>  <p class=\"small\"> <b>NATIONAL UNIVERSITY</b><p style=\"font-size: 12;\"> Education That Works | ig: saryu4u</p> </p>  </body>");
        jLabel14.setIconTextGap(15);
        header.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 80));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("<html>"+
            "<body style='line-height:-10'>"+
            "  <p style='text-transform:uppercase'>"+" <b>"+ user.getName().toUpperCase()+"</b>"+"</p>"+ "<p style='font-size: 11'>" +"@"+user.getUsername()+"  |  " + user.getStatus().toLowerCase() +"</p>"+"</body>"+"<html>");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.setIconTextGap(15);
        header.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 440, 80));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("INVENTORY");
        header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 220, 40));

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        main_menu.setBackground(new java.awt.Color(204, 204, 204));
        main_menu.setForeground(new java.awt.Color(204, 204, 204));
        main_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\gilbert\\Downloads\\leave.png")); // NOI18N
        jLabel3.setText("LOG OUT");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        main_menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 150, 30));

        historyButton.setBackground(new java.awt.Color(204, 204, 204));
        historyButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        historyButton.setForeground(new java.awt.Color(0, 0, 0));
        historyButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historyButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\gilbert\\Downloads\\bookmark.png")); // NOI18N
        historyButton.setText("HISTORY");
        historyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historyButton.setOpaque(true);
        historyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historyButtonMouseExited(evt);
            }
        });
        main_menu.add(historyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 150, 30));

        customerButton.setBackground(new java.awt.Color(204, 204, 204));
        customerButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        customerButton.setForeground(new java.awt.Color(0, 0, 0));
        customerButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\gilbert\\Downloads\\users-alt.png")); // NOI18N
        customerButton.setText("CUSTOMERS");
        customerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customerButton.setOpaque(true);
        customerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerButtonMouseExited(evt);
            }
        });
        main_menu.add(customerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 150, 30));

        productButton.setBackground(new java.awt.Color(204, 204, 204));
        productButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        productButton.setForeground(new java.awt.Color(0, 0, 0));
        productButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\gilbert\\Downloads\\shopping-cart.png")); // NOI18N
        productButton.setText("PRODUCT");
        productButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productButton.setOpaque(true);
        productButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productButtonMouseExited(evt);
            }
        });
        main_menu.add(productButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, 30));

        settingsButton.setBackground(new java.awt.Color(204, 204, 204));
        settingsButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        settingsButton.setForeground(new java.awt.Color(0, 0, 0));
        settingsButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\gilbert\\Downloads\\settings.png")); // NOI18N
        settingsButton.setText("SETTINGS");
        settingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsButton.setOpaque(true);
        settingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsButtonMouseExited(evt);
            }
        });
        main_menu.add(settingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 150, 30));

        reportingButton.setBackground(new java.awt.Color(204, 204, 204));
        reportingButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        reportingButton.setForeground(new java.awt.Color(0, 0, 0));
        reportingButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reportingButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\gilbert\\Downloads\\stats.png")); // NOI18N
        reportingButton.setText("REPORTING");
        reportingButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportingButton.setOpaque(true);
        reportingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportingButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportingButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportingButtonMouseExited(evt);
            }
        });
        main_menu.add(reportingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 150, 30));

        homeButton.setBackground(new java.awt.Color(204, 204, 204));
        homeButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        homeButton.setForeground(new java.awt.Color(0, 0, 0));
        homeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\gilbert\\Downloads\\home.png")); // NOI18N
        homeButton.setText("HOME");
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.setOpaque(true);
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
        });
        main_menu.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\gilbert\\Downloads\\power.png")); // NOI18N
        jLabel15.setText("EXIT");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        main_menu.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 457, 150, 30));

        jPanel1.add(main_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 150, 500));

        home_panel.setBackground(new java.awt.Color(255, 255, 255));
        home_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(home_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 850, 500));

        customers_panel.setBackground(new java.awt.Color(255, 255, 255));
        customers_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customer_menu.setBackground(new java.awt.Color(255, 255, 255));
        customer_menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        customer_menu.setMinimumSize(new java.awt.Dimension(160, 150));
        customer_menu.setPreferredSize(new java.awt.Dimension(150, 160));
        customer_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("di ko pa alam");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customer_menu.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 40));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("ewan ko nalang");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customer_menu.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 40));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("awit pano to");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        customer_menu.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, 40));

        customers_panel.add(customer_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 170, 500));

        customer_panel_frame.setBackground(new java.awt.Color(255, 255, 255));
        customer_panel_frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        customers_panel.add(customer_panel_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 660, 500));

        jPanel1.add(customers_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 850, 500));

        product_panel.setBackground(new java.awt.Color(255, 255, 255));
        product_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        product_menu.setBackground(new java.awt.Color(255, 255, 255));
        product_menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        product_menu.setPreferredSize(new java.awt.Dimension(150, 160));
        product_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        view_products.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        view_products.setForeground(new java.awt.Color(0, 0, 0));
        view_products.setText("Products");
        view_products.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_productsMouseClicked(evt);
            }
        });
        product_menu.add(view_products, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 30));

        stockControlButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        stockControlButton.setForeground(new java.awt.Color(0, 0, 0));
        stockControlButton.setText("Stock Control");
        stockControlButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        stockControlButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockControlButtonMouseClicked(evt);
            }
        });
        product_menu.add(stockControlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));

        orderTransactionButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        orderTransactionButton.setForeground(new java.awt.Color(0, 0, 0));
        orderTransactionButton.setText("Orders");
        orderTransactionButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        orderTransactionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTransactionButtonMouseClicked(evt);
            }
        });
        product_menu.add(orderTransactionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, 30));

        supplierButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        supplierButton.setForeground(new java.awt.Color(0, 0, 0));
        supplierButton.setText("Supplier");
        supplierButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        supplierButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierButtonMouseClicked(evt);
            }
        });
        product_menu.add(supplierButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 120, 30));

        product_panel.add(product_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 170, 500));

        product_panel_frame.setBackground(new java.awt.Color(255, 255, 255));
        product_panel_frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderPanel.setBackground(new java.awt.Color(255, 255, 255));
        orderPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable4.setBackground(new java.awt.Color(255, 255, 255));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "item", "price", "qty", "category", "descripton", "payment type", "transaction", "pre-order", "total price", "delivery", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable4);

        orderPanel.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 450));

        cancelOrderButton.setBackground(new java.awt.Color(0, 0, 102));
        cancelOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelOrderButton.setText("CANCEL ORDER");
        cancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderButtonActionPerformed(evt);
            }
        });
        orderPanel.add(cancelOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 130, 30));

        payNowButton.setBackground(new java.awt.Color(0, 0, 102));
        payNowButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        payNowButton.setForeground(new java.awt.Color(255, 255, 255));
        payNowButton.setText("PAY NOW");
        payNowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payNowButtonActionPerformed(evt);
            }
        });
        orderPanel.add(payNowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 130, 30));

        product_panel_frame.add(orderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        supplierPanel.setBackground(new java.awt.Color(255, 255, 255));
        supplierPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supplierTable.setBackground(new java.awt.Color(255, 255, 255));
        supplierTable.setForeground(new java.awt.Color(0, 0, 102));
        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product", "price", "qty", "category", "payment", "transaction", "pre-order", "total price", "status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(supplierTable);
        if (supplierTable.getColumnModel().getColumnCount() > 0) {
            supplierTable.getColumnModel().getColumn(0).setResizable(false);
            supplierTable.getColumnModel().getColumn(1).setResizable(false);
            supplierTable.getColumnModel().getColumn(2).setResizable(false);
            supplierTable.getColumnModel().getColumn(3).setResizable(false);
            supplierTable.getColumnModel().getColumn(4).setResizable(false);
            supplierTable.getColumnModel().getColumn(5).setResizable(false);
            supplierTable.getColumnModel().getColumn(6).setResizable(false);
            supplierTable.getColumnModel().getColumn(7).setResizable(false);
            supplierTable.getColumnModel().getColumn(8).setResizable(false);
        }

        supplierPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 500));

        jButton6.setBackground(new java.awt.Color(0, 0, 102));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("ORDER");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        supplierPanel.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 160, -1));

        jButton7.setBackground(new java.awt.Color(0, 0, 102));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("ADD");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        supplierPanel.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 160, -1));

        jButton8.setBackground(new java.awt.Color(0, 0, 102));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("UPDATE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        supplierPanel.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, 160, -1));

        jButton9.setBackground(new java.awt.Color(0, 0, 102));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("DELETE");
        supplierPanel.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 160, -1));

        quantityField.setBackground(new java.awt.Color(255, 255, 255));
        quantityField.setForeground(new java.awt.Color(0, 0, 102));
        quantityField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 102), null), "QTY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });
        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityFieldKeyTyped(evt);
            }
        });
        supplierPanel.add(quantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 60, -1));

        itemPriceField.setBackground(new java.awt.Color(255, 255, 255));
        itemPriceField.setForeground(new java.awt.Color(0, 0, 102));
        itemPriceField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 102), null), "PRICE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        itemPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPriceFieldActionPerformed(evt);
            }
        });
        itemPriceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemPriceFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemPriceFieldKeyTyped(evt);
            }
        });
        supplierPanel.add(itemPriceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 100, -1));

        itemField.setBackground(new java.awt.Color(255, 255, 255));
        itemField.setForeground(new java.awt.Color(0, 0, 102));
        itemField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 102), null), "ITEM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        itemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFieldActionPerformed(evt);
            }
        });
        supplierPanel.add(itemField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 160, -1));

        categoryField.setBackground(new java.awt.Color(255, 255, 255));
        categoryField.setForeground(new java.awt.Color(0, 0, 102));
        categoryField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 102), null), "CATEGORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        categoryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryFieldActionPerformed(evt);
            }
        });
        supplierPanel.add(categoryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 160, -1));

        jLabel17.setText("Pre-Order: ");
        supplierPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        supplierPanel.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 160, 30));
        LocalDate today = LocalDate.now();
        LocalDate today1 = today.plusDays(1);
        String date12 = String.valueOf(today1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = dateFormat.parse(date12);
            jDateChooser1.setMinSelectableDate(date);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARD", "CASH" }));
        supplierPanel.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 70, 20));

        jLabel22.setText("pay later:");
        supplierPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 90, 20));
        supplierPanel.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 20, -1));

        jLabel23.setText("payment type:");
        supplierPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 90, 20));

        product_panel_frame.add(supplierPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        stock_control_panel.setBackground(new java.awt.Color(255, 255, 255));
        stock_control_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stockControlTable.setBackground(new java.awt.Color(0, 0, 102));
        stockControlTable.setForeground(new java.awt.Color(255, 255, 255));
        stockControlTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "product", "price", "qty", "category", "description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        stockControlTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockControlTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(stockControlTable);

        stock_control_panel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 480, 450));

        categoyField.setBackground(new java.awt.Color(255, 255, 255));
        categoyField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CATEGORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        stock_control_panel.add(categoyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 170, -1));

        descField.setBackground(new java.awt.Color(255, 255, 255));
        descField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DESCRIPTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        stock_control_panel.add(descField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 170, 120));

        qtyField.setBackground(new java.awt.Color(255, 255, 255));
        qtyField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "QTY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        qtyField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtyFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyFieldKeyTyped(evt);
            }
        });
        stock_control_panel.add(qtyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 50, -1));

        itemNameField.setBackground(new java.awt.Color(255, 255, 255));
        itemNameField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PRODUCT NAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        stock_control_panel.add(itemNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 170, -1));

        jButton5.setBackground(new java.awt.Color(0, 0, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        stock_control_panel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 150, -1));

        updateStockButton.setBackground(new java.awt.Color(0, 0, 102));
        updateStockButton.setForeground(new java.awt.Color(255, 255, 255));
        updateStockButton.setText("UPDATE");
        updateStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStockButtonActionPerformed(evt);
            }
        });
        stock_control_panel.add(updateStockButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 150, -1));

        priceField.setBackground(new java.awt.Color(255, 255, 255));
        priceField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PRICE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 102))); // NOI18N
        priceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceFieldKeyPressed(evt);
            }
        });
        stock_control_panel.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 110, -1));

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        stock_control_panel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 330, 30));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("search: ");
        stock_control_panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 30));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "product", "price", "category", "description", " " }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        stock_control_panel.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 80, 30));

        product_panel_frame.add(stock_control_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        view_product_panel.setBackground(new java.awt.Color(255, 255, 255));
        view_product_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setBackground(new java.awt.Color(0, 0, 102));
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "PRODUCT NAME", "PRICE", "QTY", "TYPES", "DESCRIPTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        jScrollPane3.setViewportView(jTable3);

        view_product_panel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 690, 450));

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });
        view_product_panel.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 520, 30));

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("search: ");
        view_product_panel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "product", "price", "category", "description", " " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        view_product_panel.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 80, 30));

        product_panel_frame.add(view_product_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        product_panel.add(product_panel_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 690, 500));

        jPanel1.add(product_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 850, 500));

        reporting_panel.setBackground(new java.awt.Color(255, 255, 255));
        reporting_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reporting_menu.setBackground(new java.awt.Color(255, 255, 255));
        reporting_menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        reporting_menu.setMinimumSize(new java.awt.Dimension(160, 150));
        reporting_menu.setPreferredSize(new java.awt.Dimension(150, 160));
        reporting_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Dashboard");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reporting_menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Product Reports");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reporting_menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Employee Reporting");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reporting_menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, 40));

        reporting_panel.add(reporting_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 170, 500));

        reporting_panel_frame.setBackground(new java.awt.Color(255, 255, 255));
        reporting_panel_frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        reporting_panel.add(reporting_panel_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 660, 500));

        jPanel1.add(reporting_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 850, 500));

        history_panel.setBackground(new java.awt.Color(255, 255, 255));
        history_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        history_menu.setBackground(new java.awt.Color(255, 255, 255));
        history_menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        history_menu.setMinimumSize(new java.awt.Dimension(160, 150));
        history_menu.setPreferredSize(new java.awt.Dimension(150, 160));
        history_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userAuditLog.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        userAuditLog.setForeground(new java.awt.Color(0, 0, 0));
        userAuditLog.setText("USER AUDIT LOG");
        userAuditLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userAuditLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userAuditLogMouseClicked(evt);
            }
        });
        history_menu.add(userAuditLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 40));

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("ano kaya ilalagay");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        history_menu.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 40));

        adminAuditLog.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        adminAuditLog.setForeground(new java.awt.Color(0, 0, 0));
        adminAuditLog.setText("AUDIT LOG");
        adminAuditLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adminAuditLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminAuditLogMouseClicked(evt);
            }
        });
        history_menu.add(adminAuditLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, 40));

        history_panel.add(history_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 170, 500));

        history_panel_frame.setBackground(new java.awt.Color(255, 255, 255));
        history_panel_frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        auditLog_panel.setBackground(new java.awt.Color(255, 255, 255));
        auditLog_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                auditLog_panelMouseClicked(evt);
            }
        });
        auditLog_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jScrollPane7.setViewportView(jPanel2);

        auditLog_panel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 690, 450));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        auditLog_panel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "user", "action", "product", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        auditLog_panel.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 80, 30));

        history_panel_frame.add(auditLog_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        productHistoryLog_panel.setBackground(new java.awt.Color(255, 255, 255));
        productHistoryLog_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jScrollPane6.setViewportView(jPanel3);

        productHistoryLog_panel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 690, 450));

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        productHistoryLog_panel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "action" }));
        productHistoryLog_panel.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 80, 30));

        history_panel_frame.add(productHistoryLog_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 500));

        history_panel.add(history_panel_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 690, 500));

        jPanel1.add(history_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 850, 500));

        setting_panel.setBackground(new java.awt.Color(255, 255, 255));
        setting_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setting_menu.setBackground(new java.awt.Color(255, 255, 255));
        setting_menu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setting_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewUsers.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        viewUsers.setForeground(new java.awt.Color(0, 0, 0));
        viewUsers.setText("Manage User");
        viewUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewUsersMouseClicked(evt);
            }
        });
        setting_menu.add(viewUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 30));

        manageProfile.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        manageProfile.setForeground(new java.awt.Color(0, 0, 0));
        manageProfile.setText("Manage Profile");
        manageProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageProfileMouseClicked(evt);
            }
        });
        setting_menu.add(manageProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 30));

        manageUserButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        manageUserButton2.setForeground(new java.awt.Color(0, 0, 0));
        manageUserButton2.setText("Add User");
        manageUserButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageUserButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageUserButton2MouseClicked(evt);
            }
        });
        setting_menu.add(manageUserButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 30));

        setting_panel.add(setting_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 170, 500));

        setting_panel_frame.setBackground(new java.awt.Color(255, 255, 255));
        setting_panel_frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manage_profile.setBackground(new java.awt.Color(255, 255, 255));
        manage_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profNameField.setEditable(false);
        profNameField.setBackground(new java.awt.Color(255, 255, 255));
        profNameField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        profNameField.setForeground(new java.awt.Color(0, 0, 102));
        profNameField.setText(user.getAddress());
        manage_profile.add(profNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 370, 40));

        jButton10.setBackground(new java.awt.Color(0, 0, 102));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("SAVE");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        manage_profile.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 120, 30));

        profEditButton.setBackground(new java.awt.Color(0, 0, 102));
        profEditButton.setForeground(new java.awt.Color(255, 255, 255));
        profEditButton.setText("EDIT");
        profEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profEditButtonActionPerformed(evt);
            }
        });
        manage_profile.add(profEditButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 120, 30));

        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("ADDRESS");
        manage_profile.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 70, 20));

        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("NAME: ");
        manage_profile.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, 20));

        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("EMAIL: ");
        manage_profile.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 70, 20));

        profNameField1.setEditable(false);
        profNameField1.setBackground(new java.awt.Color(255, 255, 255));
        profNameField1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        profNameField1.setForeground(new java.awt.Color(0, 0, 102));
        profNameField1.setText(user.getName());
        profNameField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profNameField1ActionPerformed(evt);
            }
        });
        manage_profile.add(profNameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 370, 40));

        profNameField2.setEditable(false);
        profNameField2.setBackground(new java.awt.Color(255, 255, 255));
        profNameField2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        profNameField2.setForeground(new java.awt.Color(0, 0, 102));
        profNameField2.setText(user.getUsername());
        profNameField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profNameField2ActionPerformed(evt);
            }
        });
        manage_profile.add(profNameField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 370, 40));

        profNameField3.setEditable(false);
        profNameField3.setBackground(new java.awt.Color(255, 255, 255));
        profNameField3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        profNameField3.setForeground(new java.awt.Color(0, 0, 102));
        profNameField3.setText(user.getEmail());
        profNameField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profNameField3ActionPerformed(evt);
            }
        });
        manage_profile.add(profNameField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 370, 40));

        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("USERNAME: ");
        manage_profile.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 20));

        setting_panel_frame.add(manage_profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 690, 500));

        manage_user.setBackground(new java.awt.Color(255, 255, 255));
        manage_user.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "USERNAME", "PASSWORD", "EMAIL", "ADDRESS", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
        }

        manage_user.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 670, 320));

        statusField.setBackground(new java.awt.Color(255, 255, 255));
        statusField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "STATUS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        statusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusFieldActionPerformed(evt);
            }
        });
        manage_user.add(statusField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 170, -1));

        nameField.setBackground(new java.awt.Color(255, 255, 255));
        nameField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        manage_user.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 170, -1));

        usernameField.setBackground(new java.awt.Color(255, 255, 255));
        usernameField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USERNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        manage_user.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 170, -1));

        addressField.setBackground(new java.awt.Color(255, 255, 255));
        addressField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ADDRESS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressFieldActionPerformed(evt);
            }
        });
        manage_user.add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 170, -1));

        passwordField.setBackground(new java.awt.Color(255, 255, 255));
        passwordField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        manage_user.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 170, -1));

        emailField.setBackground(new java.awt.Color(255, 255, 255));
        emailField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "EMAIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        manage_user.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 170, -1));

        updateButton.setBackground(new java.awt.Color(0, 0, 102));
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        manage_user.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 140, 40));

        deleteButton.setBackground(new java.awt.Color(0, 0, 102));
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("DELETE");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        manage_user.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 140, 40));

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        manage_user.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 30));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "all", "name", "email", "address" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        manage_user.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 80, 30));

        setting_panel_frame.add(manage_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 690, 490));

        add_user.setBackground(new java.awt.Color(255, 255, 255));
        add_user.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "USERNAME", "PASSWORD", "ADDRESS", "EMAIL", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        add_user.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 500));

        name.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "NAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        add_user.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 190, -1));

        status.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "STATUS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        add_user.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 190, -1));

        username.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USERNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        add_user.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 190, -1));

        password.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        add_user.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 190, -1));

        email.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "EMAIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        add_user.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 190, -1));

        address.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ADDRESS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        add_user.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 190, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add_user.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 190, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add_user.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 190, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add_user.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 190, -1));

        jButton4.setBackground(new java.awt.Color(0, 0, 102));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("UPDATE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add_user.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 190, -1));

        setting_panel_frame.add(add_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 690, 500));

        setting_panel.add(setting_panel_frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));

        jPanel1.add(setting_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 850, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        // TODO add your handling code here:
        home_panel.setVisible(true);
        homeButton.setBackground(Color.white);

        historyButton.setBackground(new Color(0xCCCCCC));
        productButton.setBackground(new Color(0xCCCCCC));
        customerButton.setBackground(new Color(0xCCCCCC));
        settingsButton.setBackground(new Color(0xCCCCCC));
        reportingButton.setBackground(new Color(0xCCCCCC));
        product_panel.setVisible(false);
        customers_panel.setVisible(false);
        setting_panel.setVisible(false);
        history_panel.setVisible(false);

        reporting_panel.setVisible(false);

    }//GEN-LAST:event_homeButtonMouseClicked

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        // TODO add your handling code here:
        homeButton.setForeground(new Color(0x000066));
        homeButton.setFont(new Font("arial", Font.BOLD, 15));
    }//GEN-LAST:event_homeButtonMouseEntered

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        // TODO add your handling code here:
        homeButton.setFont(new Font("arial", Font.BOLD, 14));
        homeButton.setForeground(Color.black);
    }//GEN-LAST:event_homeButtonMouseExited

    private void customerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseClicked
        // TODO add your handling code here:
        home_panel.setVisible(false);
        product_panel.setVisible(false);
        customers_panel.setVisible(true);
        setting_panel.setVisible(false);
        history_panel.setVisible(false);

        reporting_panel.setVisible(false);

        customerButton.setBackground(Color.white);

        historyButton.setBackground(new Color(0xCCCCCC));
        productButton.setBackground(new Color(0xCCCCCC));
        homeButton.setBackground(new Color(0xCCCCCC));
        settingsButton.setBackground(new Color(0xCCCCCC));
        reportingButton.setBackground(new Color(0xCCCCCC));
    }//GEN-LAST:event_customerButtonMouseClicked

    private void customerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseEntered
        // TODO add your handling code here:
        customerButton.setForeground(new Color(0x000066));
        customerButton.setFont(new Font("arial", Font.BOLD, 15));
    }//GEN-LAST:event_customerButtonMouseEntered

    private void customerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseExited
        // TODO add your handling code here:
        customerButton.setFont(new Font("arial", Font.BOLD, 14));
        customerButton.setForeground(Color.black);
    }//GEN-LAST:event_customerButtonMouseExited

    private void historyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyButtonMouseClicked
        // TODO add your handling code here:
        home_panel.setVisible(false);
        product_panel.setVisible(false);
        customers_panel.setVisible(false);
        setting_panel.setVisible(false);
        history_panel.setVisible(true);

        reporting_panel.setVisible(false);

        historyButton.setBackground(Color.white);

        customerButton.setBackground(new Color(0xCCCCCC));
        productButton.setBackground(new Color(0xCCCCCC));
        homeButton.setBackground(new Color(0xCCCCCC));
        settingsButton.setBackground(new Color(0xCCCCCC));
        reportingButton.setBackground(new Color(0xCCCCCC));

    }//GEN-LAST:event_historyButtonMouseClicked

    private void historyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyButtonMouseEntered
        // TODO add your handling code here:
        historyButton.setForeground(new Color(0x000066));
        historyButton.setFont(new Font("arial", Font.BOLD, 15));
    }//GEN-LAST:event_historyButtonMouseEntered

    private void historyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyButtonMouseExited
        // TODO add your handling code here:
        historyButton.setFont(new Font("arial", Font.BOLD, 14));
        historyButton.setForeground(Color.black);
    }//GEN-LAST:event_historyButtonMouseExited

    private void reportingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportingButtonMouseClicked
        // TODO add your handling code here:
        home_panel.setVisible(false);
        product_panel.setVisible(false);
        customers_panel.setVisible(false);
        setting_panel.setVisible(false);
        history_panel.setVisible(false);
        reporting_panel.setVisible(true);

        reportingButton.setBackground(Color.white);

        customerButton.setBackground(new Color(0xCCCCCC));
        productButton.setBackground(new Color(0xCCCCCC));
        homeButton.setBackground(new Color(0xCCCCCC));
        settingsButton.setBackground(new Color(0xCCCCCC));
        historyButton.setBackground(new Color(0xCCCCCC));

    }//GEN-LAST:event_reportingButtonMouseClicked

    private void reportingButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportingButtonMouseEntered
        // TODO add your handling code here:
        reportingButton.setForeground(new Color(0x000066));
        reportingButton.setFont(new Font("arial", Font.BOLD, 15));

    }//GEN-LAST:event_reportingButtonMouseEntered

    private void reportingButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportingButtonMouseExited
        // TODO add your handling code here:
        reportingButton.setFont(new Font("arial", Font.BOLD, 14));
        reportingButton.setForeground(Color.black);
    }//GEN-LAST:event_reportingButtonMouseExited

    private void productButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseClicked
        // TODO add your handling code here:
        home_panel.setVisible(false);
        product_panel.setVisible(true);
        customers_panel.setVisible(false);
        setting_panel.setVisible(false);
        history_panel.setVisible(false);
        reporting_panel.setVisible(false);

        productButton.setBackground(Color.white);

        customerButton.setBackground(new Color(0xCCCCCC));
        reportingButton.setBackground(new Color(0xCCCCCC));
        homeButton.setBackground(new Color(0xCCCCCC));
        settingsButton.setBackground(new Color(0xCCCCCC));
        historyButton.setBackground(new Color(0xCCCCCC));

    }//GEN-LAST:event_productButtonMouseClicked

    private void productButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseEntered
        // TODO add your handling code here:
        productButton.setForeground(new Color(0x000066));
        productButton.setFont(new Font("arial", Font.BOLD, 15));
    }//GEN-LAST:event_productButtonMouseEntered

    private void productButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseExited
        // TODO add your handling code here:
        productButton.setFont(new Font("arial", Font.BOLD, 14));
        productButton.setForeground(Color.black);

    }//GEN-LAST:event_productButtonMouseExited

    private void settingsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsButtonMouseClicked
        // TODO add your handling code here:
        home_panel.setVisible(false);
        product_panel.setVisible(false);
        customers_panel.setVisible(false);
        setting_panel.setVisible(true);
        history_panel.setVisible(false);

        reporting_panel.setVisible(false);
        settingsButton.setBackground(Color.white);

        customerButton.setBackground(new Color(0xCCCCCC));
        reportingButton.setBackground(new Color(0xCCCCCC));
        homeButton.setBackground(new Color(0xCCCCCC));
        productButton.setBackground(new Color(0xCCCCCC));
        historyButton.setBackground(new Color(0xCCCCCC));
    }//GEN-LAST:event_settingsButtonMouseClicked

    private void settingsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsButtonMouseEntered
        // TODO add your handling code here:
        settingsButton.setForeground(new Color(0x000066));
        settingsButton.setFont(new Font("arial", Font.BOLD, 15));
    }//GEN-LAST:event_settingsButtonMouseEntered

    private void settingsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsButtonMouseExited
        // TODO add your handling code here:
        settingsButton.setFont(new Font("arial", Font.BOLD, 14));
        settingsButton.setForeground(Color.black);
    }//GEN-LAST:event_settingsButtonMouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        jLabel3.setForeground(Color.red);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        jLabel3.setForeground(Color.black);
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(this, "are you sure you want to log out?", "warning", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            new login_frame(user).setVisible(true);
            pastLogs1.clear();
            this.dispose();
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:

        int response = JOptionPane.showConfirmDialog(this, "are you sure you want to exit?", "warning", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel tblModel1 = (DefaultTableModel) jTable1.getModel();

        String username1 = username.getText();
        String password1 = password.getText();
        String name1 = name.getText();
        String address1 = address.getText();
        String email1 = email.getText();
        String status1 = status.getText();

        if (tblModel1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "WALANG LAMAN LODS");
        } else {
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                for (int i = 0; i < tblModel1.getRowCount(); i++) {
                    String name = tblModel1.getValueAt(i, 0).toString();
                    String username = tblModel1.getValueAt(i, 1).toString();
                    String password = tblModel1.getValueAt(i, 2).toString();
                    String address = tblModel1.getValueAt(i, 3).toString();
                    String email = tblModel1.getValueAt(i, 4).toString();
                    String status = tblModel1.getValueAt(i, 5).toString();

                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "INSERT into users(name, username, password, address, email, status)"
                            + "VALUES(?,?,?,?,?,?)");
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, username);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, address);
                    preparedStatement.setString(5, email);
                    preparedStatement.setString(6, status);
                    logs = new Logs(user.getId(), "CREATED " + username1 + "'s PROFILE", user.getName(), null, null);

                    if (MyJDBC.addLogsToDatabase(logs)) {
                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(this, "ACCOUNT ADDED SUCCESSFULLY");

                    } else {
                        JOptionPane.showMessageDialog(this, "tanga");
                    }

                }

                username.setText("");
                name.setText("");
                address.setText("");
                password.setText("");
                email.setText("");
                status.setText("");
                tblModel1.setRowCount(0);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblModel1 = (DefaultTableModel) jTable1.getModel();

        if (jTable1.getSelectedRowCount() == 1) {
            tblModel1.removeRow(jTable1.getSelectedRow());
        } else {
            if (jTable1.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "The Table is Empty");
            } else {
                JOptionPane.showMessageDialog(this, "Please Select a Single Row");
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String username1 = username.getText();
        String password1 = password.getText();
        String name1 = name.getText();
        String address1 = address.getText();
        String email1 = email.getText();
        String status1 = status.getText();
        DefaultTableModel tblModel1 = (DefaultTableModel) jTable1.getModel();

        if (jTable1.getSelectedRowCount() == 1) {
            if (username1.isEmpty() && password1.isEmpty() && name1.isEmpty() && address1.isEmpty() && email1.isEmpty() && status1.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill Out All the Information", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (username1.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill Out the Username", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (password1.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill Out the Password", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (name1.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill Out the Name", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (address1.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill Out the Address", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (email1.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill Out the Username", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (status1.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill Out the Status", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else {
                if (username1.length() < 6) {
                    JOptionPane.showMessageDialog(this, "Username must be 6 Characters or longer", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (password1.length() < 6) {
                    JOptionPane.showMessageDialog(this, "Password must be 6 Characters or longer", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (!email1.contains("@gmail.com")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Email", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else {
                    tblModel1.setValueAt(name1, jTable1.getSelectedRow(), 0);
                    tblModel1.setValueAt(username1, jTable1.getSelectedRow(), 1);
                    tblModel1.setValueAt(password1, jTable1.getSelectedRow(), 2);
                    tblModel1.setValueAt(email1, jTable1.getSelectedRow(), 3);
                    tblModel1.setValueAt(address1, jTable1.getSelectedRow(), 4);
                    tblModel1.setValueAt(status1, jTable1.getSelectedRow(), 5);

                    JOptionPane.showMessageDialog(this, "Update Successfully");
                }
            }

        } else {
            if (jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is empty");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row");
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void viewUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewUsersMouseClicked
        // TODO add your handling code here:

        viewUsers.setFont(new Font("arial", Font.BOLD, 13));
        manageProfile.setFont(new Font("arial", Font.PLAIN, 12));
        manageUserButton2.setFont(new Font("arial", Font.PLAIN, 12));

        add_user.setVisible(false);
        manage_profile.setVisible(false);
        manage_user.setVisible(true);
        DefaultTableModel tblModel2 = (DefaultTableModel) jTable2.getModel();
        tblModel2.setRowCount(0);
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int user_id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String status = resultSet.getString("status");
                String userid = String.valueOf(user_id);
                String data1[] = {userid, name, username, password, address, email, status};

                DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();

                tblModel1.addRow(data1);
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_viewUsersMouseClicked

    private void manageProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageProfileMouseClicked
        // TODO add your handling code here:
        manage_profile.setVisible(true);
        add_user.setVisible(false);
        manage_user.setVisible(false);

        manageProfile.setFont(new Font("arial", Font.BOLD, 13));
        manageUserButton2.setFont(new Font("arial", Font.PLAIN, 12));
        viewUsers.setFont(new Font("arial", Font.PLAIN, 12));

        DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();
        tblModel1.setRowCount(0);
    }//GEN-LAST:event_manageProfileMouseClicked

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        String username1 = username.getText();
        String password1 = password.getText();
        String name1 = name.getText();
        String address1 = address.getText();
        String email1 = email.getText();
        String status1 = status.getText();

        if (username1.isEmpty() && password1.isEmpty() && name1.isEmpty() && address1.isEmpty() && email1.isEmpty() && status1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the info to add account", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (username1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Username", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (password1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Password", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (name1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Name", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (address1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Address", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (email1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Email", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (status1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Status", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else {
            if (MyJDBC.validateUsername(username1)) {
                JOptionPane.showMessageDialog(this, "the username is already used", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (password1.length() < 6) {
                JOptionPane.showMessageDialog(this, "The password must be 6 characters or longer", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (!email1.contains("@gmail.com")) {
                JOptionPane.showMessageDialog(this, "Please enter a Valid Email", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else if (username1.length() < 6) {
                JOptionPane.showMessageDialog(this, "The username must be 6 characters or longer", "WARNING", JOptionPane.ERROR_MESSAGE);
            } else {
                String data[] = {name1, username1, password1, address1, email1, status1};

                DefaultTableModel tblModel1 = (DefaultTableModel) jTable1.getModel();

                tblModel1.addRow(data);
                username.setText("");
                name.setText("");
                address.setText("");
                password.setText("");
                email.setText("");
                status.setText("");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void manageUserButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageUserButton2MouseClicked
        // TODO add your handling code here:
        manage_profile.setVisible(false);
        add_user.setVisible(true);
        manage_user.setVisible(false);

        manageUserButton2.setFont(new Font("arial", Font.BOLD, 13));
        manageProfile.setFont(new Font("arial", Font.PLAIN, 12));
        viewUsers.setFont(new Font("arial", Font.PLAIN, 12));

        DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();
        tblModel1.setRowCount(0);
    }//GEN-LAST:event_manageUserButton2MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        DefaultTableModel tblModel1 = (DefaultTableModel) jTable1.getModel();
        String tblName = tblModel1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String tblUsername = tblModel1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String tblPassword = tblModel1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String tblAddress = tblModel1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String tblEmail = tblModel1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        String tblStatus = tblModel1.getValueAt(jTable1.getSelectedRow(), 5).toString();

        name.setText(tblName);
        username.setText(tblUsername);
        password.setText(tblPassword);
        email.setText(tblEmail);
        address.setText(tblAddress);
        status.setText(tblStatus);

    }//GEN-LAST:event_jTable1MouseClicked

    private void statusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void addressFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        String username1 = usernameField.getText();
        String password1 = passwordField.getText();
        String name1 = nameField.getText();
        String address1 = addressField.getText();
        String email1 = emailField.getText();
        String status1 = statusField.getText();

        DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (jTable2.getSelectedRowCount() == 1) {

                if (username1.isEmpty() && password1.isEmpty() && name1.isEmpty() && address1.isEmpty() && email1.isEmpty() && status1.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out All the Information", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (username1.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Username", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (password1.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Password", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (name1.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Name", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (address1.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Address", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (email1.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Username", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (status1.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Status", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (username1.length() < 6) {
                        JOptionPane.showMessageDialog(this, "Username must be 6 Characters or longer", "WARNING", JOptionPane.ERROR_MESSAGE);
                    } else if (password1.length() < 6) {
                        JOptionPane.showMessageDialog(this, "Password must be 6 Characters or longer", "WARNING", JOptionPane.ERROR_MESSAGE);
                    } else if (!email1.contains("@gmail.com")) {
                        JOptionPane.showMessageDialog(this, "Please enter a valid Email", "WARNING", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String userid = tblModel1.getValueAt(jTable2.getSelectedRow(), 0).toString();
                        int i = Integer.parseInt(userid);

                        tblModel1.setValueAt(name1, jTable2.getSelectedRow(), 1);
                        tblModel1.setValueAt(username1, jTable2.getSelectedRow(), 2);
                        tblModel1.setValueAt(password1, jTable2.getSelectedRow(), 3);
                        tblModel1.setValueAt(email1, jTable2.getSelectedRow(), 4);
                        tblModel1.setValueAt(address1, jTable2.getSelectedRow(), 5);
                        tblModel1.setValueAt(status1, jTable2.getSelectedRow(), 6);

                        PreparedStatement preparedStatement = connection.prepareStatement(
                                "UPDATE users SET name = ?, username=?, password=?, address=?, email=?, status=? WHERE id = ?"
                        );
                        preparedStatement.setString(1, name1);
                        preparedStatement.setString(2, username1);
                        preparedStatement.setString(3, password1);
                        preparedStatement.setString(4, address1);
                        preparedStatement.setString(5, email1);
                        preparedStatement.setString(6, status1);
                        preparedStatement.setInt(7, i);

                        logs = new Logs(user.getId(), "UPDATED " + name1 + " DETAILS", user.getName(), null, null);

                        if (MyJDBC.addLogsToDatabase(logs)) {
                            preparedStatement.executeUpdate();

                            usernameField.setText("");
                            nameField.setText("");
                            addressField.setText("");
                            passwordField.setText("");
                            emailField.setText("");
                            statusField.setText("");

                            JOptionPane.showMessageDialog(this, "Update Successfully");
                        }

                    }
                }

            } else {
                if (jTable2.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Table is empty");
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a row");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_updateButtonActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();

        String tblName = tblModel1.getValueAt(jTable2.getSelectedRow(), 1).toString();
        String tblUsername = tblModel1.getValueAt(jTable2.getSelectedRow(), 2).toString();
        String tblPassword = tblModel1.getValueAt(jTable2.getSelectedRow(), 3).toString();
        String tblAddress = tblModel1.getValueAt(jTable2.getSelectedRow(), 4).toString();
        String tblEmail = tblModel1.getValueAt(jTable2.getSelectedRow(), 5).toString();
        String tblStatus = tblModel1.getValueAt(jTable2.getSelectedRow(), 6).toString();

        nameField.setText(tblName);
        usernameField.setText(tblUsername);
        passwordField.setText(tblPassword);
        addressField.setText(tblAddress);
        emailField.setText(tblEmail);
        statusField.setText(tblStatus);
    }//GEN-LAST:event_jTable2MouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (jTable2.getSelectedRowCount() == 1) {

                String username1 = usernameField.getText();
                String password1 = passwordField.getText();
                String name1 = nameField.getText();
                String address1 = addressField.getText();
                String email1 = emailField.getText();
                String status1 = statusField.getText();

                String userid = tblModel1.getValueAt(jTable2.getSelectedRow(), 0).toString();
                int i = Integer.parseInt(userid);

                tblModel1.setValueAt(name1, jTable2.getSelectedRow(), 1);
                tblModel1.setValueAt(username1, jTable2.getSelectedRow(), 2);
                tblModel1.setValueAt(password1, jTable2.getSelectedRow(), 3);
                tblModel1.setValueAt(email1, jTable2.getSelectedRow(), 4);
                tblModel1.setValueAt(address1, jTable2.getSelectedRow(), 5);
                tblModel1.setValueAt(status1, jTable2.getSelectedRow(), 6);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM users WHERE id = ?");

                preparedStatement.setInt(1, i);

                preparedStatement.executeUpdate();

                usernameField.setText("");
                nameField.setText("");
                addressField.setText("");
                passwordField.setText("");
                emailField.setText("");
                statusField.setText("");
                JOptionPane.showMessageDialog(this, "Delete Successfully");
                logs = new Logs(user.getId(), "DELETED " + name1 + "'s PROFILE", user.getName(), null, null);

                MyJDBC.addLogsToDatabase(logs);

                tblModel1.removeRow(jTable2.getSelectedRow());

            } else {
                if (jTable2.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Table is empty");
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a row");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void view_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_productsMouseClicked
        // TODO add your handling code here:
        view_products.setFont(new Font("arial", Font.BOLD, 13));
        stockControlButton.setFont(new Font("arial", Font.PLAIN, 12));
        supplierButton.setFont(new Font("arial", Font.PLAIN, 12));
        orderTransactionButton.setFont(new Font("arial", Font.PLAIN, 12));

        orderPanel.setVisible(false);
        view_product_panel.setVisible(true);
        stock_control_panel.setVisible(false);
        supplierPanel.setVisible(false);

        DefaultTableModel tblModel2 = (DefaultTableModel) jTable3.getModel();
        tblModel2.setRowCount(0);
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM stocks");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_id = resultSet.getInt("id");
                String item = resultSet.getString("product_name");
                BigDecimal price = resultSet.getBigDecimal("product_price");
                String category = resultSet.getString("category");
                int qty = resultSet.getInt("quantity");
                String dsc = resultSet.getString("description");
                String price1 = String.valueOf(price);
                String item_product = String.valueOf(product_id);
                String qty1 = String.valueOf(qty);
                String data1[] = {item_product, item, price1, qty1, category, dsc};

                DefaultTableModel tblModel1 = (DefaultTableModel) jTable3.getModel();

                tblModel1.addRow(data1);
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_view_productsMouseClicked

    private void stockControlButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockControlButtonMouseClicked
        // TODO add your handling code here:

        stockControlButton.setFont(new Font("arial", Font.BOLD, 13));
        view_products.setFont(new Font("arial", Font.PLAIN, 12));
        supplierButton.setFont(new Font("arial", Font.PLAIN, 12));
        orderTransactionButton.setFont(new Font("arial", Font.PLAIN, 12));

        orderPanel.setVisible(false);
        stock_control_panel.setVisible(true);
        view_product_panel.setVisible(false);
        supplierPanel.setVisible(false);
        DefaultTableModel tblModel2 = (DefaultTableModel) stockControlTable.getModel();
        tblModel2.setRowCount(0);

        DefaultTableModel tblModel1 = (DefaultTableModel) stockControlTable.getModel();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM stocks");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int product_id = resultSet.getInt("id");
                String item = resultSet.getString("product_name");
                BigDecimal price = resultSet.getBigDecimal("product_price");
                String category = resultSet.getString("category");
                int qty = resultSet.getInt("quantity");
                String dsc = resultSet.getString("description");
                String price1 = String.valueOf(price);
                String item_product = String.valueOf(product_id);
                String qty1 = String.valueOf(qty);
                String data1[] = {item_product, item, price1, qty1, category, dsc};

                //DefaultTableModel tblModel4 = (DefaultTableModel) jTable4.getModel();
                tblModel1.addRow(data1);
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_stockControlButtonMouseClicked

    private void stockControlTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockControlTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tblModel1 = (DefaultTableModel) stockControlTable.getModel();

        String item = tblModel1.getValueAt(stockControlTable.getSelectedRow(), 1).toString();
        String price = tblModel1.getValueAt(stockControlTable.getSelectedRow(), 2).toString();
        String qty = tblModel1.getValueAt(stockControlTable.getSelectedRow(), 3).toString();
        String category = tblModel1.getValueAt(stockControlTable.getSelectedRow(), 4).toString();
        String desc = tblModel1.getValueAt(stockControlTable.getSelectedRow(), 5).toString();

        itemNameField.setText(item);
        priceField.setText(price);
        qtyField.setText(qty);
        categoyField.setText(category);
        descField.setText(desc);
    }//GEN-LAST:event_stockControlTableMouseClicked

    private void updateStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStockButtonActionPerformed
        // TODO add your handling code here:
        String item = itemNameField.getText();
        String price = priceField.getText();
        String qty = qtyField.getText();
        String category = categoyField.getText();
        String desc = descField.getText();
        //int qty1 = Integer.parseInt(qty);

        DefaultTableModel tblModel1 = (DefaultTableModel) stockControlTable.getModel();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (stockControlTable.getSelectedRowCount() == 1) {

                if (item.isEmpty() && price.isEmpty() && qty.isEmpty() && category.isEmpty() && desc.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out All the Information", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (item.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Item Name", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (price.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Price", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (qty.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Quantity", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (category.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Category", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else if (desc.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please Fill Out the Description", "WARNING", JOptionPane.ERROR_MESSAGE);
                } else {

                    String userid = tblModel1.getValueAt(stockControlTable.getSelectedRow(), 0).toString();
                    int i = Integer.parseInt(userid);

                    tblModel1.setValueAt(item, stockControlTable.getSelectedRow(), 1);
                    tblModel1.setValueAt(price, stockControlTable.getSelectedRow(), 2);
                    tblModel1.setValueAt(qty, stockControlTable.getSelectedRow(), 3);
                    tblModel1.setValueAt(category, stockControlTable.getSelectedRow(), 4);
                    tblModel1.setValueAt(desc, stockControlTable.getSelectedRow(), 5);

                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "UPDATE stocks SET product_name = ?, product_price=?, quantity = ? ,category=?, description=? WHERE id = ?"
                    );
                    preparedStatement.setString(1, item);
                    preparedStatement.setString(2, price);
                    preparedStatement.setString(3, qty);
                    preparedStatement.setString(4, category);
                    preparedStatement.setString(5, desc);
                    preparedStatement.setInt(6, i);

                    logs = new Logs(user.getId(), "MODIFIED AN ITEM", user.getName(), null, null);

                    if (MyJDBC.addLogsToDatabase(logs)) {
                        preparedStatement.executeUpdate();
                        itemNameField.setText("");
                        priceField.setText("");
                        qtyField.setText("");
                        categoyField.setText("");
                        descField.setText("");
                        JOptionPane.showMessageDialog(this, "Update Successfully");
                    }
                }

            } else {
                if (stockControlTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Table is empty");
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a row");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_updateStockButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblModel1 = (DefaultTableModel) stockControlTable.getModel();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (stockControlTable.getSelectedRowCount() == 1) {

                String item = itemNameField.getText();
                String price = priceField.getText();
                String qty = qtyField.getText();
                String category = categoyField.getText();
                String desc = descField.getText();
                int qty1 = Integer.parseInt(qty);

                String userid = tblModel1.getValueAt(stockControlTable.getSelectedRow(), 0).toString();
                int i = Integer.parseInt(userid);

                tblModel1.setValueAt(item, stockControlTable.getSelectedRow(), 1);
                tblModel1.setValueAt(price, stockControlTable.getSelectedRow(), 2);
                tblModel1.setValueAt(qty, stockControlTable.getSelectedRow(), 3);
                tblModel1.setValueAt(category, stockControlTable.getSelectedRow(), 4);
                tblModel1.setValueAt(desc, stockControlTable.getSelectedRow(), 5);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM stocks WHERE id = ?");

                preparedStatement.setInt(1, i);

                logs = new Logs(user.getId(), "DELETED A ITEM", user.getName(), null, null);

                if (MyJDBC.addLogsToDatabase(logs)) {
                    preparedStatement.executeUpdate();

                    itemNameField.setText("");
                    priceField.setText("");
                    qtyField.setText("");
                    categoyField.setText("");
                    descField.setText("");
                    JOptionPane.showMessageDialog(this, "Delete Successfully");

                    tblModel1.removeRow(stockControlTable.getSelectedRow());
                }

            } else {
                if (stockControlTable.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "Table is empty");
                } else {
                    JOptionPane.showMessageDialog(this, "Please select a row");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    String date;
    String tPrice;
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here: 

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String status = "PAID";
        String item = itemField.getText();
        String price = itemPriceField.getText();
        String qty = quantityField.getText();
        String category = categoryField.getText();

        String paymentMethod = jComboBox6.getSelectedItem().toString();
        try {
            date = sdf.format(jDateChooser1.getDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter Pre-Order Date", "WARNING", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!price.isEmpty() && !qty.isEmpty()) {
            tPrice = String.valueOf(Double.parseDouble(price) * Double.parseDouble(qty));
        } else {

        }

        if (jCheckBox1.isSelected()) {
            status = "not paid";
        }

        if (item.isEmpty() && price.isEmpty() && qty.isEmpty() && category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the info to add item", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (item.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Item Name", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Item Price", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Quantity", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else if (category.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Item Category", "WARNING", JOptionPane.ERROR_MESSAGE);
        } else {

            String data[] = {item, price, qty, category, paymentMethod, "IMPORT", date, tPrice, status};

            DefaultTableModel tblModel1 = (DefaultTableModel) supplierTable.getModel();

            tblModel1.addRow(data);
            itemField.setText("");
            itemPriceField.setText("");
            quantityField.setText("");
            categoryField.setText("");

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void supplierButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierButtonMouseClicked
        // TODO add your handling code here:
        supplierButton.setFont(new Font("arial", Font.BOLD, 13));
        stockControlButton.setFont(new Font("arial", Font.PLAIN, 12));
        view_products.setFont(new Font("arial", Font.PLAIN, 12));
        orderTransactionButton.setFont(new Font("arial", Font.PLAIN, 12));

        supplierPanel.setVisible(true);
        orderPanel.setVisible(false);
        stock_control_panel.setVisible(false);
        view_product_panel.setVisible(false);
    }//GEN-LAST:event_supplierButtonMouseClicked

    private void itemPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemPriceFieldActionPerformed

    private void itemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemFieldActionPerformed

    private void categoryFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryFieldActionPerformed


    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblModel1 = (DefaultTableModel) supplierTable.getModel();
        DefaultTableModel tblModel2 = (DefaultTableModel) jTable4.getModel();

        if (tblModel1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "WALANG LAMAN LODS");
        } else {

            //add this motherfucker to the order panel table
            for (int i = 0; i < tblModel1.getRowCount(); i++) {

                String item = tblModel1.getValueAt(i, 0).toString();
                String price = tblModel1.getValueAt(i, 1).toString();
                String qty = tblModel1.getValueAt(i, 2).toString();
                String category = tblModel1.getValueAt(i, 3).toString();
                String payment = tblModel1.getValueAt(i, 4).toString();
                String preOrderDate = tblModel1.getValueAt(i, 6).toString();
                String tprice = tblModel1.getValueAt(i, 7).toString();
                String status = tblModel1.getValueAt(i, 8).toString();

                int qty1 = Integer.parseInt(qty);
                //InputStream in = new FileInputStream("C:\Users\gilbert\Downloads\settings.png");  

                logs = new Logs(user.getId(), "ORDERED " + item + " ITEM", user.getName(), null, null);

                transaction = new Transaction(user.getId(), "IMPORT", item, new BigDecimal(price), qty1, "SUPPLIER", new BigDecimal(tprice), payment, status, preOrderDate, category, "NONE", "TO RECEIVE", null);

                if (MyJDBC.addLogsToDatabase(logs) && MyJDBC.addTransactionToDatabase(transaction)) {
                    String data[] = {item, price, qty, category, "NONE", payment, "IMPORT", preOrderDate, tprice, status, "TO RECEIVE"};

                    tblModel2.addRow(data);
                   
                }

            }
            JOptionPane.showMessageDialog(this, "ITEM ORDER SUCCESSFULLY CREATED");
            itemField.setText("");
            itemPriceField.setText("");
            quantityField.setText("");
            categoryField.setText("");

            tblModel1.setRowCount(0);

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void profEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profEditButtonActionPerformed
        // TODO add your handling code here:
        profNameField.setEditable(true);
        profNameField2.setEditable(true);
        profNameField3.setEditable(true);
        profNameField1.setEditable(true);

        profEditButton.setEnabled(false);
        jButton10.setEnabled(true);

    }//GEN-LAST:event_profEditButtonActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:

        String name = profNameField1.getText();
        String username = profNameField2.getText();
        String email = profNameField3.getText();
        String address = profNameField.getText();
        int userId = user.getId();

        try {

            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement editDetails = connection.prepareStatement(
                    "UPDATE users SET name = ?, username = ?, email = ?, address = ? WHERE id = ?"
            );

            editDetails.setString(1, name);
            editDetails.setString(2, username);
            editDetails.setString(3, email);
            editDetails.setString(4, address);
            editDetails.setInt(5, userId);

            logs = new Logs(user.getId(), "MODIFIED THE PROFILE", user.getUsername(), null, null);
            if (MyJDBC.addLogsToDatabase(logs)) {
                editDetails.executeUpdate();
                JOptionPane.showMessageDialog(this, "UPDATE COMPLETE");
                profNameField.setEditable(false);
                profNameField2.setEditable(false);
                profNameField3.setEditable(false);
                profNameField1.setEditable(false);
                profEditButton.setEnabled(true);
                jButton10.setEnabled(false);

                jLabel13.setText("<html>"
                        + "<body style='line-height:-10'>"
                        + "<p style='text-transform:uppercase'>" + "<b>" + name.toUpperCase() + "</b>" + "</p>" + "<p style='font-size: 11'>" + "@" + username + "  |  " + user.getStatus().toLowerCase() + "</p>" + "</body>" + "<html>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void profNameField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profNameField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profNameField1ActionPerformed

    private void profNameField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profNameField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profNameField3ActionPerformed

    private void profNameField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profNameField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_profNameField2ActionPerformed

    private void userAuditLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userAuditLogMouseClicked
        // TODO add your handling code here:
        productHistoryLog_panel.setVisible(true);
        auditLog_panel.setVisible(false);

        userAuditLog.setFont(new Font("arial", Font.BOLD, 13));
        jLabel25.setFont(new Font("arial", Font.PLAIN, 12));
        adminAuditLog.setFont(new Font("arial", Font.PLAIN, 12));

        // jPanel2.dispose();
        pastLogs1.clear();
        jPanel3.removeAll();
        pastLogs1 = MyJDBC.getLogsUser(user);

        for (int i = pastLogs1.size() - 1; i > 0; i--) {

            Logs pastLog = pastLogs1.get(i);

            JPanel container = new JPanel();

            container.setLayout(new BorderLayout());
            container.setBorder(BorderFactory.createEtchedBorder());

            JLabel actions = new JLabel(pastLog.getActions());
            actions.setForeground(new Color(0x000066));
            actions.setFont(new Font("Arial", Font.BOLD, 15));

            JLabel byWho = new JLabel(pastLog.getModifiedBy());
            byWho.setForeground(new Color(0x000066));
            byWho.setFont(new Font("Arial", Font.BOLD, 15));

            JLabel timeLabel = new JLabel(pastLog.getLogsDate().toString() + "  |  " + pastLog.getLogsTime().toString());
            timeLabel.setForeground(new Color(0x000066));
            timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));

            container.add(byWho, BorderLayout.EAST);
            container.add(actions, BorderLayout.CENTER);
            container.add(timeLabel, BorderLayout.SOUTH);

            container.setBackground(Color.WHITE);

            jPanel3.add(container);

        }
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_userAuditLogMouseClicked


    private void adminAuditLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminAuditLogMouseClicked
        // TODO add your handling code here:
        auditLog_panel.setVisible(true);
        productHistoryLog_panel.setVisible(false);

        adminAuditLog.setFont(new Font("arial", Font.BOLD, 13));
        jLabel25.setFont(new Font("arial", Font.PLAIN, 12));
        userAuditLog.setFont(new Font("arial", Font.PLAIN, 12));

        pastLogs.clear();
        jPanel2.removeAll();
        pastLogs = MyJDBC.getLogs(user);

        for (int i = pastLogs.size() - 1; i > 0; i--) {

            Logs pastLog = pastLogs.get(i);

            JPanel container = new JPanel();

            container.setLayout(new BorderLayout());
            container.setBorder(BorderFactory.createEtchedBorder());

            JLabel actions = new JLabel(pastLog.getActions());
            actions.setForeground(new Color(0x000066));
            actions.setFont(new Font("Arial", Font.BOLD, 15));

            JLabel byWho = new JLabel(pastLog.getModifiedBy());
            byWho.setForeground(new Color(0x000066));
            byWho.setFont(new Font("Arial", Font.BOLD, 15));

            JLabel timeLabel = new JLabel(pastLog.getLogsDate().toString() + "  |  " + pastLog.getLogsTime().toString());
            timeLabel.setForeground(new Color(0x000066));
            timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));

            container.add(byWho, BorderLayout.EAST);
            container.add(actions, BorderLayout.CENTER);
            container.add(timeLabel, BorderLayout.SOUTH);

            container.setBackground(Color.WHITE);

            jPanel2.add(container);

        }
        jPanel2.repaint();
        jPanel2.revalidate();

    }//GEN-LAST:event_adminAuditLogMouseClicked


    private void auditLog_panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_auditLog_panelMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_auditLog_panelMouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
//if (evt.getKeyChar() >= 'a' || evt.getKeyChar() <= 'z') {
        if (jComboBox1.getSelectedItem().equals("all")) {
            if (evt.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {

                pastLogs1.clear();
                jPanel2.removeAll();
                pastLogs1 = MyJDBC.getLogsAdminSearch(user, jTextField1.getText().toUpperCase());

                for (int i = pastLogs1.size() - 1; i > 0; i--) {

                    Logs pastLog = pastLogs1.get(i);

                    JPanel container = new JPanel();

                    container.setLayout(new BorderLayout());
                    container.setBorder(BorderFactory.createEtchedBorder());

                    JLabel actions = new JLabel(pastLog.getActions());
                    actions.setForeground(new Color(0x000066));
                    actions.setFont(new Font("Arial", Font.BOLD, 15));

                    JLabel byWho = new JLabel(pastLog.getModifiedBy());
                    byWho.setForeground(new Color(0x000066));
                    byWho.setFont(new Font("Arial", Font.BOLD, 15));

                    JLabel timeLabel = new JLabel(pastLog.getLogsDate().toString() + "  |  " + pastLog.getLogsTime().toString());
                    timeLabel.setForeground(new Color(0x000066));
                    timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));

                    container.add(byWho, BorderLayout.EAST);
                    container.add(actions, BorderLayout.CENTER);
                    container.add(timeLabel, BorderLayout.SOUTH);

                    container.setBackground(Color.WHITE);

                    jPanel2.add(container);

                }
                jPanel2.repaint();
                jPanel2.revalidate();

            }
        } else if (jComboBox1.getSelectedItem().equals("action")) {
            if (evt.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {

                pastLogs1.clear();
                jPanel2.removeAll();
                pastLogs1 = MyJDBC.getLogsAdminSearchAction(user, jTextField1.getText().toUpperCase());

                for (int i = pastLogs1.size() - 1; i > 0; i--) {

                    Logs pastLog = pastLogs1.get(i);

                    JPanel container = new JPanel();

                    container.setLayout(new BorderLayout());
                    container.setBorder(BorderFactory.createEtchedBorder());

                    JLabel actions = new JLabel(pastLog.getActions());
                    actions.setForeground(new Color(0x000066));
                    actions.setFont(new Font("Arial", Font.BOLD, 15));

                    JLabel byWho = new JLabel(pastLog.getModifiedBy());
                    byWho.setForeground(new Color(0x000066));
                    byWho.setFont(new Font("Arial", Font.BOLD, 15));

                    JLabel timeLabel = new JLabel(pastLog.getLogsDate().toString() + "  |  " + pastLog.getLogsTime().toString());
                    timeLabel.setForeground(new Color(0x000066));
                    timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));

                    container.add(byWho, BorderLayout.EAST);
                    container.add(actions, BorderLayout.CENTER);
                    container.add(timeLabel, BorderLayout.SOUTH);

                    container.setBackground(Color.WHITE);

                    jPanel2.add(container);

                }
                jPanel2.repaint();
                jPanel2.revalidate();

            }

        } else if (jComboBox1.getSelectedItem().equals("user")) {
            if (evt.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {

                pastLogs1.clear();
                jPanel2.removeAll();
                pastLogs1 = MyJDBC.getLogsAdminSearchUser(user, jTextField1.getText().toUpperCase());

                for (int i = pastLogs1.size() - 1; i > 0; i--) {

                    Logs pastLog = pastLogs1.get(i);

                    JPanel container = new JPanel();

                    container.setLayout(new BorderLayout());
                    container.setBorder(BorderFactory.createEtchedBorder());

                    JLabel actions = new JLabel(pastLog.getActions());
                    actions.setForeground(new Color(0x000066));
                    actions.setFont(new Font("Arial", Font.BOLD, 15));

                    JLabel byWho = new JLabel(pastLog.getModifiedBy());
                    byWho.setForeground(new Color(0x000066));
                    byWho.setFont(new Font("Arial", Font.BOLD, 15));

                    JLabel timeLabel = new JLabel(pastLog.getLogsDate().toString() + "  |  " + pastLog.getLogsTime().toString());
                    timeLabel.setForeground(new Color(0x000066));
                    timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));

                    container.add(byWho, BorderLayout.EAST);
                    container.add(actions, BorderLayout.CENTER);
                    container.add(timeLabel, BorderLayout.SOUTH);

                    container.setBackground(Color.WHITE);

                    jPanel2.add(container);

                }
                jPanel2.repaint();
                jPanel2.revalidate();

            }
        }


    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
        if (jComboBox2.getSelectedItem().equals("all")) {
            pastLogs1.clear();
            jPanel3.removeAll();
            pastLogs1 = MyJDBC.getLogsUserSearch(user, jTextField3.getText().toUpperCase(), user.getId());

            for (int i = pastLogs1.size() - 1; i > 0; i--) {

                Logs pastLog = pastLogs1.get(i);

                JPanel container = new JPanel();

                container.setLayout(new BorderLayout());
                container.setBorder(BorderFactory.createEtchedBorder());

                JLabel actions = new JLabel(pastLog.getActions());
                actions.setForeground(new Color(0x000066));
                actions.setFont(new Font("Arial", Font.BOLD, 15));

                JLabel byWho = new JLabel(pastLog.getModifiedBy());
                byWho.setForeground(new Color(0x000066));
                byWho.setFont(new Font("Arial", Font.BOLD, 15));

                JLabel timeLabel = new JLabel(pastLog.getLogsDate().toString() + "  |  " + pastLog.getLogsTime().toString());
                timeLabel.setForeground(new Color(0x000066));
                timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));

                container.add(byWho, BorderLayout.EAST);
                container.add(actions, BorderLayout.CENTER);
                container.add(timeLabel, BorderLayout.SOUTH);

                container.setBackground(Color.WHITE);

                jPanel3.add(container);

            }
            jPanel3.repaint();
            jPanel3.revalidate();
        } else if (jComboBox2.getSelectedItem().equals("action")) {
            pastLogs1.clear();
            jPanel3.removeAll();
            pastLogs1 = MyJDBC.getLogsUserSearchAction(user, jTextField3.getText().toUpperCase(), user.getId());

            for (int i = pastLogs1.size() - 1; i > 0; i--) {

                Logs pastLog = pastLogs1.get(i);

                JPanel container = new JPanel();

                container.setLayout(new BorderLayout());
                container.setBorder(BorderFactory.createEtchedBorder());

                JLabel actions = new JLabel(pastLog.getActions());
                actions.setForeground(new Color(0x000066));
                actions.setFont(new Font("Arial", Font.BOLD, 15));

                JLabel byWho = new JLabel(pastLog.getModifiedBy());
                byWho.setForeground(new Color(0x000066));
                byWho.setFont(new Font("Arial", Font.BOLD, 15));

                JLabel timeLabel = new JLabel(pastLog.getLogsDate().toString() + "  |  " + pastLog.getLogsTime().toString());
                timeLabel.setForeground(new Color(0x000066));
                timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));

                container.add(byWho, BorderLayout.EAST);
                container.add(actions, BorderLayout.CENTER);
                container.add(timeLabel, BorderLayout.SOUTH);

                container.setBackground(Color.WHITE);

                jPanel3.add(container);

            }

            jPanel3.repaint();
            jPanel3.revalidate();

        } else if (jComboBox2.getSelectedItem().equals("product")) {
            pastLogs1.clear();
            jPanel3.removeAll();
            pastLogs1 = MyJDBC.getLogsUserSearchAction(user, jTextField3.getText().toUpperCase(), user.getId());

            for (int i = pastLogs1.size() - 1; i > 0; i--) {

                Logs pastLog = pastLogs1.get(i);

                JPanel container = new JPanel();

                container.setLayout(new BorderLayout());
                container.setBorder(BorderFactory.createEtchedBorder());

                JLabel actions = new JLabel(pastLog.getActions());
                actions.setForeground(new Color(0x000066));
                actions.setFont(new Font("Arial", Font.BOLD, 15));

                JLabel byWho = new JLabel(pastLog.getModifiedBy());
                byWho.setForeground(new Color(0x000066));
                byWho.setFont(new Font("Arial", Font.BOLD, 15));

                JLabel timeLabel = new JLabel(pastLog.getLogsDate().toString() + "  |  " + pastLog.getLogsTime().toString());
                timeLabel.setForeground(new Color(0x000066));
                timeLabel.setFont(new Font("Arial", Font.PLAIN, 13));

                container.add(byWho, BorderLayout.EAST);
                container.add(actions, BorderLayout.CENTER);
                container.add(timeLabel, BorderLayout.SOUTH);

                container.setBackground(Color.WHITE);

                jPanel3.add(container);

            }

            jPanel3.repaint();
            jPanel3.revalidate();
        }

    }//GEN-LAST:event_jTextField3KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
        if (jComboBox3.getSelectedItem().equals("product")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable3.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM stocks WHERE (product_name LIKE ?)");

                String searchString = "%" + jTextField6.getText() + "%";
                preparedStatement.setString(1, searchString);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int product_id = resultSet.getInt("id");
                    String item = resultSet.getString("product_name");
                    BigDecimal price = resultSet.getBigDecimal("product_price");
                    String category = resultSet.getString("category");
                    int qty = resultSet.getInt("quantity");
                    String dsc = resultSet.getString("description");
                    String price1 = String.valueOf(price);
                    String item_product = String.valueOf(product_id);
                    String qty1 = String.valueOf(qty);
                    String data1[] = {item_product, item, price1, qty1, category, dsc};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable3.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (jComboBox3.getSelectedItem().equals("price")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable3.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM stocks WHERE (product_price LIKE ?)");

                String searchString = "%" + jTextField6.getText() + "%";
                preparedStatement.setString(1, searchString);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int product_id = resultSet.getInt("id");
                    String item = resultSet.getString("product_name");
                    BigDecimal price = resultSet.getBigDecimal("product_price");
                    String category = resultSet.getString("category");
                    int qty = resultSet.getInt("quantity");
                    String dsc = resultSet.getString("description");
                    String price1 = String.valueOf(price);
                    String item_product = String.valueOf(product_id);
                    String qty1 = String.valueOf(qty);
                    String data1[] = {item_product, item, price1, qty1, category, dsc};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable3.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (jComboBox3.getSelectedItem().equals("category")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable3.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM stocks WHERE (category LIKE ?)");

                String searchString = "%" + jTextField6.getText() + "%";
                preparedStatement.setString(1, searchString);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int product_id = resultSet.getInt("id");
                    String item = resultSet.getString("product_name");
                    BigDecimal price = resultSet.getBigDecimal("product_price");
                    String category = resultSet.getString("category");
                    int qty = resultSet.getInt("quantity");
                    String dsc = resultSet.getString("description");
                    String price1 = String.valueOf(price);
                    String item_product = String.valueOf(product_id);
                    String qty1 = String.valueOf(qty);
                    String data1[] = {item_product, item, price1, qty1, category, dsc};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable3.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (jComboBox3.getSelectedItem().equals("description")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable3.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM stocks WHERE (description LIKE ?)");

                String searchString = "%" + jTextField6.getText() + "%";
                preparedStatement.setString(1, searchString);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int product_id = resultSet.getInt("id");
                    String item = resultSet.getString("product_name");
                    BigDecimal price = resultSet.getBigDecimal("product_price");
                    String category = resultSet.getString("category");
                    int qty = resultSet.getInt("quantity");
                    String dsc = resultSet.getString("description");
                    String price1 = String.valueOf(price);
                    String item_product = String.valueOf(product_id);
                    String qty1 = String.valueOf(qty);
                    String data1[] = {item_product, item, price1, qty1, category, dsc};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable3.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jTextField6KeyPressed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
        if (jComboBox4.getSelectedItem().equals("product")) {

            DefaultTableModel tblModel2 = (DefaultTableModel) stockControlTable.getModel();
            tblModel2.setRowCount(0);

            DefaultTableModel tblModel1 = (DefaultTableModel) stockControlTable.getModel();
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM stocks WHERE (product_name LIKE ?)");

                String searchString = "%" + jTextField4.getText() + "%";
                preparedStatement.setString(1, searchString);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int product_id = resultSet.getInt("id");
                    String item = resultSet.getString("product_name");
                    BigDecimal price = resultSet.getBigDecimal("product_price");
                    String category = resultSet.getString("category");
                    int qty = resultSet.getInt("quantity");
                    String dsc = resultSet.getString("description");
                    String price1 = String.valueOf(price);
                    String item_product = String.valueOf(product_id);
                    String qty1 = String.valueOf(qty);
                    String data1[] = {item_product, item, price1, qty1, category, dsc};

                    //DefaultTableModel tblModel4 = (DefaultTableModel) jTable4.getModel();
                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (jComboBox4.getSelectedItem().equals("price")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) stockControlTable.getModel();
            tblModel2.setRowCount(0);

            DefaultTableModel tblModel1 = (DefaultTableModel) stockControlTable.getModel();
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM stocks WHERE (product_price LIKE ?)");

                String searchString = "%" + jTextField4.getText() + "%";
                preparedStatement.setString(1, searchString);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int product_id = resultSet.getInt("id");
                    String item = resultSet.getString("product_name");
                    BigDecimal price = resultSet.getBigDecimal("product_price");
                    String category = resultSet.getString("category");
                    int qty = resultSet.getInt("quantity");
                    String dsc = resultSet.getString("description");
                    String price1 = String.valueOf(price);
                    String item_product = String.valueOf(product_id);
                    String qty1 = String.valueOf(qty);
                    String data1[] = {item_product, item, price1, qty1, category, dsc};

                    //DefaultTableModel tblModel4 = (DefaultTableModel) jTable4.getModel();
                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (jComboBox4.getSelectedItem().equals("category")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) stockControlTable.getModel();
            tblModel2.setRowCount(0);

            DefaultTableModel tblModel1 = (DefaultTableModel) stockControlTable.getModel();
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM stocks WHERE (category LIKE ?)");

                String searchString = "%" + jTextField4.getText() + "%";
                preparedStatement.setString(1, searchString);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int product_id = resultSet.getInt("id");
                    String item = resultSet.getString("product_name");
                    BigDecimal price = resultSet.getBigDecimal("product_price");
                    String category = resultSet.getString("category");
                    int qty = resultSet.getInt("quantity");
                    String dsc = resultSet.getString("description");
                    String price1 = String.valueOf(price);
                    String item_product = String.valueOf(product_id);
                    String qty1 = String.valueOf(qty);
                    String data1[] = {item_product, item, price1, qty1, category, dsc};

                    //DefaultTableModel tblModel4 = (DefaultTableModel) jTable4.getModel();
                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (jComboBox4.getSelectedItem().equals("description")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) stockControlTable.getModel();
            tblModel2.setRowCount(0);

            DefaultTableModel tblModel1 = (DefaultTableModel) stockControlTable.getModel();
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM stocks WHERE (description LIKE ?)");

                String searchString = "%" + jTextField4.getText() + "%";
                preparedStatement.setString(1, searchString);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int product_id = resultSet.getInt("id");
                    String item = resultSet.getString("product_name");
                    BigDecimal price = resultSet.getBigDecimal("product_price");
                    String category = resultSet.getString("category");
                    int qty = resultSet.getInt("quantity");
                    String dsc = resultSet.getString("description");
                    String price1 = String.valueOf(price);
                    String item_product = String.valueOf(product_id);
                    String qty1 = String.valueOf(qty);
                    String data1[] = {item_product, item, price1, qty1, category, dsc};

                    //DefaultTableModel tblModel4 = (DefaultTableModel) jTable4.getModel();
                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jTextField4KeyPressed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:

        if (jComboBox5.getSelectedItem().equals("all")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable2.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM users WHERE (name LIKE ? OR username LIKE ? OR email LIKE ? OR address LIKE ?)");

                String searchString = "%" + jTextField2.getText() + "%";
                preparedStatement.setString(1, searchString);
                preparedStatement.setString(2, searchString);
                preparedStatement.setString(3, searchString);
                preparedStatement.setString(4, searchString);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int user_id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    String status = resultSet.getString("status");
                    String userid = String.valueOf(user_id);
                    String data1[] = {userid, name, username, password, address, email, status};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (jComboBox5.getSelectedItem().equals("name")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable2.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM users WHERE (name LIKE ?)");

                String searchString = "%" + jTextField2.getText() + "%";
                preparedStatement.setString(1, searchString);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int user_id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    String status = resultSet.getString("status");
                    String userid = String.valueOf(user_id);
                    String data1[] = {userid, name, username, password, address, email, status};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (jComboBox5.getSelectedItem().equals("email")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable2.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM users WHERE (email LIKE ?)");

                String searchString = "%" + jTextField2.getText() + "%";
                preparedStatement.setString(1, searchString);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int user_id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    String status = resultSet.getString("status");
                    String userid = String.valueOf(user_id);
                    String data1[] = {userid, name, username, password, address, email, status};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (jComboBox5.getSelectedItem().equals("address")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable2.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM users WHERE (address LIKE ?)");

                String searchString = "%" + jTextField2.getText() + "%";
                preparedStatement.setString(1, searchString);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int user_id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    String status = resultSet.getString("status");
                    String userid = String.valueOf(user_id);
                    String data1[] = {userid, name, username, password, address, email, status};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable2.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jTextField2KeyPressed

    private void orderTransactionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTransactionButtonMouseClicked
        // TODO add your handling code here:
        orderTransactionButton.setFont(new Font("arial", Font.BOLD, 13));
        stockControlButton.setFont(new Font("arial", Font.PLAIN, 12));
        supplierButton.setFont(new Font("arial", Font.PLAIN, 12));
        view_products.setFont(new Font("arial", Font.PLAIN, 12));

        orderPanel.setVisible(true);
        supplierPanel.setVisible(false);
        view_product_panel.setVisible(false);
        stock_control_panel.setVisible(false);

        DefaultTableModel tblModel3 = (DefaultTableModel) jTable4.getModel();

        for (int i = 0; i < tblModel3.getRowCount(); i++) {

            String preOrderDate = tblModel3.getValueAt(i, 7).toString();
            String hehe1 = tblModel3.getValueAt(i, 9).toString();
            LocalDate today = LocalDate.now();
            String status123 = tblModel3.getValueAt(i, 10).toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String dateNow = today.toString();

            System.out.println(dateNow);

            //String preOrderDate1 = sdf.format(preOrderDate);
            System.out.println(preOrderDate);

            try {
                currentDate = sdf.parse(dateNow);
                targetDate = sdf.parse(preOrderDate);

            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                e.printStackTrace(); // Optional for debugging
            }
            //16-05-2024         
            if (currentDate.before(targetDate)) {
                System.out.println("Date 1 is before Date 2.");
            } else if (currentDate.after(targetDate) && status123.equals("TO RECEIVE") && hehe1.equals("PAID")) {
                //
                System.out.println("after the date");
                DefaultTableModel tblModel1 = (DefaultTableModel) jTable4.getModel();

                if (tblModel1.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "WALANG LAMAN LODS");
                } else {
                    try {
                        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                        for (int v = 0; v < tblModel1.getRowCount(); v++) {
                            String item = tblModel1.getValueAt(v, 0).toString();
                            String price = tblModel1.getValueAt(v, 1).toString();
                            String qty = tblModel1.getValueAt(v, 2).toString();
                            String category = tblModel1.getValueAt(v, 3).toString();
                            String desc = tblModel1.getValueAt(v, 4).toString();

                            PreparedStatement preparedStatement = connection.prepareStatement(
                                    "INSERT into stocks(product_name, product_price, category, quantity, description)"
                                    + "VALUES(?,?,?,?,?)");
                            preparedStatement.setString(1, item);
                            preparedStatement.setString(2, price);
                            preparedStatement.setString(3, category);
                            preparedStatement.setString(4, qty);
                            preparedStatement.setString(5, desc);

                            PreparedStatement preparedStatement1 = connection.prepareStatement(
                                    "UPDATE transaction SET delivery = ? WHERE  product_name = ?"
                            );
                            preparedStatement1.setString(1, "ITEM RECIEVED");
                            preparedStatement1.setString(2, item);

                            logs = new Logs(user.getId(), "Order item " + item + "' arrived", user.getName(), null, null);

                            if (MyJDBC.addLogsToDatabase(logs)) {
                                preparedStatement.executeUpdate();
                                preparedStatement1.executeUpdate();
                                JOptionPane.showMessageDialog(this, "Received item SUCCESSFULLY");
                            } else {
                                JOptionPane.showMessageDialog(this, "tanga");
                            }

                        }

                        tblModel1.setRowCount(0);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            } else {

            }

            System.out.println(dateNow + "burat");

        }

        if (user.getStatus().equalsIgnoreCase("admin")) {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable4.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM transaction");

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String item = resultSet.getString("product_name");
                    String price = String.valueOf(resultSet.getBigDecimal("product_price"));
                    String qty = String.valueOf(resultSet.getInt("product_quantity"));
                    String category = resultSet.getString("category");
                    String desc = resultSet.getString("description");
                    String transactionType = resultSet.getString("transaction_type");
                    String payment = resultSet.getString("payment_method");
                    String preOrderDate = resultSet.getString("pre_order_date");
                    String tprice = String.valueOf(resultSet.getBigDecimal("total_price"));
                    String status = resultSet.getString("status");
                    String delivery = resultSet.getString("delivery");
                    String qty1 = String.valueOf(qty);

                    String data1[] = {item, price, qty, category, desc, payment, transactionType, preOrderDate, tprice, status, delivery};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable4.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            DefaultTableModel tblModel2 = (DefaultTableModel) jTable4.getModel();
            tblModel2.setRowCount(0);
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM transaction WHERE user_id=?");

                preparedStatement.setInt(1, user.getId());

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String item = resultSet.getString("product_name");
                    String price = String.valueOf(resultSet.getBigDecimal("product_price"));
                    String qty = String.valueOf(resultSet.getInt("product_quantity"));
                    String category = resultSet.getString("category");
                    String desc = resultSet.getString("description");
                    String transactionType = resultSet.getString("transaction_type");
                    String payment = resultSet.getString("payment_method");
                    String preOrderDate = resultSet.getString("pre_order_date");
                    String tprice = String.valueOf(resultSet.getBigDecimal("total_price"));
                    String status = resultSet.getString("status");
                    String qty1 = String.valueOf(qty);

                    String data1[] = {item, price, qty, category, desc, payment, transactionType, preOrderDate, tprice, status};

                    DefaultTableModel tblModel1 = (DefaultTableModel) jTable4.getModel();

                    tblModel1.addRow(data1);
                }
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_orderTransactionButtonMouseClicked

    private void itemPriceFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemPriceFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            itemPriceField.setEditable(true);
        } else {
            itemPriceField.setEditable(false);
        }

    }//GEN-LAST:event_itemPriceFieldKeyPressed

    private void itemPriceFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemPriceFieldKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_itemPriceFieldKeyTyped

    private void quantityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            quantityField.setEditable(true);
        } else {
            quantityField.setEditable(false);
        }
    }//GEN-LAST:event_quantityFieldKeyPressed

    private void quantityFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_quantityFieldKeyTyped

    private void priceFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            priceField.setEditable(true);
        } else {
            priceField.setEditable(false);
        }
    }//GEN-LAST:event_priceFieldKeyPressed

    private void qtyFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
            qtyField.setEditable(true);
        } else {
            qtyField.setEditable(false);
        }
    }//GEN-LAST:event_qtyFieldKeyPressed

    private void qtyFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyFieldKeyTyped

    private void qtyFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyFieldKeyReleased
        // TODO add your handling code here:

        try {
            int value = Integer.parseInt(qtyField.getText());
            if (value > 100) {
                updateStockButton.setEnabled(false);
            } else {
                updateStockButton.setEnabled(true);
            }
        } catch (NumberFormatException ex) {
            // Handle non-integer input
            updateStockButton.setEnabled(true);
        }
    }//GEN-LAST:event_qtyFieldKeyReleased

    private void quantityFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyReleased
        // TODO add your handling code here:
        try {
            int value = Integer.parseInt(quantityField.getText());
            if (value >= 100) {
                jButton7.setEnabled(false);
            } else {
                jButton7.setEnabled(true);
            }
        } catch (NumberFormatException ex) {
            jButton7.setEnabled(true);
        }
    }//GEN-LAST:event_quantityFieldKeyReleased

    private void payNowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payNowButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel tblModel3 = (DefaultTableModel) jTable4.getModel();

        
//            String hehe1 = tblModel3.getValueAt(i, 9).toString();
//            String item = tblModel3.getValueAt(i, 0).toString();
            try {
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE transaction SET  delivery = ? WHERE product_name = ?");
                preparedStatement.setString(1, "PAID");
               // preparedStatement.setString(2,);
                
                logs = new Logs(user.getId(), "PAY for ", user.getName(), null, null);
                
                 if (MyJDBC.addLogsToDatabase(logs)) {
                     preparedStatement.executeUpdate();
                     JOptionPane.showMessageDialog(this, "pay item SUCCESSFULLY");
                 }
                

            } catch (SQLException e) {
                e.printStackTrace();
            }
        

    }//GEN-LAST:event_payNowButtonActionPerformed

    private void cancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelOrderButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add_user;
    private javax.swing.JTextField address;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel adminAuditLog;
    private javax.swing.JPanel auditLog_panel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelOrderButton;
    private javax.swing.JTextField categoryField;
    private javax.swing.JTextField categoyField;
    private javax.swing.JLabel customerButton;
    private javax.swing.JPanel customer_menu;
    private javax.swing.JPanel customer_panel_frame;
    private javax.swing.JPanel customers_panel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descField;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emailField;
    private javax.swing.JPanel header;
    private javax.swing.JLabel historyButton;
    private javax.swing.JPanel history_menu;
    private javax.swing.JPanel history_panel;
    private javax.swing.JPanel history_panel_frame;
    private javax.swing.JLabel homeButton;
    private javax.swing.JPanel home_panel;
    private javax.swing.JTextField itemField;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JTextField itemPriceField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel main_menu;
    private javax.swing.JLabel manageProfile;
    private javax.swing.JLabel manageUserButton2;
    private javax.swing.JPanel manage_profile;
    private javax.swing.JPanel manage_user;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nameField;
    private javax.swing.JPanel orderPanel;
    private javax.swing.JLabel orderTransactionButton;
    private javax.swing.JTextField password;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton payNowButton;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel productButton;
    private javax.swing.JPanel productHistoryLog_panel;
    private javax.swing.JPanel product_menu;
    private javax.swing.JPanel product_panel;
    private javax.swing.JPanel product_panel_frame;
    private javax.swing.JButton profEditButton;
    private javax.swing.JTextField profNameField;
    private javax.swing.JTextField profNameField1;
    private javax.swing.JTextField profNameField2;
    private javax.swing.JTextField profNameField3;
    private javax.swing.JTextField qtyField;
    private javax.swing.JTextField quantityField;
    private javax.swing.JLabel reportingButton;
    private javax.swing.JPanel reporting_menu;
    private javax.swing.JPanel reporting_panel;
    private javax.swing.JPanel reporting_panel_frame;
    private javax.swing.JPanel setting_menu;
    private javax.swing.JPanel setting_panel;
    private javax.swing.JPanel setting_panel_frame;
    private javax.swing.JLabel settingsButton;
    private javax.swing.JTextField status;
    private javax.swing.JTextField statusField;
    private javax.swing.JLabel stockControlButton;
    private javax.swing.JTable stockControlTable;
    private javax.swing.JPanel stock_control_panel;
    private javax.swing.JLabel supplierButton;
    private javax.swing.JPanel supplierPanel;
    private javax.swing.JTable supplierTable;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateStockButton;
    private javax.swing.JLabel userAuditLog;
    private javax.swing.JTextField username;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel viewUsers;
    private javax.swing.JPanel view_product_panel;
    private javax.swing.JLabel view_products;
    // End of variables declaration//GEN-END:variables

}
