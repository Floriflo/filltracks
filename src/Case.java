public class Case {
    private Position position = new Position(); // position dans le tableau
    private TypeCase type = TypeCase.EMPTY;

    public Case() {

    }

    public Case(int px, int py, char t){
        position = new Position(px, py);
        setTypeFromChar(t);
        // assigne les valeurs posx posy et type à partir de la lecture du fichier
    }

    /*
     * ChangeType change le type de case :
     * Si la case était libre, elle devient un mur
     * Si la case était un case spéciale double ou bloc, elle devient libre
     * Si c'est un mur, on ne fait rien
     */
    public static void changeType(Case C){
        if(C.type == TypeCase.EMPTY){
            C.type = TypeCase.PLAYER;
        } else { // If player or SPECIALBLOCK or SPECIALPASSAGE the box becomes empty
            C.type = TypeCase.EMPTY;
        }
    }

    public void setTypeFromChar(char t){
        String ty = String.valueOf(t);

        if (t == 'o'){
            this.type = TypeCase.EMPTY;
        } else{
            if (t == 'x'){
                this.type = TypeCase.WALL;
            }else {
                if (t == 'w') {
                    this.type = TypeCase.SPECIALBLOCK;
                } else {
                    if (t == 'j') {
                        this.type = TypeCase.PLAYER;
                    } else {
                        this.type = TypeCase.SPECIALPASSAGE;
                    }
                }
            }
        }
        /*
        switch (ty){
            case "o":
                this.type = 0;
            case "x":
                this.type = 1;
            case "s":
                this.type = 2;
        }*/
    }

    public Position getPosition(){
        return position;
    }

    public TypeCase getType(){
        return this.type;
    }

    public void setType(TypeCase type){
        this.type = type;
    }
}
