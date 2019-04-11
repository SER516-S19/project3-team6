package view;

import constants.Constants;
import controller.ChangeStateListener;
import controller.QuizSelection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * To launch student Dash board
 *
 * @author Manisha, Bijaylaxmi Panda, Amanjot Singh
 * @version 1.0
 */

@SuppressWarnings("serial")
public class QuizSelectionPanel extends JPanel {
	private JComboBox comboBox;

	@SuppressWarnings("rawtypes")
	public QuizSelectionPanel(){
		setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
		

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;


		Font titleFont = new Font("Monaco", Font.BOLD, 50);
        Color foreGroundColor = new Color(47, 79, 79);
        JLabel title = new JLabel("Welcome Student");
        title.setFont(titleFont);
        title.setForeground(foreGroundColor);
        title.setBackground(Color.white);
        add(title, gbc);
		
        gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		
		Dimension buttonDimension = new Dimension(150, 50);
        Color buttonBackGround = new Color(245, 255, 250);
        Color buttonForeGround = new Color(0, 128, 128);
        Font buttonFont = new Font("Monospaced", Font.PLAIN, 24);
		
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(Color.black);
        
        
        GridBagConstraints gbc2 = new GridBagConstraints();

        gbc2.weighty = 1;
        JLabel selectQuizName = new JLabel("Select Quiz:  ");
		//buttons.add(selectQuizName, gbc2);
        add(selectQuizName, gbc2);
        add(buttons, gbc2);
        
        GridBagConstraints gbc3 = new GridBagConstraints();
		
		
		String[] listOfQuizzes = QuizSelection.getQuizList();
		comboBox= new JComboBox<String>(listOfQuizzes);
		comboBox.setSize(10, 30);
		add(comboBox, gbc3);
        add(buttons, gbc3);
        add(buttons, gbc);
		
		JButton takeQuizButton = new JButton();
        takeQuizButton.setBackground(buttonBackGround);
        takeQuizButton.setFont(buttonFont);
        takeQuizButton.setForeground(buttonForeGround);
        takeQuizButton.setPreferredSize(buttonDimension);
        takeQuizButton.setText(Constants.TAKE_QUIZ);
        takeQuizButton.addActionListener(new ChangeStateListener());
        takeQuizButton.setFocusPainted(false);
        add(takeQuizButton, gbc1);
        add(buttons, gbc1);
        //buttons.add(takeQuizButton, gbc1);
		this.setVisible(true);
		
	}

}