import javax.swing.*;

public class Quiz
{
    public static void main (String [] args)
    {
        QuizFrame qframe = new QuizFrame();
    }//main
}//Quiz

class QuizFrame extends  JFrame
{
    JLabel questionLabel = null;
    JRadioButton optionA = null;
    JRadioButton optionB = null;
    JRadioButton optionC = null;
    JRadioButton optionD = null;
    public QuizFrame()
    {
        JPanel quizPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(quizPanel,BoxLayout.Y_AXIS);
        quizPanel.setLayout(boxLayout);
        //TODO : Navigation button
        QuizDAO dao = QuizDAO.getInstance();
        JButton nextButton=new JButton(">");
        JButton giveupButton=new JButton("Give Up");
        nextButton.setBounds(300,350,95,30);
        add(nextButton);
        giveupButton.setBounds(200,350,95,30);
        add(giveupButton);
        for (int index = 0 ; index < 3; index ++)
        {
            String question = dao.getQuestion(index+1);

            System.out.println(question);
            questionLabel = new JLabel (question);
            optionA = new JRadioButton(dao.getOptionA(index +1));
            optionB = new JRadioButton(dao.getOptionB(index +1));
            optionC = new JRadioButton(dao.getOptionC(index +1));
            optionD = new JRadioButton(dao.getOptionD(index +1));

            quizPanel.add(questionLabel);
            quizPanel.add(optionA);
            quizPanel.add(optionB);
            quizPanel.add(optionC);
            quizPanel.add(optionD);

            //TODO: Add Action Listener to each Radio Button.
            ButtonGroup ansbuttonGroup = new ButtonGroup();
            ansbuttonGroup.add(optionA);
            ansbuttonGroup.add(optionB);
            ansbuttonGroup.add(optionC);
            ansbuttonGroup.add(optionD);
        }//for
        add(quizPanel);
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//QuizFrame
}//QuizFrame
