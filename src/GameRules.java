import java.io.IOException;

public class GameRules {

	private Map map;
	private Ghost ghost;
	private Pacman pacman;

	public GameRules(Pacman pacman, Ghost ghost, Map map) {
		this.pacman = pacman;
		this.ghost = ghost;
		this.map = map;
	}

	public boolean isGameOver() {
		return (pacman.getPacmanX() == ghost.getGhostX() && pacman.getPacmanY() == ghost.getGhostY());
	}

	public void endGame() throws SecurityException {
		System.out.println("GAME OVER!!!!");
		System.exit(0);
	}
	
	public void moveGhost() {
		int nextX = ghost.getGhostX() + ghost.getGhostDx();
		int nextY = ghost.getGhostY() + ghost.getGhostDy();
		
		if (map.isWall(nextX, nextY)) {
			ghost.setGhostDx(-1);
			ghost.setGhostDy(-1);
		}else {
			ghost.setGhostX(nextX);
			ghost.setGhostY(nextY);
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
		int nextX = pacman.getPacmanX() + dx;
		int nextY = pacman.getPacmanY() + dy;
		
		if (map.isWall(nextX, nextY))
			return;
		
		pacman.setPacmanX(nextX);
		pacman.setPacmanY(nextY);
	}
	

}
