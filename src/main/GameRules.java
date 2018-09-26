package main;

import java.io.IOException;
import java.security.Key;

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
		return (pacman.pacmanX == ghost.ghostX && pacman.pacmanY == ghost.ghostY);
	}

	public void endGame() throws GameOverException {
		System.out.println("GAME OVER!!!!");
		System.exit(0);
	}

	public void moveGhost() {
		int nextX = ghost.ghostX + ghost.ghostDx;
		int nextY = ghost.ghostY + ghost.ghostDy;
		
		if (map.isWall(nextX, nextY)) {
			ghost.ghostDx *= -1;
			ghost.ghostDy *= -1;
			
		}else {
			ghost.ghostX = nextX;
			ghost.ghostY = nextY;
		}				
	}

	public void processCommand(Command command) throws KeyTypedException{
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

	private class KeyTypedException extends RuntimeException {
		public KeyTypedException(Throwable error) {
			super(error);
		}
	}

	private void tryMovePacman(int dx, int dy) {
		int nextX = pacman.pacmanX + dx;
		int nextY = pacman.pacmanY + dy;
		
		if (map.isWall(nextX, nextY))
			return;
		
		pacman.setPacmanX(nextX);
		pacman.setPacmanY(nextY);
	}

	private class GameOverException extends RuntimeException {
		public GameOverException(Throwable error) {
			super(error);
		}
	}

}
