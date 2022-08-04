package com.filltracks;

import javax.swing.*;

public class Main {
    /**
     * Program input method
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }

    /**
     * Creation and display of the GUI
     */
    private static void createAndShowGui() {
        Window mainPanel = new Window();

        JFrame frame = new JFrame("Fill Tracks !!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.addKeyListener(mainPanel.keyPressObj);

        frame.setVisible(true);
    }
}