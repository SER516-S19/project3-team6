package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import constant.Constants;
import model.Question;


/**
 * Initializing the individual Question Panel.
 * @author Abhinab Mohanty GIT ID: 53
 *
 */

public class QuestionPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -714620596474140993L;
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
        Color uniformUIColor = new Color(47, 79, 79);
        Font boldFont = new Font("Monaco", Font.BOLD, 14);
        Font plainFont = new Font("Monaco", Font.PLAIN, 13);

        JLabel lblQuestion = new JLabel("Question:");
        lblQuestion.setFont(boldFont);
        lblQuestion.setForeground(uniformUIColor);
        add(lblQuestion, "2, 2, right, default");

        questionText = new JTextField();
        add(questionText, "4, 2, default, fill");
        questionText.setColumns(10);

        JLabel lblOptions = new JLabel("Options:");
        lblOptions.setFont(plainFont);
        lblOptions.setForeground(uniformUIColor);
        add(lblOptions, "2, 4");

        JLabel lblOption = new JLabel("Option 1:");
        lblOption.setFont(plainFont);
        lblOption.setForeground(uniformUIColor);
        add(lblOption, "2, 6, right, default");

        option1Text = new JTextField();
        add(option1Text, "4, 6, fill, default");
        option1Text.setColumns(10);

        JLabel lblOption_1 = new JLabel("Option 2:");
        lblOption_1.setForeground(uniformUIColor);
        lblOption_1.setFont(plainFont);
        add(lblOption_1, "2, 8, right, default");

        option2Text = new JTextField();
        add(option2Text, "4, 8, fill, default");
        option2Text.setColumns(10);

        JLabel lblOption_2 = new JLabel("Option 3:");
        lblOption_2.setForeground(uniformUIColor);
        lblOption_2.setFont(plainFont);
        add(lblOption_2, "2, 10, right, default");

        option3Text = new JTextField();
        add(option3Text, "4, 10, fill, default");
        option3Text.setColumns(10);

        JLabel lblOption_3 = new JLabel("Option 4:");
        lblOption_3.setFont(plainFont);
        lblOption_3.setForeground(uniformUIColor);
        add(lblOption_3, "2, 12, right, default");

        option4Text = new JTextField();
        add(option4Text, "4, 12, fill, default");
        option4Text.setColumns(10);

        initializeOptions();

        JLabel lblCorrectAnswer = new JLabel("Correct Answer");
        lblCorrectAnswer.setForeground(uniformUIColor);
        lblCorrectAnswer.setFont(boldFont);
        add(lblCorrectAnswer, "2, 14");

        correctAnswerChoice = new Choice();
        for(String choices : Constants.OPTIONS)
            correctAnswerChoice.add(choices);
        add(correctAnswerChoice, "4, 14, left, default");

    }
    /**
     * Prepopulate the panel.
     */
    public QuestionPanel(Question question) {
        setLayout(new FormLayout(columnSpecs,rowSpecs));
        Color uniformUIColor = new Color(47, 79, 79);
        Font boldFont = new Font("Monaco", Font.BOLD, 14);
        Font plainFont = new Font("Monaco", Font.PLAIN, 13);

        JLabel lblQuestion = new JLabel("Question:");
        lblQuestion.setFont(boldFont);
        lblQuestion.setForeground(uniformUIColor);
        add(lblQuestion, "2, 2, right, default");

        questionText = new JTextField(question.getTitle());
        add(questionText, "4, 2, default, fill");
        questionText.setColumns(10);

        JLabel lblOptions = new JLabel("Options:");
        lblOptions.setFont(plainFont);
        lblOptions.setForeground(uniformUIColor);
        add(lblOptions, "2, 4");

        JLabel lblOption = new JLabel("Option 1:");
        lblOption.setFont(plainFont);
        lblOption.setForeground(uniformUIColor);
        add(lblOption, "2, 6, right, default");

        option1Text = new JTextField(question.getOptions()[0]);
        add(option1Text, "4, 6, fill, default");
        option1Text.setColumns(10);

        JLabel lblOption_1 = new JLabel("Option 2:");
        lblOption_1.setForeground(uniformUIColor);
        lblOption_1.setFont(plainFont);
        add(lblOption_1, "2, 8, right, default");

        option2Text = new JTextField(question.getOptions()[1]);
        add(option2Text, "4, 8, fill, default");
        option2Text.setColumns(10);

        JLabel lblOption_2 = new JLabel("Option 3:");
        lblOption_2.setForeground(uniformUIColor);
        lblOption_2.setFont(plainFont);
        add(lblOption_2, "2, 10, right, default");

        option3Text = new JTextField(question.getOptions()[2]);
        add(option3Text, "4, 10, fill, default");
        option3Text.setColumns(10);

        JLabel lblOption_3 = new JLabel("Option 4:");
        lblOption_3.setFont(plainFont);
        lblOption_3.setForeground(uniformUIColor);
        add(lblOption_3, "2, 12, right, default");

        option4Text = new JTextField(question.getOptions()[3]);
        add(option4Text, "4, 12, fill, default");
        option4Text.setColumns(10);

        initializeOptions();

        JLabel lblCorrectAnswer = new JLabel("Correct Answer");
        lblCorrectAnswer.setForeground(uniformUIColor);
        lblCorrectAnswer.setFont(boldFont);
        add(lblCorrectAnswer, "2, 14");

        correctAnswerChoice = new Choice();
        for(String choices : Constants.OPTIONS)
            correctAnswerChoice.add(choices);
        add(correctAnswerChoice, "4, 14, left, default");

    }
    
    

    private void initializeOptions() {
        Color borderColor = new Color(192, 192, 192);
        Border border = new SoftBevelBorder(BevelBorder.LOWERED, borderColor, borderColor, borderColor, borderColor);
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
