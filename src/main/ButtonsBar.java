package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ButtonsBar extends JPanel {
    private static final long serialVersionUID = 4082865791263129660L;
    private JButton generateButton;
    private JButton resetButton;

    private String[] operations = { "DOWNLOAD", "COPY TO CLIPBOARD", "CLOSE" };
    private StringSelection copyToClipBoard;
    Clipboard clipBoard;

    private DateFormat dateFormat;
    private Date date;

    private JTextArea textArea;
    private JScrollPane wrapTextArea;

    public ButtonsBar(final RatesTab ratesTab, final RadarTab radarTab, final VideoTab videoTab,
            final CrosshairTab crosshairTab, final VolumeTab volumeTab, final MouseTab mouseTab) {
        setLayout(new GridLayout());

        // ============================= MAIN EXECUTABLES ============================================ //

        //GENERATE BUTTON
        generateButton = new JButton("GENERATE");
        generateButton.setFont(ratesTab.getFont());
        generateButton.setFocusable(false);
        add(generateButton);

        //RESET BUTTON
        resetButton = new JButton("RESET");
        resetButton.setFont(ratesTab.getFont());
        resetButton.setFocusable(false);
        add(resetButton);

        //DISPLAY
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(ratesTab.getFont());

        wrapTextArea = new JScrollPane(textArea);
        wrapTextArea.setPreferredSize(new Dimension(350, 500));
        wrapTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        wrapTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        //DATE
        dateFormat = new SimpleDateFormat("HH:mm:ss , dd/MM/yyyy ");
        date = new Date();

        // ------------------- FONTS ---------------------------- //

        Font oldFont = generateButton.getFont();
        Font newFont = new Font(oldFont.getName(), Font.PLAIN, 15);

        generateButton.setFont(newFont);
        resetButton.setFont(newFont);
        // ------------------- MISC ---------------------------- //

        resetButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // RATES TAB
                ratesTab.getRateSlider().setValue(128000);
                ratesTab.getRateTextField().setText(Integer.toString(128000));

                ratesTab.getCmdRateSlider().setValue(128);
                ratesTab.getCmdRateTextField().setText(Integer.toString(128));

                ratesTab.getUpdateRateSlider().setValue(128);
                ratesTab.getUpdateRateTextField().setText(Integer.toString(128));

                ratesTab.getInterpSlider().setValue(0);
                ratesTab.getInterpTextField().setText("0.0");

                //RADAR TAB
                radarTab.getAlwaysCenteredBox().setSelected(false);
                radarTab.getRotateBox().setSelected(false);

                radarTab.getScaleTextField().setText("0.3");
                radarTab.getScaleSlider().setValue(30);

                //VIDEO TAB
                videoTab.getVerticalSyncCheckBox().setSelected(false);
                videoTab.getDynamiCheckBox().setSelected(false);
                videoTab.getDrawParticlesCheckBox().setSelected(false);
                videoTab.getDrawTracersCheckBox().setSelected(false);

                videoTab.getMonitorGammaTextField().setText("5.0");
                videoTab.getMonitorGammaSlider().setValue(5);

                videoTab.getFpsMaxTextField().setText(Integer.toString(59));
                videoTab.getFpsMaxSlider().setValue(59);

                //CROSSHAIR TAB
                crosshairTab.getOutlineSlider().setValue(0);
                crosshairTab.getOutlineTextField().setText(Integer.toBinaryString(0));

                crosshairTab.getGapSlider().setValue(0);
                crosshairTab.getGapTextField().setText(Integer.toBinaryString(0));

                crosshairTab.getSizeSlider().setValue(0);
                crosshairTab.getSizeTextField().setText(Integer.toBinaryString(0));

                crosshairTab.getThicknessSlider().setValue(0);
                crosshairTab.getThicknessTextField().setText(Integer.toBinaryString(0));

                crosshairTab.setSelectedColorBoxItem(0);

                //VOLUME TAB
                volumeTab.getVoiceEnableBox().setSelected(false);
                volumeTab.getVoiceChatInLobbyBox().setSelected(false);
                volumeTab.getMuteGameWhenInWindowsBox().setSelected(false);
                volumeTab.getVolumeTextField().setText("1.0");
                volumeTab.getVolumeSlider().setValue(100);

                volumeTab.getVoiceScaleTextField().setText("1.0");
                volumeTab.getVoiceScaleSlider().setValue(100);

                volumeTab.getMusicVolumeTextField().setText("1.0");
                volumeTab.getMusicVolumeSlider().setValue(100);

                volumeTab.getSoundDelayTextField().setText("1.0");
                volumeTab.getSoundDelaySlider().setValue(100);

                //MOUSE TAB
                mouseTab.getUseRawInput().setSelected(false);

                mouseTab.getSensitivityTextField().setText(Integer.toString(0));
                mouseTab.getSensitivitySlider().setValue(0);

                mouseTab.getMouseAccelerationTextField().setText(Integer.toString(0));
                mouseTab.getSensitivitySlider().setValue(0);

                mouseTab.getZoomSensitivityTextField().setText(Integer.toString(0));
                mouseTab.getZoomSensitivitySlider().setValue(0);

            }
        });

        generateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                textArea.setText("//Autoexec code generated: "
                        + dateFormat.format(date)
                        + "\n\n\n"
                        + "//RATES"
                        + "\n"
                        + "rate "
                        + "\""
                        + ratesTab.getRateTextField().getText()
                        + "\""
                        + "\n"
                        + "cmdrate "
                        + "\""
                        + ratesTab.getCmdRateTextField().getText()
                        + "\""
                        + "\n"
                        + "updaterate "
                        + "\""
                        + ratesTab.getUpdateRateTextField().getText()
                        + "\""
                        + "\n"
                        + "cl_interp "
                        + "\""
                        + ratesTab.getInterpTextField().getText()
                        + "\""
                        + "\n\n"
                        + "//RADAR"
                        + "\n"
                        + "cl_radar_always_centered "
                        + "\""
                        + (radarTab.getAlwaysCenteredBox().isSelected() ? 1 : 0)
                        + "\""
                        + "\n"
                        + "cl_radar_rotate "
                        + "\""
                        + (radarTab.getRotateBox().isSelected() ? 1 : 0)
                        + "\""
                        + "\n"
                        + "cl_radar_scale "
                        + "\""
                        + radarTab.getScaleTextField().getText()
                        + "\""
                        + "\n\n"
                        + "//VIDEO"
                        + "\n"
                        + "mat_monitorgamma "
                        + "\""
                        + videoTab.getMonitorGammaTextField().getText()
                        + "\""
                        + "\n"
                        + "fps_max "
                        + "\""
                        + videoTab.getFpsMaxTextField().getText()
                        + "\""
                        + "\n"
                        + "mat_vsync "
                        + "\""
                        + (videoTab.getVerticalSyncCheckBox().isSelected() ? 1 : 0)
                        + "\""
                        + "\n"
                        + "r_dynamic "
                        + "\""
                        + (videoTab.getDynamiCheckBox().isSelected() ? 1 : 0)
                        + "\""
                        + "\n"
                        + "r_drawtracers_firstperson "
                        + "\""
                        + (videoTab.getDrawTracersCheckBox().isSelected() ? 1 : 0)
                        + "\""
                        + "\n"
                        + "r_drawparticles "
                        + "\""
                        + (videoTab.getDrawParticlesCheckBox().isSelected() ? 1 : 0)
                        + "\""
                        + "\n"
                        + "mat_savechanges"
                        + "\n\n"
                        + "//CROSSHAIR"
                        + "\n"
                        + "cl_crosshaircolor "
                        + "\""
                        + crosshairTab.getSelectedColorBoxItem()
                        + "\""
                        + "\n"
                        + "cl_crosshairthickness "
                        + "\""
                        + crosshairTab.getThicknessTextField().getText()
                        + "\""
                        + "\n"
                        + "cl_crosshairsize  "
                        + "\""
                        + crosshairTab.getSizeTextField().getText()
                        + "\""
                        + "\n"
                        + ((crosshairTab.getOutlineSlider().getValue() > 0) ? "cl_crosshair_outlinethickness  " + "\""
                                + crosshairTab.getOutlineTextField().getText() + "\"" + "\n"
                                + "cl_crosshair_drawoutline  " + "\"" + 1 + "\"" : "cl_crosshair_outlinethickness  "
                                + "\"" + 0 + "\"" + "\n" + "cl_crosshair_drawoutline  " + "\"" + 0) + "\"" + "\n"
                        + "cl_crosshairgap  " + "\"" + crosshairTab.getGapTextField().getText() + "\"" + "\n"
                        + "cl_fixedcrosshairgap  " + "\"" + crosshairTab.getGapTextField().getText() + "\"" + "\n\n"
                        + "//VOLUME" + "\n" + "volume " + "\"" + volumeTab.getVolumeTextField().getText() + "\"" + "\n"
                        + "voice_enable " + "\"" + (volumeTab.getVoiceEnableBox().isSelected() ? 1 : 0) + "\"" + "\n"
                        + "voice_scale " + "\"" + volumeTab.getVoiceScaleTextField().getText() + "\"" + "\n"
                        + "lobby_voice_chat_enabled " + "\""
                        + (volumeTab.getVoiceChatInLobbyBox().isSelected() ? 1 : 0) + "\"" + "\n" + "snd_musicvolume "
                        + volumeTab.getMusicVolumeTextField().getText() + "\"" + "\n" + "snd_mute_losefocus " + "\""
                        + (volumeTab.getMuteGameWhenInWindowsBox().isSelected() ? 1 : 0) + "\"" + "\n"
                        + "snd_mixahead " + "\"" + volumeTab.getSoundDelayTextField().getText() + "\"" + "\n\n"
                        + "//MOUSE" + "\n" + "sensitivity " + "\"" + mouseTab.getSensitivityTextField().getText()
                        + "\"" + "\n" + "zoom_sensitivity_ratio_mouse " + "\""
                        + mouseTab.getZoomSensitivityTextField().getText() + "\"" + "\n" + "m_customaccel " + "\""
                        + mouseTab.getMouseAccelerationTextField().getText() + "\"" + "\n" + "m_rawinput " + "\""
                        + (mouseTab.getUseRawInput().isSelected() ? 1 : 0) + "\"");
                int dialogBoxResult = JOptionPane.showOptionDialog(null, wrapTextArea, "AUTOEXEC GENERATED", 0,
                        JOptionPane.PLAIN_MESSAGE, null, operations, operations[0]);
                switch (dialogBoxResult) {
                    case 0: {
                        try {
                            FileOutput fileOutput = new FileOutput(textArea.getText());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null,

                        "The \"autoexec.cfg\" file was successfuly saved to your Desktop at " + dateFormat.format(date)
                                + "." + "\n"
                                + "For further information on how to use this file check the \"HELP\" menu contents.",
                                "FILE OUTPUT", JOptionPane.INFORMATION_MESSAGE, null);
                        break;
                    }
                    case 1: {
                        copyToClipBoard = new StringSelection(textArea.getText());
                        clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clipBoard.setContents(copyToClipBoard, null);
                        JOptionPane
                                .showMessageDialog(
                                        null,
                                        "The \"autoexec.cfg\" code was successfuly copied to your clipboard at "
                                                + dateFormat.format(date)
                                                + "."
                                                + "\n"
                                                + "For further information on how to proceed check the \"HELP\" menu contents.",
                                        "CLIPBOARD OUTPUT", JOptionPane.INFORMATION_MESSAGE, null);
                        break;
                    }
                }

            }
        });
    }
}
