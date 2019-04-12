package view;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constant.Constants;


/**
 * Initializing the Main JFrame Window class for the application.
 * @author Abhinab Mohanty GIT ID: 53
 *
 */


public class MainFrame extends JFrame {
    /**
     * Default Serial version id
     */
    private static final long serialVersionUID = 1L;

    private static JFrame mainFrame = null;
    private static JComponent menuPanel;
    private static JComponent quizPanel;
    private static JComponent editQuizPanel;
    private static JComponent currentPanel = null;
    private static JPanel containerPanel;
    private static int frameHeight = 1000;
    private static int frameWidth = 1000;


    /**+
     * Singleton Instance to ensure single running instance of Professor App
     */
    private MainFrame() {
        setTitle(Constants.APP_TITLE);


        menuPanel = PanelFactory.createPanel(Constants.MENU_PANEL);
        quizPanel = PanelFactory.createPanel(Constants.QUIZ_PANEL);
        

        //Contains all panels for dynamic switching
        containerPanel = new JPanel(new CardLayout());
        containerPanel.add(menuPanel,Constants.MENU_PANEL);
        containerPanel.add(quizPanel,Constants.QUIZ_PANEL);
        
        //Keeps track of the currentPanel being displayed
        currentPanel = menuPanel;

        this.setSize(frameWidth,frameHeight);
        this.add(containerPanel);

        //Stop Application on Window Closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setVisible(true);

    }

    /**+
     * Singleton Class get method
     * @return singleton instance of JFrame
     */
    public static JFrame getInstance(){
        if(mainFrame == null)
            return new MainFrame();
        else
            return mainFrame;
    }


    public static JComponent getCurrentPanel(){
        return currentPanel;
    }
    public static void setCurrentPanel(JPanel panel){
        currentPanel = panel;
    }

    public static void setQuizPanel(){
        CardLayout cardLayout = (CardLayout) containerPanel.getLayout();
        cardLayout.show(containerPanel,Constants.QUIZ_PANEL);
        setCurrentPanel(containerPanel);
    }
    
	public static void setEditQuizPanel() {
		final JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(containerPanel);
		try {
			File file = fc.getSelectedFile();
			if (file != null) {
				editQuizPanel = PanelFactory.createPanel(Constants.EDIT_QUIZ_PANEL, file);
				containerPanel.add(editQuizPanel, Constants.EDIT_QUIZ_PANEL);
				CardLayout cardLayout = (CardLayout) containerPanel.getLayout();
				cardLayout.show(containerPanel, Constants.EDIT_QUIZ_PANEL);
				setCurrentPanel(containerPanel);
			} else {
				CardLayout cardLayout = (CardLayout) containerPanel.getLayout();
				cardLayout.show(containerPanel, Constants.MENU_PANEL);
				setCurrentPanel(containerPanel);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

    public static JComponent getEditQuizPanel() {
		return editQuizPanel;
	}

	public static void setEditQuizPanel(JComponent editQuizPanel) {
		 CardLayout cardLayout = (CardLayout) containerPanel.getLayout();
	        cardLayout.show(containerPanel,Constants.EDIT_QUIZ_PANEL);
	        setCurrentPanel(containerPanel);
	}

	/**+
     * Shows Dialog Box on quiz storage completion and exit safely
     * @param message
     */
    public static void showMessage(String message){
        JOptionPane.showMessageDialog(mainFrame, message);
    }
    public static void showError(String message){
        JOptionPane.showMessageDialog(mainFrame, message);
    }

    public static void handleBackAction(){
        boolean confirmBack = showConfirmationPanel();

        if(confirmBack) {
            CardLayout cardLayout = (CardLayout) containerPanel.getLayout();
            cardLayout.show(containerPanel, Constants.MENU_PANEL);
            containerPanel.remove(quizPanel);
            quizPanel = QuizCreationPanel.getNewQuizCreationPanel();
            containerPanel.add(quizPanel, Constants.QUIZ_PANEL);
            setCurrentPanel(containerPanel);
        }
    }

    private static boolean showConfirmationPanel() {
        int dialogResult = JOptionPane.showConfirmDialog(mainFrame, Constants.WARNING_MESSAGE, Constants.WARNING_TITLE, JOptionPane.YES_NO_OPTION);
        if(dialogResult == 0) {
            return true;
        } else {
            return false;
        }
    }

}
