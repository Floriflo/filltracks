package com.filltracks;

/**
 * Class representing the map of a level
 */
public class Player {
    Position position = new Position(); // position dans le tableau

    public Player() {

    }

    /**
     * Player class constructor
     * @param pX X coordinate of the Case
     * @param pY Y coordinate of the Case
     */
    Player(int pX, int pY){
        position = new Position(pX, pY);
        // assigne les valeurs posx posy et type à partir de la lecture du fichier
    }

    /**
     * Return the position of the Case
     * @return a Position
     */
    Position getPosition(){
        return position;
    }
}
