package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice choice;
    JTable table;
    JButton search, print, update, add, cancel;

    // Constructor
    TeacherDetails() {
        // Set the layout manager to null to manually position the components
        setLayout(null);

        // Set background image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icon/stagairedetails.jpg")); // Update with the correct path to your image
        Image img = backgroundImage.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT); // Adjust size as needed
        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 900, 700); // Set background size
        add(background); // Add the background image first

        // Set background color for the content panel
        getContentPane().setBackground(new Color(192, 164, 252));

        // Heading
        JLabel heading = new JLabel("Search by Name");
        heading.setBounds(20, 20, 150, 20);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        heading.setForeground(Color.BLACK); // Set text color to black
        background.add(heading); // Add to the background panel

        // Dropdown for names
        choice = new Choice();
        choice.setBounds(180, 20, 150, 20);
        background.add(choice); // Add to the background panel

        // Populate dropdown with names from the `employee` table
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT name FROM employee");
            while (resultSet.next()) {
                choice.add(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display table
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Scroll pane for the table
        JScrollPane js = new JScrollPane(table);
        js.setBounds(0, 100, 900, 600);
        background.add(js); // Add scroll pane to the background panel

        // Search button
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        background.add(search); // Add to the background panel

        // Print button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        background.add(print); // Add to the background panel

        // Add button
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        background.add(add); // Add to the background panel

        // Update button
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        background.add(update); // Add to the background panel

        // Cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        background.add(cancel); // Add to the background panel

        // Frame settings
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    // Handle button actions
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            String selectedName = choice.getSelectedItem();
            String query = "SELECT * FROM teacher WHERE name = '" + selectedName + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == add) {
            setVisible(false);
            new AddFaculty();
        } else if (e.getSource() == update) {
            // Future implementation for updating teacher details
        } else if (e.getSource() == cancel) {
            setVisible(false);
        }
    }

    // Main method
    public static void main(String[] args) {
        new TeacherDetails();
    }
}
