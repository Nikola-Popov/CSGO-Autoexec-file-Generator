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

public class VideoTab extends JPanel {
    private static final long serialVersionUID = 4138096939822008999L;
    private JLabel monitorGammaLabel;
    private JLabel fpsMaxLabel;

    private JCheckBox verticalSyncCheckBox;
    private JCheckBox dynamiCheckBox;
    private JCheckBox drawTracersCheckBox;
    private JCheckBox drawParticlesCheckBox;

    private JTextField monitorGammaTextField;
    private JTextField fpsMaxTextField;

    private JSlider monitorGammaSlider;
    private JSlider fpsMaxSlider;

    public VideoTab() {
        setBorder(BorderFactory.createTitledBorder("VIDEO TAB"));
        Box verticalBox = Box.createVerticalBox();

        // ------------------- LABELS ---------------------------- //

        monitorGammaLabel = new JLabel("MONITOR GAMMA ( 0 - 5 )           ");
        fpsMaxLabel = new JLabel("FPS MAX ( 59 - 400 )");

        // ------------------- TEXTFIELDS ---------------------------- // 

        // MONITOR GAMMA TEXTFIELD
        monitorGammaTextField = new JTextField("5.0");
        monitorGammaTextField.setEditable(false);
        monitorGammaTextField.setHorizontalAlignment(JTextField.CENTER);
        monitorGammaTextField.setBackground(Color.LIGHT_GRAY);

        // FPS MAX TEXTFIELD
        fpsMaxTextField = new JTextField(Integer.toString(59));
        fpsMaxTextField.setEditable(false);
        fpsMaxTextField.setHorizontalAlignment(JTextField.CENTER);
        fpsMaxTextField.setBackground(Color.LIGHT_GRAY);

        // ------------------- CHECKBOXES ---------------------------- //

        // VERTICAL SYNC BOX
        verticalSyncCheckBox = new JCheckBox("VERTICAL SYNC");
        verticalSyncCheckBox.setFocusable(false);

        // DYNAMIC BOX
        dynamiCheckBox = new JCheckBox("DYNAMIC");
        dynamiCheckBox.setFocusable(false);

        // DRAW TRACERS BOX
        drawTracersCheckBox = new JCheckBox("DRAW TRACERS");
        drawTracersCheckBox.setFocusable(false);

        // DRAW PARTICLES BOX
        drawParticlesCheckBox = new JCheckBox("DRAW PARTICLES");
        drawParticlesCheckBox.setFocusable(false);

        // ------------------- SLIDERS ---------------------------- //

        // FPS MAX SLIDER
        fpsMaxSlider = new JSlider(JSlider.HORIZONTAL, 59, 400, 59);
        fpsMaxSlider.setToolTipText("59 - 400");
        fpsMaxSlider.setFocusable(false);

        // MONITOR GAMMA SLIDER
        monitorGammaSlider = new JSlider(JSlider.HORIZONTAL, 0, 5, 5);
        monitorGammaSlider.setToolTipText("0 - 5");
        monitorGammaSlider.setFocusable(false);

        // =========================== VERTICALBOX ======================================== //

        //SET 1
        verticalBox.add(verticalSyncCheckBox);
        verticalBox.add(drawParticlesCheckBox);
        verticalBox.add(drawTracersCheckBox);
        verticalBox.add(dynamiCheckBox);

        //SET 2
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(fpsMaxLabel);
        verticalBox.add(fpsMaxSlider);
        verticalBox.add(fpsMaxTextField);

        //SET 3
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(monitorGammaLabel);
        verticalBox.add(monitorGammaSlider);
        verticalBox.add(monitorGammaTextField);

        verticalBox.add(new JLabel("\n"));
        add(verticalBox);

        // ============================= LISTENERS ============================================ //

        VideoListener listener = new VideoListener();
        fpsMaxSlider.addChangeListener(listener);
        monitorGammaSlider.addChangeListener(listener);
    }

    // ============================= GETTERS ============================================ //
    public JCheckBox getVerticalSyncCheckBox() {
        return verticalSyncCheckBox;
    }

    public JCheckBox getDynamiCheckBox() {
        return dynamiCheckBox;
    }

    public JCheckBox getDrawTracersCheckBox() {
        return drawTracersCheckBox;
    }

    public JCheckBox getDrawParticlesCheckBox() {
        return drawParticlesCheckBox;
    }

    public JTextField getMonitorGammaTextField() {
        return monitorGammaTextField;
    }

    public JTextField getFpsMaxTextField() {
        return fpsMaxTextField;
    }

    public JSlider getMonitorGammaSlider() {
        return monitorGammaSlider;
    }

    public JSlider getFpsMaxSlider() {
        return fpsMaxSlider;
    }

    public class VideoListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            Object source = e.getSource();
            if (source == fpsMaxSlider) {
                fpsMaxTextField.setText(Integer.toString(fpsMaxSlider.getValue()));
            } else if (source == monitorGammaSlider) {
                monitorGammaTextField.setText(Integer.toString(monitorGammaSlider.getValue()));
            }
        }
    }

}
