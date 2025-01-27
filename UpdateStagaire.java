package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateStagaire extends JFrame implements ActionListener {
    JTextField textName, textAddress, textPhone, textemail, textAadhar, textSearchByName;
    JLabel empText;
    JDateChooser cdob;
    JComboBox genderbox, courseBox, departmentBox;
    JButton submit, cancel, searchByNameButton;

    UpdateStagaire() {

        // Set background color for the frame
        getContentPane().setBackground(new Color(100, 179, 239));

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpeg")); // Update with correct path to your image
        Image img = backgroundImage.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT); // Adjust size to fit your frame
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 900, 700); // Set background size to fit the frame
        add(background);

        // Heading
        JLabel heading = new JLabel("Update Stagaire Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.WHITE); // Set text color to white
        background.add(heading);

        // Label and Text Field for Searching by Name
        JLabel nameSearch = new JLabel("Enter Stagaire Name");
        nameSearch.setBounds(50, 100, 200, 30);
        nameSearch.setFont(new Font("serif", Font.BOLD, 20));
        nameSearch.setForeground(Color.WHITE); // Set text color to white
        background.add(nameSearch);

        textSearchByName = new JTextField();
        textSearchByName.setBounds(250, 100, 200, 30);
        background.add(textSearchByName);

        searchByNameButton = new JButton("Search by Name");
        searchByNameButton.setBounds(470, 100, 150, 30);
        searchByNameButton.setBackground(Color.black);
        searchByNameButton.setForeground(Color.white);
        searchByNameButton.addActionListener(this);
        background.add(searchByNameButton);

        // Full Name Field
        JLabel name = new JLabel("Full Name");
        name.setBounds(50, 150, 200, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        name.setForeground(Color.WHITE); // Set text color to white
        background.add(name);

        textName = new JTextField();
        textName.setBounds(250, 150, 200, 30);
        background.add(textName);

        // Date of Birth Field
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        dob.setForeground(Color.WHITE); // Set text color to white
        background.add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(250, 200, 200, 30);
        background.add(cdob);

        // Address Field
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        address.setForeground(Color.WHITE); // Set text color to white
        background.add(address);

        textAddress = new JTextField();
        textAddress.setBounds(250, 250, 200, 30);
        background.add(textAddress);

        // Phone Field
        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 300, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        phone.setForeground(Color.WHITE); // Set text color to white
        background.add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(250, 300, 200, 30);
        background.add(textPhone);

        // Email Field
        JLabel email = new JLabel("Email");
        email.setBounds(50, 350, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        email.setForeground(Color.WHITE); // Set text color to white
        background.add(email);

        textemail = new JTextField();
        textemail.setBounds(250, 350, 200, 30);
        background.add(textemail);

        // Gender Dropdown
        JLabel gender = new JLabel("Gender");
        gender.setBounds(50, 400, 200, 30);
        gender.setFont(new Font("serif", Font.BOLD, 20));
        gender.setForeground(Color.WHITE); // Set text color to white
        background.add(gender);

        String genderOptions[] = {"", "Male", "Female"};
        genderbox = new JComboBox(genderOptions);
        genderbox.setBounds(250, 400, 200, 30);
        background.add(genderbox);

        // Qualification Dropdown
        JLabel qualification = new JLabel("Qualification");
        qualification.setBounds(50, 450, 200, 30);
        qualification.setFont(new Font("serif", Font.BOLD, 20));
        qualification.setForeground(Color.WHITE); // Set text color to white
        background.add(qualification);

        String courseOptions[] = {"", "BAC+1", "BAC+2", "BAC+3", "BAC+4", "BAC+5", "BAC+6", "BAC+7", "BAC+8"};
        courseBox = new JComboBox(courseOptions);
        courseBox.setBounds(250, 450, 200, 30);
        background.add(courseBox);

        // Department Dropdown
        JLabel department = new JLabel("Department");
        department.setBounds(50, 500, 200, 30);
        department.setFont(new Font("serif", Font.BOLD, 20));
        department.setForeground(Color.WHITE); // Set text color to white
        background.add(department);

        String departmentOptions[] = {"", "Data Science", "Cyber Security", "Full Stack", "AI", "Robotics"};
        departmentBox = new JComboBox(departmentOptions);
        departmentBox.setBounds(250, 500, 200, 30);
        background.add(departmentBox);

        // Aadhar Field
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(50, 550, 200, 30);
        aadhar.setFont(new Font("serif", Font.BOLD, 20));
        aadhar.setForeground(Color.WHITE); // Set text color to white
        background.add(aadhar);

        textAadhar = new JTextField();
        textAadhar.setBounds(250, 550, 200, 30);
        background.add(textAadhar);

        // Submit Button
        submit = new JButton("Update");
        submit.setBounds(250, 600, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        background.add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 600, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        background.add(cancel);

        // Frame Settings
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchByNameButton) {
            String name = textSearchByName.getText();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Stagaire's name.");
                return;
            }

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM Stagaire WHERE name = '" + name + "'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if (resultSet.next()) {
                    textName.setText(resultSet.getString("name"));
                    cdob.setDate(resultSet.getDate("dob"));
                    textAddress.setText(resultSet.getString("address"));
                    textPhone.setText(resultSet.getString("phone"));
                    textemail.setText(resultSet.getString("email"));
                    genderbox.setSelectedItem(resultSet.getString("gender"));
                    courseBox.setSelectedItem(resultSet.getString("education"));
                    departmentBox.setSelectedItem(resultSet.getString("department"));
                    textAadhar.setText(resultSet.getString("aadhar"));
                } else {
                    JOptionPane.showMessageDialog(null, "No Stagaire found with the name: " + name);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == submit) {
            String name = textName.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String gender = (String) genderbox.getSelectedItem();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();
            String aadhar = textAadhar.getText();

            try {
                String query = "UPDATE Stagaire SET name = '" + name + "', dob = '" + dob + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', gender = '" + gender + "', education = '" + course + "', department = '" + department + "', aadhar = '" + aadhar + "' WHERE name = '" + name + "'";
                Conn c = new Conn();
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details Updated");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStagaire();
    }
}
