package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Question;
import model.Quiz;

/**
 * Service Implementation to read all the json files and return the java objects
 * 
 * @author amanjotsingh
 * date - March 31, 2019
 * version - 0.1
 * 
 **/

public class ReadJsonServiceImpl {

	// returns the list of JSON files in the directory /Quizzes
	public List<String> getJsonFileNames() throws IOException, JSONException {
		List<String> allJsonFiles = ReadJsonServiceFactory.getAllJsonFiles();
		return allJsonFiles;
	}
	
	/* reads the JSON file as a string and converts it into Model objects and 
	 * returns the list of Quiz objects 
	 * */
	public static List<Quiz> getJsonData(String jsonFileName) throws IOException, JSONException {
		String jsonFilePath = ReadJsonServiceFactory.getDirPath() + jsonFileName;
		List<Quiz> quizList = new ArrayList<Quiz>();
		String jsonString =  readJsonFile(jsonFilePath);
		//uses external library to convert string to JSON object
		JSONObject jsonObject = new JSONObject(jsonString.substring(jsonString.indexOf('{')));
		JSONArray jsonArray = (JSONArray) jsonObject.get("questions");
		String key = null;
		List<Question> questions = new ArrayList<>();
		for(int i=0; i< jsonArray.length(); i++) {
			JSONObject ob = jsonArray.getJSONObject(i);
			key = ob.toString();
			ObjectMapper om = new ObjectMapper();
			Question q = om.readValue(key, Question.class);
			questions.add(q);
		}
		Quiz quiz = new Quiz(questions);
		quizList.add(quiz);
		return quizList;
	}

	// method to read a file and return it's content in a String
	private static String readJsonFile(String filename) {  
		String jsonString = "";
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String readLine = br.readLine();
			while(readLine != null) {
				sb.append(readLine);
				readLine = br.readLine();
			}
			jsonString = sb.toString();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return jsonString;
	}
	
}
