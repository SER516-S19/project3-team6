package model;

import java.util.List;

/**
 * Class for Quiz which contains a list of questions
 * 
 * @author amanjotsingh
 * date - April 1, 2019
 * version - 0.1
 * 
 **/

public class Quiz {
	
	private List<Question> questions;
	
	// constructors
	public Quiz(){}
	public Quiz(List<Question> ques){
		this.questions = ques;
	}
	
	// getter and setter
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
