package com.filltracks;

import java.awt.event.KeyEvent;

public enum Direction {
    LEFT("Left", KeyEvent.VK_LEFT, -1, 0),
    RIGHT("Right", KeyEvent.VK_RIGHT, 1, 0),
    UP("Up", KeyEvent.VK_UP, 0, -1),
    DOWN("Down", KeyEvent.VK_DOWN, 0, 1);

    private String name;
    private int keyCode;
    private int deltaX;
    private int deltaY;
    private Direction(String name, int keyCode, int deltaX, int deltaY) {
        this.name = name;
        this.keyCode = keyCode;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
    public String getName() {
        return name;
    }
    public int getKeyCode() {
        return keyCode;
    }
    public int getDeltaX() {
        return deltaX;
    }
    public int getDeltaY() {
        return deltaY;
    }
}
