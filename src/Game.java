public class Game {
    Field field = new Field();
    Player player = new Player();
    Parser parser;
    String folder_levels = "";

    public Game() {
        this.folder_levels = "./Levels";
        this.parser = new Parser(folder_levels);
        this.parser.buildLevel(2, field, player);
    }

    public boolean posValide(int x, int y) {
        boolean first = x >= 0, second = x < this.field.getWidth(), third = y >= 0, fourth = y < this.field.getHeight();
        return (first && second && third && fourth);
        // return ((x >= 0) && (x <= this.field.getWidth()) && (y >= 0) && (y <= this.field.getHeight())); //&& (this.field.map[y][x].getType() == TypeCase.EMPTY));
    }

    public boolean moveplayer(Direction dir){
        int playerFuturePositionX, playerFuturePositionY;
        int playerActualPositionX = this.player.position.getX();
        int playerActualPositionY = this.player.position.getY();
        boolean boolPositionValidity = false;

        /*
        We look in which direction the player is moving
        depending on its displacement we assign -1 or 1 or 0 (depending on whether we are on X or Y) (with deltaX or deltaY)
        We add the current position the value of the displacement (-1 or 1 or 0)
        We store everything in a test variable for the 2 directions (X and Y)
        */
        playerFuturePositionX = playerActualPositionX + dir.getDeltaX();
        playerFuturePositionY = playerActualPositionY + dir.getDeltaY();

        /*
        If true we are on the field
        We check to which type of square the player is moving
        Otherwise we do nothing and we return false
        */
        if (posValide(playerFuturePositionX, playerFuturePositionY)){
            // TODO : Add new type case in Case methods
            Case playerFutureCase = field.map[playerFuturePositionY][playerFuturePositionX];
            Case playerActualCase = field.map[playerActualPositionY][playerActualPositionX];

            switch (playerFutureCase.getType()) {
                case EMPTY -> {
                    // Returns the player's Case to "empty"
                    playerActualCase.setType(TypeCase.TRACKPLAYER);
                    // Turns the futur player's Case to "Player"
                    playerFutureCase.setType(TypeCase.PLAYER);
                    this.player.position.setX(playerFuturePositionX);
                    this.player.position.setY(playerFuturePositionY);
                    boolPositionValidity = true;
                }
                case WALL, TRACKPLAYER -> {
                }
                case SPECIALBLOCK -> // Turns the SPECIALBLOCK into "empty" Case
                    playerFutureCase.setType(TypeCase.EMPTY);
                case SPECIALPASSAGE -> { // TODO : Check what we need to do with this one
                    // Returns the player's Case to "empty"
                    playerActualCase.setType(TypeCase.TRACKPLAYER);
                    // Turns the futur player's Case to "Player"
                    playerFutureCase.setType(TypeCase.PLAYER);
                    this.player.position.setX(playerFuturePositionX);
                    this.player.position.setY(playerFuturePositionY);
                }
            }
        }

        return boolPositionValidity;
    }
}
