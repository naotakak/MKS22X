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
	return solveH(board.length, 0);
    }

    private boolean solveH(int queens, int col) {
	if (col > board.length) {
	    return queens == 0;
	}
	for (int i = 0; i < board.length; i ++) {
	    if (board[i][col] == 0) {
		addQueen(i, col);
		solveH(queens--, col ++);
		removeQueen(i, col);
	    }
	    else {
		solveH(queens, col ++);
		removeQueen(i, col);
	    }
	}
	return false;
    }

    private void addQueen(int row, int col) {
	board[row][col] = -1;
	for (int r = 0; r < board.length; r ++) {
	    board[r][col] ++;
	    board[row][r] ++;
	    board[r][r] ++;
	    board[board.length - r][r] ++;
	    board[r][board.length - r] ++;
	    board[board.length - r][board.length - r] ++;
	}
    }

    private void removeQueen(int row, int col) {
	board[row][col] = 0;
	for (int r = 0; r < board.length; r ++) {
	    board[r][col] --;
	    board[row][r] --;
	    board[r][r] --;
	    board[board.length - r][r] --;
	    board[r][board.length - r] --;
	    board[board.length - r][board.length - r] --;
	}
    }

    public boolean countSolutions() {
	
    }

    public String getCount() {
	
    }

    public String toString() {
	
    }
