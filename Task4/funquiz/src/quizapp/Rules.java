package quizapp;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame implements ActionListener {
    private JButton btnStart;
    private String userName;
    private Quiz quiz;

    public Rules(String userName, Quiz quiz) {
        this.userName = userName;
        this.quiz = quiz;

        setTitle("Quiz Rules");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 220));

        JLabel heading = new JLabel("Welcome " + userName + "!");
        heading.setFont(new Font("Verdana", Font.BOLD, 22));
        heading.setForeground(new Color(50, 50, 150));
        heading.setBounds(50, 30, 500, 30);
        add(heading);

        JTextArea rulesArea = new JTextArea(
            "1. You will have 5 questions.\n" +
            "2. Each question carries 1 mark.\n" +
            "3. You can select an answer and change it before submitting.\n" +
            "4. After the last question, click Submit to see your score."
        );
        rulesArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rulesArea.setEditable(false);
        rulesArea.setBounds(50, 80, 600, 150);
        rulesArea.setBackground(new Color(245, 245, 220));
        add(rulesArea);

        btnStart = new JButton("Start Quiz");
        btnStart.setBounds(500, 300, 120, 30);
        btnStart.setBackground(new Color(60, 179, 113));
        btnStart.setForeground(Color.WHITE);
        btnStart.addActionListener(this);
        add(btnStart);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new QuizFrame(userName, quiz);
    }
}

