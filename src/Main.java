import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static int MAP [][] = new int [][] {
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,1,1,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
		{1,0,0,0,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1},
		{1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
		{1,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
		{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	};
	
	static int ghostX = 7;
	static int ghostY = 7;
	
	static int ghostDx = 0;
	static int ghostDy = 1;
	
	public static void main (String args[]) throws IOException{
		int pacmanX = 5; 
		int pacmanY = 5;
		
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
		
			render(pacmanX, pacmanY, ghostX, ghostY);
			
			if (ghostCaughtPacman(pacmanX, pacmanY))
				endGame();
			
			int n = scanner.next().charAt(0);
			
			processUserInput(n, pacmanX, pacmanY);
		
			moveGhost();
		}
	}


	private static boolean ghostCaughtPacman(int pacmanX, int pacmanY) throws IOException {
		return (pacmanX == ghostX && pacmanY == ghostY);
	}

	private static void endGame() throws IOException {
			System.out.println("GAME OVER!!!!");
			System.in.read();
			System.exit(0);
	}
	

	private static void moveGhost() {
		int nextX = ghostX + ghostDx;
		int nextY = ghostY + ghostDy;
		
		if (MAP[nextY][nextX] == 1) {
			ghostDx *= -1;
			ghostDy *= -1;
			
		}else {
			ghostX = nextX;
			ghostY = nextY;
		}		
	}


	private static void processUserInput(int n, int pacmanX, int pacmanY) {
		switch(n) {
		case 'a':
			if (MAP[pacmanY][pacmanX-1]==0)
				pacmanX -= 1;
			break;
		case 'd':
			if (MAP[pacmanY][pacmanX+1]==0)
				pacmanX += 1;
			break;
		case 'w':
			if (MAP[pacmanY-1][pacmanX]==0)
				pacmanY -=1;
			break;
		case 's':
			if (MAP[pacmanY+1][pacmanX]==0)
				pacmanY +=1;
			break;
		case 'q':
			System.exit(1);
		}		
	}

	private static void render(int pacmanX, int pacmanY, int ghostX, int ghostY) {
		for(int y = 0; y<MAP.length; y++) {
			for (int x=0; x<MAP[0].length; x++) {
				if (x==pacmanX && y == pacmanY) {
					System.out.print("C");
				}
				else
				if (x==ghostX && y == ghostY) {
					System.out.print("E");
				}
				else
				if (MAP[y][x] == 1) {
					System.out.print("#");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
