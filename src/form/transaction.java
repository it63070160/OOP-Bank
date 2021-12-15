
package form;

import java.sql.*;
import java.util.logging.*;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import main.frame;
import swing.ScrollBar;

public class transaction extends javax.swing.JPanel {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    
    public transaction(String username, Connection con) {
        this.con = con;
        initComponents();
        
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        jScrollPane1.getVerticalScrollBar().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        jScrollPane1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        
        //เพิ่ม transaction ด้วย table.addRow(new Object[]{"ชื่อบัญชี", "ประเภทธุรกรรม (Deposit, Withdrawn, Transfer)", "วันที่ เวลา", "จำนวนเงิน"});
        addRow(username);
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
                while(rs.previous());
            }
            else{
                table.addRow(new Object[]{"No data", "No data", "No data", "No data", "No data"});
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refresh(){
        table.resetRow();
        addRow(frame.getUsername());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.Table();
        refresh = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 770));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(98, 98, 98));
        jLabel1.setText("Transactions");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 175, 57));

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

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 84, 1120, 626));

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minorcomponent/refresh.png"))); // NOI18N
        refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        panel1.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        refresh();
    }//GEN-LAST:event_refreshMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.panel panel1;
    private javax.swing.JLabel refresh;
    private swing.Table table;
    // End of variables declaration//GEN-END:variables
}
