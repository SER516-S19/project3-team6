public class QuizQuestion
{
    public String question;
    public String optionA;
    public String optionB;
    public String optionC;
    public String optionD;

    public QuizQuestion(){}

    /*
    * Custom Constructor
    * */
    public QuizQuestion (String question,String optionA, String optionB,String optionC,String optionD)
    {
        this.question = question;
        this.optionA= optionA;
        this.optionB= optionB;
        this.optionC= optionC;
        this.optionD= optionD;
    }//QuizQuestion
}//QuizQuestion
