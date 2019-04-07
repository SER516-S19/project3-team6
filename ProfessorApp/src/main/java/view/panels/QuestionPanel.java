package view.panels;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.*;
import java.awt.*;

public class QuestionPanel extends JPanel {
    private JTextField txt;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Create the panel.
     */
    public QuestionPanel() {
        setLayout(new FormLayout(new ColumnSpec[] {
                FormSpecs.RELATED_GAP_COLSPEC,
                FormSpecs.DEFAULT_COLSPEC,
                FormSpecs.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("default:grow"),},
                new RowSpec[] {
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,
                        FormSpecs.RELATED_GAP_ROWSPEC,
                        FormSpecs.DEFAULT_ROWSPEC,}));

        JLabel lblQuestion = new JLabel("Question:");
        add(lblQuestion, "2, 2, right, default");

        txt = new JTextField();
        add(txt, "4, 2, fill, default");
        txt.setColumns(10);

        JLabel lblOptions = new JLabel("Options:");
        add(lblOptions, "2, 4");

        JLabel lblOption = new JLabel("Option 1:");
        add(lblOption, "2, 6, right, default");

        textField = new JTextField();
        add(textField, "4, 6, fill, default");
        textField.setColumns(10);

        JLabel lblOption_1 = new JLabel("Option 2:");
        add(lblOption_1, "2, 8, right, default");

        textField_1 = new JTextField();
        add(textField_1, "4, 8, fill, default");
        textField_1.setColumns(10);

        JLabel lblOption_2 = new JLabel("Option 3:");
        add(lblOption_2, "2, 10, right, default");

        textField_2 = new JTextField();
        add(textField_2, "4, 10, fill, default");
        textField_2.setColumns(10);

        JLabel lblOption_3 = new JLabel("Option 4:");
        add(lblOption_3, "2, 12, right, default");

        textField_3 = new JTextField();
        add(textField_3, "4, 12, fill, default");
        textField_3.setColumns(10);

        JLabel lblCorrectAnswer = new JLabel("Correct Answer");
        add(lblCorrectAnswer, "2, 14");

        Choice choice = new Choice();
        add(choice, "4, 14, left, default");

    }
}
