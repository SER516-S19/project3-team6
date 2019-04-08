import view.MainFrame;

import javax.swing.*;

public class Main {

    /**
     * The main method to run the application
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                MainFrame.getInstance();
            }
        });

    }
}
