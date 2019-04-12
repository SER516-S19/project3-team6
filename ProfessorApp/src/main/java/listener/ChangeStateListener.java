package listener;

import static view.MainFrame.handleBackAction;
import static view.MainFrame.setEditQuizPanel;
import static view.MainFrame.setQuizPanel;
import static view.MainFrame.showError;
import static view.MainFrame.showMessage;
import static view.QuizCreationPanel.addQuestionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.json.simple.JSONObject;

import constant.Constants;
import controller.QuestionsController;
import view.EditQuizPanel;
import view.QuizCreationPanel;

/**
 * + Main Listener class that relays information from View to Controller and
 * vice-versa
 * 
 * @author Abhinab Mohanty GIT ID: 53
 */
public class ChangeStateListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		Object actionSource = e.getSource();
		String message = e.getActionCommand();

		if (actionSource instanceof JButton) {
			JButton buttonPressed = (JButton) e.getSource();
			if (buttonPressed.getText().equalsIgnoreCase(Constants.CREATE_QUIZ)) {
				setQuizPanel();
			} else if (buttonPressed.getText().equalsIgnoreCase(Constants.ADD_QUESTION_CREATEQUIZ)) {
				QuizCreationPanel.addQuestionPanel();
			} else if (buttonPressed.getText().equalsIgnoreCase(Constants.ADD_QUESTION_EDITQUIZ)) {
				EditQuizPanel.addQuestionPanel();
			} else if (buttonPressed.getText().equalsIgnoreCase(Constants.EDIT_QUIZ)) {
				setEditQuizPanel();
			} else if (buttonPressed.getText().equalsIgnoreCase(Constants.BACK)) {
				handleBackAction();
			} else if (buttonPressed.getText().equalsIgnoreCase(Constants.SUBMIT)) {
				QuestionsController questionsController = QuestionsController.getQuestionsController();
				QuizCreationPanel quizCreationPanel = QuizCreationPanel.getQuizCreationPanel();
				EditQuizPanel editQuizPanel = EditQuizPanel.getEditQuestionPanel();

				// Check if Required fields are Empty
				if ((editQuizPanel == null && quizCreationPanel.getQuizName().isEmpty())
						|| (editQuizPanel != null && editQuizPanel.getQuizName().isEmpty()))
					showError(Constants.EMPTY_ERROR);

				else {
					questionsController.setQuizName(quizCreationPanel.getQuizName());
					questionsController.setQuestionPanelList(quizCreationPanel.getQuestions());
					questionsController.updateModel();
				}

			}

		} else if (actionSource instanceof JSONObject) {
			showMessage(message);
		}

	}

}
