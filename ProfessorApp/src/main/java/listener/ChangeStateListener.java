package listener;

import constant.Constants;
import controller.QuestionsController;
import org.json.simple.JSONObject;
import view.panels.QuizCreationPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.MainFrame.*;
import static view.panels.QuizCreationPanel.addQuestionPanel;



/**+
 * Main Listener class that relays information from View to Controller and vice-versa
 * @author Abhinab Mohanty GIT ID: 53
 */
public class ChangeStateListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object actionSource =  e.getSource();
        String message = e.getActionCommand();

        if(actionSource instanceof JButton){
            JButton buttonPressed = (JButton) e.getSource();
            if(buttonPressed.getText().equalsIgnoreCase(Constants.CREATE_QUIZ)){
                setQuizPanel();
            }else if(buttonPressed.getText().equalsIgnoreCase(Constants.ADD_QUESTION)){
                addQuestionPanel();
            }else if(buttonPressed.getText().equalsIgnoreCase(Constants.BACK)){
                handleBackAction();
            }else if(buttonPressed.getText().equalsIgnoreCase(Constants.SUBMIT)){
                QuestionsController questionsController = QuestionsController.getQuestionsController();
                QuizCreationPanel quizCreationPanel = QuizCreationPanel.getQuizCreationPanel();

                //Check if Required fields are Empty
                if(quizCreationPanel.getQuizName().isEmpty())
                    showError(Constants.EMPTY_ERROR);

                else{
                    questionsController.setQuizName(quizCreationPanel.getQuizName());
                    questionsController.setQuestionPanelList(quizCreationPanel.getQuestions());

                    questionsController.updateModel();
                }


            }

        }else if(actionSource instanceof JSONObject){
            showMessage(message);
        }



    }


}
