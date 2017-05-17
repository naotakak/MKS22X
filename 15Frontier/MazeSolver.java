public class MazeSolver {

    private Maze maze;
    
    public void solve() {
	solve(1);
    }
    /*
    public void solve(int i) {
	if (i == 0) {
	    
	}
	if (i == 1) {

	}
	if (i == 2) {

	}
	if (i == 3) {
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(maze.getStart());
	    while (q.getSize() != 0 && !q.next.equals(maze.getEnd())) {
		q.add(
	}
    }
    */

    public String toString() {
	return maze;
    }

}
