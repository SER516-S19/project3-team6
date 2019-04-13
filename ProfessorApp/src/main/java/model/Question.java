package model;

/**
 * Class for Question which is used to model json read
 * 
 * @author gmatti1
 * 
 * */

public class Question {
	private String title;
	private String correctAnswer;
	private String[] options = new String[4];

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
