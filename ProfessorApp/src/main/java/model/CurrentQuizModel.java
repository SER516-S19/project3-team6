package model;

import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import service.FileSaveService;


public class CurrentQuizModel implements ModelInterface{
    private static CurrentQuizModel currentQuizModel= null;
    private String fileName;
    private JSONObject quiz;
    private JSONArray questions;
    private JSONObject question;
    private JSONArray options;

    private CurrentQuizModel() {
        fileName = new String();
        quiz = new JSONObject();
        questions = new JSONArray();
        question = new JSONObject();
        options = new JSONArray();
        currentQuizModel = this;
    }

    public static CurrentQuizModel getCurrentQuizModel() {
        if(currentQuizModel == null)
            return new CurrentQuizModel();
        else
            return currentQuizModel;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void setModel(Map<String, ArrayList<String>> questionAnswers, Map<String, String> questionCorrectAnswers) {
        for(Map.Entry<String,ArrayList<String>> entry : questionAnswers.entrySet()){
            String questionEntry = entry.getKey();
            ArrayList<String> option = entry.getValue();
            question.put("title",questionEntry);
            for(String answer : option)
                options.add(answer);
            question.put("options",options);
            question.put("correctAnswer",questionCorrectAnswers.get(questionEntry));

            questions.add(question);
        }

        quiz.put("questions",questions);

        sendToSaveService(quiz);
    }

    private void sendToSaveService(JSONObject quizObject) {
        new FileSaveService(quizObject,fileName);
    }
}
