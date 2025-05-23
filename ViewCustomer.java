package travel.tour.mang.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;

    ViewCustomer(String username) {
        setBounds(100, 100, 1200, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel title = new JLabel("VIEW CUSTOMER DETAILS");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(450, 10, 300, 30);
        add(title);

        // ----- Left Side Labels -----
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 60, 150, 25);
        add(lblUsername);

        JLabel labelUsername = new JLabel();
        labelUsername.setBounds(200, 60, 150, 25);
        add(labelUsername);

        JLabel lblId = new JLabel("ID Type:");
        lblId.setBounds(50, 100, 150, 25);
        add(lblId);

        JLabel labelId = new JLabel();
        labelId.setBounds(200, 100, 150, 25);
        add(labelId);

        JLabel lblNumber = new JLabel("Number:");
        lblNumber.setBounds(50, 140, 150, 25);
        add(lblNumber);

        JLabel labelNumber = new JLabel();
        labelNumber.setBounds(200, 140, 150, 25);
        add(labelNumber);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 180, 150, 25);
        add(lblName);

        JLabel labelName = new JLabel();
        labelName.setBounds(200, 180, 150, 25);
        add(labelName);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(50, 220, 150, 25);
        add(lblGender);

        JLabel labelGender = new JLabel();
        labelGender.setBounds(200, 220, 150, 25);
        add(labelGender);

        // ----- Right Side Labels -----
        JLabel lblCountry = new JLabel("Country:");
        lblCountry.setBounds(600, 60, 150, 25);
        add(lblCountry);

        JLabel labelCountry = new JLabel();
        labelCountry.setBounds(750, 60, 150, 25);
        add(labelCountry);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(600, 100, 150, 25);
        add(lblAddress);

        JLabel labelAddress = new JLabel();
        labelAddress.setBounds(750, 100, 300, 25);
        add(labelAddress);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(600, 140, 150, 25);
        add(lblPhone);

        JLabel labelPhone = new JLabel();
        labelPhone.setBounds(750, 140, 150, 25);
        add(labelPhone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(600, 180, 150, 25);
        add(lblEmail);

        JLabel labelEmail = new JLabel();
        labelEmail.setBounds(750, 180, 250, 25);
        add(labelEmail);

        // ----- Back Button -----
        back = new JButton("Back");
        back.setBounds(500, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons-20250515T180831Z-1-001/icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(20, 400, 600, 200);
        add(image1);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons-20250515T180831Z-1-001/icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM customer WHERE username = '" + username + "'");
            while (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelName.setText(rs.getString("name"));
                labelGender.setText(rs.getString("gender"));
                labelCountry.setText(rs.getString("country"));
                labelAddress.setText(rs.getString("address"));
                labelPhone.setText(rs.getString("phone"));
                labelEmail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewCustomer("Sejal");
    }
}
