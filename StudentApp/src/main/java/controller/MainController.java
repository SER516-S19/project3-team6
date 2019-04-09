package controller;

import services.ReadJsonServiceImpl;
import model.Question;
import model.Quiz;
import view.StudentDashboard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

/**
 * Controller class to launch student Dash board
 *
 * @author Bijaylaxmi Panda
 * @version 1.0
 */
public class MainController {
	private StudentDashboard studentDashboard;
	private ReadJsonServiceImpl impl;

	/**
	 * Invokes student dashboard
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws JSONException
	 */

	public void launchStudentDashboard() {
		try {
			impl = new ReadJsonServiceImpl();
			List<String> quizListNames = impl.getJsonFileNames();
			for (int i = 0; i < quizListNames.size(); i++) {
				System.out.println("Name: " + quizListNames.get(i));
			}
			studentDashboard = new StudentDashboard(this);
			studentDashboard.setQuizList(quizListNames);
			studentDashboard.createStudentDashBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * Once Quiz is selected by student, it will launch question board
	 * with the questions given in selected quiz
	 * 
	 * @param selectedQuiz
	 */
	public void mainReturn(String selectedQuiz) {
		System.out.println("Updated one :: " + selectedQuiz);
		studentDashboard.closeStudentDashboard(); 

		try {
			List<Quiz> questionData = impl.getJsonData(selectedQuiz);
			System.out.println(questionData.size());
			for (int i = 0; i < questionData.size(); i++) {
				List<Question> q1 = questionData.get(i).getQuestions();
				for (int j = 0; j < q1.size(); j++) {
					System.out.println("Question Title: " + q1.get(j).getTitle());
					System.out.println("Correct answer: " + q1.get(j).getCorrectAnswer());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
