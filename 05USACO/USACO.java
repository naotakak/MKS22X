import java.util.*;
import java.io.*;

public class USACO {

    //Partner: Michael Cheng
    private int[][]pasture;
    private int[][] instructions;
    private char[][] silverP;
    public USACO() {
    }

    public int bronze(String filename) {
	int rows = 0;
	int cols = 0;
	int instruct = 0;
	int elevation = 0;
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
	    System.out.println("File Not Found");
	    System.exit(0);
	}
	for (int i = 0; i < instructions.length; i ++) {
	    stomp(instructions[i][0], instructions[i][1], instructions[i][2]);
	}
	fill(elevation);
	return this.volume();
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
    
    public void fill(int elevation) {
	for (int r = 0; r < pasture.length; r ++) {
	    for (int c = 0; c < pasture[0].length; c ++) {
		if (pasture[r][c] < elevation) {
		    pasture[r][c] = elevation - pasture[r][c];
		}
		else {
		    pasture[r][c] = 0;
		}
	    }
	}
    }

    public int volume() {
	int aggDepth = 0;
	for (int r = 0; r < pasture.length; r ++) {
	    for (int c = 0; c < pasture[0].length; c ++) {
		aggDepth += pasture[r][c];
	    }
	}
	return aggDepth * 72 * 72;
    }

    public int silver(String filename) {
	int rows = 0;
	int cols = 0;
	int instruct = 0;
	int elevation = 0;
	int[] firstLine = new int[4];
	try {
	    Scanner scan = new Scanner(new File(filename));
	    String next = scan.next();
	    System.out.println(next);
	    for (int i = 0; i < 3; i ++) {
		firstLine[i] = Integer.parseInt(next);
		next = scan.next();
	    }
	    rows = firstLine[0];
	    cols = firstLine[1];
	    elevation = firstLine[2];
	    instruct = firstLine[3];
	    silverP = new char[rows][cols];
	    next = scan.next();
	    for (int i = 0; i < rows; i ++) {
		for (int c = 0; c < cols; c ++) {
		    silverP[i][c] = next.charAt(0);
		    next = next.substring(1);
		}
		next = scan.next();
	    }
	    instructions = new int[instruct][3];
	    next = scan.next();
	    for (int i = 0; i < instruct; i ++) {
		for (int c = 0; c < 3; c ++) {
		    instructions[i][c] = Integer.parseInt(next);
		}
	    }
	}catch (FileNotFoundException e) {
	    System.out.println("File Not Found");
	    System.exit(0);
	}
	System.out.println(Arrays.deepToString(silverP));
	return 1;
    }

    
    public static void main(String[]args) {
	USACO x = new USACO();
	System.out.println(x.bronze("infile1.in"));
	System.out.println(x.silver("infile2.in"));
    }
}
