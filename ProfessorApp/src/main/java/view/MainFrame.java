package view;

import constant.Constants;

import javax.swing.*;


public class MainFrame extends JFrame {
    /**
     * Default Serial version id
     */
    private static final long serialVersionUID = 1L;


    private JComponent menuPanel;
    private static int headPanelHeight = 125;
    private static int headPanelWidth = 125;




    /**
     * Initializes all the component of the text editor and sets up the layout
     */
    public MainFrame() {
        setTitle("Professor-App");
//        headPanel = new JPanel();
//        BoxLayout boxlayout = new BoxLayout(headPanel, BoxLayout.Y_AXIS);
//        headPanel.setLayout(boxlayout);


        menuPanel = PanelFactory.createPanel(Constants.MENUPANEL);
        JScrollPane jScrollPane = new JScrollPane(menuPanel);
        this.setSize(1000,1000);
        this.add(jScrollPane);
        this.setVisible(true);

    }

}
