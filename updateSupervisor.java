package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import university.management.system.Conn;

public class updateSupervisor extends JFrame implements ActionListener {
    JTextField textName, textAddress, textPhone, textEmail, textYearsofExp, textNationalID, searchNameField;
    JLabel empText;
    JDateChooser cdob;
    JComboBox<String> genderBox, departmentBox;
    JButton submit, cancel;

    updateSupervisor() {
        // Set frame background color
        getContentPane().setBackground(new Color(100, 179, 239));

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icon/messi.png")); // Update with correct path to your image
        Image img = backgroundImage.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT); // Adjust size to 16:9 ratio
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 1280, 720); // Set background size to 16:9 ratio
        add(background);

        // Heading
        JLabel heading = new JLabel("Update Supervisor Details");
        heading.setBounds(460, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.WHITE); // Change text color to white
        background.add(heading);

        // Search by Name
        JLabel searchLabel = new JLabel("Enter Supervisor Name");
        searchLabel.setBounds(50, 100, 250, 30);
        searchLabel.setFont(new Font("serif", Font.BOLD, 20));
        searchLabel.setForeground(Color.WHITE); // Change text color to white
        background.add(searchLabel);

        searchNameField = new JTextField();
        searchNameField.setBounds(300, 100, 250, 30);
        background.add(searchNameField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(580, 100, 120, 30);
        searchButton.setBackground(Color.black);
        searchButton.setForeground(Color.white);
        searchButton.addActionListener(this);
        background.add(searchButton);

        // Full Name
        JLabel name = new JLabel("Full Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        name.setForeground(Color.WHITE); // Set text color to white
        background.add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 250, 30);
        background.add(textName);

        // National ID
        JLabel nationalID = new JLabel("National ID");
        nationalID.setBounds(500, 150, 150, 30);
        nationalID.setFont(new Font("serif", Font.BOLD, 20));
        nationalID.setForeground(Color.WHITE); // Set text color to white
        background.add(nationalID);

        textNationalID = new JTextField();
        textNationalID.setBounds(650, 150, 250, 30);
        background.add(textNationalID);

        // Employee ID
        JLabel empID = new JLabel("Employee ID");
        empID.setBounds(50, 200, 200, 30);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        empID.setForeground(Color.WHITE); // Set text color to white
        background.add(empID);

        empText = new JLabel();
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        empText.setForeground(Color.WHITE); // Set text color to white
        background.add(empText);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(500, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        dob.setForeground(Color.WHITE); // Set text color to white
        background.add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(650, 200, 250, 30);
        background.add(cdob);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        address.setForeground(Color.WHITE); // Set text color to white
        background.add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 250, 30);
        background.add(textAddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(500, 250, 150, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        phone.setForeground(Color.WHITE); // Set text color to white
        background.add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(650, 250, 250, 30);
        background.add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 320, 150, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        email.setForeground(Color.WHITE); // Set text color to white
        background.add(email);

        textEmail = new JTextField();
        textEmail.setBounds(200, 320, 250, 30);
        background.add(textEmail);

        // Gender
        JLabel gender = new JLabel("Gender");
        gender.setBounds(500, 320, 150, 30);
        gender.setFont(new Font("serif", Font.BOLD, 20));
        gender.setForeground(Color.WHITE); // Set text color to white
        background.add(gender);

        String[] genderOptions = {"", "Male", "Female"};
        genderBox = new JComboBox<>(genderOptions);
        genderBox.setBounds(650, 320, 250, 30);
        genderBox.setFont(new Font("serif", Font.BOLD, 20));
        background.add(genderBox);

        // Years of Experience
        JLabel yearsofexp = new JLabel("Years of Experience");
        yearsofexp.setBounds(50, 400, 200, 30);
        yearsofexp.setFont(new Font("serif", Font.BOLD, 20));
        yearsofexp.setForeground(Color.WHITE); // Set text color to white
        background.add(yearsofexp);

        textYearsofExp = new JTextField();
        textYearsofExp.setBounds(200, 400, 250, 30);
        background.add(textYearsofExp);

        // Department
        JLabel department = new JLabel("Department");
        department.setBounds(500, 400, 200, 30);
        department.setFont(new Font("serif", Font.BOLD, 20));
        department.setForeground(Color.WHITE); // Set text color to white
        background.add(department);

        String[] departments = {"", "Data Science", "Cyber Security", "Full Stack", "AI", "Robotics"};
        departmentBox = new JComboBox<>(departments);
        departmentBox.setBounds(650, 400, 250, 30);
        background.add(departmentBox);

        // Submit Button
        submit = new JButton("Update");
        submit.setBounds(350, 500, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        background.add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(550, 500, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        background.add(cancel);

        setSize(1280, 720); // Set to 16:9 aspect ratio
        setLocation(150, 50); // Position window at a suitable location
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton source = (JButton) e.getSource();

            if (source.getText().equals("Search")) {
                String studentName = searchNameField.getText();

                try {
                    Conn c = new Conn();
                    String query = "select * from employee where name = '" + studentName + "'";
                    ResultSet resultSet = c.statement.executeQuery(query);

                    if (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textNationalID.setText(resultSet.getString("nationalid"));
                        cdob.setDate(resultSet.getDate("dob"));
                        textAddress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                        empText.setText(resultSet.getString("empid"));
                        genderBox.setSelectedItem(resultSet.getString("gender"));
                        textYearsofExp.setText(resultSet.getString("yearsofexp"));
                        departmentBox.setSelectedItem(resultSet.getString("department"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Supervisor not found");
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }

            if (source.getText().equals("Update")) {
                String empid = empText.getText();
                String name = textName.getText();
                String nationalid = textNationalID.getText();
                String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
                String address = textAddress.getText();
                String phone = textPhone.getText();
                String email = textEmail.getText();
                String gender = (String) genderBox.getSelectedItem();
                String yearsofexp = textYearsofExp.getText();
                String department = (String) departmentBox.getSelectedItem();

                try {
                    String q = "UPDATE employee SET name = '" + name + "', nationalid = '" + nationalid + "', dob = '" + dob + "', " +
                            "address = '" + address + "', phone = '" + phone + "', email = '" + email + "', gender = '" + gender + "', " +
                            "yearsofexp = '" + yearsofexp + "', department = '" + department + "' WHERE empid = '" + empid + "'";

                    Conn c = new Conn();
                    c.statement.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Details Updated");
                    setVisible(false);
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }

            if (source.getText().equals("Cancel")) {
                setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        new updateSupervisor();
    }
}
