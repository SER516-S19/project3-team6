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
 * @author Manisha Miriyala, Bijaylaxmi Panda
 * @version 1.0
 */

@SuppressWarnings("serial")
public class QuizSelectionPanel extends JPanel {
	private JComboBox comboBox;
	public QuizSelectionPanel(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		setBackground(new Color(255, 255, 255));
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(gridBagLayout);

		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.fill = GridBagConstraints.NONE;
		gridConstraints.gridwidth = GridBagConstraints.REMAINDER;
		gridConstraints.anchor = GridBagConstraints.NORTH;

		JButton takeQuizButton = new JButton(Constants.TAKE_QUIZ);
		takeQuizButton.setFont(new Font("Monospaced", Font.PLAIN, 20));
		takeQuizButton.setPreferredSize(new Dimension(145, 40));
		takeQuizButton.setText(Constants.TAKE_QUIZ);
		takeQuizButton.addActionListener(new ChangeStateListener());
		takeQuizButton.setFocusPainted(false);

		gridConstraints.anchor = GridBagConstraints.CENTER;
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.insets = new Insets(40,20,20,20);

		JLabel pageName = new JLabel("Welcome Student!", SwingConstants.LEADING);
		pageName.setFont(new Font(pageName.getName(), Font.BOLD, 40));
		gridConstraints.fill = GridBagConstraints.VERTICAL;
		pageName.setVerticalAlignment(JLabel.NORTH);
		JLabel selectQuizName = new JLabel("Select Quiz");
		selectQuizName.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setLayout(gridBagLayout);
		this.add(pageName, gridConstraints);
		this.add(selectQuizName, gridConstraints);
		String[] quizList = QuizSelection.getQuizList();
		comboBox= new JComboBox<String>(quizList);
		comboBox.setSize(40, 10);
		this.add(comboBox, gridConstraints);
		this.add(takeQuizButton, gridConstraints);
	}
}