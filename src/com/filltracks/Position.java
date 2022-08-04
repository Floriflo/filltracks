package com.filltracks;

public class Position {
    private int x = 0;
    private int y = 0;

    public Position() {

    }

    public Position(int posx, int posy) {
        x = posx;
        y = posy;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int posX){
        x = posX;
    }

    public void setY(int posY){
        y = posY;
    }
}
