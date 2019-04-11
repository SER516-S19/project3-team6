import javax.swing.SwingUtilities;

import view.StudentMainFrame;

/**
 * Main method to launch the application
 *
 * @author Aman, Manisha, Bijaylaxmi Panda
 * @version 1.0
 */
public class Main {
	/**
	 * The main method to run the application
	 * @param args
	 * 
	 */ 
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				StudentMainFrame.getInstance();
			}
		});
	}
}