package view;

import constant.Constants;
import listener.ChangeStateListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


/**
 * Initializing the Main Menu Panel for the app.
 * @author Abhinab Mohanty GIT ID: 53
 *
 */
public class MenuPanel extends JPanel {

    public MenuPanel(){
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        Font titleFont = new Font("Monaco", Font.BOLD, 50);
        Color foreGroundColor = new Color(47, 79, 79);
        JLabel title = new JLabel(Constants.APP_TITLE);
        title.setFont(titleFont);
        title.setForeground(foreGroundColor);
        title.setBackground(Color.white);
        add(title, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        GridBagConstraints gbc1 = new GridBagConstraints();

        //Button UI initialization
        Dimension buttonDimension = new Dimension(300, 70);
        Color buttonBackGround = new Color(245, 255, 250);
        Color buttonForeGround = new Color(0, 128, 128);
        Font buttonFont = new Font("Monospaced", Font.PLAIN, 24);

        //Button Initialization
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(Color.black);
        JButton createQuizButton = new JButton();
        createQuizButton.setBackground(buttonBackGround);
        createQuizButton.setFont(buttonFont);
        createQuizButton.setForeground(buttonForeGround);
        createQuizButton.setPreferredSize(buttonDimension);
        createQuizButton.setText(Constants.CREATE_QUIZ);
        createQuizButton.addActionListener(new ChangeStateListener());
        createQuizButton.setFocusPainted(false);
        buttons.add(createQuizButton, gbc1);
        
        GridBagConstraints gbc2 = new GridBagConstraints();

        gbc2.weighty = 1;
        add(buttons, gbc2);

        this.setVisible(true);
    }



 }
