
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bansa
 */
public class Inventory extends javax.swing.JFrame {

    /**
     * Creates new form Inventory
     */
    public Inventory() {
        initComponents();
    }
    
    String pnoo;
    String npno;
    
     public Inventory(String pno) throws ClassNotFoundException, SQLException {
        initComponents();
        Connect();
        
        this.pnoo=pno;
        npno = pnoo;
        
        spi.setText(npno);
    }
     
     
     Connection con = null;
     Statement st;
     ResultSet rs;
        
     
     public void Connect() throws ClassNotFoundException, SQLException{
         
         
         try{
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/hospital_project","root","3562");
                  
         }catch(ClassNotFoundException ex){
             Logger.getLogger(User.class.getName()).log(Level.SEVERE,null,ex);
         } catch(SQLException ex){
             Logger.getLogger(User.class.getName()).log(Level.SEVERE,null,ex);
         }
         
     }
     
     
     public void sales() throws SQLException{
         
         DateTimeFormatter daa = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         
         String subtot = totalcost.getText();
         String pay_ = pay.getText();
         String bal = balance.getText();
         
         
         int lastinsert = 0;
         
         String query = "insert into sales(date,subtotal,pay,balance) values('"+daa+"','"+subtot+"','"+pay_+"','"+bal+"')";
         
         st=con.createStatement();
         int m = st.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
         
         rs = st.getGeneratedKeys();
         
         if(rs.next()){
             
             lastinsert = rs.getInt(1);
             
         }
         
         int rows = jTable1.getColumnCount();
         
         
         
         
         String pres_id;
         String item_id;
         String item_name;
         String price_;
         String qty_;
         int total_;
         
         Statement st1=null;
         st1=con.createStatement();
         
         for(int i=0;i<jTable1.getRowCount();i++){
             
             pres_id = (String)jTable1.getValueAt(i,0);
             item_id = (String)jTable1.getValueAt(i,1);
             qty_ = jTable1.getValueAt(i,3).toString();
             int qty1 = Integer.parseInt(qty_);
             price_ = (String)jTable1.getValueAt(i,4);
             total_ = (int)jTable1.getValueAt(i,5);
             
             
             //st=con.createStatement();
             st1.executeUpdate("insert into sales_product(sales_id,product_id,sell_price,qty,total) values('"+lastinsert+"','"+item_id+"','"+qty1+"','"+price_+"','"+total_+"')");
             JOptionPane.showMessageDialog(this,"Record Added");
         }
         
         
     }
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spid = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spi = new javax.swing.JLabel();
        sdc = new javax.swing.JTextField();
        sdn = new javax.swing.JTextField();
        sqty = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totalcost = new javax.swing.JTextField();
        pay = new javax.swing.JTextField();
        balance = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        spid.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Sales");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Prescription ID");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Drug Code");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Drug Name");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("QTY");

        spi.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        spi.setText("jLabel6");

        sdc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sdcKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prescription ID", "Drug Code", "Drug Name", "QTY", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Total Cost");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Pay");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Balance");

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sales Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout spidLayout = new javax.swing.GroupLayout(spid);
        spid.setLayout(spidLayout);
        spidLayout.setHorizontalGroup(
            spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spidLayout.createSequentialGroup()
                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spidLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1))
                    .addGroup(spidLayout.createSequentialGroup()
                        .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(spidLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(151, 151, 151)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(balance)
                                    .addComponent(pay, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(spi)
                                        .addComponent(sqty, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sdc)
                                        .addComponent(sdn)
                                        .addComponent(totalcost, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
                                .addGap(30, 30, 30))
                            .addGroup(spidLayout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1)))
                .addGap(17, 17, 17))
        );
        spidLayout.setVerticalGroup(
            spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(spidLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(spidLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(spidLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(spi))
                                .addGap(46, 46, 46)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(sdc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(sdn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(sqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(totalcost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, spidLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(spidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

       

    }//GEN-LAST:event_jTable1MouseClicked

    private void sdcKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sdcKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String dcode = sdc.getText();
            try {
                
                st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from item where item_id = '"+pnoo+"'");
                
                if(rs.next()==false){
                    
                    JOptionPane.showMessageDialog(this, "Drug not Found");
                    
                }else
                {
                    String dname = rs.getString("name");
                    sdn.setText(dname.trim());
                    sqty.requestFocus();
                     
                            
                }
            } catch (SQLException ex) {
                Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }//GEN-LAST:event_sdcKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        String pcode = sdc.getText();
        
        try {
            
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from item where item_id = '"+pnoo+"'");
            
            while(rs.next()){
                int currentqty;
                int sellprice;
                int qty;
                
                currentqty = rs.getInt("qty");
                sellprice = rs.getInt("sell_price");
                
                qty=Integer.parseInt(sqty.getValue().toString());
                
                int tot = sellprice * qty;
                
                
                if(qty>=currentqty){
                    
                    JOptionPane.showMessageDialog(this,"Available Item" + currentqty);
                    JOptionPane.showMessageDialog(this,"Qty not Enough");
                    
                }
                else
                {
                    
                    DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
                    df.addRow(new Object[]
                    {
                       spi.getText(),
                       sdc.getText(), 
                       sdn.getText(),
                       sqty.getValue().toString(),
                       sellprice,            
                       tot,
                       
                    });
                    
                    int sum = 0;
                    for(int i = 0; i<jTable1.getRowCount();i++)
                    {
                        sum = sum + Integer.parseInt(jTable1.getValueAt(i,5).toString());
                        
                        
                    }
                    
                    totalcost.setText(Integer.toString(sum));
                    sdc.setText("");
                    sdn.setText("");
                    sqty.setValue(0);
                    sdc.requestFocus();
                    
                    
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        int pay_ = (Integer.parseInt(pay.getText()));
        int tot = (Integer.parseInt(totalcost.getText()));
        
        int bal = pay_ - tot;
        
        balance.setText(String.valueOf(bal));
        
        
        try {
            sales();
        } catch (SQLException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField balance;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pay;
    private javax.swing.JTextField sdc;
    private javax.swing.JTextField sdn;
    private javax.swing.JLabel spi;
    private javax.swing.JPanel spid;
    private javax.swing.JSpinner sqty;
    private javax.swing.JTextField totalcost;
    // End of variables declaration//GEN-END:variables
}
