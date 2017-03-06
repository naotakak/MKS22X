import java.util.*;
import java.io.*;

public class MakeLake {
    
    private int[][]pasture;
    private int elevation;

    public MakeLake(String filename) {
	int rows = 0;
	int cols = 0;
	int instruct = 0;
	int[] firstLine = new int[4];
	try {
	    Scanner scan = new Scanner(new File(filename));
	    for (int i = 0; i < 4; i ++) {
		firstLine[i] = Integer.parseInt(scan.next());
	    }
	    rows = firstLine[0];
	    cols = firstLine[1];
	    elevation = firstLine[2];
	    instruct = firstLine[3];
	    
    }

    public stomp(int r, int c, int d) {

    }

    public fill(int elevation) {
	
    }

    public volume() {
    }

}
