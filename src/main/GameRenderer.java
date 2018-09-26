package main;

public class GameRenderer {

	private Map map;
	private Ghost ghost;
	private Pacman pacman;

	public GameRenderer(Pacman pacman, Ghost ghost, Map map) {
		this.pacman = pacman;
		this.ghost = ghost;
		this.map = map;
	}
	
	public void render() {
		for (int y = 0; y < map.getHeight(); y++) {
			for (int x = 0; x < map.getWidth(); x++) {
				if (isEqualToPacmanCoords(y, x)) {
					System.out.print("C");
				} else if (isEqualToGhostCoords(y, x)) {
					System.out.print("E");
				} else if (map.isWall(x, y)) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private boolean isEqualToGhostCoords(int y, int x) {
		return x == ghost.ghostX && y == ghost.ghostY;
	}

	private boolean isEqualToPacmanCoords(int y, int x) {
		return x == pacman.pacmanX && y == pacman.pacmanY;
	}
}
