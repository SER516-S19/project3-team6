
/**
 * Question Model with Question Title, answerChoices 
 * and correctChoice
 * @author bijayalaxmipanda
 *
 */
public class Question {
	private String questionTitle = "";
	private String[] optionChoices = new String[4];
	private String correctChoice = "";
	
	/**
	 * 
	 * @param questionTitle
	 * @param optionChoices
	 * @param correctChoice
	 */
	public Question(String questionTitle, String[] optionChoices, String correctChoice) {
		this.questionTitle = questionTitle;
		this.optionChoices = optionChoices;
		this.correctChoice = correctChoice;
	}
	
	/**
	 * 
	 * @param questionTitle
	 */
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public void setQuestionTitle(String[] optionChoices) {
		this.optionChoices = optionChoices;
	}
	public void setCorrectAnswer(String correctChoice) {
		this.correctChoice = correctChoice;
	}
	
	public String getQuestionTitle(String questionTitle) {
		return questionTitle;
	}
	public String[] getQuestionTitle(String[] optionChoices) {
		return optionChoices;
	}
	public String getCorrectAnswer(String correctChoice) {
		return correctChoice;
	}

}