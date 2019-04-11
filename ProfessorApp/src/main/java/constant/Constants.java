package constant;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;


/**
 * The Main Constant class
 * @author Abhinab Mohanty GIT ID: 53
 *
 */
public class Constants {
    //Global Constants
    public static final String MENU_PANEL = "menuPanel";
    public static final String QUIZ_PANEL = "quizPanel";
    public static final String EDIT_QUIZ_PANEL = "editQuizPanel";
    public static final String CREATE_QUIZ = "Create Quiz";
    public static final String EDIT_QUIZ = "Edit Quiz";
    public static final String APP_TITLE = "Professor-App";
    public static final String SUBMIT = "Submit";
    public static final String ADD_QUESTION = "Add Question";
    public static final String BACK = "Back";
    public static final String OPTION_1 = "Option 1";
    public static final String OPTION_2 = "Option 2";
    public static final String OPTION_3 = "Option 3";
    public static final String OPTION_4 = "Option 4";
    public static final String QUIZ_NAME = "Quiz Name :";
    public static final String[] OPTIONS = new String[]{OPTION_1,OPTION_2,OPTION_3,OPTION_4};
    public static final String WARNING_MESSAGE = "All Unsaved Changes will be lost. Are you sure you want to go back?";
    public static final String WARNING_TITLE = "Confirm Action";
    public static final String EMPTY_ERROR = "Quiz Name cannot be Empty!!!";

    //Form layout Constants
    public static final ColumnSpec[] columnSpecs = new ColumnSpec[] {
            FormSpecs.RELATED_GAP_COLSPEC,
            FormSpecs.DEFAULT_COLSPEC,
            FormSpecs.RELATED_GAP_COLSPEC,
            ColumnSpec.decode("default:grow"),};

    public static final RowSpec[] rowSpecs =  new RowSpec[] {
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
            FormSpecs.DEFAULT_ROWSPEC,};


    //Model Key Constants
    public static final String QUESTION_TITLE = "title";
    public static final String QUESTION_HEADER = "questions";
    public static final String ANSWER_OPTIONS = "options";
    public static final String CORRECT_ANSWER = "correctAnswer";
}
