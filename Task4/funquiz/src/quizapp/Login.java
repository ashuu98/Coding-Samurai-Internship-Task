package quizapp;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    private JButton btnStart, btnExit;
    private JTextField nameField;

    public Login() {
        setTitle("Welcome to Fun Quiz");
        setSize(800, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("qphoto/quiz6.jpg"));
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(30, 30, 300, 250);
        add(imageLabel);

        JLabel heading = new JLabel("Welcome to Quiz Time!");
        heading.setFont(new Font("Verdana", Font.BOLD, 24));
        heading.setForeground(new Color(50, 50, 150));
        heading.setBounds(400, 30, 400, 40);
        add(heading);

        JLabel nameLabel = new JLabel("Enter Your Name:");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        nameLabel.setBounds(400, 100, 200, 30);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(400, 140, 200, 30);
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(nameField);

        btnStart = new JButton("Start Quiz");
        btnStart.setBounds(400, 200, 120, 30);
        btnStart.setBackground(new Color(60, 179, 113));
        btnStart.setForeground(Color.WHITE);
        btnStart.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnStart.addActionListener(this);
        add(btnStart);

        btnExit = new JButton("Exit");
        btnExit.setBounds(540, 200, 100, 30);
        btnExit.setBackground(new Color(220, 20, 60));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnExit.addActionListener(this);
        add(btnExit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                setVisible(false);
                new Rules(name, new Quiz());
            } else {
                JOptionPane.showMessageDialog(this, "Please enter your name!");
            }
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }
}

