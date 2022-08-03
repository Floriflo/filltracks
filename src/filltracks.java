public class filltracks {

	static char[][] grid = new char[4][3];
	static int rows = grid.length;
	static int cols = grid[0].length;
	static int posX = 4, posY = 1;
	
	public static void main(String[] args) {
		// Lancement du jeu
		InitGame();
		DisplayGameGrid();
	}
	
	/*
	 * MoveDown watch the next down case and move the player if possible
	 * If it's not possible, do nothing
	 * In case of a special case block, it does nothing for the player position but destroy the down case
	 * In case of a special case passage, it put the player on this case but put this one to open case, the next call to a move will fix the 'j' position in the grid
	 */
	static void MoveDown() {
		for(int j = posX-1; j < rows-1; j++) {	
				switch(grid[j+1][posY-1]) {
				case 'x':
					return;
				case 'o':
					if(grid[j][posY-1] == 'j') {
						grid[j][posY-1] = 'x'; // maj Player initial position replaced by a wall 
						grid[j+1][posY-1] = 'j'; //maj new Player position
						posX += 1; //maj new Player position
					}
					else {
						grid[j+1][posY-1] = 'j'; //maj new Player position
						posX += 1; //maj new Player position
					}
					break;
				case 'w':
					grid[j+1][posY-1] = 'o'; // maj right case to open case because special case block disapear when touched
					return;
				case 'p':
					grid[j][posY-1] = 'x'; // maj Player initial position replaced by a wall 
					grid[j+1][posY-1] = 'o'; //maj new Player position is open case because it's a special case with become open case if touched (you can go throught and left behind an open case
					posX += 1; //maj var posY*/
					break;
				}
			}
	}
	
	/*
	 * MoveUp watch the next up case and move the player if possible
	 * If it's not possible, do nothing
	 * In case of a special case block, it does nothing for the player position but destroy the up case
	 * In case of a special case passage, it put the player on this case but put this one to open case, the next call to a move will fix the 'j' position in the grid
	 */
	static void MoveUp() {
		for(int j = posX-1; j > 0; j--) {	
				switch(grid[j-1][posY-1]) {
				case 'x':
					return;
				case 'o':
					if(grid[j][posY-1] == 'j') {
						grid[j][posY-1] = 'x'; // maj Player initial position replaced by a wall 
						grid[j-1][posY-1] = 'j'; //maj new Player position
						posX -= 1; //maj new Player position
					}
					else {
						grid[j-1][posY-1] = 'j'; //maj new Player position
						posX -= 1; //maj new Player position
					}
					break;
				case 'w':
					grid[j-1][posY-1] = 'o'; // maj right case to open case because special case block disapear when touched
					return;
				case 'p':
					grid[j][posY-1] = 'x'; // maj Player initial position replaced by a wall 
					grid[j-1][posY-1] = 'o'; //maj new Player position is open case because it's a special case with become open case if touched (you can go throught and left behind an open case
					posX -= 1; //maj var posY*/
					break;
				}
			}
	}
	
	/*
	 * MoveLeft watch the next left case and move the player if possible
	 * If it's not possible, do nothing
	 * In case of a special case block, it does nothing for the player position but destroy the left case
	 * In case of a special case passage, it put the player on this case but put this one to open case, the next call to a move will fix the 'j' position in the grid
	 */
	static void MoveLeft() {
		for(int j = posY-1; j > 0; j--) {	
				switch(grid[posX-1][j-1]) {
				case 'x':
					return;
				case 'o':
					if(grid[posX-1][j] == 'j') {
						grid[posX-1][j] = 'x'; // maj Player initial position replaced by a wall 
						grid[posX-1][j-1] = 'j'; //maj new Player position
						posY -= 1; //maj new Player position
					}
					else {
						grid[posX-1][j-1] = 'j'; //maj new Player position
						posY -= 1; //maj new Player position
					}
					break;
				case 'w':
					grid[posX-1][j-1] = 'o'; // maj right case to open case because special case block disapear when touched
					return;
				case 'p':
					grid[posX-1][j] = 'x'; // maj Player initial position replaced by a wall 
					grid[posX-1][j-1] = 'o'; //maj new Player position is open case because it's a special case with become open case if touched (you can go throught and left behind an open case
					posY -= 1; //maj var posY*/
					break;
				}
			}
	}
	/*
	 * MoveRight watch the next right case and move the player if possible
	 * If it's not possible, do nothing
	 * In case of a special case block, it does nothing for the player position but destroy the right case
	 * In case of a special case passage, it put the player on this case but put this one to open case, the next call to a move will fix the 'j' position in the grid
	 */
	static void MoveRight() {
			for(int j = posY-1; j < cols-1; j++) {	
					switch(grid[posX-1][j+1]) {
					case 'x':
						return;
					case 'o':
						if(grid[posX-1][j] == 'j') {
							grid[posX-1][j] = 'x'; // maj Player initial position replaced by a wall 
							grid[posX-1][j+1] = 'j'; //maj new Player position
							posY += 1; //maj new Player position
						}
						else {
							grid[posX-1][j+1] = 'j'; //maj new Player position
							posY += 1; //maj new Player position
						}
						break;
					case 'w':
						grid[posX-1][j+1] = 'o'; // maj right case to open case because special case block disapear when touched
						return;
					case 'p':
						grid[posX-1][j] = 'x'; // maj Player initial position replaced by a wall 
						grid[posX-1][j+1] = 'o'; //maj new Player position is open case because it's a special case with become open case if touched (you can go throught and left behind an open case
						posY += 1; //maj var posY*/
						break;
					}
				}
	}
	
	// Do it with a FileReader .txt to init the gameGrid
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
	
	// Display the game grid with prints
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
}
