package view;

import constant.Constants;

import javax.swing.*;

public class PanelFactory {
    public static int state = 1;
    /**
     * default serial version id
     */
    //private static final long serialVersionUID = 1L;

    /**
     * Default constructor to perform tasks on initialization
     * @param
     */
    public PanelFactory() {

    }


    /**
     * Factory method which takes name of the panel as argument and returns the panel after creating it
     * @param componentName
     * @return the panel after creating it
     */
    public static JComponent createPanel(final String componentName) {
        if(componentName.equalsIgnoreCase(Constants.MENUPANEL)) {
            if(state == 1) return new MenuPanel();
            else if(state == 2) return new JPanel();
        }

            return new JPanel(); //Added only till other components are missing!

    }


}
