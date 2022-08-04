package com.filltracks;

/**
 * Class representing a "unit" of the terrain
 */
public class Case {
    private Position position = new Position(); // position dans le tableau
    private TypeCase type = TypeCase.EMPTY;

    public Case() {

    }

    /**
     * Case class constructor
     * @param pX X coordinate of the Case
     * @param pY Y coordinate of the Case
     * @param t Type of the case of type TypeCase
     */
    public Case(int pX, int pY, char t){
        position = new Position(pX, pY);
        setTypeFromChar(t);
        // assigne les valeurs posx posy et type à partir de la lecture du fichier
    }

    /**
     * Set the type of the Case of type TypeCase (WALL, PLAYER, ...) from a char
     * @param typeChar char representing a type of Case on the map
     */
    public void setTypeFromChar(char typeChar){
        switch (typeChar){
            case 'x': {
                this.type = TypeCase.WALL;
                break;
            }
            case 'w': {
                this.type = TypeCase.SPECIALBLOCK;
                break;
            }
            case 'j': {
                this.type = TypeCase.PLAYER;
                break;
            }
            case 'p': {
                this.type = TypeCase.SPECIALPASSAGE;
                break;
            }
            // If we have no recognized character or if we have an 'o' character (which corresponds to empty) we put an empty box
            default:{
                this.type = TypeCase.EMPTY;
                break;
            }
        }
    }

    /**
     * Return the position of the Case
     * @return a Position
     */
    public Position getPosition(){
        return position;
    }

    /**
     * Return the type of the Case
     * @return a TypeCase
     */
    public TypeCase getType(){
        return this.type;
    }

    /**
     * Set the type of the Case of type TypeCase (WALL, PLAYER, ...)
     * @param type a TypeCase
     */
    public void setType(TypeCase type){
        this.type = type;
    }
}
