package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class() {
        // Set the layout of the frame to BorderLayout
        setLayout(new BorderLayout());

        // Create a JPanel for the menu on the left, taking half the screen width
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 1, 10, 10)); // Layout: 1 column, multiple rows with spacing
        menuPanel.setBackground(new Color(242, 242, 242)); // Soft background color

        // Create a button style (rounded corners, custom font, padding)
        JButtonStyle buttonStyle = new JButtonStyle();

        // Create menu items as large buttons with aesthetic properties
        JButton facultyInfo = createButton("New Stagaire details", null);  // No icon here
        JButton studentInfo = createButton("New Supervisor details", null);  // No icon here
        JButton facultydetails = createButton("View Supervisor Details", null);  // No icon here
        JButton studentdetails = createButton("View Stagaire Details", null);  // No icon here
        JButton facultyLeave = createButton("Supervisor Leave", null);  // No icon here
        JButton studentLeave = createButton("Stagaire Leave", null);  // No icon here
        JButton facultyleaveDetails = createButton("Supervisor Leave Details", null);  // No icon here
        JButton studentleaveDetails = createButton("Stagaire Leave Details", null);  // No icon here
        JButton updatefacultyinfo = createButton("Update Stagaire Details", null);  // No icon here
        JButton updatestudentinfo = createButton("Update Supervisor Details", null);  // No icon here
        JButton feestructure = createButton("Fee Structure", null);  // No icon here
        JButton ca = createButton("Calculator", null);  // No icon here
        JButton Notepad = createButton("Notepad", null);  // No icon here
        JButton exit = createButton("Exit", null);  // No icon here

        // Add buttons to the menu panel
        menuPanel.add(facultyInfo);
        menuPanel.add(studentInfo);
        menuPanel.add(facultydetails);
        menuPanel.add(studentdetails);
        menuPanel.add(facultyLeave);
        menuPanel.add(studentLeave);
        menuPanel.add(facultyleaveDetails);
        menuPanel.add(studentleaveDetails);
        menuPanel.add(updatefacultyinfo);
        menuPanel.add(updatestudentinfo);
        menuPanel.add(feestructure);
        menuPanel.add(ca);
        menuPanel.add(Notepad);
        menuPanel.add(exit);

        // Set the menu panel to take up half of the screen width
        add(menuPanel, BorderLayout.WEST);

        // Create an image label to display the background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1800, 1020, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);

        // Add the image to the content area
        add(img, BorderLayout.CENTER); // Content area

        // Set the frame size and visibility
        setSize(1900, 1020);
        setVisible(true);
    }

    // Helper method to create buttons with a consistent style
    private JButton createButton(String text, String iconName) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(38, 116, 185)); // Deep blue background
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(new Color(38, 116, 185), 5, true)); // Rounded border
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(250, 50)); // Set size for uniformity
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand on hover

        // Add icon to button if path is provided (null iconName means no icon)
        if (iconName != null && !iconName.isEmpty()) {
            button.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/" + iconName)));
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        }

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(50, 130, 200)); // Lighter blue on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(38, 116, 185)); // Original blue
            }
        });

        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if (sm.equals("Exit")) {
            System.exit(15);
        } else if (sm.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (sm.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (sm.equals("New Stagaire details")) {
            new AddFaculty(); // Add functionality
        } else if (sm.equals("New Supervisor details")) {
            new AddStudent(); // Add functionality
        } else if (sm.equals("View Supervisor Details")) {
            new TeacherDetails(); // Add functionality
        } else if (sm.equals("View Stagaire Details")) {
            new StudentDetails(); // Add functionality
        } else if (sm.equals("Supervisor Leave")) {
            new TeacherLeave(); // Add functionality
        } else if (sm.equals("Stagaire Leave")) {
            new StudentLeave(); // Add functionality
        } else if (sm.equals("Supervisor Leave Details")) {
            new TeacherLeaveDetails(); // Add functionality
        } else if (sm.equals("Stagaire Leave Details")) {
            new StudentLeaveDetails(); // Add functionality
        } else if (sm.equals("Update Stagaire Details")) {
            new UpdateStagaire(); // Add functionality
        } else if (sm.equals("Update Supervisor Details")) {
            new updateSupervisor(); // Add functionality
        } else if (sm.equals("Fee Structure")) {
            new StudentFeeForm(); // Add functionality
        }
    }

    public static void main(String[] args) {
        new main_class();
    }

    // Inner class to define button style properties
    private class JButtonStyle {
        private final Color backgroundColor = new Color(38, 116, 185); // Blue color for buttons
        private final Color hoverColor = new Color(50, 130, 200); // Lighter blue color for hover
        private final Color textColor = Color.WHITE; // Text color (white)
        private final int borderRadius = 20; // Radius for rounded corners
    }
}
