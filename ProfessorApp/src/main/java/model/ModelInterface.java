package model;

import java.util.ArrayList;
import java.util.Map;


/**
 * Initializing the Main JFrame Window class for the application.
 * @author Abhinab Mohanty GIT ID: 53
 *
 */
public interface ModelInterface {
    /**Since all models have distinctive , non-overlapping functionality
     * Hence created an Interface to implement**/
    void setModel(Map<String, ArrayList<String>> questionAnswers, Map<String, String> questionCorrectAnswers);
}
