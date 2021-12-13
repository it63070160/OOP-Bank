
package form;

import Model.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import main.Connect;
import swing.ScrollBar;

public class home extends javax.swing.JPanel {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String username;
    private String fname;
    private String lname;
    private String number;
    private Double money;
    private int count_card;
    
    public home(String u, Connection con) {
        username = u;
        this.con = con;
        initComponents();
        
        //set card ด้วย [card1-3].setData(new Model_Card("ชื่อบัญชี", "จำนวนเงิน", "เลขบัญชี")); 
//        card1.setData(new Model_Card(getFname()+" "+getLname(), String.valueOf(getMoney()), getNumber()));
//        card1.setData(new Model_Card("AccountName", "Balance", "AccountNum"));
//        card1.setData(new Model_Card("AccountName", "Balance", "AccountNum"));
        setCard(username);
        
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        jScrollPane1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        
        //เพิ่ม transaction ด้วย table.addRow(new Object[]{"ชื่อบัญชี", "ประเภทธุรกรรม (Deposit, Withdrawn, Transfer)", "วันที่ เวลา", "จำนวนเงิน"});
//        table.addRow(new Object[]{"AccoutName ชื่อบัญชี", "Deposit", "12/10/2021-14:38", "200"});
//        table.addRow(new Object[]{"AccoutName", "Deposit", "12/10/2021-14:38", "200"});
//        table.addRow(new Object[]{"AccoutName", "Deposit", "12/10/2021-14:38", "200"});
//        table.addRow(new Object[]{"AccoutName", "Deposit", "12/10/2021-14:38", "200"});
//        table.addRow(new Object[]{"AccoutName", "Deposit", "12/10/2021-14:38", "200"});
        addRow(username);
    }
    
    public String getNumber(){
        String sql = "SELECT * FROM BankInformation WHERE Username = '"+username+"'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                if (rs.getString("Username").equals(username)){
                    number = rs.getString("Number");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }
    
    public String getFname(){
        String sql = "SELECT * FROM BankInformation WHERE Username = '"+username+"'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                if (rs.getString("Username").equals(username)){
                    fname = rs.getString("Firstname");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fname;
    }
    
    public String getLname(){
        String sql = "SELECT * FROM BankInformation WHERE Username = '"+username+"'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                if (rs.getString("Username").equals(username)){
                    lname = rs.getString("Lastname");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lname;
    }
    
    public Double getMoney(){
        String sql = "SELECT * FROM BankInformation WHERE Username = '"+username+"'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                if (rs.getString("Username").equals(username)){
                    money = rs.getDouble("Money");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return money;
    }
    
    public void addRow(String username){
        String sql = "SELECT * FROM Transaction WHERE Username = '" + username + "'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()){
                int count_row = 1;
                rs.last();
                do{
                    table.addRow(new Object[]{String.format("%010d", rs.getInt("AccountNumber")), rs.getString("Type"), rs.getString("Date"), rs.getDouble("Amount"), rs.getString("Note")});
                    count_row++;
                }
                while(rs.previous() && count_row <= 8);
            }
            else{
                table.addRow(new Object[]{"No data", "No data", "No data", "No data", "No data"});
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setCard(String username){
        count_card = 1;
        String sql = "SELECT * FROM BankInformation WHERE Username = '" + username + "'";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next() && count_card <= 3){
                if (count_card == 1){
                    card1.setData(new Model_Card(rs.getString("Firstname")+" "+rs.getString("Lastname"), String.valueOf(rs.getDouble("Money")), String.format("%010d", rs.getInt("Number"))));
                    count_card++;
                }
                else if (count_card == 2){
                    card2.setData(new Model_Card(rs.getString("Firstname")+" "+rs.getString("Lastname"), String.valueOf(rs.getDouble("Money")), String.format("%010d", rs.getInt("Number"))));
                    count_card++;
                }
                else{
                    card3.setData(new Model_Card(rs.getString("Firstname")+" "+rs.getString("Lastname"), String.valueOf(rs.getDouble("Money")), String.format("%010d", rs.getInt("Number"))));
                    count_card++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new component.card();
        card2 = new component.card();
        card3 = new component.card();
        panel1 = new swing.panel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.Table();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 710));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(51, 51, 153));
        card1.setColor2(new java.awt.Color(255, 0, 204));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(58, 97, 134));
        card2.setColor2(new java.awt.Color(137, 37, 62));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(44, 62, 80));
        card3.setColor2(new java.awt.Color(76, 161, 175));
        panel.add(card3);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(98, 98, 98));
        jLabel1.setText("Transactions");

        jScrollPane1.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account", "Transaction", "Date", "Amount", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1123, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.card card1;
    private component.card card2;
    private component.card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane panel;
    private swing.panel panel1;
    private swing.Table table;
    // End of variables declaration//GEN-END:variables
}
