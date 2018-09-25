public class GameRules {

    private final Ghost ghost;
    private final Pacman pacman;

    public GameRules(Pacman pacman, Ghost ghost) {
        this.pacman = pacman;
        this.ghost = ghost;
    }

    public boolean isGameOver() {
        return (pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY());
    }

    public void endGame() throws SecurityException {
        System.out.println("GAME OVER!!!!");
        System.exit(0);
    }

    public void processCommand(Command command) {
        ghost.move();
        pacman.move(command);
    }
}
