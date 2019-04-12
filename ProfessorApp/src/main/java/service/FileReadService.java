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
 * Class for reading json file in the form of JSONObject
 *
 * @author gmatti1
 * date - April 11, 2019
 * version = 0.1
 *
 * */

public class FileReadService {

	public FileReadService() {
	}

	public static JSONObject readFile(File file) {
		String jsonString =  readJsonFile(file);
		JSONObject jsonObject = new JSONObject(jsonString.substring(jsonString.indexOf('{')));
		return jsonObject;
	}

	/*
	* Get the file content in the form of String
	* */
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

	public static Quiz readFileQuiz(File file) {
		Quiz quiz = null;
		try {
			JSONObject jsonObject = readFile(file);
			JSONArray jsonArray = (JSONArray) jsonObject.get("questions");
			String key = null;
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
}
