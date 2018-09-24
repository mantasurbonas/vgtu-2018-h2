public class Main {

	public static void main (String args[]) throws Exception{
		
		Map map = new Map();
		Ghost ghost = new Ghost(7,7,-1,0);
		Pacman pacman = new Pacman(5, 5);
		
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
