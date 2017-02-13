public class QueenBoard {
    private int[][]board;
    private int solutionCount;
    private boolean run = false;

    public QueenBoard(int size) {
	board = new int[size][size];
	for (int r = 0; r < size; r ++) {
	    for (int c = 0; c < size; c ++) {
		board[r][c] = 0;
	    }
	}
    }

    public void solve() {
	solveH(0);
    }

    private boolean solveH(int col) {
	if (col >= board.length) {
	    return true;
	}
	for (int i = 0; i < board.length; i ++) {
	    if (board[i][col] == 0) {
		addQueen(i, col);
		solveH(col + 1);
		removeQueen(i, col);
	    }
	}
	return false;
    }

    private void addQueen(int row, int col) {
	board[row][col] = -1;
	for (int i = 1; i < board.length; i ++) {
	    try {
		board[row][col + i] += 1;
		board[row + i][col + i] += 1;
		board[row - i][col + i] += 1;
	    }catch (ArrayIndexOutOfBoundsException e) {
	    }
	}
    }

    private void removeQueen(int row, int col) {
        board[row][col] = 0;
        for (int i = 1; i < board.length; i ++) {
	    try {
		board[row][col + i] -= 1;
		board[row + i][col + i] -= 1;
		board[row - i][col + i] -= 1;
	    }catch (ArrayIndexOutOfBoundsException e) {
	    }
	}
    }
    
    public void countSolutions() {
	run = true;
	countH(0);
    }

    private boolean countH(int col) {
	if (col >= board.length) {
	    solutionCount += 1;
	}
	for (int i = 0; i < board.length; i ++) {
	    if (board[i][col] == 0) {
		addQueen(i, col);
		solveH(col + 1);
		removeQueen(i, col);
	    }
	}
	return false;
    }

    public int getCount() {
	if (run) {
	    return solutionCount;
	}
	return -1;
    }
    
    public String toString() {
	String s = "";
	for (int i = 0; i < board.length; i ++) {
	    for (int r = 0; r < board.length; r ++) {
		if (board[i][r] == 0) {
		    s += "- ";
		}
		else if (board[i][r] == -1) {
		    s += "Q ";
		}
		else {
		    s += "X ";
		}
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
	QueenBoard b = new QueenBoard(4);
	System.out.println(b);
	//b.countSolutions();
	System.out.println(b.getCount());
    }
}
