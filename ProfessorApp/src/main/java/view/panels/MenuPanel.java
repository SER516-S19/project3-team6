package view.panels;

import constant.Constants;
import listener.ChangeStateListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


/**
 * Initializing the Main JFrame Window class for the application.
 * @author Abhinab Mohanty GIT ID: 53
 *
 */
public class MenuPanel extends JPanel {

    public MenuPanel() {
        setBackground(Color.BLACK);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        Font titleFont = new Font("Serif", Font.PLAIN, 50);

        JLabel title = new JLabel(Constants.APP_TITLE);
        title.setFont(titleFont);
        title.setForeground(Color.lightGray);
        title.setBackground(Color.white);
        add(title, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        Dimension buttonDimension = new Dimension(300, 70);
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(Color.black);
        JButton createQuizButton = new JButton();
        createQuizButton.setPreferredSize(buttonDimension);
        createQuizButton.setText(Constants.CREATE_QUIZ);
        createQuizButton.addActionListener(new ChangeStateListener());
        createQuizButton.setFocusPainted(false);
        buttons.add(createQuizButton, gbc);

        gbc.weighty = 1;
        add(buttons, gbc);

        this.setVisible(true);
    }



 }
