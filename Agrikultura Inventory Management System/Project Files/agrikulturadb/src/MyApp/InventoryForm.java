/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyApp;

import MyLib.MySqlClass;
import MyLib.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author janed
 */
public class InventoryForm extends javax.swing.JFrame {

    private MySqlClass mySql=new MySqlClass();
    private ArrayList<Product> prods;
    private ArrayList<Product> searchProds;
    DefaultTableModel model;
    int oldProdid;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    String name, status, stringId, pattern,sortType;
    int id, prodid, quantity;
    double sellprc, acqprc;
    boolean orderId = true, 
            orderName = true, 
            orderStatus = true, 
            orderSellprc = true, 
            orderAcqprc = true, 
            orderQty = true, 
            ordAcqdate = true, 
            ordExpdate = true;
    public InventoryForm() {
        initComponents();
        setLocationRelativeTo(null); 
    }
    Connection con;
    PreparedStatement pst;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        prodTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        selltxt = new javax.swing.JTextField();
        acqtxt = new javax.swing.JTextField();
        qtytxt = new javax.swing.JTextField();
        statcombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        acqdatechooser = new com.toedter.calendar.JDateChooser();
        expdatechooser = new com.toedter.calendar.JDateChooser();
        genReport = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        searchbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        idtxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        create = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        orderIdbtn = new javax.swing.JButton();
        orderNamebtn = new javax.swing.JButton();
        orderStatbtn = new javax.swing.JButton();
        orderSellprcbtn = new javax.swing.JButton();
        orderAcqprcbtn = new javax.swing.JButton();
        orderQtybtn = new javax.swing.JButton();
        orderAcqdatebtn = new javax.swing.JButton();
        orderExpdatebtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        backHome = new javax.swing.JMenuItem();
        option = new javax.swing.JMenu();
        menu1 = new javax.swing.JMenuItem();
        menu2 = new javax.swing.JMenuItem();
        menu3 = new javax.swing.JMenuItem();
        genRep = new javax.swing.JMenu();
        rep1 = new javax.swing.JMenuItem();
        rep2 = new javax.swing.JMenuItem();
        rep3 = new javax.swing.JMenuItem();
        rep4 = new javax.swing.JMenuItem();
        refresh = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 57)); // NOI18N
        jLabel1.setText("Information and Inventory Management System ");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MyApp/logo2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1390, 100));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Available Products", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Status", "Selling Price", "Acquisition Price", "Quantity", "Acquisition Date", "Expiry Date"
            }
        ));
        prodTable.getTableHeader().setReorderingAllowed(false);
        prodTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(prodTable);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 820, 670));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 860, 720));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Record Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Status:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Selling Price:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Acquisition Price:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Quantity:");

        nametxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        selltxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        acqtxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        qtytxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        statcombo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        statcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select Status>", "Good", "Expired" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Acquisition Date:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Expiry Date:");

        genReport.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        genReport.setText("Generate Report");
        genReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(acqtxt)
                    .addComponent(selltxt)
                    .addComponent(qtytxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(statcombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, 148, Short.MAX_VALUE)
                    .addComponent(nametxt)
                    .addComponent(acqdatechooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(expdatechooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(genReport)
                .addGap(80, 80, 80))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(statcombo))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acqtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(acqdatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(expdatechooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(genReport)
                .addGap(64, 64, 64))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 280, 320, 460));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        searchbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        searchbtn.setText("Search");
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("ID:");

        idtxt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(searchbtn)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 130, 320, 140));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Manage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        update.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        create.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        create.setText("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 190, 320));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), "Sort By", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        orderIdbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderIdbtn.setText("ID");
        orderIdbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderIdbtnActionPerformed(evt);
            }
        });

        orderNamebtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderNamebtn.setText("Name");
        orderNamebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderNamebtnActionPerformed(evt);
            }
        });

        orderStatbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderStatbtn.setText("Status");
        orderStatbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderStatbtnActionPerformed(evt);
            }
        });

        orderSellprcbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderSellprcbtn.setText("Selling Price");
        orderSellprcbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderSellprcbtnActionPerformed(evt);
            }
        });

        orderAcqprcbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderAcqprcbtn.setText("Acquisition Price");
        orderAcqprcbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderAcqprcbtnActionPerformed(evt);
            }
        });

        orderQtybtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderQtybtn.setText("Quantity");
        orderQtybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderQtybtnActionPerformed(evt);
            }
        });

        orderAcqdatebtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderAcqdatebtn.setText("Acquisition Date");
        orderAcqdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderAcqdatebtnActionPerformed(evt);
            }
        });

        orderExpdatebtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderExpdatebtn.setText("Expiry Date");
        orderExpdatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderExpdatebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderIdbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderNamebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderStatbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderSellprcbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderAcqprcbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(orderQtybtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderAcqdatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderExpdatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(orderIdbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderNamebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderStatbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderSellprcbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderAcqprcbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderQtybtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderAcqdatebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(orderExpdatebtn)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 190, 390));

        jMenu1.setText("File");

        backHome.setText("Home");
        backHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backHomeActionPerformed(evt);
            }
        });
        jMenu1.add(backHome);

        option.setText("Options");

        menu1.setText("Home");
        menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu1ActionPerformed(evt);
            }
        });
        option.add(menu1);

        menu2.setText("Replenish & Remove Inventory");
        menu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu2ActionPerformed(evt);
            }
        });
        option.add(menu2);

        menu3.setText("Sell Inventory");
        menu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu3ActionPerformed(evt);
            }
        });
        option.add(menu3);

        genRep.setText("Generate Report");

        rep1.setText("Product Record Report");
        rep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep1ActionPerformed(evt);
            }
        });
        genRep.add(rep1);

        rep2.setText("Product Replenishing Report");
        rep2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep2ActionPerformed(evt);
            }
        });
        genRep.add(rep2);

        rep3.setText("Product Removal Report");
        rep3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep3ActionPerformed(evt);
            }
        });
        genRep.add(rep3);

        rep4.setText("Sold Products Report");
        rep4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rep4ActionPerformed(evt);
            }
        });
        genRep.add(rep4);

        option.add(genRep);

        jMenu1.add(option);

        refresh.setText("Refresh Page");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jMenu1.add(refresh);

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenu1.add(logout);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1431, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        //create a new record for a product

        if(nametxt.getText().isEmpty()||selltxt.getText().isEmpty()||acqtxt.getText().isEmpty()||qtytxt.getText().isEmpty()||acqdatechooser.getDate()==null||expdatechooser.getDate()==null)
            JOptionPane.showMessageDialog(null,"Please check that all inputs are filled!");
        else if(statcombo.getSelectedItem().toString() == "<Select Status>")
            JOptionPane.showMessageDialog(null,"Please select status!");   //checks if inputs are filled and appropriate
        else{
                Random random = new Random();
                stringId = String.format("%04d", random.nextInt(10000));    //generate id for the product
                id = Integer.parseInt(stringId);
                prodid=id;
                name=nametxt.getText();
                status=statcombo.getSelectedItem().toString();
                sellprc=Double.parseDouble(selltxt.getText());
                acqprc=Double.parseDouble(acqtxt.getText());
                quantity=Integer.parseInt(qtytxt.getText());

                pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

                Date date = acqdatechooser.getDate();
                String acqdate = simpleDateFormat.format(date);

                Date date2 = expdatechooser.getDate();
                String expdate = simpleDateFormat.format(date2);



                Product product=new Product(prodid, name, status, sellprc, acqprc, quantity, acqdate, expdate);  //create new product object based on inputs
                mySql.createRec(product); //adds the new product record to the database

                resetAll();

                clearDisplayTable();
                prods = mySql.displayRec();
                tableMod();
            }
    }//GEN-LAST:event_createActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        //update an existing product record
        
        if(idtxt.getText().isEmpty()||nametxt.getText().isEmpty()||selltxt.getText().isEmpty()||acqtxt.getText().isEmpty()||qtytxt.getText().isEmpty()||acqdatechooser.getDate()==null||expdatechooser.getDate()==null)
            JOptionPane.showMessageDialog(null,"Please check that all inputs are filled!");
        else if(statcombo.getSelectedItem().toString() == "<Select Status>")
            JOptionPane.showMessageDialog(null,"Please select status!");    //checks if inputs are filled and appropriate
        else{
                prodid = Integer.parseInt(idtxt.getText());
                name=nametxt.getText();
                status=statcombo.getSelectedItem().toString();
                sellprc=Double.parseDouble(selltxt.getText());
                acqprc=Double.parseDouble(acqtxt.getText());
                quantity=Integer.parseInt(qtytxt.getText());

                pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

                Date date = acqdatechooser.getDate();
                String acqdate = simpleDateFormat.format(date);

                Date date2 = expdatechooser.getDate();
                String expdate = simpleDateFormat.format(date2);

                Product product=new Product(prodid, name, status, sellprc, acqprc, quantity, acqdate, expdate); //create product object based on input
                mySql.updateRec(product,oldProdid);  //updates existing record with new data based on input in the database
                
                resetAll();
                
                clearDisplayTable();
                prods = mySql.displayRec();
                tableMod();
            }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        //delete a product record
        if(idtxt.getText().isEmpty())
            JOptionPane.showMessageDialog(null,"Please ensure that a product is selected!");
        else{
        prodid = Integer.parseInt(idtxt.getText());
        name=nametxt.getText();
        status=statcombo.getSelectedItem().toString();
        sellprc=Double.parseDouble(selltxt.getText());
        acqprc=Double.parseDouble(acqtxt.getText());
        quantity=Integer.parseInt(qtytxt.getText());

        pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        Date date = acqdatechooser.getDate();
        String acqdate = simpleDateFormat.format(date);
        
        Date date2 = expdatechooser.getDate();
        String expdate = simpleDateFormat.format(date2);
        
        Product product=new Product(prodid, name, status, sellprc, acqprc, quantity, acqdate, expdate); //create product object based on input
        mySql.deleteRec(oldProdid); //deletes a record from the database
        
        resetAll();

        clearDisplayTable();
        prods = mySql.displayRec();
        tableMod();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        //refreshes the manage inventory page
        resetAll();
        
        clearDisplayTable();
        prods = mySql.displayRec();
        tableMod();
        resetOrder();

    }//GEN-LAST:event_resetActionPerformed

    private void prodTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodTableMouseClicked
       //transfer data of record clicked from the table to input fields
        
       DefaultTableModel model = (DefaultTableModel)prodTable.getModel();

       int selectedRowIndex = prodTable.getSelectedRow();
       
       idtxt.setText(model.getValueAt(selectedRowIndex, 0).toString());
       nametxt.setText(model.getValueAt(selectedRowIndex, 1).toString());
       selltxt.setText(model.getValueAt(selectedRowIndex, 3).toString());
       acqtxt.setText(model.getValueAt(selectedRowIndex, 4).toString());
       qtytxt.setText(model.getValueAt(selectedRowIndex, 5).toString());
           if("Good".equals(model.getValueAt(selectedRowIndex, 2).toString())){
               statcombo.setSelectedItem("Good");
           }
           else{
               statcombo.setSelectedItem("Expired");
           }
        String acqdate = model.getValueAt(selectedRowIndex, 6).toString();
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(acqdate);
            acqdatechooser.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String expdate = model.getValueAt(selectedRowIndex, 7).toString();
        try {
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(expdate);
            expdatechooser.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
        }

       oldProdid = Integer.parseInt(idtxt.getText());
    }//GEN-LAST:event_prodTableMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        clearDisplayTable();
        prods = mySql.displayRec();
        tableMod();
    }//GEN-LAST:event_formWindowOpened

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        //search a specific record using id
        int searchid=Integer.parseInt(idtxt.getText());
        int selectedRowIndex = prodTable.getSelectedRow();
        
        clearDisplayTable();
        searchProds = mySql.searchRec(searchid); //searches through records in the database and returns record with matching id of inputted id
    
        //display returned record to table  and input fields
        model=(DefaultTableModel) prodTable.getModel();
        for(Product p: searchProds){  
           model.addRow(new Object[] {p.getProdid(),p.getName(),p.getStatus(),df.format(p.getSellprc()),df.format(p.getAcqprc()),p.getQuantity(),p.getAcqdate(),p.getExpdate()});
           nametxt.setText(p.getName());
           selltxt.setText(Double.toString(p.getSellprc()));
           acqtxt.setText(Double.toString(p.getAcqprc()));
           qtytxt.setText(Integer.toString(p.getQuantity()));
           if(p.getStatus() == "Good"){
               statcombo.setSelectedItem("Good");
           }
           else{
               statcombo.setSelectedItem("Expired");
           }
        String acqdate = p.getAcqdate();
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(acqdate);
            acqdatechooser.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String expdate = p.getExpdate();
        try {
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(expdate);
            expdatechooser.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

       oldProdid = Integer.parseInt(idtxt.getText());
   
        DefaultTableModel p=(DefaultTableModel)prodTable.getModel();
             int rows = p.getRowCount();
         
        if(rows == 0){
            JOptionPane.showMessageDialog(null,"No record with product ID " + searchid + " found!"); //feedback that indicates no record was found
        }
    }//GEN-LAST:event_searchbtnActionPerformed

    private void orderIdbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderIdbtnActionPerformed
        //sort table order by id
        clearDisplayTable();
        sortType = "PRODID";
        if(orderId == true){           
        prods = mySql.sortA(sortType);    //ascending 
        tableMod();
        orderId = false;
        }
        else{
        prods = mySql.sortB(sortType);   //descending 
        tableMod();
        orderId = true;
        }
        orderName = true; 
        orderStatus = true;
        orderSellprc = true;
        orderAcqprc = true;
        orderQty = true;
        ordAcqdate = true;
        ordExpdate = true;
    }//GEN-LAST:event_orderIdbtnActionPerformed

    private void orderNamebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderNamebtnActionPerformed
        //sort table order by id
        clearDisplayTable();
        sortType = "PRODNAME";
        if(orderName == true){
        prods = mySql.sortA(sortType);  //alphabetical
        tableMod();
        orderName = false;
        }
        else{
        prods = mySql.sortB(sortType);  //reverse
        tableMod();
        orderName = true;
        }
        orderId = true;
        orderStatus = true;
        orderSellprc = true;
        orderAcqprc = true;
        orderQty = true;
        ordAcqdate = true;
        ordExpdate = true;
    }//GEN-LAST:event_orderNamebtnActionPerformed

    private void orderStatbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderStatbtnActionPerformed
        //sort table order by status
        clearDisplayTable();
        sortType = "PRODSTATUS";
        if(orderStatus == true){
        prods = mySql.sortA(sortType);  //expired first
        tableMod();
        orderStatus = false;
        }
        else{
        prods = mySql.sortB(sortType);  //good first
        tableMod();
        orderStatus = true;
        }
        orderId = true;
        orderName = true;
        orderSellprc = true;
        orderAcqprc = true;
        orderQty = true;
        ordAcqdate = true;
        ordExpdate = true;
    }//GEN-LAST:event_orderStatbtnActionPerformed

    private void orderSellprcbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderSellprcbtnActionPerformed
        //sort table order by selling price
        clearDisplayTable();
        sortType = "PRODSELLPRC";
        if(orderSellprc == true){
        prods = mySql.sortA(sortType);  //ascending
        tableMod();
        orderSellprc = false;
        }
        else{
        prods = mySql.sortB(sortType);  //descending
        tableMod();
        orderSellprc = true;
        }
        orderId = true;
        orderName = true;
        orderStatus = true;
        orderAcqprc = true;
        orderQty = true;
        ordAcqdate = true;
        ordExpdate = true;
    }//GEN-LAST:event_orderSellprcbtnActionPerformed

    private void orderAcqprcbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderAcqprcbtnActionPerformed
        //sort table order by acquisition price
        clearDisplayTable();
        sortType = "PRODACQPRC";
        if(orderAcqprc == true){
        prods = mySql.sortA(sortType);  //ascending
        tableMod();
        orderAcqprc = false;
        }
        else{
        prods = mySql.sortB(sortType);  //descending
        tableMod();
        orderAcqprc = true;
        }
        orderId = true;
        orderName = true;
        orderStatus = true;
        orderSellprc = true;
        orderQty = true;
        ordAcqdate = true;
        ordExpdate = true;
    }//GEN-LAST:event_orderAcqprcbtnActionPerformed

    private void orderQtybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderQtybtnActionPerformed
        //sort table order by quantity
        clearDisplayTable();
        sortType = "PRODQUANTITY";
        if(orderQty == true){
        prods = mySql.sortA(sortType);  //ascending
        tableMod();
        orderQty = false;
        }
        else{
        prods = mySql.sortB(sortType);  //descending
        tableMod();
        orderQty = true;
        }
        orderId = true;
        orderName = true;
        orderStatus = true;
        orderSellprc = true;
        orderAcqprc = true;
        ordAcqdate = true;
        ordExpdate = true;
    }//GEN-LAST:event_orderQtybtnActionPerformed

    private void orderAcqdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderAcqdatebtnActionPerformed
        //sort table order by acquisition date
        clearDisplayTable();
        sortType = "ACQDATE";
        if(ordAcqdate == true){
        prods = mySql.sortA(sortType); //ascending
        tableMod();
        ordAcqdate = false; 
        }
        else{
        prods = mySql.sortB(sortType); //descending
        tableMod();
        ordAcqdate = true;
        }
        orderId = true;
        orderName = true;
        orderStatus = true;
        orderSellprc = true;
        orderAcqprc = true;
        orderQty = true;
        ordExpdate = true;
    }//GEN-LAST:event_orderAcqdatebtnActionPerformed

    private void orderExpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderExpdatebtnActionPerformed
        //sort table order by expiry date
        clearDisplayTable();
        sortType = "EXPDATE";
        if(ordExpdate == true){
        prods = mySql.sortA(sortType);  //ascending
        tableMod();
        ordExpdate = false;
        }
        else{
        prods = mySql.sortB(sortType);  //descending
        tableMod();
        ordExpdate = true;
        }
        orderId = true;
        orderName = true;
        orderStatus = true;
        orderSellprc = true;
        orderAcqprc = true;
        orderQty = true;
        ordAcqdate = true;
    }//GEN-LAST:event_orderExpdatebtnActionPerformed

    private void menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu1ActionPerformed
        Home home = new Home();
        home.show();
        dispose();
    }//GEN-LAST:event_menu1ActionPerformed

    private void menu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu2ActionPerformed
        ReplenishForm buyform = new ReplenishForm();
        buyform.show();       
        dispose();
    }//GEN-LAST:event_menu2ActionPerformed

    private void menu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu3ActionPerformed
        SellForm sellform = new SellForm();
        sellform.show();        
        dispose();
    }//GEN-LAST:event_menu3ActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       InventoryForm ivform = new InventoryForm();
       ivform.show();
       dispose();
    }//GEN-LAST:event_refreshActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        LoginForm login = new LoginForm();
        login.show();
        dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void genReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genReportActionPerformed
        //generates inventory report
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrikulturadb?zeroDateTimeBehavior=convertToNull","root","jeet");  //connects to database
                try {
                    JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\janed\\Documents\\NetBeansProjects\\agrikulturadb\\src\\MyApp\\ProductReport.jrxml");  
                    String query = "select * from prodrec";   //selects all records of products in inventory from the database
                
                    JRDesignQuery updateQuery = new JRDesignQuery();
                    updateQuery.setText(query);
                
                    jdesign.setQuery(updateQuery);
                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con); //fills report with data
                    
                    JasperViewer.viewReport(jprint);
                } catch (JRException ex) {
                    Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_genReportActionPerformed

    private void rep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep1ActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrikulturadb?zeroDateTimeBehavior=convertToNull","root","jeet");
                try {
                    JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\janed\\Documents\\NetBeansProjects\\agrikulturadb\\src\\MyApp\\ProductReport.jrxml");
                    String query = "select * from prodrec";
                
                    JRDesignQuery updateQuery = new JRDesignQuery();
                    updateQuery.setText(query);
                
                    jdesign.setQuery(updateQuery);
                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
                    
                    JasperViewer.viewReport(jprint);
                } catch (JRException ex) {
                    Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rep1ActionPerformed

    private void rep2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep2ActionPerformed
try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrikulturadb?zeroDateTimeBehavior=convertToNull","root","jeet");
                try {
                    JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\janed\\Documents\\NetBeansProjects\\agrikulturadb\\src\\MyApp\\ReplenishReport.jrxml");
                    String query = "select PRODID, PRODNAME, PRODSTATUS, PRODACQPRC, PRODQUANTITY from prodrec where PRODQUANTITY < 10 AND PRODSTATUS = 'Good'";
                
                    JRDesignQuery updateQuery = new JRDesignQuery();
                    updateQuery.setText(query);
                
                    jdesign.setQuery(updateQuery);
                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
                    
                    JasperViewer.viewReport(jprint);
                } catch (JRException ex) {
                    Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_rep2ActionPerformed

    private void rep3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep3ActionPerformed
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrikulturadb?zeroDateTimeBehavior=convertToNull","root","jeet");
                try {
                    JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\janed\\Documents\\NetBeansProjects\\agrikulturadb\\src\\MyApp\\RemoveReport.jrxml");
                    String query = "select PRODID, PRODNAME, PRODSTATUS, PRODSTATUS, PRODQUANTITY, EXPDATE from prodrec where PRODSTATUS = 'Expired'";
                
                    JRDesignQuery updateQuery = new JRDesignQuery();
                    updateQuery.setText(query);
                
                    jdesign.setQuery(updateQuery);
                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
                    
                    JasperViewer.viewReport(jprint);
                } catch (JRException ex) {
                    Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rep3ActionPerformed

    private void rep4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rep4ActionPerformed
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agrikulturadb?zeroDateTimeBehavior=convertToNull","root","jeet");
                try {
                    JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\janed\\Documents\\NetBeansProjects\\agrikulturadb\\src\\MyApp\\SoldProductReport.jrxml");
                    String query = "select * from sellrec";
                
                    JRDesignQuery updateQuery = new JRDesignQuery();
                    updateQuery.setText(query);
                
                    jdesign.setQuery(updateQuery);
                    JasperReport jreport = JasperCompileManager.compileReport(jdesign);
                    JasperPrint jprint = JasperFillManager.fillReport(jreport, null, con);
                    
                    JasperViewer.viewReport(jprint);
                } catch (JRException ex) {
                    Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InventoryForm.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_rep4ActionPerformed

    private void backHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backHomeActionPerformed
        Home home = new Home();
        home.show();
        dispose();
    }//GEN-LAST:event_backHomeActionPerformed

        public void clearDisplayTable()
    {
        model=(DefaultTableModel) prodTable.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }
        
        public void resetAll()
        {
        idtxt.setText("");
        nametxt.setText("");
        statcombo.setSelectedItem("<Select Status>");
        selltxt.setText("");
        acqtxt.setText("");
        qtytxt.setText("");
        acqdatechooser.setCalendar(null);
        expdatechooser.setCalendar(null);
        }
        public void tableMod(){
        model=(DefaultTableModel) prodTable.getModel();
        for(Product p: prods)    
           model.addRow(new Object[] {p.getProdid(),p.getName(),p.getStatus(),df.format(p.getSellprc()),df.format(p.getAcqprc()),p.getQuantity(),p.getAcqdate(),p.getExpdate()});   
        }
        public void resetOrder()
        {
            orderId = true;
            orderName = true; 
            orderStatus = true;
            orderSellprc = true;
            orderAcqprc = true;
            orderQty = true;
            ordAcqdate = true;
            ordExpdate = true;
        }
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
            java.util.logging.Logger.getLogger(InventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser acqdatechooser;
    private javax.swing.JTextField acqtxt;
    private javax.swing.JMenuItem backHome;
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private com.toedter.calendar.JDateChooser expdatechooser;
    private javax.swing.JMenu genRep;
    private javax.swing.JButton genReport;
    private javax.swing.JTextField idtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem logout;
    private javax.swing.JMenuItem menu1;
    private javax.swing.JMenuItem menu2;
    private javax.swing.JMenuItem menu3;
    private javax.swing.JTextField nametxt;
    private javax.swing.JMenu option;
    private javax.swing.JButton orderAcqdatebtn;
    private javax.swing.JButton orderAcqprcbtn;
    private javax.swing.JButton orderExpdatebtn;
    private javax.swing.JButton orderIdbtn;
    private javax.swing.JButton orderNamebtn;
    private javax.swing.JButton orderQtybtn;
    private javax.swing.JButton orderSellprcbtn;
    private javax.swing.JButton orderStatbtn;
    private javax.swing.JTable prodTable;
    private javax.swing.JTextField qtytxt;
    private javax.swing.JMenuItem refresh;
    private javax.swing.JMenuItem rep1;
    private javax.swing.JMenuItem rep2;
    private javax.swing.JMenuItem rep3;
    private javax.swing.JMenuItem rep4;
    private javax.swing.JButton reset;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTextField selltxt;
    private javax.swing.JComboBox<String> statcombo;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
