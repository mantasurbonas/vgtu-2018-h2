package main;

public class Main {
	private static final int GHOST_X = 7;
	private static final int GHOST_Y = 7;
	private static final int GHOST_Dx = -1;
	private static final int GHOST_Dy = 0;
	private static final int PACMAN_X = 5;
	private static final int PACMAN_Y = 5;

	public static void main (String args[]) throws Exception{
		
		Map map = new Map();
		Ghost ghost = new Ghost(GHOST_X,GHOST_Y,GHOST_Dx,GHOST_Dy);
		Pacman pacman = new Pacman(PACMAN_X, PACMAN_Y);

		GameRenderer renderer = new GameRenderer(pacman, ghost, map);

		GameRules gameRules = new GameRules(pacman, ghost, map);

		UserInput userInput = new UserInput();
		
		while(true) {
		
			renderer.render();
			
			if (gameRules.isGameOver())
				gameRules.endGame();
			
			Command command = userInput.getCommand();
			gameRules.processCommand(command);
		
			gameRules.moveGhost();
		}


	}


}
