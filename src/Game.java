public class Game {
    Field field = new Field();
    Player player = new Player();
    Parser parser;
    String folder_levels = "";

    public Game() {
        folder_levels = "./Levels";
        parser = new Parser(folder_levels);
        parser.buildLevel(1, field, player);
    }

    /*
	 * MoveDown watch the next down case and move the player if possible
	 * If it's not possible, do nothing
	 * In case of a special case block, it does nothing for the player position but destroy the down case
	 * In case of a special case passage, it put the player on this case but put this one to open case, the next call to a move will fix the 'j' position in the grid
	 */
	public void MoveDown() {
		for(int j = player.position.x-1; j < field.width-1; j++) {
			switch(field.map[j+1][player.position.y-1].temp) {
			case 'x':
				return;
			case 'o':
				if(field.map[j][player.position.y-1].temp == 'j') {
					field.map[j][player.position.y-1].temp = 'x'; // maj Player initial position replaced by a wall 
					field.map[j+1][player.position.y-1].temp = 'j'; //maj new Player position
					player.position.x += 1; //maj new Player position
				}
				else {
					field.map[j+1][player.position.y-1].temp = 'j'; //maj new Player position
					player.position.x += 1; //maj new Player position
				}
				break;
			case 'w':
                field.map[j+1][player.position.y-1].temp = 'o'; // maj right case to open case because special case block disapear when touched
				return;
			case 'p':
                field.map[j][player.position.y-1].temp = 'x'; // maj Player initial position replaced by a wall 
				field.map[j+1][player.position.y-1].temp = 'o'; //maj new Player position is open case because it's a special case with become open case if touched (you can go throught and left behind an open case
				player.position.x += 1; //maj var py
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
    public void MoveUp() {
		for(int j = player.position.x-1; j > 0; j--) {
			switch(field.map[j-1][player.position.y-1].temp) {
			case 'x':
				return;
			case 'o':
				if(field.map[j][player.position.y-1].temp == 'j') {
					field.map[j][player.position.y-1].temp = 'x'; // maj Player initial position replaced by a wall 
					field.map[j-1][player.position.y-1].temp = 'j'; //maj new Player position
					player.position.x -= 1; //maj new Player position
				}
				else {
					field.map[j-1][player.position.y-1].temp = 'j'; //maj new Player position
					player.position.x -= 1; //maj new Player position
				}
				break;
			case 'w':
                field.map[j-1][player.position.y-1].temp = 'o'; // maj right case to open case because special case block disapear when touched
				return;
			case 'p':
                field.map[j][player.position.y-1].temp = 'x'; // maj Player initial position replaced by a wall 
				field.map[j-1][player.position.y-1].temp = 'o'; //maj new Player position is open case because it's a special case with become open case if touched (you can go throught and left behind an open case
				player.position.x -= 1; //maj var px
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
	public void MoveLeft() {
		for(int j = player.position.y-1; j > 0; j--) {	
				switch(field.map[player.position.x-1][j-1].temp) {
				case 'x':
					return;
				case 'o':
					if(field.map[player.position.x-1][j].temp == 'j') {
						field.map[player.position.x-1][j].temp = 'x'; // maj Player initial position replaced by a wall 
						field.map[player.position.x-1][j-1].temp = 'j'; //maj new Player position
						player.position.y -= 1; //maj new Player position
					}
					else {
						field.map[player.position.x-1][j-1].temp = 'j'; //maj new Player position
						player.position.y -= 1; //maj new Player position
					}
					break;
				case 'w':
					field.map[player.position.x-1][j-1].temp = 'o'; // maj right case to open case because special case block disapear when touched
					return;
				case 'p':
                    field.map[player.position.x-1][j].temp = 'x'; // maj Player initial position replaced by a wall 
                    field.map[player.position.x-1][j-1].temp = 'o'; //maj new Player position is open case because it's a special case with become open case if touched (you can go throught and left behind an open case
					player.position.y -= 1; //maj var py
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
    public void MoveRight() {
		for(int j = player.position.y-1; j < field.height-1; j++) {	
				switch(field.map[player.position.x-1][j+1].temp) {
				case 'x':
					return;
				case 'o':
					if(field.map[player.position.x-1][j].temp == 'j') {
						field.map[player.position.x-1][j].temp = 'x'; // maj Player initial position replaced by a wall 
						field.map[player.position.x-1][j+1].temp = 'j'; //maj new Player position
						player.position.y += 1; //maj new Player position
					}
					else {
						field.map[player.position.x-1][j+1].temp = 'j'; //maj new Player position
						player.position.y += 1; //maj new Player position
					}
					break;
				case 'w':
					field.map[player.position.x-1][j+1].temp = 'o'; // maj right case to open case because special case block disapear when touched
					return;
				case 'p':
                    field.map[player.position.x-1][j].temp = 'x'; // maj Player initial position replaced by a wall 
                    field.map[player.position.x-1][j+1].temp = 'o'; //maj new Player position is open case because it's a special case with become open case if touched (you can go throught and left behind an open case
					player.position.y += 1; //maj var py
					break;
				}
			}
	}
}  