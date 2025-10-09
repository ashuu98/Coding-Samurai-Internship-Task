package quizapp;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuizFrame extends JFrame implements ActionListener {
    private Quiz quiz;
    private Question currentQuestion;
    private int questionIndex = 0;
    private int score = 0;

    private JLabel questionLabel;
    private JRadioButton[] optionsButtons;
    private ButtonGroup optionsGroup;
    private JButton btnNext, btnSubmit;
    private String userName;

    public QuizFrame(String userName, Quiz quiz) {
        this.quiz = quiz;
        this.userName = userName;

        setTitle("Quiz - Welcome " + userName);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(230, 230, 250));

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        questionLabel.setBounds(50, 30, 700, 50);
        add(questionLabel);

        optionsButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionsButtons[i] = new JRadioButton();
            optionsButtons[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            optionsButtons[i].setBounds(70, 100 + i * 40, 600, 30);
            optionsGroup.add(optionsButtons[i]);
            add(optionsButtons[i]);
        }

        btnNext = new JButton("Next");
        btnNext.setBounds(500, 300, 100, 30);
        btnNext.setBackground(new Color(60, 179, 113));
        btnNext.setForeground(Color.WHITE);
        btnNext.addActionListener(this);
        add(btnNext);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(620, 300, 100, 30);
        btnSubmit.setBackground(new Color(30, 144, 255));
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        loadQuestion();
        setVisible(true);
    }

    private void loadQuestion() {
        optionsGroup.clearSelection();
        currentQuestion = quiz.getQuestion(questionIndex);
        questionLabel.setText((questionIndex + 1) + ". " + currentQuestion.getQuestion());
        String[] opts = currentQuestion.getOptions();
        for (int i = 0; i < 4; i++) {
            optionsButtons[i].setText(opts[i]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            checkAnswer();
            questionIndex++;
            if (questionIndex < quiz.getTotalQuestions()) {
                loadQuestion();
            } else {
                JOptionPane.showMessageDialog(this, "This is the last question. Please submit!");
            }
        } else if (e.getSource() == btnSubmit) {
            checkAnswer();
            JOptionPane.showMessageDialog(this, userName + ", your score is: " + score + "/" + quiz.getTotalQuestions());
            System.exit(0);
        }
    }

    private void checkAnswer() {
        for (int i = 0; i < 4; i++) {
            if (optionsButtons[i].isSelected() && i == currentQuestion.getCorrectAnswer()) {
                score++;
            }
        }
    }
}

