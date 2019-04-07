package controller;

import model.CurrentQuizModel;
import view.panels.QuestionPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionsController implements ControllerInterface {
    private static QuestionsController questionsController = null;
    private String quizName;
    private List<QuestionPanel> questionPanelList;
    private Map<String,ArrayList<String>> questionAnswers;
    private Map<String,String> questionCorrectAnswers;

    private QuestionsController(){
        quizName = new String();
        questionPanelList = new ArrayList<>();
        questionAnswers = new HashMap<>();
        questionCorrectAnswers = new HashMap<>();
        questionsController = this;
    }

    public static QuestionsController getQuestionsController(){
        if(questionsController == null)
            return new QuestionsController();
        else
            return questionsController;
    }

    public void setQuizName(String quizName){
        this.quizName = quizName;
    }

    public void setQuestionPanelList(List<QuestionPanel> questionPanelList){
        this.questionPanelList = questionPanelList;
    }

    public void updateModel(){
        final CurrentQuizModel currentQuizModel = CurrentQuizModel.getCurrentQuizModel();
        if(this.quizName != null)
            currentQuizModel.setFileName(quizName);

        refineData();


        currentQuizModel.setModel(questionAnswers,questionCorrectAnswers);





    }

    private void refineData() {
        for(QuestionPanel questionPanel : questionPanelList){
            if(!questionAnswers.containsKey(questionPanel.getQuestionText())){
                ArrayList<String> answers = new ArrayList<>();
                answers.add(questionPanel.getOption1Text());
                answers.add(questionPanel.getOption2Text());
                answers.add(questionPanel.getOption3Text());
                answers.add(questionPanel.getOption4Text());
                questionAnswers.put(questionPanel.getQuestionText(),answers);
            }

            if(!questionCorrectAnswers.containsKey(questionPanel.getQuestionText())){
                questionCorrectAnswers.put(questionPanel.getQuestionText(),questionPanel.getCorrectAnswerChoice());
            }

        }
    }

}
