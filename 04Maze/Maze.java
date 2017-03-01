import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
        int rows = 1;
	int cols = 0;
	boolean E = false;
	boolean S = false;
	String s = "";
	try {
	    Scanner scan = new Scanner(new File(filename));
	    cols = scan.nextLine().length();
	    while (scan.hasNextLine()) {
		rows += 1;
		scan.nextLine();
	    }
	    Scanner rScan = new Scanner(new File(filename));
	    while (rScan.hasNextLine()) {
		s += rScan.nextLine();
	    }
	}catch (FileNotFoundException e) {
	    System.out.println("File not found");
	    System.exit(0);
	}catch (NoSuchElementException e) {
	    System.out.println(rows);
	    System.out.println("No Such Element");
	}
	/*
	if (!E || !S) {
	    System.out.println("Missing E or S");
	    System.exit(0);
	}
	*/
	System.out.println(rows);
	System.out.println(cols);
	System.out.println(s);
	maze = new char[rows][cols];
	for (int r = 1 ; r < maze.length + 1; r ++) {
	    for (int c = 0 ; c < maze[0].length ; c ++) {
		if (r * c - 1 >= 0) {
		    maze[r - 1][c] = s.charAt(r * c - 1);
		}
		else {
		    maze[r - 1][c] = s.charAt(0);
		}
	    }
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startx=0,starty=0;
            //Initialize startx and starty with the location of the S. 
            maze[startx][starty] = ' ';//erase the S, and start solving!
            return solve(startx,starty);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int x, int y){
        if(animate){
            System.out.println(this);
            //wait(20);
        }

        //COMPLETE SOLVE
        return false; //so it compiles
    }
    
    public String toString() {
	String s = "";
	for (int r = 0 ; r < maze.length ; r ++) {
	    for (int c = 0 ; c < maze[0].length ; c ++) {
		s += maze[r][c];
	    }
	}
	return s;
    }

    public static void main (String[]args) {
	Maze a = new Maze("data1.dat");
	System.out.println(a);
    }
}
