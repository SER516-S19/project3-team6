package services;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Properties;
import java.util.List;
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
		
		// creating a file name filer of .json to filter out all json files
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
	
	// static block to read the properties file to get the directory path where
	// all the .json files are placed
	static {
		try {
			File quizFileDir = new File("src/../../quizzes/");
			_directoryPath = quizFileDir.getCanonicalPath() + '/';
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
		}
	}
}