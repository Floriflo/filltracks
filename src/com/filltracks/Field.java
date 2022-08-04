package com.filltracks;

/**
 * Class representing the map of a level
 */
public class Field {
    int width;
    int height;
    Case[][] map;
    //Joueur playeur;

    /**
     * Field class constructor
     */
    public Field(){

    }

    /**
     * Field class constructor
     * @param w Map width
     * @param h Card Height
     * @param m Case array representing the map
     */
    public void Field(int w, int h, Case[][] m){
        width = w;
        height = h;
        map = m;
    }


    /**
     * Return the map width
     * @return a int
     */
    public int getWidth(){
        return width;
    }

    /**
     * Return the map height
     * @return a int
     */
    public int getHeight(){
        return height;
    }

    /**
     * Return the Case array representing the map
     * @return a Case[][]
     */
    public Case[][] getMap(){
        return map;
    }
}