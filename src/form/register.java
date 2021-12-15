
package form;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import javax.swing.text.*;
import main.Connect;

public class register extends javax.swing.JPanel {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    
    public register() {
        con = Connect.ConnectDB();
        initComponents();
        PlainDocument document = (PlainDocument) pinfield.getDocument();
        document.setDocumentFilter(new DocumentFilter() {

            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String string = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (string.length() <= 6) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

        });
    }

    public JTextField getFname() {
        return fname;
    }

    public void setFname(JTextField fname) {
        this.fname = fname;
    }

    public JTextField getLname() {
        return lname;
    }

    public void setLname(JTextField lname) {
        this.lname = lname;
    }

    public JPasswordField getPinfield() {
        return pinfield;
    }

    public void setPinfield(JPasswordField pinfield) {
        this.pinfield = pinfield;
    }

    public JTextField getUser() {
        return user;
    }

    public void setUser(JTextField user) {
        this.user = user;
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
        user = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pinfield = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 770));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 84, 84));
        jLabel1.setText("Register");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setText("Username");

        user.setBackground(new java.awt.Color(240, 247, 255));
        user.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userMouseExited(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(4, 115, 227));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Register");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 84, 84));
        jLabel4.setText("PIN");

        pinfield.setBackground(new java.awt.Color(240, 247, 255));
        pinfield.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        pinfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pinfieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pinfieldMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(84, 84, 84));
        jLabel5.setText("Firstname");

        fname.setBackground(new java.awt.Color(240, 247, 255));
        fname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        fname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fnameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fnameMouseExited(evt);
            }
        });
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });

        lname.setBackground(new java.awt.Color(240, 247, 255));
        lname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(158, 173, 210), 2, true));
        lname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lnameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lnameMouseExited(evt);
            }
        });
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(84, 84, 84));
        jLabel6.setText("Lastname");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(520, 520, 520)
                        .addComponent(jLabel1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(470, 470, 470)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(pinfield)
                                .addComponent(fname)))))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(pinfield, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

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
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void userMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseEntered
        user.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_userMouseEntered

    private void userMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseExited
        user.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_userMouseExited

    private void pinfieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pinfieldMouseEntered
        pinfield.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_pinfieldMouseEntered

    private void pinfieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pinfieldMouseExited
        pinfield.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_pinfieldMouseExited

    private void fnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameMouseEntered
        fname.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_fnameMouseEntered

    private void fnameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fnameMouseExited
         fname.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_fnameMouseExited

    private void lnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnameMouseEntered
        lname.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_lnameMouseEntered

    private void lnameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnameMouseExited
        lname.setBackground(new Color(240,247,255));
    }//GEN-LAST:event_lnameMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField lname;
    private swing.panel panel1;
    private javax.swing.JPasswordField pinfield;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
