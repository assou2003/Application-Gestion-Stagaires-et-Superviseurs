package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {
    JTextField textName, Textuni, textAddress, textPhone, textemail, textyearsofexp;
    JLabel empText;
    JDateChooser cdob;
    JComboBox<String> departmentBox, genderbox;
    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddStudent() {
        // Set frame background color to a light color for clarity
        getContentPane().setBackground(new Color(100, 179, 239));

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icon/addsupr.jpg")); // Update with the correct path to your image
        Image img = backgroundImage.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT); // Adjust size as needed
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 900, 700); // Set background size
        add(background);

        // Heading
        JLabel heading = new JLabel("New Supervisor Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setForeground(Color.BLACK); // Change text color to black
        background.add(heading);

        // Full Name
        JLabel name = new JLabel("Full Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        name.setForeground(Color.BLACK); // Set text color to black
        background.add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 200, 30);
        background.add(textName);

        // National ID
        JLabel fname = new JLabel("National ID");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        fname.setForeground(Color.BLACK); // Set text color to black
        background.add(fname);

        Textuni = new JTextField();
        Textuni.setBounds(600, 150, 200, 30);
        background.add(Textuni);

        // Employee ID
        JLabel empID = new JLabel("Employee ID");
        empID.setBounds(50, 200, 200, 30);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        empID.setForeground(Color.BLACK); // Set text color to black
        background.add(empID);

        empText = new JLabel("1409" + f4);
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        empText.setForeground(Color.BLACK); // Set text color to black
        background.add(empText);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        dob.setForeground(Color.BLACK); // Set text color to black
        background.add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600, 200, 200, 30);
        background.add(cdob);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        address.setForeground(Color.BLACK); // Set text color to black
        background.add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 200, 30);
        background.add(textAddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        phone.setForeground(Color.BLACK); // Set text color to black
        background.add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600, 250, 200, 30);
        background.add(textPhone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 320, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        email.setForeground(Color.BLACK); // Set text color to black
        background.add(email);

        textemail = new JTextField();
        textemail.setBounds(200, 320, 200, 30);
        background.add(textemail);

        // Gender
        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(400, 320, 200, 30);
        Gender.setFont(new Font("serif", Font.BOLD, 20));
        Gender.setForeground(Color.BLACK); // Set text color to black
        background.add(Gender);

        String gender[] = {"", "male", "female"};
        genderbox = new JComboBox<>(gender);
        genderbox.setBounds(600, 320, 200, 30);
        genderbox.setFont(new Font("serif", Font.BOLD, 20));
        background.add(genderbox);

        // Years of Experience
        JLabel yearsofexp = new JLabel("Years of Experience");
        yearsofexp.setBounds(50, 400, 200, 30);
        yearsofexp.setFont(new Font("serif", Font.BOLD, 20));
        yearsofexp.setForeground(Color.BLACK); // Set text color to black
        background.add(yearsofexp);

        textyearsofexp = new JTextField();
        textyearsofexp.setBounds(200, 400, 200, 30);
        background.add(textyearsofexp);

        // Department
        JLabel Department = new JLabel("Department");
        Department.setBounds(400, 400, 200, 30);
        Department.setFont(new Font("serif", Font.BOLD, 20));
        Department.setForeground(Color.BLACK); // Set text color to black
        background.add(Department);

        String department[] = {"", "Data Science", "Cyber Security", "Full Stack", "AI", "Robotique"};
        departmentBox = new JComboBox<>(department);
        departmentBox.setBounds(600, 400, 200, 30);
        background.add(departmentBox);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(250, 500, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        background.add(submit);

        // Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        background.add(cancel);

        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = textName.getText();
            String nationalid = Textuni.getText();
            String empid = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String gender = (String) genderbox.getSelectedItem();
            String yearsofexp = textyearsofexp.getText();
            String department = (String) departmentBox.getSelectedItem();

            try {
                String q = "INSERT INTO employee (name, nationalid, empid, dob, address, phone, email, gender, yearsofexp, department) " +
                        "VALUES ('" + name + "', '" + nationalid + "', '" + empid + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + gender + "', '" + yearsofexp + "', '" + department + "')";

                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Inserted");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
