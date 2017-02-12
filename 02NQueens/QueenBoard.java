public class QueenBoard {
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size) {
	board = new int[size][size];
	for (int r = 0; r < size; r ++) {
	    for (int c = 0; c < size; c ++) {
		board[r][c] = 0;
	    }
	}
    }

    public boolean solve() {
	return solveH(0);
    }

    private boolean solveH(int col) {
	if (col >= board.length) {
	    return true;
	}
	for (int i = 0; i < board.length; i ++) {
	    if (board[i][col] == 0) {
		addQueen(i, col);
		solveH(col ++);
		removeQueen(i, col);
	    }
	}
	return false;
    }

    private void addQueen(int row, int col) {
	board[row][col] = -1;
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board.length; c ++) {
		int rowDiff = row - r;
		int colDiff = col - c;
		if (Math.abs(rowDiff * colDiff) == rowDiff * colDiff) {
		    board[r][c] ++;
		}
	    }
	}
    }

    private void removeQueen(int row, int col) {
        board[row][col] = 0;
	for (int r = 0; r < board.length; r ++) {
	    for (int c = 0; c < board.length; c ++) {
		int rowDiff = row - r;
		int colDiff = col - c;
		if (Math.abs(rowDiff * colDiff) == rowDiff * colDiff) {
		    board[r][c] --;
		}
	    }
	}
    }
    /*
    public boolean countSolutions() {
	
    }*/

    public String getCount() {
	return "" + solutionCount;
    }
    
    public String toString() {
	String s = "";
	for (int i = 0; i < board.length; i ++) {
	    for (int r = 0; r < board.length; r ++) {
		s += board[i][r];
	    }
	    s += "\n";
	}
	return s;
    }

    public static void main(String[]args) {
	QueenBoard a = new QueenBoard(4);
	System.out.println(a);
	a.solve();
	System.out.println(a);
    }
}
