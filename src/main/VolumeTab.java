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

public class VolumeTab extends JPanel {
    private JLabel volumeLabel;
    private JLabel voiceScaleLabel;
    private JLabel musicVolumeLabel;
    private JLabel sounderDelayLabel;

    private JSlider volumeSlider;
    private JSlider voiceScaleSlider;
    private JSlider musicVolumeSlider;
    private JSlider soundDelaySlider;

    private JTextField volumeTextField;
    private JTextField voiceScaleTextField;
    private JTextField musicVolumeTextField;
    private JTextField soundDelayTextField;

    private JCheckBox voiceEnableBox;
    private JCheckBox voiceChatInLobbyBox;
    private JCheckBox muteGameWhenInWindowsBox;

    public VolumeTab() {
        setBorder(BorderFactory.createTitledBorder("VOLUME TAB"));
        Box verticalBox = Box.createVerticalBox();

        // ------------------- LABELS ---------------------------- //

        volumeLabel = new JLabel("VOLUME ( 0.0 - 1.0 )         ");
        voiceScaleLabel = new JLabel("VOICE SCALE ( 0.0 - 1.0 )");
        musicVolumeLabel = new JLabel("music VOLUME ( 0.0 - 1.0 )");
        sounderDelayLabel = new JLabel("SOUND DELAY ( 0.0 - 1.0 )");

        // ------------------- TEXTFIELDS ---------------------------- // 

        // VOLUME TEXTFIELD
        volumeTextField = new JTextField("1.0");
        volumeTextField.setEditable(false);
        volumeTextField.setHorizontalAlignment(JTextField.CENTER);
        volumeTextField.setBackground(Color.LIGHT_GRAY);

        // VOICE SCALE TEXTFIELD
        voiceScaleTextField = new JTextField("1.0");
        voiceScaleTextField.setEditable(false);
        voiceScaleTextField.setHorizontalAlignment(JTextField.CENTER);
        voiceScaleTextField.setBackground(Color.LIGHT_GRAY);

        // music VOLUME TEXTFIELD
        musicVolumeTextField = new JTextField("1.0");
        musicVolumeTextField.setEditable(false);
        musicVolumeTextField.setHorizontalAlignment(JTextField.CENTER);
        musicVolumeTextField.setBackground(Color.LIGHT_GRAY);

        // SOUND DELAY TEXTFIELD
        soundDelayTextField = new JTextField("1.0");
        soundDelayTextField.setEditable(false);
        soundDelayTextField.setHorizontalAlignment(JTextField.CENTER);
        soundDelayTextField.setBackground(Color.LIGHT_GRAY);

        // ------------------- CHECKBOXES ---------------------------- //

        // VOICE ENABLE BOX
        voiceEnableBox = new JCheckBox("VOICE ENABLE");
        voiceEnableBox.setFocusable(false);

        // VOICE CHAT IN LOBBY BOX
        voiceChatInLobbyBox = new JCheckBox("VOICE CHAT IN LOBBY");
        voiceChatInLobbyBox.setFocusable(false);

        // MUTE GAME WHEN IN WINDOWS BOX
        muteGameWhenInWindowsBox = new JCheckBox("MUTE WHILE IN WINDOWS");
        muteGameWhenInWindowsBox.setFocusable(false);

        // ------------------- SLIDERS ---------------------------- //

        // VOLUME SLIDER
        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        volumeSlider.setToolTipText("0.0 - 1.0");
        volumeSlider.setFocusable(false);

        // VOICE SCALE SLIDER
        voiceScaleSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        voiceScaleSlider.setToolTipText("0.0 - 1.0");
        voiceScaleSlider.setFocusable(false);

        // music VOLUME SLIDER
        musicVolumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        musicVolumeSlider.setToolTipText("0.0 - 1.0");
        musicVolumeSlider.setFocusable(false);

        // SOUND DELAY SLIDER
        soundDelaySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
        soundDelaySlider.setToolTipText("0.0 - 1.0");
        soundDelaySlider.setFocusable(false);

        // =========================== VERTICALBOX ======================================== //

        //SET 1
        verticalBox.add(voiceEnableBox);
        verticalBox.add(voiceChatInLobbyBox);
        verticalBox.add(muteGameWhenInWindowsBox);

        //SET 2
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(volumeLabel);
        verticalBox.add(volumeSlider);
        verticalBox.add(volumeTextField);

        //SET 3
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(voiceScaleLabel);
        verticalBox.add(voiceScaleSlider);
        verticalBox.add(voiceScaleTextField);

        //SET 4
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(musicVolumeLabel);
        verticalBox.add(musicVolumeSlider);
        verticalBox.add(musicVolumeTextField);

        //SET 5
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(new JLabel("\n"));
        verticalBox.add(sounderDelayLabel);
        verticalBox.add(soundDelaySlider);
        verticalBox.add(soundDelayTextField);

        verticalBox.add(new JLabel("\n"));
        add(verticalBox);

        // ============================= LISTENERS ============================================ //

        VolumeSliderListener lister = new VolumeSliderListener();
        volumeSlider.addChangeListener(lister);
        voiceScaleSlider.addChangeListener(lister);
        musicVolumeSlider.addChangeListener(lister);
        soundDelaySlider.addChangeListener(lister);
    }

