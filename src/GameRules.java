import java.io.IOException;

public class GameRules {

	private MazeMap mazeMap;
	private Ghost ghost;
	private Pacman pacman;

	public GameRules(Pacman pacman, Ghost ghost, MazeMap mazeMap) {
		this.pacman = pacman;
		this.ghost = ghost;
		this.mazeMap = mazeMap;
	}

	public boolean isGameOver() {
		return (pacman.pacmanX == ghost.ghostX && pacman.pacmanY == ghost.ghostY);
	}

	public void endGame() throws IOException {
		System.out.println("GAME OVER!!!!");
		System.exit(0);
	}
	
	public void moveGhost() {
		int nextX = ghost.ghostX + ghost.ghostDx;
		int nextY = ghost.ghostY + ghost.ghostDy;
		
		if (mazeMap.isWall(nextX, nextY)) {
			ghost.ghostDx *= -1;
			ghost.ghostDy *= -1;
			
		}else {
			ghost.ghostX = nextX;
			ghost.ghostY = nextY;
		}				
	}

	public void processCommand(Command command) throws Exception{
		switch(command) {
		case DOWN:
			tryMovePacman(0, 1);
			break;
		case LEFT:
			tryMovePacman(-1, 0);
			break;
		case NOTHING:
			break;
		case QUIT:
			endGame();
			break;
		case RIGHT:
			tryMovePacman(1, 0);
			break;
		case UP:
			tryMovePacman(0, -1);
			break;
		default:
			break;
		
		}
	}

	private void tryMovePacman(int dx, int dy) {
		int nextX = pacman.pacmanX + dx;
		int nextY = pacman.pacmanY + dy;
		
		if (mazeMap.isWall(nextX, nextY))
			return;
		
		pacman.setPacmanX(nextX);
		pacman.setPacmanY(nextY);
	}
	

}
