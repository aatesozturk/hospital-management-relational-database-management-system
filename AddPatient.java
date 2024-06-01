
import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JTextField;
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
public class AddPatient extends javax.swing.JFrame {
    private Connection con;
    private int asa;
    /**
     *
     */
    
    private Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Atoras21");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Creates new form AddPatient
     */
    public AddPatient() {
        initComponents();
        con = connect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add_patient_f_name_label = new javax.swing.JLabel();
        add_patient_m_name_label = new javax.swing.JLabel();
        add_patient_l_name_label = new javax.swing.JLabel();
        add_patient_age_label = new javax.swing.JLabel();
        add_patient_sex_label = new javax.swing.JLabel();
        add_patient_address_label = new javax.swing.JLabel();
        add_patient_phone_label = new javax.swing.JLabel();
        add_patient_mail_label = new javax.swing.JLabel();
        add_patient_blood_label = new javax.swing.JLabel();
        add_patient_m_name_textfield = new javax.swing.JTextField();
        add_patient_f_name_textfield = new javax.swing.JTextField();
        add_patient_l_name_textfield = new javax.swing.JTextField();
        add_patient_age_textfield = new javax.swing.JTextField();
        add_patient_address_textfield = new javax.swing.JTextField();
        add_patient_phone_textfield = new javax.swing.JTextField();
        add_patient_mail_textfield = new javax.swing.JTextField();
        add_patient_blood_textfield = new javax.swing.JTextField();
        add_patient_add_patient_button = new javax.swing.JButton();
        add_patient_cancel_button = new javax.swing.JButton();
        add_patient_no_family_button = new javax.swing.JButton();
        add_patient_patient_ıd_label = new javax.swing.JLabel();
        add_patient_patient_ıd_textfield = new javax.swing.JTextField();
        add_patient_password_label = new javax.swing.JLabel();
        add_patient_password_textfield = new javax.swing.JTextField();
        add_patient_male_radiobutton = new javax.swing.JRadioButton();
        add_patient_female_radiobutton = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add_patient_f_name_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_f_name_label.setText("First Name");

        add_patient_m_name_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_m_name_label.setText("Middle Name");

        add_patient_l_name_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_l_name_label.setText("Last Name");

        add_patient_age_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_age_label.setText("Age");

        add_patient_sex_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_sex_label.setText("Sex");

        add_patient_address_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_address_label.setText("Address(City, Street, Postal)");

        add_patient_phone_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_phone_label.setText("Phone Number");

        add_patient_mail_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_mail_label.setText("Mail");

        add_patient_blood_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_blood_label.setText("Blood Type");

        add_patient_add_patient_button.setText("Add Patient Information");
        add_patient_add_patient_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_patient_add_patient_buttonActionPerformed(evt);
            }
        });

        add_patient_cancel_button.setText("Cancel");
        add_patient_cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_patient_cancel_buttonActionPerformed(evt);
            }
        });

        add_patient_no_family_button.setText("No Family");
        add_patient_no_family_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_patient_no_family_buttonActionPerformed(evt);
            }
        });

        add_patient_patient_ıd_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_patient_ıd_label.setText("Patient ID");

        add_patient_password_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_patient_password_label.setText("Password");

        add_patient_male_radiobutton.setText("Male");
        add_patient_male_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_patient_male_radiobuttonActionPerformed(evt);
            }
        });

        add_patient_female_radiobutton.setText("Female");
        add_patient_female_radiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_patient_female_radiobuttonActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add_patient_no_family_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_patient_cancel_button)
                        .addGap(8, 8, 8)
                        .addComponent(add_patient_add_patient_button))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(add_patient_password_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_patient_patient_ıd_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_patient_f_name_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(add_patient_m_name_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_patient_l_name_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_patient_age_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_patient_sex_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_patient_address_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_patient_phone_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_patient_mail_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add_patient_blood_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add_patient_m_name_textfield)
                            .addComponent(add_patient_f_name_textfield)
                            .addComponent(add_patient_l_name_textfield)
                            .addComponent(add_patient_age_textfield)
                            .addComponent(add_patient_address_textfield)
                            .addComponent(add_patient_phone_textfield)
                            .addComponent(add_patient_mail_textfield)
                            .addComponent(add_patient_blood_textfield)
                            .addComponent(add_patient_patient_ıd_textfield)
                            .addComponent(add_patient_password_textfield)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(add_patient_male_radiobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(add_patient_female_radiobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 16, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_patient_f_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(add_patient_f_name_textfield))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_patient_m_name_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(add_patient_m_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_patient_l_name_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(add_patient_l_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_patient_age_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(add_patient_age_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_patient_sex_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_patient_male_radiobutton)
                    .addComponent(add_patient_female_radiobutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_patient_address_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(add_patient_address_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_patient_phone_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(add_patient_phone_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_patient_mail_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(add_patient_mail_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_patient_blood_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_patient_blood_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_patient_patient_ıd_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_patient_patient_ıd_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add_patient_password_label, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(add_patient_password_textfield))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(add_patient_add_patient_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(add_patient_no_family_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add_patient_cancel_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_patient_add_patient_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_patient_add_patient_buttonActionPerformed
        
    // Collect and validate input
    String f_name = add_patient_f_name_textfield.getText();
    String m_name = add_patient_m_name_textfield.getText();
    String l_name = add_patient_l_name_textfield.getText();
    String age_s = add_patient_age_textfield.getText();
    int age = Integer.parseInt(age_s);

    char sexxx = 'm';
    if (add_patient_male_radiobutton.isSelected()) {
        sexxx = 'm';
    } else if (add_patient_female_radiobutton.isSelected()) {
        sexxx = 'f';
    }
    if (!add_patient_male_radiobutton.isSelected() && !add_patient_female_radiobutton.isSelected()) {
        add_patient_male_radiobutton.setSelected(true);
    }

    String address = add_patient_address_textfield.getText();
    String[] parts = address.split(",\\s*");
    String city = parts.length > 0 ? parts[0] : "";
    String street = parts.length > 1 ? parts[1] : "";
    String postal_code = parts.length > 2 ? parts[2] : "";

    String phone = add_patient_phone_textfield.getText();
    String mail = add_patient_mail_textfield.getText();
    String blood = add_patient_blood_textfield.getText();
    String ıd_s = add_patient_patient_ıd_textfield.getText();
    long ıd = Long.parseLong(ıd_s);
    String password = add_patient_password_textfield.getText();

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Atoras21");
        is_ıd_exists();

        String sql = "INSERT INTO patient (Patient_ID, F_name, M_name, L_name, Age, Blood_type, Phone_number, Mail, Password, Sex) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // INSERT ROW TO PATIENT TABLE
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, ıd);
        pstmt.setString(2, f_name);
        pstmt.setString(3, m_name);
        pstmt.setString(4, l_name);
        pstmt.setInt(5, age);
        pstmt.setString(6, blood);
        pstmt.setString(7, phone);
        pstmt.setString(8, mail);
        pstmt.setString(9, password);
        pstmt.setString(10, String.valueOf(sexxx));

        // INSERT ADDRESS TABLE
        String adres = "INSERT INTO address (Address_ID, City, Street, Postal_code) VALUES (?, ?, ?, ?)";
        PreparedStatement adres_ps = con.prepareStatement(adres);
        adres_ps.setLong(1, ıd);
        adres_ps.setString(2, city);
        adres_ps.setString(3, street);
        adres_ps.setString(4, postal_code);
        adres_ps.executeUpdate();

        // INSERT FAMILY TABLE
        String familya = "INSERT INTO family (Family_ID) VALUES (?)";
        PreparedStatement familya_ps = con.prepareStatement(familya);
        familya_ps.setLong(1, ıd);
        familya_ps.executeUpdate();

        pstmt.executeUpdate();
        checkage(age, 1);

        if (asa == 1) {
            AddFamily af = new AddFamily(ıd, 0);
            af.setVisible(true);
            this.setVisible(false);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Invalid input. Please check your entries and try again.", "Input Error", JOptionPane.WARNING_MESSAGE);
        Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
    }

    }//GEN-LAST:event_add_patient_add_patient_buttonActionPerformed

    private void add_patient_cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_patient_cancel_buttonActionPerformed
        new login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_add_patient_cancel_buttonActionPerformed
    
    public void is_ıd_exists(){
        String pt_ıd = add_patient_patient_ıd_textfield.getText();
        
        Connection con=null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root","Atoras21");
            pt = con.prepareStatement("SELECT COUNT(*) AS count FROM patient WHERE Patient_ID =?;");
            pt.setString(1, pt_ıd);
            rs = pt.executeQuery();
            
            boolean patientExists = false; // Initialize boolean variable

            if (rs.next()) {
                int count = rs.getInt("count"); // Get the value of the count column
                patientExists = count > 0; // Set patientExists to true if count > 0
            }
            if(patientExists){
                JOptionPane.showMessageDialog(this, "Patient ID is already exists.");
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
    
    /*public void checkage(int age, int as){
        try {
            // Establish connection to MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Atoras21");

            // Prepare the call to the stored procedure
            CallableStatement callableStatement = (CallableStatement) connection.prepareCall("{call check_age_constraint(?)}");

            // Set the age parameter
            callableStatement.setInt(1, age);

            // Execute the stored procedure
            callableStatement.execute();
            
            // Close the connection and statement
            callableStatement.close();
            connection.close();
            
        } catch (SQLException e) {
            String ıd_s = add_patient_patient_ıd_textfield.getText();
            long ıd = Long.parseLong(ıd_s);
            
            as = 0;
            JOptionPane.showMessageDialog(this, "Age must be above 0");
            
            if (con != null) {
                try {
                    String pt = "DELET FROM patient WHERE Patient_ID = ?";
                    PreparedStatement pt_ps = con.prepareStatement(pt);
                    pt_ps.setLong(1, ıd);
                    pt_ps.executeUpdate();
                    
                    
                    String adrees = "DELET FROM address WHERE Address_ID = ?";
                    PreparedStatement adres_pss = con.prepareStatement(adrees);
                    adres_pss.setLong(1, ıd);
                    adres_pss.executeUpdate();
                    
                    
                    
                    String deleteSql = "DELETE FROM family WHERE Family_ID = ?";
                    PreparedStatement pstmt = con.prepareStatement(deleteSql);
                    pstmt.setLong(1, ıd);
                    pstmt.executeUpdate();
                    this.asa = as;
                    
                    
                    
                    
                    
                } catch (SQLException ex) {
                        Logger.getLogger(AddFamily.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            this.setVisible(false);
            new AddPatient().setVisible(true);
            
        }
    }*/
    
    public void checkage(int age, int as) {
    Connection connection = null;
    CallableStatement callableStatement = null;

    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Atoras21");

        // Prepare the call to the stored procedure
        callableStatement = (CallableStatement) connection.prepareCall("{call check_age_constraint(?)}");

        // Set the age parameter
        callableStatement.setInt(1, age);

        // Execute the stored procedure
        callableStatement.execute();

        // If no exception occurs, assume age is valid
        this.asa = 1;

    } catch (SQLException e) {
        // Log the exception for debugging
        Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, e);

        // Handle invalid age scenario
        String ıd_s = add_patient_patient_ıd_textfield.getText();
        long ıd = Long.parseLong(ıd_s);
        as = 0;
        this.asa = as;
        JOptionPane.showMessageDialog(this, "Age must be above 0");

        if (connection != null) {
            try {
                // Delete patient from database
                String pt = "DELETE FROM patient WHERE Patient_ID = ?";
                PreparedStatement pt_ps = connection.prepareStatement(pt);
                pt_ps.setLong(1, ıd);
                pt_ps.executeUpdate();

                String adrees = "DELETE FROM address WHERE Address_ID = ?";
                PreparedStatement adres_pss = connection.prepareStatement(adrees);
                adres_pss.setLong(1, ıd);
                adres_pss.executeUpdate();

                String deleteSql = "DELETE FROM family WHERE Family_ID = ?";
                PreparedStatement pstmt = connection.prepareStatement(deleteSql);
                pstmt.setLong(1, ıd);
                pstmt.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(AddFamily.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Close the current frame and open a new AddPatient frame
        this.setVisible(false);
        new AddPatient().setVisible(true);

    } finally {
        try {
            if (callableStatement != null) {
                callableStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    
    private void add_patient_no_family_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_patient_no_family_buttonActionPerformed
        String f_name = add_patient_f_name_textfield.getText();
    String m_name = add_patient_m_name_textfield.getText();
    String l_name = add_patient_l_name_textfield.getText();
    String age_s = add_patient_age_textfield.getText();
    int age = Integer.parseInt(age_s);
        
    char sexxx = 'm';
    
    if (add_patient_male_radiobutton.isSelected()) {
        sexxx = 'm';
    } else if (add_patient_female_radiobutton.isSelected()) {
        sexxx = 'f';
    }
    if (!add_patient_male_radiobutton.isSelected() && !add_patient_female_radiobutton.isSelected()) {
        add_patient_male_radiobutton.setSelected(true);
    }
    
    String address = add_patient_address_textfield.getText();
    String[] parts = address.split(",\\s*");
    String city = "";
    String street = "";
    String postal_code = "";
    int count = 0;
    for(String a : parts){
        if(count == 0)
            city = a;
        if(count == 1)
            street = a;
        if(count == 2)
            postal_code = a;
        count++;
    }
    
    String phone = add_patient_phone_textfield.getText();
    String mail = add_patient_mail_textfield.getText();
    String blood = add_patient_blood_textfield.getText();
    String ıd_s = add_patient_patient_ıd_textfield.getText();
    long ıd = Long.parseLong(ıd_s);
    String password = add_patient_password_textfield.getText();
    
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Atoras21"); 
        is_ıd_exists();

        String sql = "INSERT INTO patient (Patient_ID, F_name, M_name, L_name, Age, Blood_type, Phone_number, Mail, Password, Sex) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        // INSERT ROW TO PATIENT TABLE
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, ıd);
        pstmt.setString(2, f_name);
        pstmt.setString(3, m_name);
        pstmt.setString(4, l_name);
        pstmt.setInt(5, age);
        pstmt.setString(6, blood);
        pstmt.setString(7, phone);
        pstmt.setString(8, mail);
        pstmt.setString(9, password);
        pstmt.setString(10, String.valueOf(sexxx));
        
        // INSERT ADDRESS TABLE
        String adres = "INSERT INTO address (Address_ID, City, Street, Postal_code) VALUES (?, ?, ?, ?)";
        PreparedStatement adres_ps = con.prepareStatement(adres);
        adres_ps.setLong(1, ıd);
        adres_ps.setString(2, city);
        adres_ps.setString(3, street);
        adres_ps.setString(4, postal_code);
        adres_ps.executeUpdate();
        
        // INSERT FAMILY TABLE
        String familya = "INSERT INTO family (Family_ID) VALUES (?)";
        PreparedStatement familya_ps = con.prepareStatement(familya);
        familya_ps.setLong(1, ıd);
        familya_ps.executeUpdate();
        
        pstmt.executeUpdate();
        checkage(age, 1);
        this.setVisible(false);
        if(asa == 1)
            new login().setVisible(true);
        
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }//GEN-LAST:event_add_patient_no_family_buttonActionPerformed

    private void add_patient_female_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_patient_female_radiobuttonActionPerformed
            if(add_patient_male_radiobutton.isSelected()){
                add_patient_male_radiobutton.setSelected(false);
            }
    }//GEN-LAST:event_add_patient_female_radiobuttonActionPerformed

    private void add_patient_male_radiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_patient_male_radiobuttonActionPerformed
        if(add_patient_female_radiobutton.isSelected()){
                add_patient_male_radiobutton.setSelected(false);
        }
    }//GEN-LAST:event_add_patient_male_radiobuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "Address is first three letters of requested information.");
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPatient().setVisible(true);             
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_patient_add_patient_button;
    private javax.swing.JLabel add_patient_address_label;
    private javax.swing.JTextField add_patient_address_textfield;
    private javax.swing.JLabel add_patient_age_label;
    private javax.swing.JTextField add_patient_age_textfield;
    private javax.swing.JLabel add_patient_blood_label;
    private javax.swing.JTextField add_patient_blood_textfield;
    private javax.swing.JButton add_patient_cancel_button;
    private javax.swing.JLabel add_patient_f_name_label;
    private javax.swing.JTextField add_patient_f_name_textfield;
    private javax.swing.JRadioButton add_patient_female_radiobutton;
    private javax.swing.JLabel add_patient_l_name_label;
    private javax.swing.JTextField add_patient_l_name_textfield;
    private javax.swing.JLabel add_patient_m_name_label;
    private javax.swing.JTextField add_patient_m_name_textfield;
    private javax.swing.JLabel add_patient_mail_label;
    private javax.swing.JTextField add_patient_mail_textfield;
    private javax.swing.JRadioButton add_patient_male_radiobutton;
    private javax.swing.JButton add_patient_no_family_button;
    private javax.swing.JLabel add_patient_password_label;
    private javax.swing.JTextField add_patient_password_textfield;
    private javax.swing.JLabel add_patient_patient_ıd_label;
    private javax.swing.JTextField add_patient_patient_ıd_textfield;
    private javax.swing.JLabel add_patient_phone_label;
    private javax.swing.JTextField add_patient_phone_textfield;
    private javax.swing.JLabel add_patient_sex_label;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

}
