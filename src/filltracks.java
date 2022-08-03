public class filltracks {

	static char[][] grid = new char[4][3];
	static int rows = grid.length;
	static int cols = grid[0].length;
	static int posX = 4, posY = 1;
	
	public static void main(String[] args) {
		// Initialise the Game
		Game filltracks = new Game();

		// Lancement du jeu
		filltracks.field.DisplayGameGrid();
		filltracks.MoveRight();
		filltracks.field.DisplayGameGrid();
		filltracks.MoveUp();
		filltracks.field.DisplayGameGrid();
		filltracks.MoveLeft();
		filltracks.field.DisplayGameGrid();
	}
	
	/* TO DO : Do it with a FileReader .txt to init the gameGrid
	 * DONE : Florian did the FileReader with the class Parser.java
	 * This function don't belong to exist now
	 */

	/*
	static void InitGame() {
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				grid[i][j]='o';
			}
		}
		grid[posX-1][posY-1]='j';
		
		grid[1][0]='x';
		grid[1][1]='x';
		grid[2][0]='x';
		grid[2][1]='x';
	}
	*/

	// Display the game grid with prints
	/*
	 * These functions belong to the class Field because it display the field of the game
	 * I moved this function in the class Field and adapted to the Case map[][] with the class Case
	 */
	
	/*
	static void DisplayGameGrid() {
		// System.out.println("nbLines = " + rows + " et nbCols = " + cols);
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols-1; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println(grid[i][cols-1]);
		}
	}
	
	static void Line() {
		System.out.println("-------------------------------------------");
	}
	*/
}
