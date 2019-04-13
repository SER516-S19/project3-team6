package services;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

import constants.Constants;

import java.util.ArrayList;

/**
 * Factory class to read the directory location of the json
 * files from the properties file
 * 
 * @author amanjotsingh
 * date - March 31, 2019
 * version - 0.1
 * 
 **/

public class ReadJsonServiceFactory {
	
	private static String _directoryPath;
	
	private ReadJsonServiceFactory() {}
	
	// method to return the list of .json files in the particular directory
	public static List<String> getAllJsonFiles() throws IOException {
		
		File file = new File(_directoryPath);
		
		// creating a filename filer of .json to filter out all JSON files in the directory
		String[] allJsonFiles = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.toLowerCase().endsWith(".json")){
                    return true;
                } else {
                    return false;
                }
			}
		});
		List<String> filesFullPath = new ArrayList<String>();
		for(String jsonFile : allJsonFiles) {
			filesFullPath.add(_directoryPath + jsonFile);
		}
		return filesFullPath;
	}
	
	// static block to read the directory path of the JSON files placed
	static {
		try {
			_directoryPath = System.getProperty("user.dir");
			_directoryPath = _directoryPath + "/Quizzes/";
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
		}
	}
	public static String getDirPath() {
		return _directoryPath;
	}
}