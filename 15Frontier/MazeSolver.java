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
	    FrontierStack q = new FrontierStack();
	    q.add(maze.getStart());
	    int distToStart = 0;
	    int distToEnd = 0;
	    while (q.getSize() > 0) {
		Location temp = q.next();
		if (!temp.equals(maze.getEnd())) {
		    if (maze.get(temp.getR() + 1, temp.getC()) == ' ') {
			q.add(new Location(temp.getR() + 1, temp.getC(), 
					   temp, distToStart, distToEnd));
			maze.set(temp.getR() + 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    if (maze.get(temp.getR() - 1, temp.getC()) == ' ') {
			q.add(new Location(temp.getR() - 1, temp.getC(), 
					   temp, distToStart, distToEnd));
			maze.set(temp.getR() - 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    if (maze.get(temp.getR(), temp.getC() + 1) == ' ') {
			q.add(new Location(temp.getR(), temp.getC() + 1, 
					   temp, distToStart, distToEnd));
			maze.set(temp.getR(), temp.getC() + 1, '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    if (maze.get(temp.getR(), temp.getC() - 1) == ' ') {
			q.add(new Location(temp.getR(), temp.getC() - 1, 
					   temp, distToStart, distToEnd));
			maze.set(temp.getR() - 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		}
		System.out.println(this);
	    }	
	}
	if (i == 1) { //BFS
	    FrontierQueue q = new FrontierQueue();
	    q.add(maze.getStart());
	    int distToStart = 0;
	    int distToEnd = 0;
	    while (q.getSize() > 0) {
		Location temp = q.next();
		if (!temp.equals(maze.getEnd())) {
		    if (maze.get(temp.getR() + 1, temp.getC()) == ' ') {
			q.add(new Location(temp.getR() + 1, temp.getC(), 
					   temp, distToStart, distToEnd));
			maze.set(temp.getR() + 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    if (maze.get(temp.getR() - 1, temp.getC()) == ' ') {
			q.add(new Location(temp.getR() - 1, temp.getC(), 
					   temp, distToStart, distToEnd));
			maze.set(temp.getR() - 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    if (maze.get(temp.getR(), temp.getC() + 1) == ' ') {
			q.add(new Location(temp.getR(), temp.getC() + 1, 
					   temp, distToStart, distToEnd));
			maze.set(temp.getR(), temp.getC() + 1, '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    if (maze.get(temp.getR(), temp.getC() - 1) == ' ') {
			q.add(new Location(temp.getR(), temp.getC() - 1, 
					   temp, distToStart, distToEnd));
			maze.set(temp.getR() - 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		}
		System.out.println(this);
	    }	
	}
	if (i == 2) { //BestFirst
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(maze.getStart());
	    int distToStart = 0;
	    int distToEnd = maze.getEnd().getDistToGoal();
	    while (q.getSize() > 0) {
		Location temp = q.next();
		if (!temp.equals(maze.getEnd())) {
		    if (maze.get(temp.getR() + 1, temp.getC()) == ' ') {
			distToStart ++;
			distToEnd --;
			q.add(new Location(temp.getR() + 1, temp.getC(), 
					   temp, distToStart, distToEnd, false));
			maze.set(temp.getR() + 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    else if (maze.get(temp.getR() - 1, temp.getC()) == ' ') {
			distToStart ++;
			distToEnd --;
			q.add(new Location(temp.getR() - 1, temp.getC(), 
					   temp, distToStart, distToEnd, false));
			maze.set(temp.getR() - 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    else if (maze.get(temp.getR(), temp.getC() + 1) == ' ') {
			distToStart ++;
			distToEnd --;
			q.add(new Location(temp.getR(), temp.getC() + 1, 
					   temp, distToStart, distToEnd, false));
			maze.set(temp.getR(), temp.getC() + 1, '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    else if (maze.get(temp.getR(), temp.getC() - 1) == ' ') {
			distToStart ++;
			distToEnd --;
			q.add(new Location(temp.getR(), temp.getC() - 1, 
					   temp, distToStart, distToEnd, false));
			maze.set(temp.getR() - 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		}
		System.out.println(this);
	    }	
	}
	if (i == 3) { //A*
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(maze.getStart());
	    int distToStart = 0;
	    int distToEnd = maze.getEnd().getDistToGoal();
	    while (q.getSize() > 0) {
		Location temp = q.next();
		if (!temp.equals(maze.getEnd())) {
		    if (maze.get(temp.getR() + 1, temp.getC()) == ' ') {
			distToStart ++;
			distToEnd --;
			q.add(new Location(temp.getR() + 1, temp.getC(), 
					   temp, distToStart, distToEnd, true));
			maze.set(temp.getR() + 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    else if (maze.get(temp.getR() - 1, temp.getC()) == ' ') {
			distToStart ++;
			distToEnd --;
			q.add(new Location(temp.getR() - 1, temp.getC(), 
					   temp, distToStart, distToEnd, true));
			maze.set(temp.getR() - 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    else if (maze.get(temp.getR(), temp.getC() + 1) == ' ') {
			distToStart ++;
			distToEnd --;
			q.add(new Location(temp.getR(), temp.getC() + 1, 
					   temp, distToStart, distToEnd, true));
			maze.set(temp.getR(), temp.getC() + 1, '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		    else if (maze.get(temp.getR(), temp.getC() - 1) == ' ') {
			distToStart ++;
			distToEnd --;
			q.add(new Location(temp.getR(), temp.getC() - 1, 
					   temp, distToStart, distToEnd, true));
			maze.set(temp.getR() - 1, temp.getC(), '?');
			maze.set(temp.getR(), temp.getC(), '.');
		    }
		}
		System.out.println(this);
	    }	
	}
    }

    public String toString() {
	if (a) {
	    return maze.toString(20);
	}
	return maze.toString();
    }

    public static void main (String[]args) {
	MazeSolver a = new MazeSolver("maze1.txt", true);
	a.solve(0);
    }

}
