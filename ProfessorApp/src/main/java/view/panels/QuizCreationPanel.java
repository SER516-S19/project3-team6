package view.panels;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import constant.Constants;
import listener.ChangeStateListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class QuizCreationPanel extends JPanel{
    JLabel quizName;
    JTextField quizNameText;
    JButton btnAddQuestion,btnSubmit;
    public QuizCreationPanel() {
        setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"),},
                new RowSpec[] {
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
                        FormSpecs.DEFAULT_ROWSPEC,}));

        JLabel quizName = new JLabel("Quiz Name :");
        add(quizName, "2, 2");

        quizNameText = new JTextField();
        add(quizNameText, "4, 2, left, default");
        quizNameText.setColumns(10);

//        Panel panel = new Panel();
//        panel.add(new JLabel("Question:"));
//        panel.add(new JTextField());
        add(new QuestionPanel(), "4, 4, default, center");

        btnAddQuestion = new JButton("Add Question");
        add(btnAddQuestion, "4, 10, left, default");

        btnSubmit = new JButton("Submit");
        add(btnSubmit, "4, 12, right, default");
    }

    private void initializeContentpanel(JPanel contentPanel) {

    }

    private JLabel getLabel(){
        return new JLabel();
    }

    private JTextPane getTextField(){
        return new JTextPane();
    }
}
