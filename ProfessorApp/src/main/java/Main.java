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
                new MainFrame();
            }
        });

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                    MonitorQuizDir monitorQuizDir = MonitorQuizDir.getInstance();
//                    System.out.println(monitorQuizDir.getCount());
//            }
//        }).start();


    }
}
