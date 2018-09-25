
public class Pacman extends GameEntity {
	private final Map map;

	public Pacman(Map map, int x, int y) {
		super(x, y);

		this.map = map;
	}

	public void move(Command command) {
		int dx = 0;
		int dy = 0;

		switch (command) {
			case UP:
				dy = -1;
				break;
			case DOWN:
				dy = 1;
				break;
			case LEFT:
				dx = -1;
				break;
			case RIGHT:
				dx = 1;
				break;
		}

		int nextX = getX() + dx;
		int nextY = getY() + dy;

		if (map.isWall(nextX, nextY))
			return;

		setX(nextX);
		setY(nextY);
	}
}
