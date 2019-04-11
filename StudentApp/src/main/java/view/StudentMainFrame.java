package view;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.Constants;

/**
 * Student Main Frame to launch student App
 * @author bijayalaxmipanda
 *
 */
public class StudentMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private static JFrame studentMainFrame = null;
	private static JComponent dashboardPanel;
	private static JComponent questionPanel;
	private static JComponent currentPanel = null;
	private static JPanel containerPanel;
	private static int frameHeight = 1000;
	private static int frameWidth = 1000;


	/**+
	 * Singleton Instance to ensure single running instance of Student App
	 */
	private StudentMainFrame() {
		setTitle(Constants.APP_TITLE);


		dashboardPanel = PanelFactory.createPanel(Constants.DASHBOARD_PANEL);

		//Contains all panels for dynamic switching
		containerPanel = new JPanel(new CardLayout());
		containerPanel.add(dashboardPanel,Constants.DASHBOARD_PANEL);

		//Keeps track of the currentPanel being displayed
		currentPanel = dashboardPanel;
		this.setLocationRelativeTo(null);
		this.setSize(frameWidth,frameHeight);
		this.add(containerPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	/**+
	 * Singleton Class get method
	 * @return singleton instance of JFrame
	 */
	public static JFrame getInstance(){
		if(studentMainFrame == null)
			return new StudentMainFrame();
		else
			return studentMainFrame;
	}

	public static JComponent getCurrentPanel(){
		return currentPanel;
	}
	public static void setCurrentPanel(JPanel panel){
		currentPanel = panel;
	}

	public static void setQuestionDisplayPanel(int counter){
		questionPanel = PanelFactory.createPanel(Constants.QUESTION_DISPLAY_PANEL);
		containerPanel.add(questionPanel,Constants.QUESTION_DISPLAY_PANEL);

		CardLayout cardLayout = (CardLayout) containerPanel.getLayout();
		cardLayout.show(containerPanel,Constants.QUESTION_DISPLAY_PANEL);
		setCurrentPanel(containerPanel);

		if (counter == -1) {
			getQuestionsToDisplay();
			counter = 0;
		}
		((QuestionDisplayPanel) questionPanel).display(counter);
	}  
	
	public static void getQuestionsToDisplay() {
		Component[] arr = dashboardPanel.getComponents();
		String str = null;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] instanceof JComboBox) {
				str = ((JComboBox)arr[i]).getSelectedItem().toString();

			}
		}
		QuestionDisplayPanel.setQuestion(str);

	}
	
	public static void closeWindow() {
		System.exit(0);
	}
}