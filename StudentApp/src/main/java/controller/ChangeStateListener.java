package controller;

import constants.Constants;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.StudentMainFrame;

/**
 * Controller class to handle button events
 * @author Narendra, bijayalaxmipanda
 *
 */

public class ChangeStateListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object actionSource =  e.getSource();
		if(actionSource instanceof JButton){
			JButton buttonPressed = (JButton) e.getSource();
			if(buttonPressed.getText().equalsIgnoreCase(Constants.TAKE_QUIZ)){
				StudentMainFrame.setQuestionDisplayPanel(Constants.START_APP);

			} else if (buttonPressed.getText().equalsIgnoreCase(Constants.GIVEUP_BUTTON)) {
				StudentMainFrame.closeWindow();
			}

		}

	}
}
