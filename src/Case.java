public class Case {
    int posx, posy; // position dans le tableau
    char type;

    Case(){
        // assigne les valeurs posx posy et type à partir de la lecture du fichier
    }

    /*
     * ChangeType change le type de case :
     * Si la case était libre, elle devient un mur
     * Si la case était un case spéciale double ou bloc, elle devient libre
     * Si c'est un mur, on ne fait rien
     */
    void ChangeType(Case C){
        if(C.type == 'o'){
            C.type = 'x';
        } else {
            if(C.type == 'p' || C.type == 'w'){
                C.type = 'o';
            }
        }
    }

    int GetX(){
        return this.posx;
    }

    int GetY(){
        return this.posy;
    }

    char GetType(){
        return this.type;
    }
}
