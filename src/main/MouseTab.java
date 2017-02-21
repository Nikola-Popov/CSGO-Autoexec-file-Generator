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

public class MouseTab extends JPanel {
    private static final long serialVersionUID = -7821490498384459244L;
    private JLabel sensitivityLabel;
    private JLabel zoomSensitivityLabel;
    private JLabel mouseAccelerationLabel;

    private JTextField sensitivityTextField;
    private JTextField zoomSensitivityTextField;
    private JTextField mouseAccelerationTextField;

    private JSlider sensitivitySlider;
    private JSlider zoomSensitivitySlider;
    private JSlider mouseAccelerationSlider;

    private JCheckBox useRawInput;

    public MouseTab() {
        setBorder(BorderFactory.createTitledBorder("MOUSE TAB"));
        Box verticalBox = Box.createVerticalBox();

        // ------------------- LABELS ---------------------------- //

        sensitivityLabel = new JLabel("SENSITIVITY ( 0 - 10 )");
        zoomSensitivityLabel = new JLabel("ZOOM SENSITIVITY ( 0 - 10 )");
        mouseAccelerationLabel = new JLabel("MOUSE ACCELERATION ( 0 - 10 )");

        // ------------------- TEXTFIELDS ---------------------------- // 

        // SENSITIVITY TEXTFIELD
        sensitivityTextField = new JTextField(Integer.toString(0));
        sensitivityTextField.setEditable(false);
        sensitivityTextField.setHorizontalAlignment(JTextField.CENTER);
        sensitivityTextField.setBackground(Color.LIGHT_GRAY);

        // ZOOM SENSITIVITY TEXTFIELD
        zoomSensitivityTextField = new JTextField(Integer.toString(0));
        zoomSensitivityTextField.setEditable(false);
        zoomSensitivityTextField.setHorizontalAlignment(JTextField.CENTER);
        zoomSensitivityTextField.setBackground(Color.LIGHT_GRAY);

        // MOUSE ACCELERATION TEXTFIELD
        mouseAccelerationTextField = new JTextField(Integer.toString(0));
        mouseAccelerationTextField.setEditable(false);
        mouseAccelerationTextField.setHorizontalAlignment(JTextField.CENTER);
        mouseAccelerationTextField.setBackground(Color.LIGHT_GRAY);
        // ------------------- SLIDERS ---------------------------- //

        // SENSITIVITY SLIDER
        sensitivitySlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        sensitivitySlider.setToolTipText("0 - 10");
        sensitivitySlider.setFocusable(false);

        // ZOOM SENSITIVITY SLIDER
        zoomSensitivitySlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        zoomSensitivitySlider.setToolTipText("0 - 10");
        zoomSensitivitySlider.setFocusable(false);

        // MOUSE ACCELERATION SLIDER
        mouseAccelerationSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        mouseAccelerationSlider.setToolTipText("0 - 10");
        mouseAccelerationSlider.setFocusable(false);

        // ------------------- CHECKBOXES ---------------------------- //

        //  USE RAW INPUT BOX
        useRawInput = new JCheckBox("USE RAW INPUT");
        useRawInput.setFocusable(false);

        // =========================== VERTICALBOX ======================================== //

        //SET 1
        verticalBox.add(useRawInput);

        //SET 2
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(sensitivityLabel);
        verticalBox.add(sensitivitySlider);
        verticalBox.add(sensitivityTextField);

        //SET 3
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(zoomSensitivityLabel);
        verticalBox.add(zoomSensitivitySlider);
        verticalBox.add(zoomSensitivityTextField);

        // SET 4
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(mouseAccelerationLabel);
        verticalBox.add(mouseAccelerationSlider);
        verticalBox.add(mouseAccelerationTextField);

        verticalBox.add(new JLabel("\n"));

        verticalBox.add(new JLabel("\n"));
        add(verticalBox);

        // ============================= LISTENERS ============================================ //

        RateSliderListener listener = new RateSliderListener();
        mouseAccelerationSlider.addChangeListener(listener);
        zoomSensitivitySlider.addChangeListener(listener);
        sensitivitySlider.addChangeListener(listener);

    }

    public class RateSliderListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            Object source = e.getSource();
            if (source == mouseAccelerationSlider) {
                mouseAccelerationTextField.setText(Integer.toString(mouseAccelerationSlider.getValue()));
            } else if (source == sensitivitySlider) {
                sensitivityTextField.setText(Integer.toString(sensitivitySlider.getValue()));
            } else if (source == zoomSensitivitySlider) {
                zoomSensitivityTextField.setText(Integer.toString(zoomSensitivitySlider.getValue()));
            }

        }

    }

    // ============================= GETTERS ============================================ //

    public JTextField getSensitivityTextField() {
        return sensitivityTextField;
    }

    public JTextField getZoomSensitivityTextField() {
        return zoomSensitivityTextField;
    }

    public JTextField getMouseAccelerationTextField() {
        return mouseAccelerationTextField;
    }

    public JCheckBox getUseRawInput() {
        return useRawInput;
    }

    public JSlider getSensitivitySlider() {
        return sensitivitySlider;
    }

    public JSlider getZoomSensitivitySlider() {
        return zoomSensitivitySlider;
    }

    public JSlider getMouseAccelerationSlider() {
        return mouseAccelerationSlider;
    }

}