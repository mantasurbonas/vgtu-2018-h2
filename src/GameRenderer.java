
public class GameRenderer {

	private MazeMap mazeMap;
	private Ghost ghost;
	private Pacman pacman;

	public GameRenderer(Pacman pacman, Ghost ghost, MazeMap mazeMap) {
		this.pacman = pacman;
		this.ghost = ghost;
		this.mazeMap = mazeMap;
	}
	
	public void render() {
		for (int y = 0; y < mazeMap.getBadMap().length; y++) {
			for (int x = 0; x < mazeMap.getBadMap()[0].length; x++) {
				if (x == pacman.pacmanX && y == pacman.pacmanY) {
					System.out.print("C");
				} else if (x == ghost.ghostX && y == ghost.ghostY) {
					System.out.print("E");
				} else if (mazeMap.isWall(x, y)) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
