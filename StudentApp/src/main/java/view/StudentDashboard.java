package view;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import controller.MainController;

import javax.swing.*;

/**
 * Controller class to launch student Dash board
 *
 * @author Manisha Miriyala, Bijaylaxmi Panda
 * @version 1.0
 */

public class StudentDashboard {
	private String[] listOfQuizzes;
	private JComboBox comboBox;
	private String getQuizName;
	
	private JFrame frame;
	private JPanel panel;
	
	private final String frameName = "Student Quiz Application";
	//private final String quizButton = "Take Quiz";
	
	MainController mainController;
	/**
	 * Parameterized constructor with all required object.
	 * 
	 * @param mainController
	 */
	public StudentDashboard(MainController mainController) {
		this.mainController = mainController;
	}
	
	/**
	 * creates Frame and panel for student dashboard
	 */
	@SuppressWarnings({ "unchecked", "rawtypes"})
	public void createStudentDashBoard() {
        frame = new JFrame(frameName);        
        frame.setLocationRelativeTo(null);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(20,20,20,20);
		 
		JButton takeQuizButton = new JButton("Take Quiz");
		JLabel pageName = new JLabel("Welcome to Student Portal", SwingConstants.LEADING);
		pageName.setFont(new Font(pageName.getName(), Font.BOLD, 35));
		gbc.fill = GridBagConstraints.VERTICAL;
		//pageName.setFont(new Font(pageName.getFont().getName(), pageName.getFont().getStyle(), 30));
		pageName.setVerticalAlignment(JLabel.NORTH);
		JLabel selectQuiz = new JLabel("Please select a Quiz");
		selectQuiz.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel = new JPanel();
		panel.setLayout(gridBagLayout);
		gbc.gridy = 0;
		panel.add(pageName, gbc);
		gbc.gridy++;
		panel.add(selectQuiz, gbc);
		comboBox= new JComboBox(getQuizList());
		comboBox.setSize(10, 10);
		gbc.gridy++;
		panel.add(comboBox, gbc);
		gbc.gridy++;
		panel.add(takeQuizButton, gbc);
		
		
		takeQuizButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				mainController.mainReturn(comboBox.getSelectedItem().toString());
			}
		});
		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.fill = GridBagConstraints.NONE;
		
		frame.add(panel, gbc2);
		
		frame.pack();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Shows all the available quizzes to the student to select
	 * @param quizListNames
	 */
	public void setQuizList(List<String> quizListNames) {
		listOfQuizzes = new String[quizListNames.size()];
		for (int i = 0; i < quizListNames.size(); i++) {
			String quizFileName = quizListNames.get(i);
			System.out.println("only Name:: " + quizFileName.substring(quizFileName.lastIndexOf('\\')+1));;
			listOfQuizzes[i] = quizFileName;
		}	
	}
	
	/**
     * @return String[] : return list of quizzes
     */
	private String[] getQuizList() {
		return this.listOfQuizzes;
	}
	
	/**
	 * Closes the student dash-board once student selects a quiz
	 */
	public void closeStudentDashboard() {
		frame.setVisible(false);
	}
	
}