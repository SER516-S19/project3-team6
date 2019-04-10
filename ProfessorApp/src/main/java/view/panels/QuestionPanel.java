package view.panels;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import constant.Constants;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;


/**
 * Initializing the individual Question Panel.
 * @author Abhinab Mohanty GIT ID: 53
 *
 */

public class QuestionPanel extends JPanel {
    private JTextField questionText;
    private JTextField option1Text;
    private JTextField option2Text;
    private JTextField option3Text;
    private JTextField option4Text;
    private Choice correctAnswerChoice;
    private static ColumnSpec[] columnSpecs = Constants.columnSpecs;
    private static RowSpec[] rowSpecs = Constants.rowSpecs;



    /**
     * Create the panel.
     */
    public QuestionPanel() {
        setLayout(new FormLayout(columnSpecs,rowSpecs));

        JLabel lblQuestion = new JLabel("Question:");
        lblQuestion.setFont(new Font("Monaco", Font.BOLD, 14));
        lblQuestion.setForeground(new Color(47, 79, 79));
        add(lblQuestion, "2, 2, right, default");

        questionText = new JTextField();
        add(questionText, "4, 2, default, fill");
        questionText.setColumns(10);

        JLabel lblOptions = new JLabel("Options:");
        lblOptions.setFont(new Font("Monaco", Font.PLAIN, 13));
        lblOptions.setForeground(new Color(47, 79, 79));
        add(lblOptions, "2, 4");

        JLabel lblOption = new JLabel("Option 1:");
        lblOption.setFont(new Font("Monaco", Font.PLAIN, 13));
        lblOption.setForeground(new Color(47, 79, 79));
        add(lblOption, "2, 6, right, default");

        option1Text = new JTextField();
        add(option1Text, "4, 6, fill, default");
        option1Text.setColumns(10);

        JLabel lblOption_1 = new JLabel("Option 2:");
        lblOption_1.setForeground(new Color(47, 79, 79));
        lblOption_1.setFont(new Font("Monaco", Font.PLAIN, 13));
        add(lblOption_1, "2, 8, right, default");

        option2Text = new JTextField();
        add(option2Text, "4, 8, fill, default");
        option2Text.setColumns(10);

        JLabel lblOption_2 = new JLabel("Option 3:");
        lblOption_2.setForeground(new Color(47, 79, 79));
        lblOption_2.setFont(new Font("Monaco", Font.PLAIN, 13));
        add(lblOption_2, "2, 10, right, default");

        option3Text = new JTextField();
        add(option3Text, "4, 10, fill, default");
        option3Text.setColumns(10);

        JLabel lblOption_3 = new JLabel("Option 4:");
        lblOption_3.setFont(new Font("Monaco", Font.PLAIN, 13));
        lblOption_3.setForeground(new Color(47, 79, 79));
        add(lblOption_3, "2, 12, right, default");

        option4Text = new JTextField();
        add(option4Text, "4, 12, fill, default");
        option4Text.setColumns(10);

        initializeOptions();

        JLabel lblCorrectAnswer = new JLabel("Correct Answer");
        lblCorrectAnswer.setForeground(new Color(47, 79, 79));
        lblCorrectAnswer.setFont(new Font("Monaco", Font.BOLD, 14));
        add(lblCorrectAnswer, "2, 14");

        correctAnswerChoice = new Choice();
        for(String choices : Constants.OPTIONS)
            correctAnswerChoice.add(choices);
        add(correctAnswerChoice, "4, 14, left, default");

    }

    private void initializeOptions() {
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        questionText.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
        option1Text.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
        option2Text.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
        option3Text.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
        option4Text.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
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
