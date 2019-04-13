package model;

import java.util.List;

/**
 * Class for Quiz which contains a list of questions
 * 
 * @author Gangadhara Matti
 * 
 **/

public class Quiz {
	private String quizName;
	private List<Question> questions;

	public Quiz(){}
	public Quiz(List<Question> ques){
		this.questions = ques;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
}
