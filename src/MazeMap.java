import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// NEVADINT VIDINIU KLASIU VARDAIS (buvo map)
public class MazeMap {

	List<Wall> walls = new ArrayList<>();

//	neefektyvu. geriau laikyti faile?
	int badMap [][] = new int [][] {
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

	public MazeMap(){
        for (int y = 0; y< badMap.length; y++) {
            for (int x = 0; x < badMap[0].length; x++) {
                if(badMap[y][x] == 1) walls.add(new Wall(x, y));
            }
        }
    }

	public boolean isWall(int x, int y) {
	    for(Wall wall : walls)
	        if(wall.equals(new Wall(x, y))) return true;
	    return false;
	}

    public int[][] getBadMap() {
        return badMap;
    }

    public void setBadMap(int[][] badMap) {
        this.badMap = badMap;
    }
}
