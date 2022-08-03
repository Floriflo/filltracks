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


    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Case[][] getMap(){
        return map;
    }
}