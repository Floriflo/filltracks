public class Player {
    Position position = new Position(); // position dans le tableau

    public Player() {

    }

    Player(int px, int py){
        position = new Position(px, py);
        // assigne les valeurs posx posy et type à partir de la lecture du fichier
    }

    Position getPosition(){
        return position;
    }
}
