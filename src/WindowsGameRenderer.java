import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WindowsGameRenderer {

	private final BufferedImage pacmanImg;
	private final BufferedImage ghostImg;
	private final BufferedImage wallImg;
	private final Map map;
	private final Pacman pacman;
	private final Ghost ghost;
	private final int offset = 50;
	private final int spriteSize = 20;


	public WindowsGameRenderer(Map map, Pacman pacman, Ghost ghost) throws IllegalArgumentException, IOException {
		this.map = map;
		this.pacman = pacman;
		this.ghost = ghost;

		pacmanImg = ImageIO.read(new FileInputStream("pacman-open.png"));
		ghostImg = ImageIO.read(new FileInputStream("ghost.png"));
		wallImg = ImageIO.read(new FileInputStream("wall.png"));
	}

	void render(Graphics g) {
		for (int y = 0; y < map.getHeight(); y++) {
			for (int x = 0; x < map.getWidth(); x++) {
				if (pacman.getX() == x && pacman.getY() == y)
					g.drawImage(pacmanImg, offset + x * spriteSize, offset + y * spriteSize, spriteSize, spriteSize, null);

				if (ghost.getX() == x && ghost.getY() == y)
					g.drawImage(ghostImg, offset + x * spriteSize, offset + y * spriteSize, spriteSize, spriteSize, null);

				if (map.isWall(x, y))
					g.drawImage(wallImg, offset + x * spriteSize, offset + y * spriteSize, spriteSize, spriteSize, null);
			}
		}
	}
}
