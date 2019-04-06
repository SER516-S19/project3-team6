package view;

import constant.Constants;

import javax.swing.*;
import java.awt.*;


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
    private static int headPanelHeight = 125;
    private static int headPanelWidth = 125;




    /**
     * Initializes all the component of the text editor and sets up the layout
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

        this.setSize(1000,1000);
        this.add(containerPanel);
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


}
