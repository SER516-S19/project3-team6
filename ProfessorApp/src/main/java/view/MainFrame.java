package view;

import constant.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


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

    /**+
     * Shows Dialog Box on quiz storage completion
     * @param message
     */
    public static void showMessage(String message){
        JOptionPane.showMessageDialog(mainFrame, message);

    }

}
