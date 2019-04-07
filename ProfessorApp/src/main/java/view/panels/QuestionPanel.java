package view.panels;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import constant.Constants;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class QuestionPanel extends JPanel {
    private JTextField questionText;
    private JTextField option1Text;
    private JTextField option2Text;
    private JTextField option3Text;
    private JTextField option4Text;
    private Choice correctAnswerChoice;



    /**
     * Create the panel.
     */
    public QuestionPanel() {
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
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,}));

        JLabel lblQuestion = new JLabel("Question:");
        add(lblQuestion, "2, 2, right, default");

        questionText = new JTextField();
        add(questionText, "4, 2, fill, default");
        questionText.setColumns(10);

        JLabel lblOptions = new JLabel("Options:");
        add(lblOptions, "2, 4");

        JLabel lblOption = new JLabel("Option 1:");
        add(lblOption, "2, 6, right, default");

        option1Text = new JTextField();
        add(option1Text, "4, 6, fill, default");
        option1Text.setColumns(10);

        JLabel lblOption_1 = new JLabel("Option 2:");
        add(lblOption_1, "2, 8, right, default");

        option2Text = new JTextField();
        add(option2Text, "4, 8, fill, default");
        option2Text.setColumns(10);

        JLabel lblOption_2 = new JLabel("Option 3:");
        add(lblOption_2, "2, 10, right, default");

        option3Text = new JTextField();
        add(option3Text, "4, 10, fill, default");
        option3Text.setColumns(10);

        JLabel lblOption_3 = new JLabel("Option 4:");
        add(lblOption_3, "2, 12, right, default");

        option4Text = new JTextField();
        add(option4Text, "4, 12, fill, default");
        option4Text.setColumns(10);

        initializeOptions();

        JLabel lblCorrectAnswer = new JLabel("Correct Answer");
        add(lblCorrectAnswer, "2, 14");

        correctAnswerChoice = new Choice();
        for(String choices : Constants.OPTIONS)
            correctAnswerChoice.add(choices);
        add(correctAnswerChoice, "4, 14, left, default");

    }

    private void initializeOptions() {
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        questionText.setBorder(border);
        option1Text.setBorder(border);
        option2Text.setBorder(border);
        option3Text.setBorder(border);
        option4Text.setBorder(border);
    }

    public String getQuestionText() {
        return questionText.getText();
    }

    public String getOption1Text() {
        return option1Text.getText();
    }

    public String getOption2Text() {
        return option2Text.getText();
    }

    public String getOption3Text() {
        return option3Text.getText();
    }

    public String getOption4Text() {
        return option4Text.getText();
    }

    public String getCorrectAnswerChoice() {
        switch(correctAnswerChoice.getSelectedItem()){
            case Constants.OPTION_1: return option1Text.getText();
            case Constants.OPTION_2: return option2Text.getText();
            case Constants.OPTION_3: return option3Text.getText();
            case Constants.OPTION_4: return option4Text.getText();
        }

        return option1Text.getText(); //Default Correct answer for every unset correct answer
    }
}
