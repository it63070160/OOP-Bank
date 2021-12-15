
package form;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class about extends javax.swing.JPanel {

    
    public about() {
        initComponents();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new swing.panel();
        aboutPanel1 = new swing.aboutPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(1200, 770));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setPreferredSize(new java.awt.Dimension(1030, 485));

        aboutPanel1.setPreferredSize(new java.awt.Dimension(1030, 485));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(54, 54, 54));
        jLabel1.setText("Developers");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(84, 84, 84));
        jLabel2.setText("63070105 | Pawit Prempree");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 84, 84));
        jLabel3.setText("63070124 | Piradon Phuengphong");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(84, 84, 84));
        jLabel4.setText("63070143 | Yuttana Phongphuak ");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(84, 84, 84));
        jLabel5.setText("63070160 | Veerawat Kamolchet ");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 26)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(84, 84, 84));
        jLabel6.setText("63070164 | Sarun Cherdwongtrakul");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(54, 54, 54));
        jLabel7.setText("Artworks");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 26)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(84, 84, 84));
        jLabel8.setText("Youtube : Ra Ven");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minorcomponent/link.png"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                link(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(54, 54, 54));
        jLabel9.setText("References");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 26)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(84, 84, 84));
        jLabel11.setText("CLIP STUDIO PAINT  PRO");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 26)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(84, 84, 84));
        jLabel12.setText("Adobe Photoshop CS6");

        javax.swing.GroupLayout aboutPanel1Layout = new javax.swing.GroupLayout(aboutPanel1);
        aboutPanel1.setLayout(aboutPanel1Layout);
        aboutPanel1Layout.setHorizontalGroup(
            aboutPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanel1Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(aboutPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(aboutPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        aboutPanel1Layout.setVerticalGroup(
            aboutPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutPanel1Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(aboutPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(aboutPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(aboutPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aboutPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel4)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel5)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel6))
                            .addGroup(aboutPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(45, 45, 45)
                                .addGroup(aboutPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10))
                                .addGap(50, 50, 50)
                                .addComponent(jLabel7)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel11)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel12)))))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void link(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_link
        try {
            String url = "https://www.youtube.com/channel/UCKMsm-Sp3Tf8MSs1gJO4o5g";
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(about.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_link

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.aboutPanel aboutPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private swing.panel panel1;
    // End of variables declaration//GEN-END:variables
}
