package main.windows;

import main.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class WindowsGame extends JFrame implements KeyListener {
  private static final int WIDTH = 1200;
  private static final int HEIGHT = 1200;
  private static final int GHOST_X = 7;
  private static final int GHOST_Y = 7;
  private static final int GHOST_Dx = -1;
  private static final int GHOST_Dy = 0;
  private static final int PACMAN_X = 5;
  private static final int PACMAN_Y = 5;


  Map map = new Map();
  Ghost ghost = new Ghost(GHOST_X, GHOST_Y, GHOST_Dx, GHOST_Dy);
  Pacman pacman = new Pacman(PACMAN_X, PACMAN_Y);

  UserInput userInput = new UserInput();
  GameRules gameRules = new GameRules(pacman, ghost, map);
  WindowsGameRenderer gameRenderer = new WindowsGameRenderer(map, pacman, ghost);

  public WindowsGame() throws Exception {
    super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
  public void keyTyped(KeyEvent keyEvent) {
    try {
      if (gameRules.isGameOver())
        gameRules.endGame();

      Command command = userInput.getCommand(keyEvent.getKeyChar());
      gameRules.processCommand(command);
    } catch (Exception e) {
      e.printStackTrace();
    }

    gameRules.moveGhost();

    this.repaint();
  }

}
