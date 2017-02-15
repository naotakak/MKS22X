public class KnightBoard {
    private int[][]board;
    private int rows;
    private int cols;

    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	rows = startingRows;
	cols = startingCols;
	for (int r = 0; r < startingRows; r ++) {
	    for (int c = 0; c < startingCols; c ++) {
		board[r][c] = 0;
	    }
	}
    }

    public void solve() {
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[0].length; r ++) {
		solveH(r, c, 1);
	    }
	}
    }

    private boolean solveH(int row, int col, int level) {
	if (level >= (board.length * board[0].length)) {
	    return true;
	}
	if (board[row][col] == 0) {
	    board[row][col] = level;
	    if (row - 2 >= 0 
		&& col + 1 <= cols 
		&& solveH(row - 2, col + 1, level + 1)) {
		return true;
	    }
	    if (row - 1 >= 0 
		&& col + 2 <= cols
		&& solveH(row - 1, col + 2, level + 1)) {
		return true;
	    }
	    if (row + 1 <= rows 
		&& col + 2 <= cols
		&& solveH(row + 1, col + 2, level + 1)) {
		return true;
	    }
	    if (row + 2 <= rows
		&& col + 1 <= cols
		&& solveH(row + 2, col + 1, level + 1)) {
		return true;
	    }
	    if (row + 2 <= rows
		&& col - 1 >= 0
		&& solveH(row + 2, col - 1, level + 1)) {
		return true;
	    }
	    if (row + 1 <= rows
		&& col - 2 >= 0
		&& solveH(row + 1, col - 2, level + 1)) {
		return true;
	    }
	    if (row - 1 >= 0
		&& col - 2 >= 0
		&& solveH(row - 1, col - 2, level + 1)) {
		return true;
	    }
	    if (row - 2 >= 0
		&& col - 1 >= 0
		&& solveH(row - 2, col - 1, level + 1)) {
		return true;
	    }
	}
	board[row][col] = 0;
	return false;
    }

    public String toString() {
	String s = "";
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board[0].length; c ++) {
		if (board[r][c] >= 10) {
		    s += " " + board[r][c];
		}
		else {
		    s += "  " + board[r][c];
		}
	    }
	    s += "\n";
	}
	return s;
    }

    public static void main (String[]args) {
	KnightBoard a = new KnightBoard(7, 7);
	System.out.println(a);
	a.solve();
	System.out.println(a);
    }
}
