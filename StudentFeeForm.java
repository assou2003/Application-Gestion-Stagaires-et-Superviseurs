package university.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.time.LocalDate;

public class StudentFeeForm extends JFrame implements ActionListener, Printable {
    JTextField textName, textDOB, textAddress, textPhone, textEmail, textCompanyName, textStage, textSupervisor, textSupervisorPosition, textSupervisorContact;
    JDateChooser startDateChooser, endDateChooser;
    JComboBox departmentBox, genderBox, courseBox;
    JButton submit, cancel, attestationButton, printButton, shutdownButton;

    StudentFeeForm() {
        getContentPane().setBackground(new Color(100, 179, 239));

        // Main Layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Heading
        JLabel heading = new JLabel("Stage Attestation Form", SwingConstants.CENTER);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(heading);

        // Personal Information Panel
        JPanel personalInfoPanel = createSectionPanel("Personal Information");
        addFormRow(personalInfoPanel, "Full Name:", textName = new JTextField(20));
        addFormRow(personalInfoPanel, "Date of Birth:", textDOB = new JTextField(20));
        addFormRow(personalInfoPanel, "Address:", textAddress = new JTextField(20));
        addFormRow(personalInfoPanel, "Phone Number:", textPhone = new JTextField(20));
        addFormRow(personalInfoPanel, "Email:", textEmail = new JTextField(20));
        add(personalInfoPanel);

        // Gender and Course Panel
        JPanel genderCoursePanel = new JPanel();
        genderCoursePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Gender
        genderBox = new JComboBox(new String[]{"Male", "Female"});
        genderCoursePanel.add(new JLabel("Gender:"));
        genderCoursePanel.add(genderBox);

        // Course
        courseBox = new JComboBox(new String[]{"Course A", "Course B", "Course C"});
        genderCoursePanel.add(new JLabel("Course:"));
        genderCoursePanel.add(courseBox);

        add(genderCoursePanel);

        // Internship Details Panel
        JPanel internshipDetailsPanel = createSectionPanel("Internship Details");
        addFormRow(internshipDetailsPanel, "Company Name:", textCompanyName = new JTextField(20));
        addFormRow(internshipDetailsPanel, "Stage Name:", textStage = new JTextField(20));
        addFormRow(internshipDetailsPanel, "Department:", departmentBox = new JComboBox(new String[]{"", "Data Science", "Cyber Security", "Full Stack", "AI", "Robotics"}));
        addFormRow(internshipDetailsPanel, "Start Date:", startDateChooser = new JDateChooser());
        addFormRow(internshipDetailsPanel, "End Date:", endDateChooser = new JDateChooser());
        add(internshipDetailsPanel);

        // Supervisor Information Panel
        JPanel supervisorPanel = createSectionPanel("Supervisor Information");
        addFormRow(supervisorPanel, "Supervisor Name:", textSupervisor = new JTextField(20));
        addFormRow(supervisorPanel, "Supervisor Position:", textSupervisorPosition = new JTextField(20));
        addFormRow(supervisorPanel, "Supervisor Contact:", textSupervisorContact = new JTextField(20));
        add(supervisorPanel);

        // Action Buttons Panel
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        submit = new JButton("Submit");
        submit.addActionListener(this);
        actionPanel.add(submit);

        attestationButton = new JButton("Generate Attestation");
        attestationButton.addActionListener(this);
        actionPanel.add(attestationButton);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        actionPanel.add(cancel);

        printButton = new JButton("Print Attestation");
        printButton.addActionListener(this);
        actionPanel.add(printButton);

        // Shutdown Button
        shutdownButton = new JButton("Shutdown");
        shutdownButton.addActionListener(this);
        actionPanel.add(shutdownButton);

        add(actionPanel);

        // Window settings
        setSize(1000, 900);
        setLocation(350, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createSectionPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

    private void addFormRow(JPanel panel, String labelText, JComponent field) {
        JPanel row = new JPanel();
        row.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("serif", Font.BOLD, 18));
        row.add(label);
        row.add(field);
        panel.add(row);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            // Get the data from the form fields
            String name = textName.getText();
            String university = textName.getText();  // Assuming you're getting university info from another field
            String empid = textPhone.getText();  // Assuming you're using phone as the empid for now
            String dob = textDOB.getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String gender = (String) genderBox.getSelectedItem();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            try {
                // Create the SQL query to insert the data
                String query = "INSERT INTO Attestation (name, university, empid, dob, address, phone, email, gender, course, department) " +
                        "VALUES ('" + name + "', '" + university + "', '" + empid + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + gender + "', '" + course + "', '" + department + "')";

                // Connect to the database and execute the query
                Conn connection = new Conn(); // Assuming Conn class is already set up to handle DB connection
                connection.statement.executeUpdate(query);  // Execute the insert query

                // Show a success message
                JOptionPane.showMessageDialog(null, "Details Inserted Successfully");

                // Optionally, close the form after successful insertion (if required)
                // setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();  // Print any errors to the console
                JOptionPane.showMessageDialog(null, "Error inserting details. Please try again.");
            }
        } else if (e.getSource() == cancel) {
            setVisible(false); // Close the form
        } else if (e.getSource() == attestationButton) {
            generateAttestation();
        } else if (e.getSource() == printButton) {
            printAttestation();
        } else if (e.getSource() == shutdownButton) {
            // Exit the application
            System.exit(0);
        }
    }

    private void generateAttestation() {
        // Collect form data and generate attestation (same as before)
        String name = textName.getText();
        String companyName = textCompanyName.getText();
        String stage = textStage.getText();
        String department = (String) departmentBox.getSelectedItem();
        String startDate = ((JTextField) startDateChooser.getDateEditor().getUiComponent()).getText();
        String endDate = ((JTextField) endDateChooser.getDateEditor().getUiComponent()).getText();
        String supervisor = textSupervisor.getText();
        String supervisorContact = textSupervisorContact.getText();

        if (name.isEmpty() || companyName.isEmpty() || stage.isEmpty() || supervisor.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the details to generate an attestation.");
            return;
        }

        String attestation = "Stage Attestation\n\n" +
                "This is to certify that " + name + " has successfully completed an internship at " + companyName + ".\n" +
                "The stage was conducted in the " + department + " department under the supervision of " + supervisor + ".\n" +
                "Internship Period: " + startDate + " to " + endDate + ".\n\n" +
                "Supervisor's Contact: " + supervisorContact + "\n\n" +
                "Date: " + LocalDate.now();

        JOptionPane.showMessageDialog(null, attestation, "Attestation", JOptionPane.INFORMATION_MESSAGE);
    }

    private void printAttestation() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return 0;
    }

    public static void main(String[] args) {
        new StudentFeeForm();  // Launch the form
    }
}
