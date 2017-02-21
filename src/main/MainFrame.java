package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1453023172562886029L;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("CS:GO Autoexec Generator");
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setSize(375, 555);
                Dimension windowSizeDimension = Toolkit.getDefaultToolkit().getScreenSize();
                int centerWindowXAxis = (int) (windowSizeDimension.getWidth() / 2 - frame.getWidth() / 2);
                int centerWindowYAxis = (int) (windowSizeDimension.getHeight() / 2 - frame.getHeight() / 2);
                frame.setLocation(centerWindowXAxis, centerWindowYAxis);
                JTabbedPane panelTabs = new JTabbedPane(JTabbedPane.LEFT);

                panelTabs.setFocusable(false);

                RatesTab ratesTab = new RatesTab();
                RadarTab radarTab = new RadarTab();
                VideoTab videoTab = new VideoTab();
                VolumeTab volumeTab = new VolumeTab();
                CrosshairTab crosshairTab = new CrosshairTab();
                MouseTab mouseTab = new MouseTab();

                panelTabs.addTab("MOUSE", null, mouseTab);
                panelTabs.addTab("VOLUME", null, volumeTab);
                panelTabs.addTab("VIDEO", null, videoTab);
                panelTabs.addTab("CROSSHAIR", null, crosshairTab);
                panelTabs.addTab("RATES", null, ratesTab);
                panelTabs.addTab("RADAR", null, radarTab);

                Font oldFont = ratesTab.getFont();
                Font newFont = new Font(oldFont.getFontName(), Font.PLAIN, 13);
                panelTabs.setFont(newFont);

                frame.add(panelTabs);
                frame.add(new ButtonsBar(ratesTab, radarTab, videoTab, crosshairTab, volumeTab, mouseTab),
                        BorderLayout.SOUTH);
                frame.setJMenuBar(MenuBar.createMenuBar(frame));
                frame.setVisible(true);
            }
        });

    }
}
