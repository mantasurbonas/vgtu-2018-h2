import java.util.Scanner;

public class UserInput {

	private Scanner scanner = new Scanner(System.in);
	
	public Command getCommand() {
		char n = scanner.next().charAt(0);
		return getCommand(n);
	}

	public Command getCommand(char keyChar) {
		switch(keyChar) {
		case 'a':
			return Command.LEFT;
		case 'd':
			return Command.RIGHT;
		case 'w':
			return Command.UP;
		case 's':
			return Command.DOWN;
		case 'q':
			return Command.QUIT;
		default:
			return Command.NOTHING;
		}	
	}

}
