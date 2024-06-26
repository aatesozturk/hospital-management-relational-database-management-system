
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author atesz
 */
public class AdminAddPolyclinic extends javax.swing.JFrame {

    /**
     * Creates new form AdminAddPolyclinic
     */
    public AdminAddPolyclinic() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        admin_add_polyclinic_polyclinic_ıd_label = new javax.swing.JLabel();
        admin_add_polyclinic_polyclinic_ıd_textfield = new javax.swing.JTextField();
        admin_add_polyclinic_name_label = new javax.swing.JLabel();
        admin_add_polyclinic_name_textfield = new javax.swing.JTextField();
        admin_add_polyclinic_capacity_label = new javax.swing.JLabel();
        admin_add_polyclinic_capacity_textfield = new javax.swing.JTextField();
        admin_add_polyclinic_manager_ıd_label = new javax.swing.JLabel();
        admin_add_polyclinic_manager_ıd_textfield = new javax.swing.JTextField();
        admin_add_polyclinic_add_button = new javax.swing.JButton();
        admin_add_polyclinic_cancel_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        admin_add_polyclinic_polyclinic_ıd_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_add_polyclinic_polyclinic_ıd_label.setText("Polyclinic ID");

        admin_add_polyclinic_name_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_add_polyclinic_name_label.setText("Name");

        admin_add_polyclinic_capacity_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_add_polyclinic_capacity_label.setText("Capacity");

        admin_add_polyclinic_manager_ıd_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin_add_polyclinic_manager_ıd_label.setText("Manager ID");

        admin_add_polyclinic_add_button.setText("Add Polyclinic");
        admin_add_polyclinic_add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_add_polyclinic_add_buttonActionPerformed(evt);
            }
        });

        admin_add_polyclinic_cancel_button.setText("Cancel");
        admin_add_polyclinic_cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admin_add_polyclinic_cancel_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(admin_add_polyclinic_manager_ıd_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin_add_polyclinic_capacity_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin_add_polyclinic_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(admin_add_polyclinic_polyclinic_ıd_label, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(admin_add_polyclinic_polyclinic_ıd_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(admin_add_polyclinic_name_textfield)
                    .addComponent(admin_add_polyclinic_capacity_textfield)
                    .addComponent(admin_add_polyclinic_manager_ıd_textfield))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(admin_add_polyclinic_cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(admin_add_polyclinic_add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(admin_add_polyclinic_polyclinic_ıd_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_add_polyclinic_polyclinic_ıd_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(admin_add_polyclinic_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(admin_add_polyclinic_name_textfield))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(admin_add_polyclinic_capacity_label, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(admin_add_polyclinic_capacity_textfield))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(admin_add_polyclinic_manager_ıd_label, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(admin_add_polyclinic_manager_ıd_textfield))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(admin_add_polyclinic_add_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(admin_add_polyclinic_cancel_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void admin_add_polyclinic_cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_add_polyclinic_cancel_buttonActionPerformed
        this.setVisible(false);
        new Admin().setVisible(true);
    }//GEN-LAST:event_admin_add_polyclinic_cancel_buttonActionPerformed

    private void admin_add_polyclinic_add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admin_add_polyclinic_add_buttonActionPerformed
        String poly_s = admin_add_polyclinic_polyclinic_ıd_textfield.getText();
        int poly_ıd = Integer.parseInt(poly_s);
        
        String name = admin_add_polyclinic_name_textfield.getText();
        
        String capacity_s = admin_add_polyclinic_capacity_textfield.getText();
        int capacity = Integer.parseInt(poly_s);
        
        String manager_s = admin_add_polyclinic_manager_ıd_textfield.getText();
        int man_ıd = Integer.parseInt(manager_s);
        
        try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Atoras21"); 
        is_ıd_exists();

        String sql = "INSERT INTO polyclinic (Polyclinic_ID, Name, capacity, Manager_ID) " +
                     "VALUES (?, ?, ?, ?)";
        
        // INSERT ROW TO PATIENT TABLE
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, poly_ıd);
        pstmt.setString(2, name);
        pstmt.setInt(3, capacity);
        pstmt.setInt(4, man_ıd);
        
        int rowsInserted = pstmt.executeUpdate();
            
        this.setVisible(false);
            //new login().setVisible(true);
        new Admin().setVisible(true);
            
        
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }//GEN-LAST:event_admin_add_polyclinic_add_buttonActionPerformed

    public void is_ıd_exists(){
        String ıd_s = admin_add_polyclinic_polyclinic_ıd_textfield.getText();
        
        Connection con=null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root","Atoras21");
            pt = con.prepareStatement("SELECT COUNT(*) AS count FROM polyclinic WHERE Polyclinic_ID =?;");
            pt.setString(1, ıd_s);
            rs = pt.executeQuery();
            
            boolean patientExists = false; // Initialize boolean variable

            if (rs.next()) {
                int count = rs.getInt("count"); // Get the value of the count column
                patientExists = count > 0; // Set patientExists to true if count > 0
            }
            if(patientExists){
                JOptionPane.showMessageDialog(this, "Polyclinic ID is already exists.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close resources in the reverse order of their creation
                if (pt != null) {
                    pt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            java.util.logging.Logger.getLogger(AdminAddPolyclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAddPolyclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAddPolyclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAddPolyclinic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminAddPolyclinic().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admin_add_polyclinic_add_button;
    private javax.swing.JButton admin_add_polyclinic_cancel_button;
    private javax.swing.JLabel admin_add_polyclinic_capacity_label;
    private javax.swing.JTextField admin_add_polyclinic_capacity_textfield;
    private javax.swing.JLabel admin_add_polyclinic_manager_ıd_label;
    private javax.swing.JTextField admin_add_polyclinic_manager_ıd_textfield;
    private javax.swing.JLabel admin_add_polyclinic_name_label;
    private javax.swing.JTextField admin_add_polyclinic_name_textfield;
    private javax.swing.JLabel admin_add_polyclinic_polyclinic_ıd_label;
    private javax.swing.JTextField admin_add_polyclinic_polyclinic_ıd_textfield;
    // End of variables declaration//GEN-END:variables
}
