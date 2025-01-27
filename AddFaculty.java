package university.management.system;

import com.toedter.calendar.JDateChooser;
import university.management.system.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddFaculty extends JFrame implements ActionListener {

    JTextField textName, Textuni, textAddress, textPhone, textemail, textM12, textAadhar;
    JLabel empText;
    JDateChooser cdob;
    JComboBox courseBox, departmentBox, genderbox;
    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

    AddFaculty() {

        getContentPane().setBackground(new Color(100, 179, 239)); // This is optional if you want to apply background color

        // Load the image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/icon/addstagaire.jpg")); // Ensure the image path is correct
        Image image = imageIcon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        JLabel background = new JLabel(new ImageIcon(image));
        background.setBounds(0, 0, 900, 700);  // Set the position and size of the background image
        add(background);

        JLabel heading = new JLabel("New Stagaire Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        background.add(heading);

        JLabel name = new JLabel("full Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        background.add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 150, 30);
        background.add(textName);

        JLabel fname = new JLabel("university");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        background.add(fname);

        Textuni = new JTextField();
        Textuni.setBounds(600, 150, 150, 30);
        background.add(Textuni);

        JLabel empID = new JLabel("Employee ID");
        empID.setBounds(50, 200, 200, 30);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        background.add(empID);

        empText = new JLabel("1409" + f4);
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        background.add(empText);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        background.add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600, 200, 150, 30);
        background.add(cdob);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 200, 30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        background.add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200, 250, 150, 30);
        background.add(textAddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        background.add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600, 250, 150, 30);
        background.add(textPhone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 320, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        background.add(email);

        textemail = new JTextField();
        textemail.setBounds(200, 320, 150, 30);
        background.add(textemail);

        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(400, 320, 200, 30);
        Gender.setFont(new Font("serif", Font.BOLD, 20));
        background.add(Gender);

        String gender[] = {"", "male ", "female"};
        genderbox = new JComboBox(gender);
        genderbox.setBounds(600, 320, 200, 30);
        genderbox.setFont(new Font("serif", Font.BOLD, 20));
        background.add(genderbox);

        JLabel Qualification = new JLabel("Qualification");
        Qualification.setBounds(50, 400, 200, 30);
        Qualification.setFont(new Font("serif", Font.BOLD, 20));
        background.add(Qualification);

        String course[] = {"", "BAC+1", "BAC+2", "BAC+3", "BAC+4", "BAC+5", "BAC+6", "BAC+7", "BAC+8"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200, 400, 150, 30);
        courseBox.setBackground(Color.WHITE);
        background.add(courseBox);

        JLabel Department = new JLabel("Department");
        Department.setBounds(400, 400, 200, 30);
        Department.setFont(new Font("serif", Font.BOLD, 20));
        background.add(Department);

        String department[] = {"", "Data Science", "Cyber Security", "Full Stack", "AI", "Robotique"};
        departmentBox = new JComboBox(department);
        departmentBox.setBounds(600, 400, 150, 30);
        departmentBox.setBackground(Color.WHITE);
        background.add(departmentBox);

        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        background.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
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
            String university = Textuni.getText();
            String empid = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textemail.getText();
            String gender = (String) genderbox.getSelectedItem();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();
            try {
                String q = "INSERT INTO Stagaire (name, university, empid, dob, address, phone, email, gender, course, department) " +
                        "VALUES ('" + name + "', '" + university + "', '" + empid + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + gender + "', '" + course + "', '" + department + "')";

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
        new AddFaculty();
    }
}
