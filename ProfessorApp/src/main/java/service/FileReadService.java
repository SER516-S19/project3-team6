package service;

import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONObject;

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

	public static JSONObject readFile(String file) {
		String jsonString =  readJsonFile(file);
		JSONObject jsonObject = new JSONObject(jsonString.substring(jsonString.indexOf('{')));
		return jsonObject;
	}

	/*
	* Get the file content in the form of String
	* */
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
