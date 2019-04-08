package view;

import constant.Constants;
import view.panels.MenuPanel;
import view.panels.QuizCreationPanel;

import javax.swing.*;


/**
 * Initializing the Main JFrame Window class for the application.
 * @author Abhinab Mohanty GIT ID: 53
 *
 */
public class PanelFactory {
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
