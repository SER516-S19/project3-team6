package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Question;
import model.Quiz;

/**
 * Class to perform read operation on JSON file and model it to Quiz class
 *
 * @author Gangadhara Matti
 *
 * */

public class FileReadService {

	public FileReadService() {
	}

	/**
	* Reads json file and models it to quiz object and returns the quiz object
	* */
	public static Quiz readFileQuiz(File file) {
		Quiz quiz = null;
		try {
			JSONObject jsonObject = readFile(file);
			JSONArray jsonArray = (JSONArray) jsonObject.get("questions");
			String key;
			List<Question> questions = new ArrayList<>();
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject ob = jsonArray.getJSONObject(i);
				key = ob.toString();
				ObjectMapper om = new ObjectMapper();
				Question q = om.readValue(key, Question.class);
				questions.add(q);
			}
			quiz = new Quiz(questions);
			String fileName = file.getName();
			quiz.setQuizName(fileName.substring(0, fileName.indexOf(".")));
		}catch (IOException e){
			e.printStackTrace();
		}
		return quiz;
	}

	/**
	 * Reads json file and models it to a JSONObject object and returns that jsonObject object
	 */
	private static JSONObject readFile(File file) {
		String jsonString =  readJsonFile(file);
		JSONObject jsonObject = new JSONObject(jsonString.substring(jsonString.indexOf('{')));
		return jsonObject;
	}

	/**
	 * Reads json file and returns it as a String
	 */
	private static String readJsonFile(File file) {
		String jsonString = "";
		try {
			FileReader fileReader = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String readLine = br.readLine();
			while(readLine != null) {
				sb.append(readLine);
				readLine = br.readLine();
			}
			jsonString = sb.toString();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		return jsonString;
	}
}
