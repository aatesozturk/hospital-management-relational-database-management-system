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
import java.util.List;
/**
 *
 * @author atesz
 */
public class Patient extends javax.swing.JFrame {
    
    private Connection con;
    public static long patient_id;
    
    public void set_patient_id(long id){this.patient_id = id;}
    
    /**
     * Creates new form Patient
     */
    public Patient(long patient_id) {
        initComponents();
        con = connect(); // Establishing connection to the database
        put_result();
        set_patient_id(patient_id);
        populatePolyclinicComboBox(); // Populating the polyclinic combobox
        populateDateComboBox();
    }
    
    private Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Atoras21");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private void populatePolyclinicComboBox() {
        try {
            String sql = "SELECT Polyclinic_ID, Name FROM polyclinic";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            while (rs.next()) {
                int polyclinicID = rs.getInt("Polyclinic_ID");
                String name = rs.getString("Name");
                model.addElement(polyclinicID + " - " + name);
            }

            patient_polyclinic_combobox.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void populateDoctorComboBox(int polyclinicID) {
        try {
            String sql = "SELECT Staff_ID, F_name, Title FROM staff WHERE Polyclinic_ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, polyclinicID);
            ResultSet rs = pstmt.executeQuery();

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            while (rs.next()) {
                if(rs.getString("Title").equalsIgnoreCase("doctor")){
                    long staffID = rs.getLong("Staff_ID");
                    String name = rs.getString("F_name");
                    model.addElement(String.valueOf(staffID) + " - " + name);
                }
            }

            patient_doctor_combobox.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void populateDateComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < 5; i++) {
            LocalDate date = currentDate.plusDays(i);
            model.addElement(date.format(formatter));
        }

        patient_date_combobox.setModel(model);
    }
    
    private void populateTimeComboBox(String selectedDate, long doctorID) {
        try {
            String sql = "SELECT Time FROM appointment WHERE Date = ? AND Doctor_ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, selectedDate);
            pstmt.setLong(2, doctorID);
            ResultSet rs = pstmt.executeQuery();

            List<Time> takenTimes = new ArrayList<>();

            while (rs.next()) {
                takenTimes.add(rs.getTime("Time"));
            }

            Time[] allTimes = {
                Time.valueOf("09:00:00"),
                Time.valueOf("10:00:00"),
                Time.valueOf("11:00:00"),
                Time.valueOf("13:00:00"),
                Time.valueOf("14:00:00"),
                Time.valueOf("15:00:00"),
                Time.valueOf("16:00:00"),
                Time.valueOf("17:00:00")
            };

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

            for (Time time : allTimes) {
                if (!takenTimes.contains(time)) {
                    model.addElement(time.toString());
                }
            }

            patient_time_combobox.setModel(model);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void put_result(){
        try {
            String diagnosis = "SELECT Diagnosis, Medication_ID FROM prescription WHERE Patient_ID = ?";
            PreparedStatement pstmt = con.prepareStatement(diagnosis);
            pstmt.setLong(1, patient_id);
            ResultSet rs = pstmt.executeQuery();
            String dia = null;
            String meds = "";
            while(rs.next()){
                dia = rs.getString("Diagnosis");
                int columnValue = rs.getInt("Medication_ID");
                meds = meds + " " + columnValue;
            }
            
            patient_diagnosis2_label.setText(dia);
            patient_medication2_label.setText(meds);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        patient_take_appointment_label = new javax.swing.JLabel();
        patient_polyclinic_combobox = new javax.swing.JComboBox<>();
        patient_doctor_combobox = new javax.swing.JComboBox<>();
        patient_date_combobox = new javax.swing.JComboBox<>();
        patient_time_combobox = new javax.swing.JComboBox<>();
        patient_approve_appointment_button = new javax.swing.JButton();
        patient_result_panel = new javax.swing.JPanel();
        patient_results_label = new javax.swing.JLabel();
        patient_diagnosis_label = new javax.swing.JLabel();
        patient_medication_label = new javax.swing.JLabel();
        patient_diagnosis2_label = new javax.swing.JLabel();
        patient_medication2_label = new javax.swing.JLabel();
        patient_welcome_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        patient_take_appointment_label.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        patient_take_appointment_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patient_take_appointment_label.setText("Take Appointment");

        patient_polyclinic_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Polyclinic", "Item 2", "Item 3", "Item 4" }));
        patient_polyclinic_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_polyclinic_comboboxActionPerformed(evt);
            }
        });

        patient_doctor_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doctor", "Item 2", "Item 3", "Item 4" }));
        patient_doctor_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_doctor_comboboxActionPerformed(evt);
            }
        });

        patient_date_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Date", "Item 2", "Item 3", "Item 4" }));
        patient_date_combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_date_comboboxActionPerformed(evt);
            }
        });

        patient_time_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Time", "Item 2", "Item 3", "Item 4" }));

        patient_approve_appointment_button.setText("Approve Appointment");
        patient_approve_appointment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patient_approve_appointment_buttonActionPerformed(evt);
            }
        });

        patient_results_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patient_results_label.setText("My Results");

        patient_diagnosis_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patient_diagnosis_label.setText("Diagnosis");

        patient_medication_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patient_medication_label.setText("Medications");

        patient_diagnosis2_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout patient_result_panelLayout = new javax.swing.GroupLayout(patient_result_panel);
        patient_result_panel.setLayout(patient_result_panelLayout);
        patient_result_panelLayout.setHorizontalGroup(
            patient_result_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patient_result_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patient_result_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patient_result_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(patient_diagnosis_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(patient_results_label, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                    .addComponent(patient_medication_label, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(patient_result_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patient_diagnosis2_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patient_medication2_label, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                .addContainerGap())
        );
        patient_result_panelLayout.setVerticalGroup(
            patient_result_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patient_result_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patient_results_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(patient_result_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patient_diagnosis_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patient_diagnosis2_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(patient_result_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(patient_medication2_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patient_medication_label, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        patient_welcome_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patient_welcome_label.setText("Welcome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(patient_take_appointment_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patient_polyclinic_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patient_doctor_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patient_date_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patient_time_combobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patient_approve_appointment_button, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patient_result_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patient_welcome_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(patient_welcome_label, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(patient_take_appointment_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(patient_polyclinic_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(patient_doctor_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(patient_date_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(patient_time_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(patient_approve_appointment_button, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(patient_result_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void patient_polyclinic_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_polyclinic_comboboxActionPerformed
        String selectedItem = (String) patient_polyclinic_combobox.getSelectedItem();
        if (selectedItem != null) {
            String[] parts = selectedItem.split(" - ");
            if (parts.length > 0) {
                int polyclinicID = Integer.parseInt(parts[0]);
                populateDoctorComboBox(polyclinicID);
            }
        }
    }//GEN-LAST:event_patient_polyclinic_comboboxActionPerformed

    private void patient_doctor_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_doctor_comboboxActionPerformed
        
    }//GEN-LAST:event_patient_doctor_comboboxActionPerformed

    private void patient_date_comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_date_comboboxActionPerformed
        String selectedDate = (String) patient_date_combobox.getSelectedItem();
    String selectedDoctorIDString = (String) patient_doctor_combobox.getSelectedItem();
    if (selectedDate != null && selectedDoctorIDString != null) {
        try {
            long selectedDoctorID = Long.parseLong(selectedDoctorIDString.split(" - ")[0]); // Assuming the ID is the first part before " - "
            populateTimeComboBox(selectedDate, selectedDoctorID);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error in converting Doctor ID to number.");
        }
    }
    }//GEN-LAST:event_patient_date_comboboxActionPerformed

    private void patient_approve_appointment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patient_approve_appointment_buttonActionPerformed
        try {
        String selectedDate = (String) patient_date_combobox.getSelectedItem();
        String selectedTime = (String) patient_time_combobox.getSelectedItem();
        String selectedDoctorIDString = (String) patient_doctor_combobox.getSelectedItem();
        String selectedPolyclinicIDString = (String) patient_polyclinic_combobox.getSelectedItem();

        if (selectedDate != null && selectedTime != null && selectedDoctorIDString != null && selectedPolyclinicIDString != null) {
            try {
                long selectedDoctorID = Long.parseLong(selectedDoctorIDString.split(" - ")[0]); // Assuming the ID is the first part before " - "
                int polyclinicID = Integer.parseInt(selectedPolyclinicIDString.split(" - ")[0]); // Assuming the ID is the first part before " - "

                String sql = "INSERT INTO appointment (Date, Time, Doctor_ID, Patient_ID) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, selectedDate);
                pstmt.setString(2, selectedTime);
                pstmt.setLong(3, selectedDoctorID);
                pstmt.setLong(4, patient_id);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Appointment approved successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to approve the appointment.");
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error in converting ID to number.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select all fields before approving.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "SQL Error: " + ex.getMessage());
    }
    }//GEN-LAST:event_patient_approve_appointment_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton patient_approve_appointment_button;
    private javax.swing.JComboBox<String> patient_date_combobox;
    private javax.swing.JLabel patient_diagnosis2_label;
    private javax.swing.JLabel patient_diagnosis_label;
    private javax.swing.JComboBox<String> patient_doctor_combobox;
    private javax.swing.JLabel patient_medication2_label;
    private javax.swing.JLabel patient_medication_label;
    private javax.swing.JComboBox<String> patient_polyclinic_combobox;
    private javax.swing.JPanel patient_result_panel;
    private javax.swing.JLabel patient_results_label;
    private javax.swing.JLabel patient_take_appointment_label;
    private javax.swing.JComboBox<String> patient_time_combobox;
    private javax.swing.JLabel patient_welcome_label;
    // End of variables declaration//GEN-END:variables

    
}
