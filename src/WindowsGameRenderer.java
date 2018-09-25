import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class WindowsGameRenderer {

	private BufferedImage pacmanImg;
	private BufferedImage ghostImg;
	private BufferedImage wallImg;
	private MazeMap mazeMap;
	private Pacman pacman;
	private Ghost ghost;

	
	public WindowsGameRenderer(MazeMap mazeMap, Pacman pacman, Ghost ghost) throws Exception {
		this.mazeMap = mazeMap;
		this.pacman = pacman;
		this.ghost = ghost;
		
		pacmanImg = ImageIO.read(new FileInputStream("pacman-open.png"));
		ghostImg = ImageIO.read(new FileInputStream("ghost.png"));
		wallImg = ImageIO.read(new FileInputStream("wall.png"));
	}

//	maziau resursu naudojantis renderinimas
	void render(Graphics g) {
		g.drawImage(ghostImg, 50+ghost.getGhostX()*20, 50+ghost.getGhostY()*20, 20, 20, null);
		g.drawImage(pacmanImg, 50+pacman.getPacmanX()*20, 50+pacman.getPacmanY()*20, 20, 20, null);
		for(Wall wall : mazeMap.walls) g.drawImage(wallImg, 50+wall.getX()*20, 50+wall.getY()*20, 20, 20, null);
	}
}
