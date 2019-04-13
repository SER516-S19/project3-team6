package model;

/**
 * Class for Question object
 * 
 * @author gmatti1
 * date - April 11, 2019
 * version = 0.1 
 * 
 * */

public class Question {
	private String title;
	private String correctAnswer;
	private String[] options = new String[4];
	
	// getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
}
