public class Case {
    Position position; // position dans le tableau
    TypeCase type;

    Case(int px, int py, char t){
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
    void changeType(Case C){
        if(C.type == TypeCase.EMPTY){
            C.type = TypeCase.WALL;
        } else {
            if(C.type == TypeCase.SPECIAL || C.type == TypeCase.WALL){
                C.type = TypeCase.SPECIAL;
            }
        }
    }

    void setTypeFromChar(char t){
        String ty = String.valueOf(t);

        if (t == 'o'){
            this.type = TypeCase.EMPTY;
        } else{
            if (t == 'x'){
                this.type = TypeCase.WALL;
            }else {
                this.type = TypeCase.SPECIAL;
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

    Position getPosition(){
        return position;
    }

    TypeCase getType(){
        return this.type;
    }
}
