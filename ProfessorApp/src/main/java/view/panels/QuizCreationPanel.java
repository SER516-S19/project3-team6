package view.panels;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import constant.Constants;
import listener.ChangeStateListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.util.ArrayList;
import java.util.List;

public class QuizCreationPanel extends JPanel{
    private static List<QuestionPanel> questions;
    private static JTextField quizNameText;
    private static JButton btnAddQuestion,btnSubmit;
    private static QuizCreationPanel quizCreationPanel = null;
    private static JScrollPane containerPane;
    private static JPanel listDisplayPanel;
    private static ColumnSpec[] columnSpecs = new ColumnSpec[] {
            FormSpecs.RELATED_GAP_COLSPEC,
            FormSpecs.DEFAULT_COLSPEC,
            FormSpecs.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("default:grow"),};
    private static RowSpec[] rowSpecs =  new RowSpec[] {
            FormSpecs.RELATED_GAP_ROWSPEC,
            FormSpecs.DEFAULT_ROWSPEC,
            FormSpecs.RELATED_GAP_ROWSPEC,
            FormSpecs.DEFAULT_ROWSPEC,
            FormSpecs.RELATED_GAP_ROWSPEC,
            FormSpecs.DEFAULT_ROWSPEC,
            FormSpecs.RELATED_GAP_ROWSPEC,
            FormSpecs.DEFAULT_ROWSPEC,
            FormSpecs.RELATED_GAP_ROWSPEC,
            FormSpecs.DEFAULT_ROWSPEC,
            FormSpecs.RELATED_GAP_ROWSPEC,
            FormSpecs.DEFAULT_ROWSPEC,
            FormSpecs.RELATED_GAP_ROWSPEC,
            FormSpecs.DEFAULT_ROWSPEC,};

    private QuizCreationPanel() {
        questions = new ArrayList<>();
        setLayout(new FormLayout(columnSpecs, rowSpecs));

        JLabel quizName = new JLabel("Quiz Name :");
        add(quizName, "2, 2");

        quizNameText = new JTextField();
        quizNameText.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        add(quizNameText, "4, 2, left, default");
        quizNameText.setColumns(10);


        btnAddQuestion = getBtnAddQuestion();
        add(btnAddQuestion, "2, 4, left, default");

        btnSubmit = getBtnSubmit();
        add(btnSubmit, "4, 4, right, default");

        listDisplayPanel = new JPanel();
        listDisplayPanel.setLayout(new BoxLayout(listDisplayPanel,BoxLayout.Y_AXIS));
        addFooterForm();
        containerPane = new JScrollPane(listDisplayPanel);
        containerPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(containerPane, "4, 6, default, center");
        quizCreationPanel = this;
    }


    private  static void addFooterForm(){
        QuestionPanel questionPanel = new QuestionPanel();
        listDisplayPanel.add(questionPanel);
        //Add in Class DataStructure
        questions.add(questionPanel);
        listDisplayPanel.revalidate();

    }

    public static QuizCreationPanel getQuizCreationPanel() {
        if(quizCreationPanel == null)
            return new QuizCreationPanel();
        else
            return quizCreationPanel;
    }

    private static JButton getBtnAddQuestion(){
        JButton addQuestionButton = new JButton(Constants.ADD_QUESTION);
        addQuestionButton.setFocusPainted(false);
        addQuestionButton.addActionListener(new ChangeStateListener());
        return addQuestionButton;
    }

    private static JButton getBtnSubmit(){
        JButton submitButton = new JButton(Constants.SUBMIT);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new ChangeStateListener());
        return submitButton;
    }

    public static void addQuestionPanel(){
        addFooterForm();
        quizCreationPanel.validate();
    }

    public List<QuestionPanel> getQuestions(){
        return questions;
    }

    public String getQuizName(){
        return quizNameText.getText();
    }
}
