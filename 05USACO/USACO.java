import java.util.*;
import java.io.*;

public class USACO {
    
    private int[][]pasture;
    private int elevation;
    private int[][] instructions;

    public USACO() {
    }

    public int bronze(String filename) {
	int rows = 0;
	int cols = 0;
	int instruct = 0;
	int[] firstLine = new int[4];
	try {
	    Scanner scan = new Scanner(new File(filename));
	    for (int i = 0; i < 4; i ++) {
		firstLine[i] = scan.nextInt();
	    }
	    rows = firstLine[0];
	    cols = firstLine[1];
	    elevation = firstLine[2];
	    instruct = firstLine[3];
	    pasture = new int[rows][cols];
	    for (int i = 0; i < rows; i ++) {
		for (int c = 0; c < cols; c ++) {
		    pasture[i][c] = scan.nextInt();
		}
	    }
	    instructions = new int[instruct][3];
	    for (int i = 0; i < instruct; i ++) {
		for (int c = 0; c < 3; c ++) {
		    instructions[i][c] = scan.nextInt();
		}
	    }
	}catch (FileNotFoundException e) {
	}
	System.out.println(Arrays.deepToString(instructions));
	stomp(instructions[0][0], instructions[0][1], instructions[0][2]);
	System.out.println(Arrays.deepToString(pasture));
	return 1;
    }

    public boolean stomp(int r, int c, int d) {

        int highR = r - 1;
	int highC = c - 1;
	
	for (int row = r - 1; row < r+2; row ++) {
	    for (int col = c - 1; col < c+2; col ++) {
		if (pasture[row][col] > pasture[highR][highC]) {
		    highR = row;
		    highC = col;
		}
	    }
	}
	int highest = pasture[highR][highC];
	System.out.println(highest);
	pasture[highR][highC] -= d;
	for (int row = r - 1; row < r+2; row ++) {
	    for (int col = c - 1; col < c+2; col ++) {
		if (pasture[row][col] + d >= pasture[highR][highC]) {
		    pasture[row][col] = pasture[highR][highC];
		}
	    }
	}
     
	return true;
    }
    /*
    public fill(int elevation) {
	
    }

    public volume() {
    }
    */

    public static void main(String[]args) {
	USACO x = new USACO();
	x.bronze("infile1.in");
    }
}