    public class VolumeSliderListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            Object source = e.getSource();

            if (source == volumeSlider) {
                int tmp = volumeSlider.getValue() / 10;
                if (tmp == 10) {
                    volumeTextField.setText("1.0");
                } else if (tmp == 0) {
                    volumeTextField.setText("0.0");
                } else {
                    volumeTextField.setText("0." + tmp);
                }
            } else if (source == voiceScaleSlider) {
                int tmp = voiceScaleSlider.getValue() / 10;
                if (tmp == 10) {
                    voiceScaleTextField.setText("1.0");
                } else if (tmp == 0) {
                    voiceScaleTextField.setText("0.0");
                } else {
                    voiceScaleTextField.setText("0." + tmp);
                }
            } else if (source == musicVolumeSlider) {
                int tmp = musicVolumeSlider.getValue() / 10;
                if (tmp == 10) {
                    musicVolumeTextField.setText("1.0");
                } else if (tmp == 0) {
                    musicVolumeTextField.setText("0.0");
                } else {
                    musicVolumeTextField.setText("0." + tmp);
                }

            } else if (source == soundDelaySlider) {
                int tmp = soundDelaySlider.getValue() / 10;
                if (tmp == 10) {
                    soundDelayTextField.setText("1.0");
                } else if (tmp == 0) {
                    soundDelayTextField.setText("0.0");
                } else {
                    soundDelayTextField.setText("0." + tmp);
                }
            }
        }

    }

    // ============================= GETTERS ============================================ //

    public JSlider getVolumeSlider() {
        return volumeSlider;
    }

    public JSlider getVoiceScaleSlider() {
        return voiceScaleSlider;
    }

    public JSlider getMusicVolumeSlider() {
        return musicVolumeSlider;
    }

    public JSlider getSoundDelaySlider() {
        return soundDelaySlider;
    }

    public JTextField getVolumeTextField() {
        return volumeTextField;
    }

    public JTextField getVoiceScaleTextField() {
        return voiceScaleTextField;
    }

    public JTextField getMusicVolumeTextField() {
        return musicVolumeTextField;
    }

    public JTextField getSoundDelayTextField() {
        return soundDelayTextField;
    }

    public JCheckBox getVoiceEnableBox() {
        return voiceEnableBox;
    }

    public JCheckBox getVoiceChatInLobbyBox() {
        return voiceChatInLobbyBox;
    }

    public JCheckBox getMuteGameWhenInWindowsBox() {
        return muteGameWhenInWindowsBox;
    }

}
