public class Main {

	public static void main(String args[]) {
		Map map = new Map();
		Ghost ghost = new Ghost(map, 7, 7, Direction.LEFT);
		Pacman pacman = new Pacman(map, 5, 5);

		GameRenderer renderer = new GameRenderer(pacman, ghost, map);

		GameRules gameRules = new GameRules(pacman, ghost);

		UserInput userInput = new UserInput();

		while (!gameRules.isGameOver()) {
			renderer.render();

			Command command = userInput.getCommand();
			gameRules.processCommand(command);
		}

		gameRules.endGame();
	}

}
