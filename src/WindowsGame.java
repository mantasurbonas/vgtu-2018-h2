import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class WindowsGame extends JFrame implements KeyListener{

	Map map = new Map();
	Ghost ghost = new Ghost(7,7,-1,0);
	Pacman pacman = new Pacman(5, 5);
	
	UserInput userInput = new UserInput();
	GameRules gameRules = new GameRules(pacman, ghost, map);
	WindowsGameRenderer gameRenderer = new WindowsGameRenderer(map, pacman, ghost);

	public static final int WindowWidth = 1200;
	public static final int WindowHeight = 600;
	
	public WindowsGame() throws Exception {
		super.setPreferredSize(new Dimension(WindowWidth, WindowHeight));
		super.pack();
		super.setVisible(true);
		
		super.addKeyListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		gameRenderer.render(g);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		try {
			if (gameRules.isGameOver())
				gameRules.endGame();
			
			Command command = userInput.getCommand(e.getKeyChar());
			gameRules.processCommand(command);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		gameRules.moveGhost();

		this.repaint();
	}
}
