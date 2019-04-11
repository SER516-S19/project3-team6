package controller;

import services.ReadJsonServiceImpl;
import java.util.List;

/**
 * Controller class to provide list of JSON files present in a directory
 * @author bijayalaxmipanda
 *
 */

public class QuizSelection {
	private static ReadJsonServiceImpl readJsonService;
	private static String[] listOfQuizzes;

	public static String[] getQuizList() {
		try {
			readJsonService = new ReadJsonServiceImpl();
			List<String> quizListNames = readJsonService.getJsonFileNames();
			listOfQuizzes = new String[quizListNames.size()];
			for (int i = 0; i < quizListNames.size(); i++) {
				String quizFileName = quizListNames.get(i);
				System.out.println("only Name:: " + quizFileName.substring(quizFileName.lastIndexOf('/')+1));;
				listOfQuizzes[i] = quizFileName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return listOfQuizzes;
	}
}
