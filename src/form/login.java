
package form;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import javax.swing.text.*;
import main.Connect;

public class login extends javax.swing.JPanel {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String pin,username,number;
    
    public login() {
        con = Connect.ConnectDB();
        initComponents();
        PlainDocument document = (PlainDocument) jPasswordField1.getDocument();
        document.setDocumentFilter(new DocumentFilter() {

            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (string.length() <= 6) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

        });
    }

    public JTextField getUser() {
        return user;
    }

    public void setUser(JTextField user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

    public void setjPasswordField1(JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 770));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 84, 84));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minorcomponent/logomed.png"))); // NOI18N
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 345, 270));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setText("Username");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minorcomponent/user_icon.png"))); // NOI18N
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 40, 30));

        user.setBackground(new java.awt.Color(240, 247, 255));
        user.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userMousePressed(evt);
            }
        });
        panel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 380, 50));

        jButton1.setBackground(new java.awt.Color(4, 115, 227));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        panel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 640, 220, 60));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 84, 84));
        jLabel4.setText("PIN");
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minorcomponent/password_icon.png"))); // NOI18N
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 40, 40));

        jPasswordField1.setBackground(new java.awt.Color(240, 247, 255));
        jPasswordField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordField1MousePressed(evt);
            }
        });
        panel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 550, 380, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minorcomponent/loginbg.png"))); // NOI18N
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMousePressed
       jLabel6.setVisible(false);
    }//GEN-LAST:event_userMousePressed

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
        user.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_userMouseEntered

    private void userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseExited
        user.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_userMouseExited

    private void jPasswordField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MousePressed
        jLabel5.setVisible(false);
    }//GEN-LAST:event_jPasswordField1MousePressed

    private void jPasswordField1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseExited
        jPasswordField1.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_jPasswordField1MouseExited

    private void jPasswordField1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseEntered
        jPasswordField1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_jPasswordField1MouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private swing.panel panel1;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
