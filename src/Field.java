public class Field {
    int width;
    int height;
    Case[][] map;
    //Joueur playeur;

    public Field(){

    }

    // I modified this to be a constructor
    public void Init(int w, int h, Case[][] m){
        width = w;
        height = h;
        map = m;
    }

    public void DisplayGameGrid() {
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height-1; j++) {
				System.out.print(map[i][j].temp);
			}
			System.out.println(map[i][height-1].temp);
		}
        Line();
	}

	public void Line() {
		System.out.println("-------------------------------------------");
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