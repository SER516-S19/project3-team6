package view.panels;

import constant.Constants;
import listener.ChangeStateListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Initializing the Main Menu Panel for the app.
 * @author Abhinab Mohanty GIT ID: 53
 *
 */
public class MenuPanel extends JPanel {

    public MenuPanel() {
        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());   
        
        URL url;
		try {
			url = new URL("https://media.giphy.com/media/TgFfQltcAa8KSWcrsH/giphy.gif");
			Icon icon = new ImageIcon(url);
	        JLabel label = new JLabel(icon);
	        JFrame f = new JFrame("Animation");
	        f.getContentPane().add(label);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.pack();
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        Font titleFont = new Font("Serif", Font.PLAIN, 50);

        JLabel title = new JLabel("PROFESSOR APP");
        title.setFont(new Font("Monaco", Font.BOLD, 50));
        title.setForeground(new Color(47, 79, 79));
        title.setBackground(Color.white);
        add(title, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;


        GridBagConstraints gbc1 = new GridBagConstraints();
        Dimension buttonDimension = new Dimension(300, 70);
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(Color.black);
        JButton createQuizButton = new JButton();
        createQuizButton.setBackground(new Color(245, 255, 250));
        createQuizButton.setFont(new Font("Monospaced", Font.PLAIN, 24));
        createQuizButton.setForeground(new Color(0, 128, 128));
        createQuizButton.setPreferredSize(new Dimension(300, 70));
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
