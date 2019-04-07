package model;

import java.util.ArrayList;
import java.util.Map;

public interface ModelInterface {
    void setModel(Map<String, ArrayList<String>> questionAnswers, Map<String, String> questionCorrectAnswers);
    /**Since all models have distinctive , non-overlapping functionality
     * Hence created an Interface to implement**/

}
