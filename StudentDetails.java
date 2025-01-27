package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentDetails extends JFrame implements ActionListener {

    Choice choiceName;
    JTable table;
    JButton search, print, update, add, cancel;

    // Constructor
    StudentDetails() {
        setLayout(null);

        // Set background color for content area
        getContentPane().setBackground(new Color(210, 252, 218));

        // Heading label
        JLabel heading = new JLabel("Search by Name");
        heading.setBounds(20, 20, 150, 20);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        heading.setForeground(Color.BLACK); // Set text color to black
        add(heading);

        // Dropdown for student names
        choiceName = new Choice();
        choiceName.setBounds(180, 20, 150, 20);
        add(choiceName);

        // Populate dropdown with student names
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT name FROM Stagaire");
            while (resultSet.next()) {
                choiceName.add(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Table to display student data
        table = new JTable();

        // Set background image behind table area
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icon/stagairedetails.jpg")); // Update with the correct path to your image
        Image img = backgroundImage.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT); // Adjust size as needed
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 100, 900, 600); // Set background size for the table area
        add(background); // Add the background image behind the table

        // Scroll pane for the table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600); // Scroll pane with the same bounds as the background image
        background.add(scrollPane); // Add scroll pane inside the background image area

        // Search button
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        // Print button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);

        // Add button
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        // Update button
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        // Frame settings
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    // Handle button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String selectedName = choiceName.getSelectedItem();
            String query = "SELECT * FROM Stagaire WHERE name = '" + selectedName + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == add) {
            setVisible(false);
            new AddStudent();
        } else if (e.getSource() == update) {
            // Add update functionality as required
        } else {
            setVisible(false);
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new StudentDetails();
    }
}
