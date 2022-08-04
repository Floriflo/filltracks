package com.filltracks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

/**
 * Class to manage the display of the game on the graphical interface
 */
public class Window extends JPanel {
    boolean verboseDebug = true;
    public static final int CASE_WIDTH = 100;
    public static final int CASE_HEIGHT = CASE_WIDTH;

    private static final int PREF_W = 800;
    private static final int PREF_H = 650;

    private JLabel labelPosition = new JLabel("Label debug for position");
    public KeyPress keyPressObj = new KeyPress();

    protected Game game;

    /**
     * Window class constructor
     */
    public Window() {
        this.game = new Game(); // Create new com.filltracks.Game Object

        this.add(this.labelPosition); // add label1 to JFrame
    }

    /**
     * Returns the window's preferred dimensions in a dimension object
     * @return a Dimension
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    /**
     * Allows you to "paint" items in the window from a copy of the window's Graphics object
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int positionCaseX = 0, positionCaseY = 0;

        System.out.println();

        // We draw the com.filltracks.Case of the field
        for (int y = 0; y < game.field.getHeight(); y++){
            for (int x = 0; x < game.field.getWidth(); x++) {
                positionCaseX = CASE_WIDTH *x;
                positionCaseY = CASE_HEIGHT *y;

                // Color the rectangle the right color
                switch (game.field.map[y][x].getType()) {
                    case PLAYER: {
                        g.setColor(Color.RED);
                        break;
                    }

                    case EMPTY: {
                        g.setColor(Color.WHITE);
                        break;
                    }
                    case WALL: {
                        g.setColor(new Color(139, 69, 19));
                        break;
                    }
                    case TRACKPLAYER: {
                        g.setColor(Color.PINK);
                        break;
                    }
                    case SPECIALBLOCK: {
                        g.setColor(Color.BLACK);
                        break;
                    }
                    case SPECIALPASSAGE: {
                        g.setColor(Color.YELLOW);
                        break;
                    }
                }

                // Draw square with correct coordinate and width/height
                g.fillRect(positionCaseX, positionCaseY, CASE_WIDTH, CASE_HEIGHT);

                if (verboseDebug) {
                    System.out.println("(" + x + ", " + y + ") : " + game.field.map[y][x].getType()
                            + " : (" + positionCaseX + ", " + positionCaseY + ")");
                }
            }
        }

        if (verboseDebug) {
            labelPosition.setText("com.filltracks.Position Joueur : X : " + game.player.position.getX() + " Y : " + game.player.position.getY());
        }
    }

    /**
     * Method to retrieve keys pressed by player
     */
    private class KeyPress extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == Direction.UP.getKeyCode()) {
                game.moveplayer(Direction.UP);
                if (verboseDebug) {
                    System.out.println("Up Arrrow-Key is pressed!");
                }
            }
            else if (keyCode == Direction.DOWN.getKeyCode()) {
                game.moveplayer(Direction.DOWN);
                if (verboseDebug) {
                    System.out.println("Down Arrrow-Key is pressed!");
                }
            }
            else if (keyCode == Direction.LEFT.getKeyCode()) {
                game.moveplayer(Direction.LEFT);
                if (verboseDebug) {
                    System.out.println("Left Arrrow-Key is pressed!");
                }
            }
            else if (keyCode == Direction.RIGHT.getKeyCode()) {
                game.moveplayer(Direction.RIGHT);
                if (verboseDebug) {
                    System.out.println("Right Arrrow-Key is pressed!");
                }
            }

            // Call the method to update the display
            repaint();
        }
    }
}