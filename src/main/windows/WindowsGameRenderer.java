package main.windows;

import main.Ghost;
import main.Map;
import main.Pacman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WindowsGameRenderer {
	private static final String gfxDir = "src/resources/gfx/";
	private final BufferedImage pacmanImg = readImage("pacman-open.png");
	private final BufferedImage ghostImg = readImage("ghost.png");
	private final BufferedImage wallImg = readImage("wall.png");

	private static final int IMAGE_WIDTH= 20;
	private static final int IMAGE_HEIGHT= 20;

	private Map map;
	private Pacman pacman;
	private Ghost ghost;

	
	public WindowsGameRenderer(Map map, Pacman pacman, Ghost ghost) throws Exception {
		this.map = map;
		this.pacman = pacman;
		this.ghost = ghost;
	}

	void render(Graphics graphics) {
		for (int y=0; y<map.getHeight(); y++) {
			for (int x=0; x<map.getWidth(); x++) {
				if (isEqualToPacmanCoords(y, x))
					drawGraphics(graphics, pacmanImg, x, y);
				else
				if (isEqualToGhostCoords(y, x))
					drawGraphics(graphics, ghostImg, x, y);
				else
				if (map.isWall(x, y))
					drawGraphics(graphics, wallImg, x, y);
			}
		}
	}

	private void drawGraphics(Graphics g, BufferedImage image, int x, int y){
		g.drawImage(image, 50+x*IMAGE_WIDTH, 50+y*IMAGE_HEIGHT, IMAGE_WIDTH, IMAGE_HEIGHT, null);
	}

	private boolean isEqualToGhostCoords(int y, int x) {
		return ghost.getGhostX() == x && ghost.getGhostY() == y;
	}

	private boolean isEqualToPacmanCoords(int y, int x) {
		return pacman.getPacmanX() == x && pacman.getPacmanY() == y;
	}

	private BufferedImage readImage(String image) throws IOException {
		return ImageIO.read(new FileInputStream(gfxDir + image));
	}
}
