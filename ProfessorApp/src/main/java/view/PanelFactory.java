package view;

import constant.Constants;
import view.panels.MenuPanel;
import view.panels.QuizCreationPanel;

import javax.swing.*;

public class PanelFactory {
    public static int state = 1;
    /**
     * default serial version id
     */
    //private static final long serialVersionUID = 1L;

    /**
     * Default constructor to perform tasks on initialization
     * @param
     */
    public PanelFactory() {

    }


    /**
     * Factory method which takes name of the panel as argument and returns the panel after creating it
     * @param componentName
     * @return the panel after creating it
     */
    public static JComponent createPanel(final String componentName) {
        if(componentName.equalsIgnoreCase(Constants.MENU_PANEL)) {
            return new MenuPanel();

        }else if(componentName.equalsIgnoreCase(Constants.QUIZ_PANEL))
            return new JScrollPane(QuizCreationPanel.getQuizCreationPanel());

        return new JPanel();//Added only till other components are missing!

    }


}
