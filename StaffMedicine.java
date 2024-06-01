/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author atesz
 */
public class StaffMedicine extends javax.swing.JFrame {
    
    public long pt_ıd;
    public long st_ıd;
    private Connection con;
    
    private Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Atoras21");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Creates new form StaffMedicine
     */
    public StaffMedicine(long patient_ıd, long staff_ıd) {
        initComponents();
        this.pt_ıd = patient_ıd;
        this.st_ıd = staff_ıd;
        con = connect();
        put_pt_infos(pt_ıd);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        staff_medicine_f_name_label = new javax.swing.JLabel();
        staff_medicine_m_name_label = new javax.swing.JLabel();
        staff_medicine_l_name_label = new javax.swing.JLabel();
        staff_medicine_patient_ıd_label = new javax.swing.JLabel();
        staff_medicine_diagnosis_textfield = new javax.swing.JTextField();
        staff_medicine_medicine_list_textfield = new javax.swing.JTextField();
        staff_medicine_approve_button = new javax.swing.JButton();
        staff_medicine_cancel_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staff_medicine_approve_button.setText("Approve");
        staff_medicine_approve_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_medicine_approve_buttonActionPerformed(evt);
            }
        });

        staff_medicine_cancel_button.setText("Cancel");
        staff_medicine_cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_medicine_cancel_buttonActionPerformed(evt);
            }
        });

        jButton1.setText("?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(staff_medicine_f_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(staff_medicine_m_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(staff_medicine_l_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(staff_medicine_patient_ıd_label, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staff_medicine_cancel_button, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(staff_medicine_approve_button, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(staff_medicine_diagnosis_textfield)
                    .addComponent(staff_medicine_medicine_list_textfield))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staff_medicine_diagnosis_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(staff_medicine_f_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staff_medicine_medicine_list_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(staff_medicine_m_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(staff_medicine_l_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staff_medicine_patient_ıd_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(staff_medicine_approve_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(staff_medicine_cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void staff_medicine_approve_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_medicine_approve_buttonActionPerformed
        String diagnosis = staff_medicine_diagnosis_textfield.getText();
        String[] medicine_list_s = staff_medicine_medicine_list_textfield.getText().split(",");
        int medicine_count = medicine_list_s.length;
        try {
            for(int i = 0; i<medicine_count;i++){
                String sql = "INSERT INTO prescription (Patient_ID, Medication_ID, Diagnosis) " +
                         "VALUES (?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setLong(1, pt_ıd);
                pstmt.setInt(2, Integer.parseInt(medicine_list_s[i]));
                pstmt.setString(3, diagnosis);
                pstmt.executeQuery();
            }
            Staff st = new Staff(st_ıd);
            st.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_staff_medicine_approve_buttonActionPerformed

    private void staff_medicine_cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_medicine_cancel_buttonActionPerformed
        Staff st = new Staff(st_ıd);
        st.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_staff_medicine_cancel_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "Example diagnosis: 'Flu'. Example medicine list: '2,4,7'.");
    }//GEN-LAST:event_jButton1ActionPerformed
    public void put_pt_infos(long pt_ıd){
        staff_medicine_patient_ıd_label.setText(String.valueOf(pt_ıd));
        String f_ = "";
        String l_ = "";
        String m_ = "";
        try {
            String sql = "SELECT * FROM patient WHERE Patient_ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, pt_ıd);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                f_ = rs.getString("F_name");
                m_ = rs.getString("m_name");
                l_ = rs.getString("l_name");
                
            }

            staff_medicine_f_name_label.setText(f_);
            staff_medicine_m_name_label.setText(m_);
            staff_medicine_l_name_label.setText(l_);
            

        } catch (SQLException ex) {
            ex.printStackTrace();
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
            java.util.logging.Logger.getLogger(StaffMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffMedicine(0, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton staff_medicine_approve_button;
    private javax.swing.JButton staff_medicine_cancel_button;
    private javax.swing.JTextField staff_medicine_diagnosis_textfield;
    private javax.swing.JLabel staff_medicine_f_name_label;
    private javax.swing.JLabel staff_medicine_l_name_label;
    private javax.swing.JLabel staff_medicine_m_name_label;
    private javax.swing.JTextField staff_medicine_medicine_list_textfield;
    private javax.swing.JLabel staff_medicine_patient_ıd_label;
    // End of variables declaration//GEN-END:variables
}
