import services.ReadJsonServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.JSONException;


import model.Question;
import model.Quiz;

public class Main {
    /**
     * The main method to run the application
     * @param args
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws JSONException 
     * @throws ParseException 
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, JSONException {
        System.out.println("Main Here");
        ReadJsonServiceImpl impl = new ReadJsonServiceImpl();
        List<Quiz> data =  impl.getJsonData();
        for(int i = 0; i < data.size(); i++) {
        	List<Question> q1 = data.get(i).getQuestions();
        	for(int j = 0; j< q1.size(); j++) {
        		System.out.println(q1.get(j).getTitle());
        	}
        }
    }
}
