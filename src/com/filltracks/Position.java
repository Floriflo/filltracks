package com.filltracks;

/**
 * Class representing the position of a game element
 */
public class Position {
    private int x = 0;
    private int y = 0;

    public Position() {

    }

    /**
     * Position class constructor
     * @param posX X coordinate
     * @param posY Y coordinate
     */
    public Position(int posX, int posY) {
        x = posX;
        y = posY;
    }

    /**
     * @return X coordinate
     */
    public int getX(){
        return x;
    }

    /**
     * @return Y coordinate
     */
    public int getY(){
        return y;
    }

    /**
     * Set the X coordinate of the position
     * @param posX X coordinate
     */
    public void setX(int posX){
        x = posX;
    }

    /**
     * Set the Y coordinate of the position
     * @param posY Y coordinate
     */
    public void setY(int posY){
        y = posY;
    }
}
