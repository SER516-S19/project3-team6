import controller.MainController;

/**
 * Main method to launch the application
 *
 * @author Aman, Manisha, Bijaylaxmi
 * @version 1.0
 */
public class Main {
    /**
     * The main method to run the application
     * @param args
     * 
     */ 
    public static void main(String[] args) {
        System.out.println("Main Here");
        MainController c = new MainController();
        c.launchStudentDashboard();
    }
}
