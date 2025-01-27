package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textFieldName;
    JPasswordField passwordField;
    JButton login, back;
    Login(){

        JLabel labelName = new JLabel("Username");
        labelName.setForeground(Color.WHITE);
        labelName.setBounds(80,30,100,20);
        labelName.setFont(new Font("Arial", Font.PLAIN, 20));
        add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(250,30,160,25);
        add(textFieldName);

        JLabel labelpass = new JLabel("Password");
        labelpass.setForeground(Color.WHITE);
        labelpass.setBounds(80,80,100,20);
        labelpass.setFont(new Font("Arial", Font.PLAIN, 20));
        add(labelpass);

        passwordField = new JPasswordField();
        passwordField.setBounds(250,80,160,25);
        add(passwordField);

        login = new JButton("Login");
        login.setBounds(100,140,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(240,140,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500,20,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
        Image i22 = i11.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0,0,800,500);
        add(image);



        setSize(800,500);
        setLocation(500,250);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            String username = textFieldName.getText();
            String password = passwordField.getText();

            String query = "select * from login where username='"+username+"' and password = '"+password+"'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new main_class();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }


            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}




