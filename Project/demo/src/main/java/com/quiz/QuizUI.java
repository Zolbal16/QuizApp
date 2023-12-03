package com.quiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class QuizUI extends JFrame {
    private Quiz quiz;
    private JComboBox<String> topicSelector;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;
    private JLabel scoreLabel;
    private Iterator<QuizQuestion> questionIterator;
    private QuizQuestion currentQuestion;

    public QuizUI() {
        quiz = new Quiz();
        setupUI();
    }

    private void setupUI() {
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("images/quiz_background.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);

        JPanel basePanel = new JPanel(new BorderLayout());
        Color backgroundColor = Color.decode("#030B20");
        basePanel.add(imageLabel, BorderLayout.CENTER);
        basePanel.setBackground(backgroundColor);

        setContentPane(basePanel);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("images/icon_quiz.png"));
        setIconImage(icon.getImage());

        setTitle("Quiz");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setOpaque(false);

        String[] topics = { "Geography", "History", "Physics", "Chemistry", "Literature" };
        topicSelector = new JComboBox<>(topics);
        centerPanel.add(topicSelector);

        questionLabel = new JLabel("Topics");
        questionLabel.setForeground(Color.WHITE);
        centerPanel.add(questionLabel);

        answerField = new JTextField(20);
        centerPanel.add(answerField);

        submitButton = new JButton("Send");
        centerPanel.add(submitButton);

        scoreLabel = new JLabel("");
        scoreLabel.setForeground(Color.WHITE);
        centerPanel.add(scoreLabel);

        basePanel.add(centerPanel, BorderLayout.NORTH);

        setupEventHandlers();
    }

    private void setupEventHandlers() {
        topicSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTopic = (String) topicSelector.getSelectedItem();
                quiz.generateQuestions(selectedTopic);
                questionIterator = quiz.getQuestions().iterator();
                displayNextQuestion();
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userAnswer = answerField.getText();
                boolean isCorrect = quiz.checkAnswer(userAnswer, currentQuestion.getAnswer());
                answerField.setBackground(isCorrect ? Color.GREEN : Color.RED);
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        displayNextQuestion();
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
    }

    private void displayNextQuestion() {
        if (questionIterator != null && questionIterator.hasNext()) {
            currentQuestion = questionIterator.next();
            questionLabel.setText(currentQuestion.getQuestion());
            answerField.setText("");
            answerField.setBackground(Color.WHITE);
        } else {
            scoreLabel.setText("Score: " + quiz.getScore());
            questionLabel.setText("Quiz has ended");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new QuizUI().setVisible(true);
            }
        });
    }
}
