import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class WindowsGame extends JFrame implements KeyListener {

	private final Map map = new Map();
	private final Ghost ghost = new Ghost(map, 7, 7, Direction.LEFT);
	private final Pacman pacman = new Pacman(map, 5, 5);

	private final UserInput userInput = new UserInput();
	private final GameRules gameRules = new GameRules(pacman, ghost);
	private final WindowsGameRenderer gameRenderer = new WindowsGameRenderer(map, pacman, ghost);

	public WindowsGame() throws Exception {
		super.setPreferredSize(new Dimension(1200, 600));
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
		} catch (SecurityException ex) {
			ex.printStackTrace();
		}

		this.repaint();
	}
}
