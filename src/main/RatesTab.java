package main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RatesTab extends JPanel {
    private static final long serialVersionUID = -659227815727422996L;
    private JLabel rateLabel;
    private JLabel cmdRateLabel;
    private JLabel updateRateLabel;
    private JLabel interpLabel;

    private JTextField rateTextField;
    private JTextField cmdRateTextField;
    private JTextField updateRateTextField;
    private JTextField interpTextField;

    private JSlider rateSlider;
    private JSlider cmdRateSlider;
    private JSlider updateRateSlider;
    private JSlider interpSlider;

    public RatesTab() {
        setBorder(BorderFactory.createTitledBorder("RATES TAB"));
        Box verticalBox = Box.createVerticalBox();

        // ------------------- LABELS ---------------------------- //

        rateLabel = new JLabel("RATE ( 0 - 128000 )                     ");
        cmdRateLabel = new JLabel("CMD RATE ( 0 - 128 )");
        updateRateLabel = new JLabel("UPDATE RATE ( 0 - 128 )");
        interpLabel = new JLabel("INTERP ( 0.0 - 0.5 )");

        // ------------------- TEXTFIELDS ---------------------------- // 

        // RATE TEXTFIELD
        rateTextField = new JTextField(Integer.toString(128000));
        rateTextField.setEditable(false);
        rateTextField.setHorizontalAlignment(JTextField.CENTER);
        rateTextField.setBackground(Color.LIGHT_GRAY);

        // CMD RATE TEXTFIELD
        cmdRateTextField = new JTextField(Integer.toString(128));
        cmdRateTextField.setEditable(false);
        cmdRateTextField.setHorizontalAlignment(JTextField.CENTER);
        cmdRateTextField.setBackground(Color.LIGHT_GRAY);

        // UPDATE RATE TEXTFIELD
        updateRateTextField = new JTextField(Integer.toString(128));
        updateRateTextField.setEditable(false);
        updateRateTextField.setHorizontalAlignment(JTextField.CENTER);
        updateRateTextField.setBackground(Color.LIGHT_GRAY);

        // INTERP TEXTFIELD
        interpTextField = new JTextField("0.0");
        interpTextField.setEditable(false);
        interpTextField.setHorizontalAlignment(JTextField.CENTER);
        interpTextField.setBackground(Color.LIGHT_GRAY);

        // ------------------- SLIDERS ---------------------------- //

        // RATE SLIDER
        rateSlider = new JSlider(JSlider.HORIZONTAL, 0, 128000, 128000);
        rateSlider.setToolTipText("0 - 128000");
        rateSlider.setFocusable(false);

        // CMD RATE SLIDER
        cmdRateSlider = new JSlider(JSlider.HORIZONTAL, 0, 128, 128);
        cmdRateSlider.setToolTipText("0 - 128");
        cmdRateSlider.setFocusable(false);

        // UPDATE RATE SLIDER
        updateRateSlider = new JSlider(JSlider.HORIZONTAL, 0, 128, 128);
        updateRateSlider.setToolTipText("0 - 128");
        updateRateSlider.setFocusable(false);

        // INTERP SLIDER
        interpSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
        interpSlider.setToolTipText("0.0 - 0.5");
        interpSlider.setFocusable(false);

        // =========================== VERTICALBOX ======================================== //

        //SET 1
        verticalBox.add(rateLabel);
        verticalBox.add(rateSlider);
        verticalBox.add(rateTextField);

        //SET 2
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(cmdRateLabel);
        verticalBox.add(cmdRateSlider);
        verticalBox.add(cmdRateTextField);

        //SET 3
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(updateRateLabel);
        verticalBox.add(updateRateSlider);
        verticalBox.add(updateRateTextField);

        // SET 4
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(interpLabel);
        verticalBox.add(interpSlider);
        verticalBox.add(interpTextField);

        verticalBox.add(new JLabel("\n"));

        verticalBox.add(new JLabel("\n"));
        add(verticalBox);

        // ============================= LISTENERS ============================================ //

        RateSliderListener listener = new RateSliderListener();
        rateSlider.addChangeListener(listener);
        cmdRateSlider.addChangeListener(listener);
        updateRateSlider.addChangeListener(listener);
        interpSlider.addChangeListener(listener);

    }

    public class RateSliderListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            Object source = e.getSource();
            if (source == rateSlider) {
                rateTextField.setText(Integer.toString(rateSlider.getValue()));
            } else if (source == cmdRateSlider) {
                cmdRateTextField.setText(Integer.toString(cmdRateSlider.getValue()));
            } else if (source == updateRateSlider) {
                updateRateTextField.setText(Integer.toString(updateRateSlider.getValue()));
            } else if (source == interpSlider) {
                int tmp = interpSlider.getValue() / 10;
                if (tmp == 5) {
                    interpTextField.setText("0.5");
                } else {
                    interpTextField.setText("0." + tmp);
                }
            }
        }

    }

    // ============================= GETTERS ============================================ //

    public JTextField getRateTextField() {
        return rateTextField;
    }

    public JTextField getCmdRateTextField() {
        return cmdRateTextField;
    }

    public JTextField getUpdateRateTextField() {
        return updateRateTextField;
    }

    public JTextField getInterpTextField() {
        return interpTextField;
    }

    public JSlider getRateSlider() {
        return rateSlider;
    }

    public JSlider getCmdRateSlider() {
        return cmdRateSlider;
    }

    public JSlider getUpdateRateSlider() {
        return updateRateSlider;
    }

    public JSlider getInterpSlider() {
        return interpSlider;
    }

}
