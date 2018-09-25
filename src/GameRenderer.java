
public class GameRenderer {

    private final Map map;
    private final Ghost ghost;
    private final Pacman pacman;

    public GameRenderer(Pacman pacman, Ghost ghost, Map map) {
        this.pacman = pacman;
        this.ghost = ghost;
        this.map = map;
    }

    public void render() {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                if (x == pacman.getX() && y == pacman.getY()) {
                    System.out.print("C");
                } else if (x == ghost.getX() && y == ghost.getY()) {
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
}
