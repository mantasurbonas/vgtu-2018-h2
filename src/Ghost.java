
public class Ghost {
	int ghostX = 7;
	int ghostY = 7;
	int ghostDx = 0;
	int ghostDy = 1;

	public Ghost(int ghostX, int ghostY, int ghostDx, int ghostDy) {
		this.ghostX = ghostX;
		this.ghostY = ghostY;
		this.ghostDx = ghostDx;
		this.ghostDy = ghostDy;
	}

	public int getGhostX() {
		return ghostX;
	}

	public void setGhostX(int ghostX) {
		this.ghostX = ghostX;
	}

	public int getGhostY() {
		return ghostY;
	}

	public void setGhostY(int ghostY) {
		this.ghostY = ghostY;
	}

	public int getGhostDx() {
		return ghostDx;
	}

	public void setGhostDx(int ghostDx) {
		this.ghostDx = ghostDx;
	}

	public int getGhostDy() {
		return ghostDy;
	}

	public void setGhostDy(int ghostDy) {
		this.ghostDy = ghostDy;
	}

}