package view;

import constants.Constants;
import controller.ChangeStateListener;
import controller.QuizSelection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * To launch student Dash board
 *
 * @author Manisha, Bijaylaxmi Panda
 * @version 1.0
 */

@SuppressWarnings("serial")
public class QuizSelectionPanel extends JPanel {
	//private JPanel panel;
	private JComboBox comboBox;
	private String[] listOfQuizzes = {"Quiz1", "Quiz2"};

	@SuppressWarnings("rawtypes")
	public QuizSelectionPanel(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		//setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(gridBagLayout);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;


		Font titleFont = new Font("Monospaced", Font.BOLD, 40);
		Font buttonFont = new Font("Monospaced", Font.PLAIN, 20);
		Dimension buttonDimension = new Dimension(300, 70);

		JButton takeQuizButton = new JButton(Constants.TAKE_QUIZ);
		//takeQuizButton.setBackground(buttonBackGround);
		takeQuizButton.setFont(buttonFont);
		//takeQuizButton.setForeground(buttonForeGround);
		takeQuizButton.setPreferredSize(buttonDimension);
		takeQuizButton.setText(Constants.TAKE_QUIZ);
		takeQuizButton.addActionListener(new ChangeStateListener());
		takeQuizButton.setFocusPainted(false);
		//buttons.add(createQuizButton, gbc1);





		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		JLabel pageName = new JLabel("Welcome to Student Portal", SwingConstants.CENTER);
		JLabel selectQuizName = new JLabel("Select Quiz");
		pageName.setFont(titleFont);
		this.setLayout(gridBagLayout);
		gbc.gridy = 0;
		this.add(pageName, gbc);
		gbc.gridy++;
		this.add(selectQuizName, gbc);
		String[] listOfQuizzes = QuizSelection.getQuizList();
		comboBox= new JComboBox<String>(listOfQuizzes);
		comboBox.setSize(40, 10);
		gbc.gridy++;
		this.add(comboBox, gbc);
		gbc.gridy++;
		this.add(takeQuizButton, gbc);

	}

}