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
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
/**
 *
 * @author atesz
 */
public class Staff extends javax.swing.JFrame {
    
    public long staff_id;
    
    private Connection con;
    private Time[] times;
    private long[] pt_ıd; 
    
    public void set_staff_id(long id){this.staff_id = id;}
    
    /**
     * Creates new form Staff
     */
    public Staff(long id) {
        initComponents();
        con = connect();
        this.staff_id = id;
        get_appointment(staff_id);
        staff_info();
    }
    
    private Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Atoras21");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void get_appointment(long staff_id) {
        try {
            String sql = "SELECT Time, Patient_ID, Date FROM appointment WHERE Doctor_ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, staff_id);
            ResultSet rs = pstmt.executeQuery();

            List<Time> timeList = new ArrayList<>();
            List<Long> ptIdList = new ArrayList<>();
            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

            while (rs.next()) {
                java.sql.Date date = rs.getDate("Date");
                if (currentDate.toLocalDate().equals(date.toLocalDate())) {
                    Time time = rs.getTime("Time");
                    long patientId = rs.getLong("Patient_ID");

                    timeList.add(time);
                    ptIdList.add(patientId);
                }
            }

            // Convert lists to arrays
            Time[] times = timeList.toArray(new Time[0]);
            Long[] ptIds = ptIdList.toArray(new Long[0]);

            // Debugging: Print fetched times and patient IDs
            System.out.println("Fetched Times: " + Arrays.toString(times));
            System.out.println("Fetched Patient IDs: " + Arrays.toString(ptIds));

            Time[] scheduleTimes = {
                Time.valueOf("09:00:00"), Time.valueOf("10:00:00"), Time.valueOf("11:00:00"),
                Time.valueOf("13:00:00"), Time.valueOf("14:00:00"), Time.valueOf("15:00:00"),
                Time.valueOf("16:00:00"), Time.valueOf("17:00:00")
            };

            JButton[] staffCalendars = {
                staff_calendar_9, staff_calendar_10, staff_calendar_11,
                staff_calendar_13, staff_calendar_14, staff_calendar_15,
                staff_calendar_16, staff_calendar_17
            };


            for (int i = 0; i < scheduleTimes.length; i++) {
                Time scheduleTime = scheduleTimes[i];
                for (int j = 0; j < times.length; j++) {
                    if (scheduleTime.equals(times[j])) {
                        staffCalendars[i].setText(scheduleTime.toString() + " " + ptIds[j]);
                        break;
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    private void staff_info(){
        String f_ = "";
        String m_ = "";
        String l_ = "";
        String t_ = "";
        String final_s  = "";
        try {
            String sql = "SELECT F_name, M_name, L_name, Title FROM staff WHERE Staff_ID = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, staff_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                f_ = rs.getString("F_name");
                m_ = rs.getString("M_name");
                l_ = rs.getString("L_name");
                t_ = rs.getString("Title");
            }
            
            final_s = f_ + " " + m_ + " " + l_;
            
            staff_info_f_m_l_label.setText(final_s);
            staff_info_title_label.setText(t_);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        staff_calendar_panel = new javax.swing.JPanel();
        staff_calendar_9 = new javax.swing.JButton();
        staff_calendar_10 = new javax.swing.JButton();
        staff_calendar_11 = new javax.swing.JButton();
        staff_calendar_13 = new javax.swing.JButton();
        staff_calendar_14 = new javax.swing.JButton();
        staff_calendar_15 = new javax.swing.JButton();
        staff_calendar_16 = new javax.swing.JButton();
        staff_calendar_17 = new javax.swing.JButton();
        staff_info_panel = new javax.swing.JPanel();
        staff_info_image_label = new javax.swing.JLabel();
        staff_info_f_m_l_label = new javax.swing.JLabel();
        staff_info_title_label = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staff_calendar_9.setText("09:00:00");
        staff_calendar_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_calendar_9ActionPerformed(evt);
            }
        });

        staff_calendar_10.setText("10:00:00");
        staff_calendar_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_calendar_10ActionPerformed(evt);
            }
        });

        staff_calendar_11.setText("11:00:00");
        staff_calendar_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_calendar_11ActionPerformed(evt);
            }
        });

        staff_calendar_13.setText("13:00:00");
        staff_calendar_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_calendar_13ActionPerformed(evt);
            }
        });

        staff_calendar_14.setText("14:00:00");
        staff_calendar_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_calendar_14ActionPerformed(evt);
            }
        });

        staff_calendar_15.setText("15:00:00");
        staff_calendar_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_calendar_15ActionPerformed(evt);
            }
        });

        staff_calendar_16.setText("16:00:00");
        staff_calendar_16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_calendar_16ActionPerformed(evt);
            }
        });

        staff_calendar_17.setText("17:00:00");
        staff_calendar_17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_calendar_17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout staff_calendar_panelLayout = new javax.swing.GroupLayout(staff_calendar_panel);
        staff_calendar_panel.setLayout(staff_calendar_panelLayout);
        staff_calendar_panelLayout.setHorizontalGroup(
            staff_calendar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staff_calendar_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staff_calendar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staff_calendar_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_calendar_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_calendar_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_calendar_13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_calendar_14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_calendar_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_calendar_16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_calendar_17, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        staff_calendar_panelLayout.setVerticalGroup(
            staff_calendar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staff_calendar_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staff_calendar_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staff_calendar_10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staff_calendar_11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staff_calendar_13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staff_calendar_14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staff_calendar_15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staff_calendar_16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staff_calendar_17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout staff_info_panelLayout = new javax.swing.GroupLayout(staff_info_panel);
        staff_info_panel.setLayout(staff_info_panelLayout);
        staff_info_panelLayout.setHorizontalGroup(
            staff_info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staff_info_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(staff_info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staff_info_image_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_info_f_m_l_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staff_info_title_label, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addContainerGap())
        );
        staff_info_panelLayout.setVerticalGroup(
            staff_info_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staff_info_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staff_info_image_label, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(staff_info_f_m_l_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(staff_info_title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(staff_calendar_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(staff_info_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(staff_calendar_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(staff_info_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void staff_calendar_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_calendar_9ActionPerformed
        String[] info = staff_calendar_9.getText().split(" ");
        if(info[1] != null){
            long _patient_ıd = Long.parseLong(info[1]);
            StaffMedicine sf = new StaffMedicine(_patient_ıd, staff_id);
            sf.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_staff_calendar_9ActionPerformed

    private void staff_calendar_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_calendar_10ActionPerformed
        String[] info = staff_calendar_10.getText().split(" ");
        if(info[1] != null){
            long _patient_ıd = Long.parseLong(info[1]);
            StaffMedicine sf = new StaffMedicine(_patient_ıd, staff_id);
            sf.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_staff_calendar_10ActionPerformed

    private void staff_calendar_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_calendar_11ActionPerformed
        String[] info = staff_calendar_11.getText().split(" ");
        if(info[1] != null){
            long _patient_ıd = Long.parseLong(info[1]);
            StaffMedicine sf = new StaffMedicine(_patient_ıd, staff_id);
            sf.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_staff_calendar_11ActionPerformed

    private void staff_calendar_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_calendar_13ActionPerformed
        String[] info = staff_calendar_13.getText().split(" ");
        if(info[1] != null){
            long _patient_ıd = Long.parseLong(info[1]);
            StaffMedicine sf = new StaffMedicine(_patient_ıd, staff_id);
            sf.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_staff_calendar_13ActionPerformed

    private void staff_calendar_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_calendar_14ActionPerformed
        String[] info = staff_calendar_14.getText().split(" ");
        if(info[1] != null){
            long _patient_ıd = Long.parseLong(info[1]);
            StaffMedicine sf = new StaffMedicine(_patient_ıd, staff_id);
            sf.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_staff_calendar_14ActionPerformed

    private void staff_calendar_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_calendar_15ActionPerformed
        String[] info = staff_calendar_15.getText().split(" ");
        if(info[1] != null){
            long _patient_ıd = Long.parseLong(info[1]);
            StaffMedicine sf = new StaffMedicine(_patient_ıd, staff_id);
            sf.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_staff_calendar_15ActionPerformed

    private void staff_calendar_16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_calendar_16ActionPerformed
        String[] info = staff_calendar_16.getText().split(" ");
        if(info[1] != null){
            long _patient_ıd = Long.parseLong(info[1]);
            StaffMedicine sf = new StaffMedicine(_patient_ıd, staff_id);
            sf.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_staff_calendar_16ActionPerformed

    private void staff_calendar_17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_calendar_17ActionPerformed
        String[] info = staff_calendar_17.getText().split(" ");
        if(info[1] != null){
            long _patient_ıd = Long.parseLong(info[1]);
            StaffMedicine sf = new StaffMedicine(_patient_ıd, staff_id);
            sf.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_staff_calendar_17ActionPerformed

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
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton staff_calendar_10;
    private javax.swing.JButton staff_calendar_11;
    private javax.swing.JButton staff_calendar_13;
    private javax.swing.JButton staff_calendar_14;
    private javax.swing.JButton staff_calendar_15;
    private javax.swing.JButton staff_calendar_16;
    private javax.swing.JButton staff_calendar_17;
    private javax.swing.JButton staff_calendar_9;
    private javax.swing.JPanel staff_calendar_panel;
    private javax.swing.JLabel staff_info_f_m_l_label;
    private javax.swing.JLabel staff_info_image_label;
    private javax.swing.JPanel staff_info_panel;
    private javax.swing.JLabel staff_info_title_label;
    // End of variables declaration//GEN-END:variables
}
