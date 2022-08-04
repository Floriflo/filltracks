package com.filltracks;

/**
 * Class allowing to manage the evolution of the game
 */
public class Game {
    Field field = new Field();
    Player player = new Player();
    Parser parser;
    String folder_levels = "";

    private static TypeCase previousTypeCase = TypeCase.EMPTY;

    /**
     * Game class constructor
     */
    public Game() {
        this.folder_levels = "./Levels";
        this.parser = new Parser(folder_levels);
        this.parser.buildLevel(2, field, player);
    }

    /**
     * Checks if the transmitted position does not go out of the map
     * @param x X coordinate of the position givent
     * @param y Y coordinate of the position givent
     * @return a boolean to know if the position is valid
     */
    public boolean posValide(int x, int y) {
        boolean first = x >= 0, second = x < this.field.getWidth(), third = y >= 0, fourth = y < this.field.getHeight();
        return (first && second && third && fourth);
        // return ((x >= 0) && (x <= this.field.getWidth()) && (y >= 0) && (y <= this.field.getHeight())); //&& (this.field.map[y][x].getType() == com.filltracks.TypeCase.EMPTY));
    }

    /**
     * Modifies the position of the player and the types of Cases on the map depending
     * on the direction the player wishes to take
     * @param dir Direction that the player wants to take (LEFT, RIGHT, ...)
     */
    public void moveplayer(Direction dir){
        int playerFuturePositionX, playerFuturePositionY;
        int playerActualPositionX, playerActualPositionY;
        // Storage of the future Case type for next move

        boolean moveNotEnd = true;

        // As long as we can move in the same direction we move forward otherwise we stop
        do{
            /*
            We look in which direction the player is moving
            depending on its displacement we assign -1 or 1 or 0 (depending on whether we are on X or Y) (with deltaX or deltaY)
            We add the current position the value of the displacement (-1 or 1 or 0)
            We store everything in a test variable for the 2 directions (X and Y)
            */
            playerActualPositionX = this.player.position.getX();
            playerActualPositionY = this.player.position.getY();
            playerFuturePositionX = playerActualPositionX + dir.getDeltaX();
            playerFuturePositionY = playerActualPositionY + dir.getDeltaY();

            /*
            If true we are on the field
            We check to which type of square the player is moving
            Otherwise we do nothing and we return false
            */
            if (posValide(playerFuturePositionX, playerFuturePositionY)){
                // TODO : Add new type case in com.filltracks.Case methods
                Case playerFutureCase = field.map[playerFuturePositionY][playerFuturePositionX];
                Case playerActualCase = field.map[playerActualPositionY][playerActualPositionX];

                switch (playerFutureCase.getType()) {
                    case EMPTY: {
                        if(previousTypeCase == TypeCase.SPECIALPASSAGE){
                            // Returns the player's Case to "EMPTY" because we were
                            // at the last move on a "SPECIALPASSAGE" Case
                            playerActualCase.setType(TypeCase.EMPTY);
                        } else {
                            // Returns the player's Case to "TRACKPLAYER"
                            playerActualCase.setType(TypeCase.TRACKPLAYER);
                        }

                        // Storage of the future Case type for next move
                        previousTypeCase = playerFutureCase.getType();

                        // Turns the futur player's Case to "PLAYER"
                        playerFutureCase.setType(TypeCase.PLAYER);
                        this.player.position.setX(playerFuturePositionX);
                        this.player.position.setY(playerFuturePositionY);
                        break;
                    }
                    case SPECIALBLOCK: {
                        /*
                        The SPECIALBLOCK Case becomes empty when you try to pass over it,
                        the player stays in the Case. The player remains in the Case where
                        he was before going to the SPECIALBLOCK Case.
                        The next time he goes in the same direction he can move forward
                        because there is no more SPECIALBLOCK (It's a EMPTY Case now).

                        w : SPECIALBLOCK
                        j : PLAYER
                        t : TRACKPLAYER
                        o : EMPTY
                        1.
                        o|j|w|o|
                        o|o|o|o|
                        2.
                        o|j|o|o|
                        o|o|o|o|
                        3.
                        o|o|j|o|
                        o|o|o|o|

                        We don't change the position and the variable "previousTypeCase" here because
                        if we had a SPECIALBLOCK we stay in the same place so the previous move we don't care.
                        */
                        playerFutureCase.setType(TypeCase.EMPTY);
                        moveNotEnd = false;
                        break;
                    }
                    case SPECIALPASSAGE: {
                        /*
                        The SPECIALPASSAGE Case becomes empty once you pass over it.
                        p : SPECIALPASSAGE
                        j : PLAYER
                        t : TRACKPLAYER
                        o : EMPTY
                        1.
                        j|p|o|
                        o|o|o|
                        2.
                        t|j|o|
                        o|o|o|
                        3.
                        t|o|j|
                        o|o|o|

                        The next square is a SPECIALPASSAGE so we will keep in mind
                        that we have passed over it, on the next "valid" move we
                        replace it with an empty Case
                        */
                        // Returns the player's com.filltracks.Case to "TRACKPLAYER"
                        playerActualCase.setType(TypeCase.TRACKPLAYER);
                        // Storage of the future Case type for next move
                        previousTypeCase = playerFutureCase.getType();

                        // Turns the futur player's Case to "PLAYER"
                        playerFutureCase.setType(TypeCase.PLAYER);
                        this.player.position.setX(playerFuturePositionX);
                        this.player.position.setY(playerFuturePositionY);
                        break;
                    }
                    default: { // PLAYER, WALL
                        // Storage of the future Case type for next move
                        previousTypeCase = playerFutureCase.getType();

                        moveNotEnd = false;
                        break;
                    }
                }
            }
            else {
                moveNotEnd = false;
            }
        }while(moveNotEnd);
    }
}
