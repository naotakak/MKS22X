public class MazeSolver {

    private Maze maze;
    private boolean a;

    public MazeSolver(String filename) {
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate) {
	maze = new Maze(filename);
	a = animate;
    }

    public void solve() {
	solve(1);
    }
    
    public void solve(int i) {
	if (i == 0) { //DFS
	    
	}
	if (i == 1) { //BFS
	    FrontierQueue q = new FrontierQueue();
	    q.add(maze.getStart());
	    int distToStart = 0;
	    int distToEnd = maze.getStart().getDistToGoal();
	    while(q.getSize() != 0 && !q.next().equals(maze.getEnd())) {
		Location temp = q.next();
		if (maze.get(temp.getR() + 1, temp.getC()) == ' ') {
		    distToStart ++;
		    distToEnd --;
		    q.add(new Location(temp.getR() + 1, temp.getC(), 
				       temp, distToStart, distToEnd));
		    maze.set(temp.getR() + 1, temp.getC(), '?');
		    maze.set(temp.getR(), temp.getC(), '.');
		}
		if (maze.get(temp.getR() - 1, temp.getC()) == ' ') {
		    distToStart ++;
		    distToEnd --;
		    q.add(new Location(temp.getR() - 1, temp.getC(), 
				       temp, distToStart, distToEnd));
		    maze.set(temp.getR() - 1, temp.getC(), '?');
		    maze.set(temp.getR(), temp.getC(), '.');
		}
		if (maze.get(temp.getR(), temp.getC() + 1) == ' ') {
		    distToStart ++;
		    distToEnd --;
		    q.add(new Location(temp.getR(), temp.getC() + 1, 
				       temp, distToStart, distToEnd));
		    maze.set(temp.getR(), temp.getC() + 1, '?');
		    maze.set(temp.getR(), temp.getC(), '.');
		}
		if (maze.get(temp.getR(), temp.getC() - 1) == ' ') {
		    distToStart ++;
		    distToEnd --;
		    q.add(new Location(temp.getR(), temp.getC() - 1, 
				       temp, distToStart, distToEnd));
		    maze.set(temp.getR() - 1, temp.getC(), '?');
		    maze.set(temp.getR(), temp.getC(), '.');
		}
	    }
	    
		
	}
	if (i == 2) { //BestFirst

	}
	if (i == 3) { //A*
	    /*
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(maze.getStart());
	    while (q.getSize() != 0 && !q.next.equals(maze.getEnd())) {
		q.add();
		if (a) {
		    System.out.println(this);
		}
	    }
	    */
	}
    }

    public String toString() {
	return maze.toString();
    }

}
