public class Field {
    int width;
    int height;
    Case[][] map;
    //Joueur playeur;

    public Field(){

    }

    public void Field(int w, int h, Case[][] m){
        width = w;
        height = h;
        map = m;
    }


    int getWidth(){
        return width;
    }

    int getHeight(){
        return height;
    }

    Case[][] getMap(){
        return map;
    }
}