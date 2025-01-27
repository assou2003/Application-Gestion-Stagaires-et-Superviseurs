package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice choiceStudentName;  // Changed to search by student name
    JTable table;
    JButton search, cancel, print;

    StudentLeaveDetails() {
        getContentPane().setBackground(new Color(250, 172, 206));

        JLabel heading = new JLabel("Search by Student Name");
        heading.setBounds(20, 20, 200, 20);
        add(heading);

        choiceStudentName = new Choice();  // Changed to student name
        choiceStudentName.setBounds(180, 20, 150, 20);
        add(choiceStudentName);

        // Populate the Choice with student names
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT name FROM Stagaire");
            while (resultSet.next()) {
                choiceStudentName.add(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Table to display student leave details
        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM StagaireLeave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            // Use the student name to search for their leave details
            String selectedName = choiceStudentName.getSelectedItem();
            String query = "SELECT * FROM StagaireLeave WHERE name = (SELECT name FROM Stagaire WHERE name = '" + selectedName + "')";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeaveDetails();
    }
}
