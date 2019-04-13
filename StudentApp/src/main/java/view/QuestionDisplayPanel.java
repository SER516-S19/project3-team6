package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
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

	// returns a panel with Questions added to it based on the quiz selected.
	public void display(final int counter)
	{
		this.setBackground(new Color(255, 255, 255));
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
        JButton nextButton=new JButton(Constants.NEXT_BUTTON);
		styleButton(nextButton);
		JButton giveupButton=new JButton(Constants.GIVEUP_BUTTON);
		styleButton(giveupButton);
		JButton submitButton = new JButton(Constants.SUBMIT_BUTTON);
		styleButton(submitButton);
		
		if (questions.size() == 0) {
			StudentMainFrame.closeWindow();
		}
		questionLabel = new JLabel (questions.get(counter).getTitle()); 
		String[] options = new String[4];
		options = questions.get(counter).getOptions();
		optionA = new JRadioButton(options[0]);
		optionB = new JRadioButton(options[1]);
		optionC = new JRadioButton(options[2]);
		optionD = new JRadioButton(options[3]);
		
		ButtonGroup ansbuttonGroup = new ButtonGroup(); // for grouping buttons together
		ansbuttonGroup.add(optionA);
		ansbuttonGroup.add(optionB);
		ansbuttonGroup.add(optionC);
		ansbuttonGroup.add(optionD);
		correctAnswer = questions.get(counter).getCorrectAnswer();
		
		giveupButton.addActionListener(new ChangeStateListener());
		Dimension panelDimention = new Dimension(600, 300);
		JPanel questionPanel = new JPanel();
		questionPanel.setAlignmentX( JPanel.LEFT_ALIGNMENT);		
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
		questionPanel.setPreferredSize(panelDimention);
		questionPanel.setBackground(new Color(255, 255, 255));
		
		Color borderColor = new Color(192, 192, 192);
        Border border = new SoftBevelBorder(BevelBorder.LOWERED, borderColor, borderColor, borderColor, borderColor);
		questionPanel.setBorder(border);

		questionPanel.add(questionLabel);
		questionPanel.add(optionA);
		questionPanel.add(optionB);
		questionPanel.add(optionC);
		questionPanel.add(optionD);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		buttonPanel.setAlignmentX( JPanel.LEFT_ALIGNMENT );
		buttonPanel.setBackground(new Color(255, 255, 255));
		buttonPanel.add(submitButton);
		buttonPanel.add(giveupButton);
		buttonPanel.add(nextButton);

		this.add(questionPanel);
		this.add(buttonPanel);

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
	
	// setting the questions for the quiz selected
	static void setQuestion(String filePath) {
		questions = QuestionsDisplay.getAllQuestions(filePath);
	}
	
	// method for common styling of the buttons
	public static void styleButton(JButton button) {
		button.setFont(new Font("Monospaced", Font.PLAIN, 20));
		button.setPreferredSize(new Dimension(145, 40));
		button.setFocusPainted(false);
	}
}