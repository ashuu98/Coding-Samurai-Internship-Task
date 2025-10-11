package atm;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    private ATMSystem system;
    private Account account;

    public DashboardFrame(ATMSystem system, Account account) {
        this.system = system;
        this.account = account;

        setTitle("ATM Dashboard - Account: " + account.getAccNo());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome, Account: " + account.getAccNo());
        welcomeLabel.setBounds(150, 20, 400, 40);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(welcomeLabel);

        JButton balanceButton = createButton("Check Balance", 100);
        JButton depositButton = createButton("Deposit Money", 160);
        JButton withdrawButton = createButton("Withdraw Money", 220);
        JButton exitButton = createButton("Exit", 280);

        add(balanceButton);
        add(depositButton);
        add(withdrawButton);
        add(exitButton);

        balanceButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Current Balance: ₹" + account.getBalance()));

        depositButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0) {
                    account.deposit(amount);
                    JOptionPane.showMessageDialog(this, "Deposit Successful! New Balance: ₹" + account.getBalance());
                } else JOptionPane.showMessageDialog(this, "Enter a valid amount!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        withdrawButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            try {
                double amount = Double.parseDouble(input);
                if (amount > 0) {
                    if (account.withdraw(amount)) {
                        JOptionPane.showMessageDialog(this, "Withdrawal Successful! New Balance: ₹" + account.getBalance());
                    } else {
                        JOptionPane.showMessageDialog(this, "Insufficient Balance!");
                    }
                } else JOptionPane.showMessageDialog(this, "Enter a valid amount!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        });

        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Thank you for using  ATM!");
            dispose();
            new LoginFrame(system);
        });

        setVisible(true);
    }

    private JButton createButton(String text, int y) {
        JButton button = new JButton(text);
        button.setBounds(200, y, 200, 40);
        button.setBackground(new Color(0, 120, 215));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        return button;
    }
}
