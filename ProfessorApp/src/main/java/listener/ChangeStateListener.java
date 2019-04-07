package listener;

import constant.Constants;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainFrame.setQuizPanel;
import static view.panels.QuizCreationPanel.addQuestionPanel;


public class ChangeStateListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionSource =  e.getSource();

        if(actionSource instanceof JButton){
            JButton buttonPressed = (JButton) e.getSource();
            if(buttonPressed.getText().equalsIgnoreCase(Constants.CREATE_QUIZ)){
                setQuizPanel();
            }else if(buttonPressed.getText().equalsIgnoreCase(Constants.ADD_QUESTION)){
                addQuestionPanel();
            }
        }



    }


}