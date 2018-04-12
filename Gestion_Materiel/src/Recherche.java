import java.sql.DriverManager;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Cursor;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ProBook
 */
public class Recherche extends javax.swing.JFrame {

    Connection connection;
    PreparedStatement ps;
    DefaultTableModel model = new DefaultTableModel();
    
    /**
     * Creates new form Recherche
     */
    public Recherche() {
        initComponents();
                
    model.addColumn("Référence :");
    model.addColumn("Type :");
    model.addColumn("Etat :");
    model.addColumn("Configuration :");
    model.addColumn("Série :");
    model.addColumn("Utilisateur :");
    model.addColumn("Date d'utilisation :");
    model.addColumn("Date fin d'utilisation :");    
          
           // model.setRowCount(0);// pour vider la list des materiel
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_materiel","root", "");
                ps = connection.prepareStatement(" SELECT reference, type_mat, materiel.Serie, materiel.Nom_Complet, Date_debut_us,OS,CPU,RAM,HDD,Graphics,Etat,Date_fin_us "
                                               + " FROM materiel "
                                               + " LEFT JOIN utilisateur ON utilisateur.Nom_Complet = materiel.Nom_Complet "
                                               + " LEFT JOIN type ON type.Serie = materiel.Serie "
                                               + " LEFT JOIN configuration ON  configuration.Serie = materiel.Serie ");
                            ResultSet result = ps.executeQuery();
                while(result.next())
                    {        
                        if(result.getString(6) == null && result.getString(7) == null && result.getString(8) == null && result.getString(9) == null && result.getString(10) == null ){
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"",result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)});                        
                         }
                        else{
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"OS : "+result.getString(6)+" / CPU : "+result.getString(7)+" / RAM : "+result.getString(8)+" / HDD : "+result.getString(9)+" / Graphics : "+result.getString(10),result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)}); 
                        }
                     
                    }
            } catch (SQLException ex) {
                System.err.println(ex);
                Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
            }
            tble.setModel(model);
    }
    
    public void afficher(){
        try {
                model.setRowCount(0);
                connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_materiel","root", "");
                ps = connection.prepareStatement(" SELECT reference, type_mat, materiel.Serie, materiel.Nom_Complet, Date_debut_us,OS,CPU,RAM,HDD,Graphics,Etat,Date_fin_us "
                                               + " FROM materiel "
                                               + " LEFT JOIN utilisateur ON utilisateur.Nom_Complet = materiel.Nom_Complet "
                                               + " LEFT JOIN type ON type.Serie = materiel.Serie "
                                               + " LEFT JOIN configuration ON  configuration.Serie = materiel.Serie ");
                            ResultSet result = ps.executeQuery();
                while(result.next())
                    {        
                        if(result.getString(6) == null && result.getString(7) == null && result.getString(8) == null && result.getString(9) == null && result.getString(10) == null ){
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"",result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)});                        
                         }
                        else{
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"OS : "+result.getString(6)+" / CPU : "+result.getString(7)+" / RAM : "+result.getString(8)+" / HDD : "+result.getString(9)+" / Graphics : "+result.getString(10),result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)}); 
                        }
                     
                    }
            } catch (SQLException ex) {
                System.err.println(ex);
                Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
            }
            tble.setModel(model);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Serie = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        menu_0 = new javax.swing.JLabel();
        menu_1 = new javax.swing.JLabel();
        menu_2 = new javax.swing.JLabel();
        menu_3 = new javax.swing.JLabel();
        menu_5 = new javax.swing.JLabel();
        menu_6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        etat = new javax.swing.JComboBox();
        type = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tble = new javax.swing.JTable();
        logout = new javax.swing.JLabel();
        depart = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        Recherchebg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1083, 733));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(1090, 735));
        jPanel1.setMinimumSize(new java.awt.Dimension(1090, 735));
        jPanel1.setPreferredSize(new java.awt.Dimension(1090, 735));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Serie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerieActionPerformed(evt);
            }
        });
        Serie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SerieKeyReleased(evt);
            }
        });
        jPanel1.add(Serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 200, -1));

        jLabel12.setFont(new java.awt.Font("Architects Daughter", 1, 11)); // NOI18N
        jLabel12.setText("Série :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 443, 50, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search0.png"))); // NOI18N
        jLabel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel11MouseMoved(evt);
            }
        });
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 40, 30));

        menu_0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu_00.png"))); // NOI18N
        menu_0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_0.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                menu_0MouseMoved(evt);
            }
        });
        menu_0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_0MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_0MouseExited(evt);
            }
        });
        jPanel1.add(menu_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 97, 120, 40));

        menu_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu_01.png"))); // NOI18N
        menu_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                menu_1MouseMoved(evt);
            }
        });
        menu_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_1MouseExited(evt);
            }
        });
        jPanel1.add(menu_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 143, 110, 40));

        menu_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu_02.png"))); // NOI18N
        menu_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_2.setPreferredSize(new java.awt.Dimension(117, 20));
        menu_2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                menu_2MouseMoved(evt);
            }
        });
        menu_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_2MouseExited(evt);
            }
        });
        jPanel1.add(menu_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 189, 120, 40));

        menu_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menu_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu_03.png"))); // NOI18N
        menu_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_3.setPreferredSize(new java.awt.Dimension(117, 20));
        menu_3.setVerifyInputWhenFocusTarget(false);
        menu_3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                menu_3MouseMoved(evt);
            }
        });
        menu_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_3MouseExited(evt);
            }
        });
        jPanel1.add(menu_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 239, 130, 40));

        menu_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu_05RG.png"))); // NOI18N
        menu_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                menu_5MouseMoved(evt);
            }
        });
        menu_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_5MouseExited(evt);
            }
        });
        jPanel1.add(menu_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 284, 140, 50));

        menu_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu_06.png"))); // NOI18N
        menu_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_6.setMaximumSize(new java.awt.Dimension(117, 28));
        menu_6.setMinimumSize(new java.awt.Dimension(117, 28));
        menu_6.setPreferredSize(new java.awt.Dimension(117, 28));
        menu_6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                menu_6MouseMoved(evt);
            }
        });
        menu_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_6MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menu_6MouseExited(evt);
            }
        });
        jPanel1.add(menu_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 342, 140, 40));

        jLabel10.setFont(new java.awt.Font("Architects Daughter", 1, 11)); // NOI18N
        jLabel10.setText("Etat :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 543, 50, -1));

        jLabel14.setFont(new java.awt.Font("Architects Daughter", 1, 11)); // NOI18N
        jLabel14.setText("Type :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 543, 60, -1));

        etat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Toutes", "Utilisé", "Reformer", "Inconnu" }));
        etat.setBackground(Color.GRAY);
        etat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etatActionPerformed(evt);
            }
        });
        jPanel1.add(etat, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, 110, -1));

        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Toutes", "Ecran", "Sourie", "Clavie", "Unité Centrale" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel1.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 120, -1));

        tble.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Référence :", "Type :", "Etat  :", "Configuration :", " Série :", "Utilisateur :", "Date d'utilisation :", "Date fin d'utilisation  :"
            }
        ));
        tble.setRowHeight(20);
        tble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tble);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 930, 123));

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/power.png"))); // NOI18N
        logout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                logoutMouseMoved(evt);
            }
        });
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 400, 30, 30));

        depart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Toutes", "D.A.F", "D.G.U", "D.A.J.F", "D.E", "S.I", "D.G.U" }));
        depart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departActionPerformed(evt);
            }
        });
        jPanel1.add(depart, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, 80, -1));

        jLabel3.setFont(new java.awt.Font("Architects Daughter", 1, 11)); // NOI18N
        jLabel3.setText("Depart :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 543, 70, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 543, 10, 20));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 543, 10, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf.png"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(48, 50));
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, -1, -1));

        Recherchebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Recherche.png"))); // NOI18N
        jPanel1.add(Recherchebg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SerieActionPerformed

    private void menu_0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_0MouseClicked
        // TODO add your handling code here:
        Home H = new Home();
        H.setVisible(true);
        H.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_menu_0MouseClicked

    private void menu_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_2MouseClicked
        // TODO add your handling code here:
      Materiel M = new Materiel();
      M.setVisible(true);
      M.setLocationRelativeTo(null);
      dispose();
    }//GEN-LAST:event_menu_2MouseClicked

    private void menu_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_3MouseClicked
        // TODO add your handling code here:
      Utilisateur U = new Utilisateur();
      U.setVisible(true);
      U.setLocationRelativeTo(null);
      dispose();
    }//GEN-LAST:event_menu_3MouseClicked

    private void menu_0MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_0MouseMoved
        menu_0.setIcon(new ImageIcon(getClass().getResource("/icons/menu_00G.png")));
    }//GEN-LAST:event_menu_0MouseMoved

    private void menu_0MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_0MouseExited
        menu_0.setIcon(new ImageIcon(getClass().getResource("/icons/menu_00.png")));
    }//GEN-LAST:event_menu_0MouseExited

    private void menu_1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_1MouseMoved
        menu_1.setIcon(new ImageIcon(getClass().getResource("/icons/menu_01G.png")));
    }//GEN-LAST:event_menu_1MouseMoved

    private void menu_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_1MouseExited
        menu_1.setIcon(new ImageIcon(getClass().getResource("/icons/menu_01.png")));
    }//GEN-LAST:event_menu_1MouseExited

    private void menu_2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_2MouseMoved
        menu_2.setIcon(new ImageIcon(getClass().getResource("/icons/menu_02G.png")));
    }//GEN-LAST:event_menu_2MouseMoved

    private void menu_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_2MouseExited
        menu_2.setIcon(new ImageIcon(getClass().getResource("/icons/menu_02.png")));
    }//GEN-LAST:event_menu_2MouseExited

    private void menu_3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_3MouseMoved
        menu_3.setIcon(new ImageIcon(getClass().getResource("/icons/menu_03G.png")));
    }//GEN-LAST:event_menu_3MouseMoved

    private void menu_3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_3MouseExited
        menu_3.setIcon(new ImageIcon(getClass().getResource("/icons/menu_03.png")));
    }//GEN-LAST:event_menu_3MouseExited

    private void menu_5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_5MouseMoved
        menu_5.setIcon(new ImageIcon(getClass().getResource("/icons/menu_05R.png")));
    }//GEN-LAST:event_menu_5MouseMoved

    private void menu_5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_5MouseExited
       menu_5.setIcon(new ImageIcon(getClass().getResource("/icons/menu_05RG.png")));
    }//GEN-LAST:event_menu_5MouseExited

    private void menu_6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_6MouseMoved
        menu_6.setIcon(new ImageIcon(getClass().getResource("/icons/menu_06G.png")));
    }//GEN-LAST:event_menu_6MouseMoved

    private void menu_6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_6MouseExited
        menu_6.setIcon(new ImageIcon(getClass().getResource("/icons/menu_06.png")));
    }//GEN-LAST:event_menu_6MouseExited

    private void menu_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_1MouseClicked
      Admine A = new Admine();
      A.setVisible(true);
      A.setLocationRelativeTo(null);
      dispose();
    }//GEN-LAST:event_menu_1MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseMoved
    }//GEN-LAST:event_jLabel11MouseMoved

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
    }//GEN-LAST:event_jLabel11MouseExited

    private void etatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etatActionPerformed
        if(etat.getSelectedItem().toString().equals("Toutes")){
            afficher();
            etat.setBackground(Color.GRAY);
            Serie.setText(null);
            Serie.setEnabled(true);
            type.setEnabled(true);
            depart.setEnabled(true);
        }
        else if(etat.getSelectedItem().toString().equals("Utilisé")){
            etat.setBackground(Color.green);
            Serie.setText(null);
            Serie.setEnabled(false);
            type.setEnabled(false);
            depart.setEnabled(false);
            
            try {
                model.setRowCount(0);
                connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_materiel","root", "");
                ps = connection.prepareStatement(" SELECT reference, type_mat, materiel.Serie, materiel.Nom_Complet, Date_debut_us,OS,CPU,RAM,HDD,Graphics,Etat,Date_fin_us "
                                               + " FROM materiel "
                                               + " LEFT JOIN utilisateur ON utilisateur.Nom_Complet = materiel.Nom_Complet "
                                               + " LEFT JOIN type ON type.Serie = materiel.Serie "
                                               + " LEFT JOIN configuration ON  configuration.Serie = type.Serie ");
                           
                            ResultSet result = ps.executeQuery();
                while(result.next())
                    {        
                      if(result.getString(11).equals(etat.getSelectedItem().toString())){ 
                        if(result.getString(6) == null && result.getString(7) == null && result.getString(8) == null && result.getString(9) == null && result.getString(10) == null ){
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"",result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)});                        
                         }
                        else{
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"OS : "+result.getString(6)+" / CPU : "+result.getString(7)+" / RAM : "+result.getString(8)+" / HDD : "+result.getString(9)+" / Graphics : "+result.getString(10),result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)}); 
                        }
                     }
                    }
            } catch (SQLException ex) {
                System.err.println(ex);
                Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
            }
            tble.setModel(model);
        }
        else if(etat.getSelectedItem().toString().equals("Reformer")){
            etat.setBackground(Color.red);
            Serie.setText(null);
            Serie.setEnabled(false);
            type.setEnabled(false);
            depart.setEnabled(false);
            
            try {
                model.setRowCount(0);
                connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_materiel","root", "");
                ps = connection.prepareStatement(" SELECT reference, type_mat, materiel.Serie, materiel.Nom_Complet, Date_debut_us,OS,CPU,RAM,HDD,Graphics,Etat,Date_fin_us "
                                               + " FROM materiel "
                                               + " LEFT JOIN utilisateur ON utilisateur.Nom_Complet = materiel.Nom_Complet "
                                               + " LEFT JOIN type ON type.Serie = materiel.Serie "
                                               + " LEFT JOIN configuration ON  configuration.Serie = type.Serie ");
                           
                            ResultSet result = ps.executeQuery();
                while(result.next())
                    {        
                      if(result.getString(11).equals(etat.getSelectedItem().toString())){ 
                        if(result.getString(6) == null && result.getString(7) == null && result.getString(8) == null && result.getString(9) == null && result.getString(10) == null ){
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"",result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)});                        
                         }
                        else{
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"OS : "+result.getString(6)+" / CPU : "+result.getString(7)+" / RAM : "+result.getString(8)+" / HDD : "+result.getString(9)+" / Graphics : "+result.getString(10),result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)}); 
                        }
                     }
                    }
            } catch (SQLException ex) {
                System.err.println(ex);
                Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
            }
            tble.setModel(model);
        }
        else if(etat.getSelectedItem().toString().equals("Inconnu")){
            etat.setBackground(Color.yellow);
            Serie.setEnabled(false);
            type.setEnabled(false);
            depart.setEnabled(false); 
            
            try {
                model.setRowCount(0);
                connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_materiel","root", "");
                ps = connection.prepareStatement(" SELECT reference, type_mat, materiel.Serie, materiel.Nom_Complet, Date_debut_us,OS,CPU,RAM,HDD,Graphics,Etat,Date_fin_us "
                                               + " FROM materiel "
                                               + " LEFT JOIN utilisateur ON utilisateur.Nom_Complet = materiel.Nom_Complet "
                                               + " LEFT JOIN type ON type.Serie = materiel.Serie "
                                               + " LEFT JOIN configuration ON  configuration.Serie = type.Serie ");
                           
                            ResultSet result = ps.executeQuery();
                while(result.next())
                    {        
                      if(result.getString(11).equals(etat.getSelectedItem().toString())){ 
                        if(result.getString(6) == null && result.getString(7) == null && result.getString(8) == null && result.getString(9) == null && result.getString(10) == null ){
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"",result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)});                        
                         }
                        else{
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"OS : "+result.getString(6)+" / CPU : "+result.getString(7)+" / RAM : "+result.getString(8)+" / HDD : "+result.getString(9)+" / Graphics : "+result.getString(10),result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)}); 
                        }
                     }
                    }
            } catch (SQLException ex) {
                System.err.println(ex);
                Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
            }
            tble.setModel(model);
        }
    }//GEN-LAST:event_etatActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed

      if(type.getSelectedItem().toString().equals("Toutes")){
            afficher();
            Serie.setText(null);
            Serie.setEnabled(true);
            etat.setEnabled(true);
            depart.setEnabled(true);
        }
      else{
            Serie.setText(null);
            Serie.setEnabled(false);
            etat.setEnabled(false);
            depart.setEnabled(false);
            
             try {
                model.setRowCount(0);
                connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_materiel","root", "");
                ps = connection.prepareStatement(" SELECT reference, type_mat, materiel.Serie, materiel.Nom_Complet, Date_debut_us,OS,CPU,RAM,HDD,Graphics,Etat,Date_fin_us "
                                               + " FROM materiel "
                                               + " LEFT JOIN utilisateur ON utilisateur.Nom_Complet = materiel.Nom_Complet "
                                               + " LEFT JOIN type ON type.Serie = materiel.Serie "
                                               + " LEFT JOIN configuration ON  configuration.Serie = type.Serie ");
                           
                            ResultSet result = ps.executeQuery();
                while(result.next())
                    {        
                      if(result.getString(2).equals(type.getSelectedItem().toString())){ 
                        if(result.getString(6) == null && result.getString(7) == null && result.getString(8) == null && result.getString(9) == null && result.getString(10) == null ){
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"",result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)});                        
                         }
                        else{
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"OS : "+result.getString(6)+" / CPU : "+result.getString(7)+" / RAM : "+result.getString(8)+" / HDD : "+result.getString(9)+" / Graphics : "+result.getString(10),result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)}); 
                        }
                     }
                    }
            } catch (SQLException ex) {
                System.err.println(ex);
                Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
            }
            tble.setModel(model);
      }
    }//GEN-LAST:event_typeActionPerformed

    private void tbleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbleMouseClicked

    }//GEN-LAST:event_tbleMouseClicked

    private void logoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseMoved
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/power-red.png")));
    }//GEN-LAST:event_logoutMouseMoved

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        int val=JOptionPane.showConfirmDialog(null, "Voulez-Vous Vraiment Quitter ?");
        if(val==1){

        }else if(val==0){

            Login l = new Login();
            l.setVisible(true);
            l.setLocationRelativeTo(null);
            dispose();
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/power.png")));
    }//GEN-LAST:event_logoutMouseExited

    private void departActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departActionPerformed
      if(depart.getSelectedItem().toString().equals("Toutes")){
            afficher();
            Serie.setText(null);
            Serie.setEnabled(true);
            etat.setEnabled(true);
            type.setEnabled(true);
        }
      else{
            Serie.setText(null);
            Serie.setEnabled(false);
            etat.setEnabled(false);
            type.setEnabled(false);
            
            try {
                model.setRowCount(0);
                connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_materiel","root", "");
                ps = connection.prepareStatement(" SELECT reference, type_mat, materiel.Serie, materiel.Nom_Complet, Date_debut_us,OS,CPU,RAM,HDD,Graphics,Etat,Date_fin_us,depart "
                                               + " FROM materiel "
                                               + " LEFT JOIN utilisateur ON utilisateur.Nom_Complet = materiel.Nom_Complet "
                                               + " LEFT JOIN type ON type.Serie = materiel.Serie "
                                               + " LEFT JOIN configuration ON  configuration.Serie = type.Serie ");
                           
                            ResultSet result = ps.executeQuery();
                while(result.next())
                    {        
                      if(result.getString(13).equals(depart.getSelectedItem().toString())){ 
                        if(result.getString(6) == null && result.getString(7) == null && result.getString(8) == null && result.getString(9) == null && result.getString(10) == null ){
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"",result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)});                        
                         }
                        else{
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"OS : "+result.getString(6)+" / CPU : "+result.getString(7)+" / RAM : "+result.getString(8)+" / HDD : "+result.getString(9)+" / Graphics : "+result.getString(10),result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)}); 
                        }
                     }
                    }
            } catch (SQLException ex) {
                System.err.println(ex);
                Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
            }
            tble.setModel(model);
        }
    }//GEN-LAST:event_departActionPerformed

    private void SerieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SerieKeyReleased
        try {
                model.setRowCount(0);
                connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_materiel","root", "");
                ps = connection.prepareStatement(" SELECT reference, type_mat, materiel.Serie, materiel.Nom_Complet, Date_debut_us,OS,CPU,RAM,HDD,Graphics,Etat,Date_fin_us "
                                               + " FROM materiel "
                                               + " LEFT JOIN utilisateur ON utilisateur.Nom_Complet = materiel.Nom_Complet "
                                               + " LEFT JOIN type ON type.Serie = materiel.Serie "
                                               + " LEFT JOIN configuration ON  configuration.Serie = type.Serie ");
                           
                            ResultSet result = ps.executeQuery();
                while(result.next())
                    {        
                      if(result.getString(3).contains(Serie.getText())){ 
                        if(result.getString(6) == null && result.getString(7) == null && result.getString(8) == null && result.getString(9) == null && result.getString(10) == null ){
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"",result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)});                        
                         }
                        else{
                             model.addRow(new Object[]{result.getString(1),result.getString(2),result.getString(11),"OS : "+result.getString(6)+" / CPU : "+result.getString(7)+" / RAM : "+result.getString(8)+" / HDD : "+result.getString(9)+" / Graphics : "+result.getString(10),result.getString(3),result.getString(4),
                             result.getString(5),result.getString(12)}); 
                        }
                     }
                    }
            } catch (SQLException ex) {
                System.err.println(ex);
                Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
            }
            tble.setModel(model);
 
    }//GEN-LAST:event_SerieKeyReleased

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        jLabel4.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); 
        Document d=new Document() {};
        try {

            PdfWriter.getInstance(d, new FileOutputStream("D:\\NetBeansProjects\\Gestion_Materiel\\src\\pdf\\Materiel_Informatique.pdf"));
            d.open();
            com.itextpdf.text.Image im=com.itextpdf.text.Image.getInstance("D:\\NetBeansProjects\\Gestion_Materiel\\src\\icons\\LOGO-2.png");
            im.scaleAbsoluteWidth(200);
            im.scaleAbsoluteHeight(100);
            im.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
            d.add(im);

            //Nom de Matier et tous les infos...
            PdfPTable table1=new PdfPTable(1);
            table1.setWidthPercentage(100);
            PdfPCell c;
            c=new PdfPCell(new Phrase("AUL \n",FontFactory.getFont("Comic Sans MS",14,BaseColor.WHITE)));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBorderColor(BaseColor.WHITE);
            c.setBackgroundColor(BaseColor.BLUE);
            table1.addCell(c);
            d.add(table1);
            //souter de ligne
            PdfPTable t=new PdfPTable(1);
            t.setWidthPercentage(100);
            PdfPCell ce;
            ce=new PdfPCell(new Phrase(" Materiel Informatique \n ",FontFactory.getFont("Comic Sans MS",14,BaseColor.WHITE)));
            ce.setBorderColor(BaseColor.WHITE);
            ce.setHorizontalAlignment(Element.ALIGN_CENTER);
            ce.setBackgroundColor(BaseColor.BLUE);
            t.addCell(ce);
            d.add(t);
            PdfPTable tn=new PdfPTable(1);
            tn.setWidthPercentage(100);
            //souter de ligne
            PdfPTable t1=new PdfPTable(1);
            t1.setWidthPercentage(100);
            PdfPCell ce1;
            ce1=new PdfPCell(new Phrase(" ",FontFactory.getFont("Comic Sans MS",14)));
            ce1.setBorderColor(BaseColor.WHITE);
            ce1.setHorizontalAlignment(Element.ALIGN_CENTER);
            ce1.setBackgroundColor(BaseColor.WHITE);
            t1.addCell(ce1);
            d.add(t1);
            PdfPTable tb=new PdfPTable(6);
            tb.setWidthPercentage(100);
            tb.setHorizontalAlignment(100);
            PdfPCell cell;
            cell=new PdfPCell(new Phrase("Type ",FontFactory.getFont("Comic Sans MS",10)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tb.addCell(cell);
            cell=new PdfPCell(new Phrase("Série",FontFactory.getFont("Comic Sans MS",10)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tb.addCell(cell);
            cell=new PdfPCell(new Phrase("Etat",FontFactory.getFont("Comic Sans MS",10)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tb.addCell(cell);
            cell=new PdfPCell(new Phrase("Utilisateur ",FontFactory.getFont("Comic Sans MS",10)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tb.addCell(cell);
            cell=new PdfPCell(new Phrase("Date d'utilisation ",FontFactory.getFont("Comic Sans MS",10)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tb.addCell(cell);
            cell=new PdfPCell(new Phrase("Date de fin d'utilisation ",FontFactory.getFont("Comic Sans MS",10)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tb.addCell(cell);
            d.add(tb);
            String sql=" SELECT type_mat, materiel.Serie, Etat, materiel.Nom_Complet, Date_debut_us,Date_fin_us,depart "
                                               + " FROM materiel "
                                               + " LEFT JOIN utilisateur ON utilisateur.Nom_Complet = materiel.Nom_Complet "
                                               + " LEFT JOIN type ON type.Serie = materiel.Serie ";

            connection = DriverManager.getConnection("jdbc:mysql://localhost/gestion_materiel","root", "");

            ps = connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(! type.getSelectedItem().toString().equals("Toutes")){
               while(rs.next()){
                PdfPTable tab1=new PdfPTable(6);
                tab1.setWidthPercentage(100);
                tab1.setHorizontalAlignment(100);
                PdfPCell cell1;
              if(rs.getString(1).equals(type.getSelectedItem().toString())){   
                cell1=new PdfPCell(new Phrase(rs.getString(1),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                cell1=new PdfPCell(new Phrase(rs.getString(2),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                if(rs.getString(3).contains("Utilisé")){
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.GREEN);
                    tab1.addCell(cell1);
                }else if(rs.getString(3).contains("Reformer")){
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.RED);
                    tab1.addCell(cell1);
                }
                else{
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.YELLOW);
                    tab1.addCell(cell1);
                }
                cell1=new PdfPCell(new Phrase(rs.getString(4),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                cell1=new PdfPCell(new Phrase(rs.getString(5),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                 cell1=new PdfPCell(new Phrase(rs.getString(6),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                
                d.add(tab1);
                }

            }
            }
            
            else if(! etat.getSelectedItem().toString().equals("Toutes")){
               while(rs.next()){
                PdfPTable tab1=new PdfPTable(6);
                tab1.setWidthPercentage(100);
                tab1.setHorizontalAlignment(100);
                PdfPCell cell1;
              if(rs.getString(3).equals(etat.getSelectedItem().toString())){   
                cell1=new PdfPCell(new Phrase(rs.getString(1),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                cell1=new PdfPCell(new Phrase(rs.getString(2),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                if(rs.getString(3).contains("Utilisé")){
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.GREEN);
                    tab1.addCell(cell1);
                }else if(rs.getString(3).contains("Reformer")){
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.RED);
                    tab1.addCell(cell1);
                }
                else{
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.YELLOW);
                    tab1.addCell(cell1);
                }
                cell1=new PdfPCell(new Phrase(rs.getString(4),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                cell1=new PdfPCell(new Phrase(rs.getString(5),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                 cell1=new PdfPCell(new Phrase(rs.getString(6),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                
                d.add(tab1);
                }

            }
            }else if(! depart.getSelectedItem().toString().equals("Toutes")){
               while(rs.next()){
                PdfPTable tab1=new PdfPTable(6);
                tab1.setWidthPercentage(100);
                tab1.setHorizontalAlignment(100);
                PdfPCell cell1;
              if(rs.getString(7).equals(depart.getSelectedItem().toString())){   
                cell1=new PdfPCell(new Phrase(rs.getString(1),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                cell1=new PdfPCell(new Phrase(rs.getString(2),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                if(rs.getString(3).contains("Utilisé")){
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.GREEN);
                    tab1.addCell(cell1);
                }else if(rs.getString(3).contains("Reformer")){
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.RED);
                    tab1.addCell(cell1);
                }
                else{
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.YELLOW);
                    tab1.addCell(cell1);
                }
                cell1=new PdfPCell(new Phrase(rs.getString(4),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                cell1=new PdfPCell(new Phrase(rs.getString(5),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                 cell1=new PdfPCell(new Phrase(rs.getString(6),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                
                d.add(tab1);
                }

            }
            }
            else {
               while(rs.next()){
                PdfPTable tab1=new PdfPTable(6);
                tab1.setWidthPercentage(100);
                tab1.setHorizontalAlignment(100);
                PdfPCell cell1;
                
                cell1=new PdfPCell(new Phrase(rs.getString(1),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                cell1=new PdfPCell(new Phrase(rs.getString(2),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                if(rs.getString(3).contains("Utilisé")){
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.GREEN);
                    tab1.addCell(cell1);
                }else if(rs.getString(3).contains("Reformer")){
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.RED);
                    tab1.addCell(cell1);
                }
                else{
                    cell1=new PdfPCell(new Phrase(rs.getString(3),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell1.setBackgroundColor(BaseColor.YELLOW);
                    tab1.addCell(cell1);
                }
                cell1=new PdfPCell(new Phrase(rs.getString(4),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                cell1=new PdfPCell(new Phrase(rs.getString(5),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                 cell1=new PdfPCell(new Phrase(rs.getString(6),FontFactory.getFont("Times New Roman (Titres CS)",8)));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.WHITE);
                tab1.addCell(cell1);
                
                d.add(tab1);
            }
            }
             
            d.close();

            Desktop.getDesktop().open(new File("D:\\NetBeansProjects\\Gestion_Materiel\\src\\pdf\\Materiel_Informatique.pdf"));

        } catch (BadElementException | IOException ex) {
            JOptionPane.showMessageDialog(null,""+ex.getMessage());
        }catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null,""+ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel4.setCursor(Cursor.getDefaultCursor());
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf-red.png")));
    }//GEN-LAST:event_jLabel4MouseMoved

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf.png")));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pdf-red-2.png")));
    }//GEN-LAST:event_jLabel4MousePressed

    private void menu_6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_6MouseClicked
       
        try {
            Desktop.getDesktop().open(new File("D:\\NetBeansProjects\\Gestion_Materiel\\src\\pdf\\Guide.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menu_6MouseClicked

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
            java.util.logging.Logger.getLogger(Recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Recherche Re = new Recherche();
        Re.setVisible(true);
        Re.setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Recherchebg;
    private javax.swing.JTextField Serie;
    private javax.swing.JComboBox depart;
    private javax.swing.JComboBox etat;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel menu_0;
    private javax.swing.JLabel menu_1;
    private javax.swing.JLabel menu_2;
    private javax.swing.JLabel menu_3;
    private javax.swing.JLabel menu_5;
    private javax.swing.JLabel menu_6;
    private javax.swing.JTable tble;
    private javax.swing.JComboBox type;
    // End of variables declaration//GEN-END:variables
}
