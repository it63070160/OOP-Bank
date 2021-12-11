
package form;

import Model.Model_Card;
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
    
    public home() {
        con = Connect.ConnectDB();
        initComponents();
        
        //set card ด้วย [card1-3].setData(new Model_Card("ชื่อบัญชี", "จำนวนเงิน", "เลขบัญชี"));
        card1.setData(new Model_Card("Kim", "$200", "63070164"));
        //card1.setData(new Model_Card("AccountName", "Balance", "AccountNum"));
        //card1.setData(new Model_Card("AccountName", "Balance", "AccountNum"));
        
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
        addRow("username1");
    }
    public void addRow(String username){
        String sql = "SELECT * FROM Transaction";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                if (rs.getString("Username").equals(username)){
                    table.addRow(new Object[]{String.format("%010d", rs.getInt("AccountNumber")), rs.getString("Type"), rs.getString("Date"), rs.getDouble("Amount")});
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
                "Account", "Transaction", "Date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
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
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1163, Short.MAX_VALUE))
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
