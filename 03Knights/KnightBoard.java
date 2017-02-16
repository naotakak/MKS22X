public class KnightBoard {
    private int[][]board;
    private int rows;
    private int cols;
    private boolean solved = false;

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
	for (int r = 0; r < rows; r ++) {
	    if (solveH(r, 0, 1)) {
		solved = true;
	    }
	}
    }

    private boolean solveH(int row, int col, int level) {
	if (level > (rows * cols)) {
	    return true;
	}
	if (row >= rows || col >= cols || row < 0 || col < 0) {
	    return false;
	}
	if (board[row][col] == 0) {
	    board[row][col] = level;
	    if (solveH(row - 2, col + 1, level + 1) ||
	        solveH(row - 1, col + 2, level + 1) ||
	        solveH(row + 1, col + 2, level + 1) ||
	        solveH(row + 2, col + 1, level + 1) ||
	        solveH(row + 2, col - 1, level + 1) ||
	        solveH(row + 1, col - 2, level + 1) ||
	        solveH(row - 1, col - 2, level + 1) ||
	        solveH(row - 2, col - 1, level + 1)) {
		return true;
	    }
	    board[row][col] = 0;
	}
	return false;
    }

    public String toString() {
	String s = "";
	if (solved) {
	    for (int r = 0; r < rows; r ++) {
		for (int c = 0; c < cols; c ++) {
		    if (board[r][c] >= 10) {
			s += " " + board[r][c];
		    }
		    else {
			s += "  " + board[r][c];
		    }
		}
		s += "\n";
	    }
	}
	return s;
    }

    public static void main (String[]args) {
	int a = 0;
	int b = 0;
	try {
	    a = Integer.parseInt(args[0]);
	    b = Integer.parseInt(args[1]);
	}catch (NumberFormatException e) {
	    System.out.println("[rows] [cols]");
	}
	KnightBoard k = new KnightBoard(a, b);
	k.solve();
	System.out.println(k);
    }

}
