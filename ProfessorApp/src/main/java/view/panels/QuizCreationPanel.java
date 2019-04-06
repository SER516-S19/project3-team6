package view.panels;

import constant.Constants;
import listener.ChangeStateListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QuizCreationPanel extends JScrollPane{
    public QuizCreationPanel() {
        setBackground(Color.BLUE);
//        setBorder(new EmptyBorder(10, 10, 10, 10));
//        setLayout(new ScrollPaneLayout());


//        Dimension buttonDimension = new Dimension(300, 70);
//        JPanel contentPanel = new JPanel(new FlowLayout());
//        contentPanel.setSize(new Dimension(300,300));
        JLabel quizName = getLabel();
        quizName.setText("Quiz Name:");
//        contentPanel.add(quizName);


        JTextField quizNameText = getTextField();
//        contentPanel.add(quizNameText);
//        contentPanel.setVisible(true);
//


        add(quizName);
        add(quizNameText);
        add(new JButton());
        setVisible(true);
    }

    private void initializeContentpanel(JPanel contentPanel) {

    }

    private JLabel getLabel(){
        return new JLabel();
    }

    private JTextField getTextField(){
        return new JTextField();
    }
}
