package view;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import constant.Constants;
import listener.ChangeStateListener;
import model.Question;
import model.Quiz;
import service.FileReadService;

/**
 * @author Sabyasachi Mohanty
 * @since 11th Apr, 2019
 * @desc This is the Panel for the EDIT QUIZ Functionality.
 */
public class EditQuizPanel extends JPanel {

	private static final long serialVersionUID = 4729156041871805029L;
	private static List<QuestionPanel> questions;
	private static JTextField quizNameText;
	private static JButton btnAddQuestion, btnSubmit, btnBack;
	private static EditQuizPanel editQuizPanel = null;
	private static JScrollPane containerPane;
	private static JPanel listDisplayPanel;
	private static ColumnSpec[] columnSpecs = Constants.columnSpecs;
	private static RowSpec[] rowSpecs = Constants.rowSpecs;

	public EditQuizPanel(Quiz quiz) {
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
		quizNameText = new JTextField(quiz.getQuizName());
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
		listDisplayPanel.setLayout(new BoxLayout(listDisplayPanel, BoxLayout.Y_AXIS));

		populateQuestions(quiz.getQuestions());
		containerPane = new JScrollPane(listDisplayPanel);
		containerPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		add(containerPane, "4, 8, default, center");
		editQuizPanel = this;
	}

	private static JButton getBtnAddQuestion() {
		JButton addQuestionButton = new JButton(Constants.ADD_QUESTION_EDITQUIZ);
		addQuestionButton.setFocusPainted(false);
		addQuestionButton.addActionListener(new ChangeStateListener());
		return addQuestionButton;
	}

	private static JButton getBtnSubmit() {
		JButton submitButton = new JButton(Constants.SUBMIT);
		submitButton.setFocusPainted(false);
		submitButton.addActionListener(new ChangeStateListener());
		return submitButton;
	}

	private static JButton getBackButton() {
		JButton backButton = new JButton(Constants.BACK);
		backButton.setFocusPainted(false);
		backButton.addActionListener(new ChangeStateListener());
		return backButton;
	}

	private static void populateQuestions(List<Question> questionsList) {
		if (null != questionsList && !questionsList.isEmpty()) {
			for (Question que : questionsList) {
				QuestionPanel questionPanel = new QuestionPanel(que);
				setQuestions(questionPanel);

			}
		}

		listDisplayPanel.revalidate();

	}

	private static void setQuestions(QuestionPanel questionPanel) {
		Color borderColor = new Color(154, 154, 154);
		Color foreGroundColor = new Color(47, 79, 79);
		questionPanel
				.setBorder(new SoftBevelBorder(BevelBorder.RAISED, borderColor, borderColor, borderColor, borderColor));
		questionPanel.setForeground(foreGroundColor);
		listDisplayPanel.add(questionPanel);
		questions.add(questionPanel);
	}

	public static void editQuestionPanel() {
		editQuizPanel.validate();
	}

	public List<QuestionPanel> getQuestions() {
		return questions;
	}

	public String getQuizName() {
		return quizNameText.getText();
	}

	public static EditQuizPanel getEditQuestionPanel(File file) {
		Quiz quiz = FileReadService.readFileQuiz(file);
		if (null == editQuizPanel)
			editQuizPanel = new EditQuizPanel(quiz);

		return editQuizPanel;
	}

	private static void addFooterForm() {
		QuestionPanel questionPanel = new QuestionPanel();
		setQuestions(questionPanel);
		listDisplayPanel.revalidate();

	}

	public static void addQuestionPanel() {
		addFooterForm();
		editQuizPanel.validate();
	}

	public static EditQuizPanel getEditQuestionPanel() {

		if (null != editQuizPanel) {
			return editQuizPanel;
		} else {
			System.out.println("The Edit Quiz Panel is null! ");
			return null;
		}
	}

}
