package view.panels;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import constant.Constants;
import listener.ChangeStateListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class QuizCreationPanel extends JPanel{
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
        listDisplayPanel.add(new QuestionPanel());
        listDisplayPanel.revalidate();

    }

    public static JPanel getQuizCreationPanel() {
        if(quizCreationPanel == null)
            return new QuizCreationPanel();
        else
            return quizCreationPanel;
    }

    private static JButton getBtnAddQuestion(){
        JButton addQuestionButton = new JButton(Constants.ADD_QUESTION);
        addQuestionButton.addActionListener(new ChangeStateListener());
        return addQuestionButton;
    }

    private static JButton getBtnSubmit(){
        return new JButton("Submit");
    }

    public static void addQuestionPanel(){
        addFooterForm();
        quizCreationPanel.validate();
    }
}
