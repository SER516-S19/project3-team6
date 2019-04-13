package view;

import constants.Constants;

import javax.swing.*;

/**
 * Factory class two create different panels
 * @author bijayalaxmipanda
 *
 */

public class PanelFactory {
	/**
	 * Factory method which takes name of the panel as argument and returns the panel after creating it
	 * @param componentName
	 * @return the panel after creating it
	 */
	public static JComponent createPanel(final String componentName) {
		if(componentName.equalsIgnoreCase(Constants.DASHBOARD_PANEL)) {
			return new QuizSelectionPanel();
		}
		else if(componentName.equalsIgnoreCase(Constants.QUESTION_DISPLAY_PANEL)) {
			return  new QuestionDisplayPanel();
		}
		return new JPanel();//Added only till other components are missing!
	}
}