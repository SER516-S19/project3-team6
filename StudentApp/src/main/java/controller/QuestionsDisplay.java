package controller;

import java.util.List;

import model.Question;
import model.Quiz;
import services.ReadJsonServiceImpl;

/**
 * Controller class for getting the Questions from
 * a json file
 * 
 * @author bijayalaxmipanda
 *
 */

public class QuestionsDisplay {
	public static List<Question> questions;
	
	/**
	 * Get all the questions from a JSON file
	 * @param filePath
	 * @return List<Question>
	 */
	
	public static List<Question> getAllQuestions(String filePath) {
		try{
			List<Quiz> questionData = ReadJsonServiceImpl.getJsonData(filePath);
			for (int i = 0; i < questionData.size(); i++) {
				questions = questionData.get(i).getQuestions();
			} 
		}catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}
}
