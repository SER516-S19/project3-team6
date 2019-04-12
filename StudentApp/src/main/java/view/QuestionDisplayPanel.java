package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import constants.Constants;
import controller.ChangeStateListener;
import controller.QuestionsDisplay;
import model.Question;
import model.Quiz;

/**
 * To show Question Panel in student APP
 * @author Amit, Narendra, bijayalaxmipanda, Amanjot Singh
 *
 */
public class QuestionDisplayPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	JLabel questionLabel = null;
	JRadioButton optionA = null;
	JRadioButton optionB = null;
	JRadioButton optionC = null;
	JRadioButton optionD = null;
	public int questionCount = 0;

	public static List<Quiz> questionData;
	public static List<Question> questions;
	String correctAnswer = null;

	public void display(final int counter)
	{
		this.setBackground(new Color(255, 255, 255));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        Dimension buttonDimension = new Dimension(150, 50);
        Color buttonBackGround = new Color(245, 255, 250);
        Color buttonForeGround = new Color(0, 128, 128);
        Font buttonFont = new Font("Monospaced", Font.PLAIN, 24);
		
		JButton nextButton=new JButton(Constants.NEXT_BUTTON);
		nextButton.setBackground(buttonBackGround);
		nextButton.setFont(buttonFont);
		nextButton.setForeground(buttonForeGround);

		nextButton.setSize(buttonDimension);

		nextButton.setFocusPainted(false);
		
		JButton giveupButton=new JButton(Constants.GIVEUP_BUTTON);
		giveupButton.setBackground(buttonBackGround);
		giveupButton.setFont(buttonFont);
		giveupButton.setForeground(buttonForeGround);
		giveupButton.setSize(buttonDimension);
		giveupButton.setFocusPainted(false);
        
		JButton submitButton = new JButton(Constants.SUBMIT_BUTTON);
		submitButton.setBackground(buttonBackGround);
		submitButton.setFont(buttonFont);
		submitButton.setForeground(buttonForeGround);

		submitButton.setSize(buttonDimension);
		submitButton.setFocusPainted(false);
		
		if (questions.size() == 0) {
			StudentMainFrame.closeWindow();
		}
		
		questionLabel = new JLabel (questions.get(counter).getTitle());
		questionLabel.setFont(buttonFont); 
		String[] options = new String[4];
		options = questions.get(counter).getOptions();
		optionA = new JRadioButton(options[0]);
		optionA.setFont(buttonFont); 
		optionB = new JRadioButton(options[1]);
		optionB.setFont(buttonFont);
		optionC = new JRadioButton(options[2]);
		optionC.setFont(buttonFont);
		optionD = new JRadioButton(options[3]);

		optionD.setFont(buttonFont);
		correctAnswer = questions.get(counter).getCorrectAnswer();

		giveupButton.addActionListener(new ChangeStateListener());
		Dimension panelDimention = new Dimension(600, 300);
		JPanel jp = new JPanel();
		jp.setAlignmentX( JPanel.LEFT_ALIGNMENT );		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.setPreferredSize(panelDimention);
		jp.setBackground(new Color(255, 255, 255));
		jp.setBorder(BorderFactory.createLineBorder(Color.black));

		jp.add(questionLabel);
		jp.add(optionA);
		jp.add(optionB);
		jp.add(optionC);
		jp.add(optionD);
		
		JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jp1.setAlignmentX( JPanel.LEFT_ALIGNMENT );
		jp1.setBackground(new Color(255, 255, 255));
		jp1.add(submitButton);
		jp1.add(giveupButton);
		jp1.add(nextButton);


		this.add(jp);
		this.add(jp1);

		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isCorrectAnsGiven = false;
				if (optionA.isSelected()) {
					if (optionA.getText().equals(correctAnswer)) {
						isCorrectAnsGiven = true;
					}

				} else if (optionB.isSelected()) {
					if (optionB.getText().equals(correctAnswer)) {
						isCorrectAnsGiven = true;
					}
				} else if (optionC.isSelected()) {
					if (optionC.getText().equals(correctAnswer)) {
						isCorrectAnsGiven = true;
					}
				} else if (optionD.isSelected()) {
					if (optionD.getText().equals(correctAnswer)) {
						isCorrectAnsGiven = true;
					}
				}

				if (isCorrectAnsGiven) {
					questions.remove(counter);
					questionCount = counter;
				} else {
					questionCount = counter + 1;
				}
				if (questionCount >= questions.size()) {
					questionCount = 0;
				} else if (questions.size() == 0){
					StudentMainFrame.closeWindow();
				}
				StudentMainFrame.setQuestionDisplayPanel(questionCount);
			}
		});
		
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isCorrectAnsGiven = false;
				if (optionA.isSelected()) {
					if (optionA.getText().equals(correctAnswer)) {
						isCorrectAnsGiven = true;
					}

				} else if (optionB.isSelected()) {
					if (optionB.getText().equals(correctAnswer)) {
						isCorrectAnsGiven = true;
					}
				} else if (optionC.isSelected()) {
					if (optionC.getText().equals(correctAnswer)) {
						isCorrectAnsGiven = true;
					}
				} else if (optionD.isSelected()) {
					if (optionD.getText().equals(correctAnswer)) {
						isCorrectAnsGiven = true;
					}
				}

				if (isCorrectAnsGiven) {
					questions.remove(counter);
					questionCount = counter;
				} else {
					questionCount = counter + 1;
				}
				if (questionCount >= questions.size()) {
					questionCount = 0;
				} else if (questions.size() == 0){
					StudentMainFrame.closeWindow();
				}
				StudentMainFrame.setQuestionDisplayPanel(questionCount);
			}
		});

	}

	static void setQuestion(String filePath) {
		questions = QuestionsDisplay.getAllQuestions(filePath);
	}
}