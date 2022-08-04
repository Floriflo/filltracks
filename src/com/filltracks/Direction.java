package com.filltracks;

import java.awt.event.KeyEvent;

/**
 * Enumeration representing the direction the player is going
 */
public enum Direction {
    LEFT("Left", KeyEvent.VK_LEFT, -1, 0),
    RIGHT("Right", KeyEvent.VK_RIGHT, 1, 0),
    UP("Up", KeyEvent.VK_UP, 0, -1),
    DOWN("Down", KeyEvent.VK_DOWN, 0, 1);

    private String name;
    private int keyCode;
    private int deltaX;
    private int deltaY;

    /**
     * Direction enum constructor
     * @param name Name representing the different directional keys (Left, right, up, down)
     * @param keyCode Code representing the associated directional key
     * @param deltaX Movement delta along X axis
     * @param deltaY Movement delta along Y axis
     */
    private Direction(String name, int keyCode, int deltaX, int deltaY) {
        this.name = name;
        this.keyCode = keyCode;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    /**
     * Return name representing the different directional keys (Left, right, up, down)
     * @return a String
     */
    public String getName() {
        return name;
    }

    /**
     * Return the code representing the associated directional key
     * @return a int
     */
    public int getKeyCode() {
        return keyCode;
    }

    /**
     * Return delta movement along X axis
     * @return a int
     */
    public int getDeltaX() {
        return deltaX;
    }

    /**
     * Return delta movement along Y axis
     * @return a int
     */
    public int getDeltaY() {
        return deltaY;
    }
}
