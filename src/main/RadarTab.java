package main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RadarTab extends JPanel {
    private JLabel scaleLabel;
    private JTextField scaleTextField;
    private JCheckBox rotateBox;
    private JCheckBox alwaysCenteredBox;
    private JSlider scaleSlider;
    RatesTab tab = new RatesTab();

    public RadarTab() {
        setBorder(BorderFactory.createTitledBorder("RADAR TAB"));
        Box verticalBox = Box.createVerticalBox();

        // ------------------- LABELS ---------------------------- //
        scaleLabel = new JLabel("SCALE ( 0.3 - 1.0 )                        ");

        // ------------------- TEXTFIELDS ---------------------------- // 

        scaleTextField = new JTextField("0.3");
        scaleTextField.setEditable(false);
        scaleTextField.setHorizontalAlignment(JTextField.CENTER);
        scaleTextField.setBackground(Color.LIGHT_GRAY);

        // ------------------- CHECKBOXES ---------------------------- //

        //ALWWAYS CENTERED BOX
        alwaysCenteredBox = new JCheckBox("ALWAYS CENTERED");
        alwaysCenteredBox.setFocusable(false);

        //ROTATE BOX
        rotateBox = new JCheckBox("ROTATE");
        rotateBox.setFocusable(false);

        // ------------------- SLIDERS ---------------------------- //

        scaleSlider = new JSlider(JSlider.HORIZONTAL, 30, 100, 30);
        scaleSlider.setFocusable(false);
        scaleSlider.setToolTipText("0.3 - 1.0");

        // =========================== VERTICALBOX ======================================== //

        // SET 1
        verticalBox.add(alwaysCenteredBox);

        //SET 2
        verticalBox.add(rotateBox);

        // SET 3
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(scaleLabel);
        verticalBox.add(scaleSlider);
        verticalBox.add(scaleTextField);

        add(verticalBox);

        // ============================= LISTENERS ============================================ //

        scaleSlider.addChangeListener(new ScaleSliderListener());
    }

    public class ScaleSliderListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            int tmp = scaleSlider.getValue() / 10;
            if (tmp == 10) {
                scaleTextField.setText(Integer.toString(1));
            } else {
                scaleTextField.setText("0." + tmp);
            }
        }

    }

    // ============================= GETTERS ============================================ //

    public JTextField getScaleTextField() {
        return scaleTextField;
    }

    public JCheckBox getRotateBox() {
        return rotateBox;
    }

    public JCheckBox getAlwaysCenteredBox() {
        return alwaysCenteredBox;
    }

    public JSlider getScaleSlider() {
        return scaleSlider;
    }
}
