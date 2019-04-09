import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        giveupButton.addActionListener( new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });



            String question = dao.getQuestion(1);

            System.out.println(question);
            questionLabel = new JLabel (question);
            optionA = new JRadioButton(dao.getOptionA(1));
            optionB = new JRadioButton(dao.getOptionB(1));
            optionC = new JRadioButton(dao.getOptionC(1));
            optionD = new JRadioButton(dao.getOptionD(1));

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




        nextButton.addActionListener( new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
              quizPanel.removeAll();
              quizPanel.revalidate();
              quizPanel.repaint();

               // JButton giveupButton=new JButton("Give Up");
                //giveupButton.setBounds(200,350,95,30);
                //add(giveupButton);

                int questionnumber = 2;
                String question = dao.getQuestion(questionnumber);

                System.out.println(question);
                questionLabel = new JLabel (question);
                optionA = new JRadioButton(dao.getOptionA(questionnumber));
                optionB = new JRadioButton(dao.getOptionB(questionnumber));
                optionC = new JRadioButton(dao.getOptionC(questionnumber));
                optionD = new JRadioButton(dao.getOptionD(questionnumber));

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





            }
        });
        add(quizPanel);
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//QuizFrame
}//QuizFrame
