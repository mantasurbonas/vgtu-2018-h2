import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class WindowsGameRenderer {

	private BufferedImage pacmanImg;
	private BufferedImage ghostImg;
	private BufferedImage wallImg;
	private Map map;
	private Pacman pacman;
	private Ghost ghost;

	public static final int ImageHeight = 20;
	public static final int ImageWidth = 20;
	
	public WindowsGameRenderer(Map map, Pacman pacman, Ghost ghost) throws Exception {
		this.map = map;
		this.pacman = pacman;
		this.ghost = ghost;
		
		pacmanImg = ImageIO.read(new FileInputStream("pacman-open.png"));
		ghostImg = ImageIO.read(new FileInputStream("ghost.png"));
		wallImg = ImageIO.read(new FileInputStream("wall.png"));
	}

	void render(Graphics g) {
		for (int y=0; y<map.getHeight(); y++) {
			for (int x=0; x<map.getWidth(); x++) {
				PrintMapCellImage(g, y, x);
			}
		}
	}

	private void PrintMapCellImage(Graphics g, int y, int x) {
		if (pacman.getPacmanX() == x && pacman.getPacmanY() == y)
			g.drawImage(pacmanImg, 50+x*20, 50+y*20, ImageWidth, ImageHeight, null);
		else
		if (ghost.getGhostX() == x && ghost.getGhostY() == y)
			g.drawImage(ghostImg, 50+x*20, 50+y*20, ImageWidth, ImageHeight, null);
		else
		if (map.isWall(x, y))
			g.drawImage(wallImg, 50+x*20, 50+y*20, ImageWidth, ImageHeight, null);
	}
}
