package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {
    Choice choiceEmpName;  // Changed to search by employee name
    JTable table;
    JButton search, cancel, print;

    TeacherLeaveDetails() {
        getContentPane().setBackground(new Color(101, 149, 248));

        JLabel heading = new JLabel("Search by Employee Name");
        heading.setBounds(20, 20, 200, 20);
        add(heading);

        choiceEmpName = new Choice();  // Change the choice to employee name
        choiceEmpName.setBounds(180, 20, 150, 20);
        add(choiceEmpName);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT name FROM employee");
            while (resultSet.next()) {
                choiceEmpName.add(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM employeeLeave");
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
            String selectedName = choiceEmpName.getSelectedItem();
            String query = "SELECT * FROM employeeLeave WHERE name = (SELECT name FROM employee WHERE name = '" + selectedName + "')";
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
        new TeacherLeaveDetails();
    }
}