package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import constants.Constants;
import controller.QuizSelection;

/**
 * To launch student Dash board
 *
 * @author Manisha Miriyala, Bijayalaxmi Panda
 * @version 1.0
 */

@SuppressWarnings("serial")
public class QuizSelectionPanel extends JPanel {
	
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	
	// returns the panel with list of available quizzes in a combo-box
	public QuizSelectionPanel(){
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(gridBagLayout);
		
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.fill = GridBagConstraints.NONE;
		gridConstraints.gridwidth = GridBagConstraints.REMAINDER;
		gridConstraints.anchor = GridBagConstraints.NORTH;
		gridConstraints.insets = new Insets(40,20,20,20);
		
		JButton takeQuizButton = new JButton(Constants.TAKE_QUIZ);
		QuestionDisplayPanel.styleButton(takeQuizButton);
		takeQuizButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentMainFrame.setQuestionDisplayPanel(Constants.START_APP);
            }
		});
		
		JLabel pageName = new JLabel("Welcome Student!", SwingConstants.LEADING);
		pageName.setFont(new Font(pageName.getName(), Font.BOLD, 40));
		pageName.setVerticalAlignment(JLabel.NORTH);
		
		JLabel selectQuizName = new JLabel("Select Quiz");
		selectQuizName.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		String[] quizList = QuizSelection.getQuizList();
		comboBox= new JComboBox<String>(quizList);
		comboBox.setSize(40, 10);
		
		this.setLayout(gridBagLayout);
		this.add(pageName, gridConstraints);
		this.add(selectQuizName, gridConstraints);
		this.add(comboBox, gridConstraints);
		this.add(takeQuizButton, gridConstraints);
	}
}