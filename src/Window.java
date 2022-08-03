import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.EnumMap;
import java.util.Map;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

// @SuppressWarnings("serial")
public class Window extends JPanel {
    public static final int CASE_WIDTH = 100;
    public static final int CASE_HEIGHT = CASE_WIDTH;

    private static final int PREF_W = 800;
    private static final int PREF_H = 650;

    private JLabel labelPosition = new JLabel("Label debug for position");
    public KeyPress keyPressObj = new KeyPress();

    protected Game game;

    public Window() {
        this.game = new Game(); // Create new Game Object

        this.add(this.labelPosition); // add label1 to JFrame
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int positionCaseX = 0, positionCaseY = 0;

        System.out.println();

        // We draw the Case of the field
        for (int y = 0; y < game.field.getHeight(); y++){
            for (int x = 0; x < game.field.getWidth(); x++) {
                positionCaseX = CASE_WIDTH *x;
                positionCaseY = CASE_HEIGHT *y;

                // Color the rectangle the right color
                switch (game.field.map[y][x].getType()) {
                    case PLAYER -> g.setColor(Color.RED);

                    case EMPTY -> g.setColor(Color.WHITE);
                    case WALL -> g.setColor(new Color(139, 69, 19));
                    case TRACKPLAYER -> g.setColor(Color.PINK);
                    case SPECIALBLOCK -> g.setColor(Color.BLACK);
                    case SPECIALPASSAGE -> g.setColor(Color.YELLOW);
                }
                
                // Draw square with correct coordinate and width/height
                g.fillRect(positionCaseX, positionCaseY, CASE_WIDTH, CASE_HEIGHT);
                System.out.println("(" + x + ", " + y + ") : " + game.field.map[y][x].getType()
                        + " : (" + positionCaseX + ", " + positionCaseY + ")");
            }
        }

        labelPosition.setText("Position Joueur : X : " + game.player.position.getX() + " Y : " + game.player.position.getY());
    }

    private class KeyPress extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == Direction.UP.getKeyCode()) {
                game.moveplayer(Direction.UP);
                System.out.println("Up Arrrow-Key is pressed!");
            }
            else if (keyCode == Direction.DOWN.getKeyCode()) {
                game.moveplayer(Direction.DOWN);
                System.out.println("Down Arrrow-Key is pressed!");
            }
            else if (keyCode == Direction.LEFT.getKeyCode()) {
                game.moveplayer(Direction.LEFT);
                System.out.println("Left Arrrow-Key is pressed!");
            }
            else if (keyCode == Direction.RIGHT.getKeyCode()) {
                game.moveplayer(Direction.RIGHT);
                System.out.println("Right Arrrow-Key is pressed!");
            }

            repaint();
        }
    }
}