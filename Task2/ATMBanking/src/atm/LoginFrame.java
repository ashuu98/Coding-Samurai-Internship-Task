package atm;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private ATMSystem system;
    private JTextField accNoField;
    private JPasswordField pinField;

    public LoginFrame(ATMSystem system) {
        this.system = system;

        setTitle("ATM Login");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(30, 30, 30)); 

        JLabel title = new JLabel("Welcome to ATM");
        title.setBounds(100, 30, 300, 40);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        JLabel accNoLabel = new JLabel("Account Number:");
        accNoLabel.setBounds(70, 100, 150, 25);
        accNoLabel.setForeground(Color.WHITE);
        accNoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(accNoLabel);

        accNoField = new JTextField();
        accNoField.setBounds(230, 100, 200, 30);
        add(accNoField);

        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setBounds(70, 150, 150, 25);
        pinLabel.setForeground(Color.WHITE);
        pinLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(pinLabel);

        pinField = new JPasswordField();
        pinField.setBounds(230, 150, 200, 30);
        add(pinField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(180, 220, 140, 40);
        loginButton.setBackground(new Color(0, 120, 215));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(loginButton);

        loginButton.addActionListener(e -> {
            String accNo = accNoField.getText();
            String pin = new String(pinField.getPassword());
            Account account = system.login(accNo, pin);

            if (account != null) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                dispose();
                new DashboardFrame(system, account);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Account Number or PIN");
            }
        });

        setVisible(true);
    }
}
