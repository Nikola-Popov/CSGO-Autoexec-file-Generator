package main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CrosshairTab extends JPanel {
    private static final long serialVersionUID = -4257489894795875961L;
    private JLabel colorsLabel;
    private JLabel outlineLabel;
    private JLabel thicknessLabel;
    private JLabel gapLabel;
    private JLabel sizeLabel;

    private JTextField outlineTextField;
    private JTextField thicknessTextField;
    private JTextField gapTextField;
    private JTextField sizeTextField;

    private JSlider outlineSlider;
    private JSlider thicknessSlider;
    private JSlider gapSlider;
    private JSlider sizeSlider;

    private JComboBox<String> colorsBox;

    private final String[] colors = { "Green", "Yellow", "Blue", "Cyan" };

    public CrosshairTab() {

        setBorder(BorderFactory.createTitledBorder("CROSSHAIR TAB"));
        Box verticalBox = Box.createVerticalBox();

        // ------------------- LABELS ---------------------------- //
        colorsLabel = new JLabel("CROSSHAIR COLORS");
        JLabel outlineLabel = new JLabel("OUTLINE ( 0 - 3 )                      ");
        JLabel thicknessLabel = new JLabel("THICKNESS ( 0 - 100 )");
        JLabel gapLabel = new JLabel("GAP ( -100 -100 )");
        JLabel sizeLabel = new JLabel("SIZE ( 0 - 100 )");

        // ------------------- TEXTFIELDS ---------------------------- // 

        // THICKNESS TEXTFIELD
        thicknessTextField = new JTextField(Integer.toString(0));
        thicknessTextField.setEditable(false);
        thicknessTextField.setHorizontalAlignment(JTextField.CENTER);
        thicknessTextField.setBackground(Color.LIGHT_GRAY);

        // GAP TEXTFIELD
        gapTextField = new JTextField(Integer.toString(0));
        gapTextField.setEditable(false);
        gapTextField.setHorizontalAlignment(JTextField.CENTER);
        gapTextField.setBackground(Color.LIGHT_GRAY);

        // SIZE TEXTFIELD
        sizeTextField = new JTextField(Integer.toString(0));
        sizeTextField.setEditable(false);
        sizeTextField.setHorizontalAlignment(JTextField.CENTER);
        sizeTextField.setBackground(Color.LIGHT_GRAY);

        // OUTLINE TEXTFIELD
        outlineTextField = new JTextField("0");
        outlineTextField.setEditable(false);
        outlineTextField.setHorizontalAlignment(JTextField.CENTER);
        outlineTextField.setBackground(Color.LIGHT_GRAY);

        // ------------------- COMBOBOXES ---------------------------- // 

        colorsBox = new JComboBox<String>(colors);
        colorsBox.setFocusable(false);

        // ------------------- SLIDERS ---------------------------- //

        outlineSlider = new JSlider(JSlider.HORIZONTAL, 0, 3, 0);
        outlineSlider.setFocusable(false);
        outlineSlider.setToolTipText("0 - 3");

        thicknessSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        thicknessSlider.setFocusable(false);
        thicknessSlider.setToolTipText("0 - 100");

        gapSlider = new JSlider(JSlider.HORIZONTAL, -100, 100, 0);
        gapSlider.setFocusable(false);
        gapSlider.setToolTipText("-100 - 100");

        sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        sizeSlider.setFocusable(false);
        sizeSlider.setToolTipText("0 - 100");

        // =========================== VERTICALBOX ======================================== //

        // SET 1
        verticalBox.add(thicknessLabel);
        verticalBox.add(thicknessSlider);
        verticalBox.add(thicknessTextField);

        // SET 2
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(outlineLabel);
        verticalBox.add(outlineSlider);
        verticalBox.add(outlineTextField);

        // SET 3
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(gapLabel);
        verticalBox.add(gapSlider);
        verticalBox.add(gapTextField);

        // SET 4
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(sizeLabel);
        verticalBox.add(sizeSlider);
        verticalBox.add(sizeTextField);

        // SET 5
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(colorsLabel);
        verticalBox.add(colorsBox);

        add(verticalBox);

        // ------------------- MISC (LISTENERS LOGIC) ---------------------------- //

        CrosshairSliderLister lister = new CrosshairSliderLister();
        outlineSlider.addChangeListener(lister);
        thicknessSlider.addChangeListener(lister);
        sizeSlider.addChangeListener(lister);
        gapSlider.addChangeListener(lister);
    }

    public class CrosshairSliderLister implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            Object source = e.getSource();
            if (source == thicknessSlider) {
                thicknessTextField.setText(Integer.toString(thicknessSlider.getValue()));
            } else if (source == outlineSlider) {
                outlineTextField.setText(Integer.toString(outlineSlider.getValue()));
            } else if (source == gapSlider) {
                gapTextField.setText(Integer.toString(gapSlider.getValue()));
            } else if (source == sizeSlider) {
                sizeTextField.setText(Integer.toString(sizeSlider.getValue()));
            }

        }
    }

    // ============================= GETTERS ============================================ //

    public void setSelectedColorBoxItem(int index) {
        colorsBox.setSelectedIndex(index);
    }

    public int getSelectedColorBoxItem() {
        return colorsBox.getSelectedIndex() + 1;
    }

    public JTextField getOutlineTextField() {
        return outlineTextField;
    }

    public JTextField getThicknessTextField() {
        return thicknessTextField;
    }

    public JTextField getGapTextField() {
        return gapTextField;
    }

    public JTextField getSizeTextField() {
        return sizeTextField;
    }

    public JSlider getOutlineSlider() {
        return outlineSlider;
    }

    public JSlider getThicknessSlider() {
        return thicknessSlider;
    }

    public JSlider getGapSlider() {
        return gapSlider;
    }

    public JSlider getSizeSlider() {
        return sizeSlider;
    }

    public JComboBox<String> getColorsBox() {
        return colorsBox;
    }

}
