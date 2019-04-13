package view;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import constant.Constants;
import listener.ChangeStateListener;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


/**
 * Initializing the Quiz Creation Panel.
 * @author Abhinab Mohanty GIT ID: 53, Carnic GIT ID:57
 *
 */
public class QuizCreationPanel extends JPanel{

	private static final long serialVersionUID = -6414793394333032650L;
	private static List<QuestionPanel> questions;
    private static JTextField quizNameText;
    private static JButton btnAddQuestion,btnSubmit,btnBack;
    private static QuizCreationPanel quizCreationPanel = null;
    private static JScrollPane containerPane;
    private static JPanel listDisplayPanel;
    private static ColumnSpec[] columnSpecs = Constants.columnSpecs;
    private static RowSpec[] rowSpecs = Constants.rowSpecs;

    private QuizCreationPanel() {
    	setForeground(Color.black);
        questions = new ArrayList<>();
        setLayout(new FormLayout(columnSpecs, rowSpecs));

        Color foreGroundColor = new Color(47, 79, 79);
        Font boldFont = new Font("Monaco", Font.BOLD, 18);
        JLabel quizName = new JLabel(Constants.QUIZ_NAME);
        quizName.setForeground(foreGroundColor);
        quizName.setFont(boldFont);
        add(quizName, "2, 2");

        Color textColor = new Color(192, 192, 192);
        quizNameText = new JTextField();
        quizNameText.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, textColor, textColor, textColor, textColor));
        add(quizNameText, "4, 2");
        quizNameText.setColumns(10);

        btnBack = getBackButton();
        add(btnBack, "2, 4, default, fill");

        btnAddQuestion = getBtnAddQuestion();
        add(btnAddQuestion, "2, 6, left, default");

        btnSubmit = getBtnSubmit();
        add(btnSubmit, "4, 6, right, default");

        listDisplayPanel = new JPanel();
        listDisplayPanel.setLayout(new BoxLayout(listDisplayPanel,BoxLayout.Y_AXIS));
        addFooterForm();
        containerPane = new JScrollPane(listDisplayPanel);
        containerPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(containerPane, "4, 8, default, center");
        quizCreationPanel = this;
    }


    private  static void addFooterForm(){
        QuestionPanel questionPanel = new QuestionPanel();
        Color borderColor = new Color(154, 154, 154);
        Color foreGroundColor = new Color(47, 79, 79);
        questionPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED,borderColor, borderColor, borderColor, borderColor));
        questionPanel.setForeground(foreGroundColor);
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

    public static QuizCreationPanel getNewQuizCreationPanel(){
        quizCreationPanel = new QuizCreationPanel();
        return quizCreationPanel;
    }

    private static JButton getBtnAddQuestion(){
        JButton addQuestionButton = new JButton(Constants.ADD_QUESTION_CREATEQUIZ);
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

    private static JButton getBackButton(){
        JButton backButton = new JButton(Constants.BACK);
        backButton.setToolTipText("Create New Quiz");
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ChangeStateListener());
        return backButton;
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
