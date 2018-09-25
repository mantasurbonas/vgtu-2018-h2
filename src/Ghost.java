
public class Ghost extends GameEntity {
    private int xDirection;
    private int yDirection;
    private final Map map;

    public Ghost(Map map, int x, int y, Direction direction) {
        super(x, y);

        this.map = map;
        setDirection(direction);
    }

    public void move() {
        int nextX = getX() + xDirection;
        int nextY = getY() + yDirection;

        if (map.isWall(nextX, nextY)) {
            changeDirection();
        } else {
            setX(nextX);
            setY(nextY);
        }
    }

    private void setDirection(Direction direction) {
        switch (direction) {
            case RIGHT: xDirection = 1; yDirection = 0; break;
            case LEFT: xDirection = -1; yDirection = 0; break;
            case UP: xDirection = 0; yDirection = -1; break;
            case DOWN: xDirection = 0; yDirection = 1; break;
        }
    }

    private void changeDirection() {
        xDirection *= -1;
        yDirection *= -1;
    }
}