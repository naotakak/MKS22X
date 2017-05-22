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
	    int distToGoal = 0;
	    while (q.getSize() > 0) {
		Location temp = q.next();
		if(distCalc(temp.getR(), temp.getC(), maze.getEnd()) == 0){
		    maze.set(temp.getR(), temp.getC(), 'E');
		    temp = temp.getPrev();
		    while (!temp.getPrev().equals(maze.getStart())) {
			maze.set(temp.getR(), temp.getC(), '@');
			temp = temp.getPrev();
			System.out.println(this);
		    }
		    maze.set(temp.getR(), temp.getC(), '@');
		    maze.set(maze.getStart().getR(), maze.getStart().getC(), 'S');
		    System.out.println(this);
		    return;
		}
		try{
		    if(maze.get(temp.getR() + 1, temp.getC()) == ' '){
			int r = temp.getR() + 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR() - 1, temp.getC()) == ' '){
			int r = temp.getR() - 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR(), temp.getC() + 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR(), temp.getC() - 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		maze.set(temp.getR(), temp.getC(), '.');
		System.out.println(this);
	    }	
	}
	if (i == 1) { //BFS
	    FrontierQueue q = new FrontierQueue();
	    q.add(maze.getStart());
	    int distToStart = 0;
	    int distToGoal = 0;
	    while (q.getSize() > 0) {
		Location temp = q.next();
	        if(distCalc(temp.getR(), temp.getC(), maze.getEnd()) == 0){
		    maze.set(temp.getR(), temp.getC(), 'E');
		    temp = temp.getPrev();
		    while (!temp.getPrev().equals(maze.getStart())) {
			maze.set(temp.getR(), temp.getC(), '@');
			temp = temp.getPrev();
			System.out.println(this);
		    }
		    maze.set(temp.getR(), temp.getC(), '@');
		    maze.set(maze.getStart().getR(), maze.getStart().getC(), 'S');
		    System.out.println(this);
		    return;
		}
		try{
		    if(maze.get(temp.getR() + 1, temp.getC()) == ' '){
			int r = temp.getR() + 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR() - 1, temp.getC()) == ' '){
			int r = temp.getR() - 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR(), temp.getC() + 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR(), temp.getC() - 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		maze.set(temp.getR(), temp.getC(), '.');
		System.out.println(this);
	    }  	
	}
	if (i == 2) { //BestFirst
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(maze.getStart());
	    int distToStart;
	    int distToGoal;
	    while (q.getSize() > 0) {
		Location temp = q.next();
	        if(distCalc(temp.getR(), temp.getC(), maze.getEnd()) == 0){
		    maze.set(temp.getR(), temp.getC(), 'E');
		    temp = temp.getPrev();
		    while (!temp.getPrev().equals(maze.getStart())) {
			maze.set(temp.getR(), temp.getC(), '@');
			temp = temp.getPrev();
			System.out.println(this);
		    }
		    maze.set(temp.getR(), temp.getC(), '@');
		    maze.set(maze.getStart().getR(), maze.getStart().getC(), 'S');
		    System.out.println(this);
		    return;
		}
		distToStart = distCalc(temp.getR(), temp.getC(), maze.getStart());
		distToGoal = distCalc(temp.getR(), temp.getC(), maze.getEnd());
		try{
		    if(maze.get(temp.getR() + 1, temp.getC()) == ' '){
			int r = temp.getR() + 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			maze.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR() - 1, temp.getC()) == ' '){
			int r = temp.getR() - 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR(), temp.getC() + 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR(), temp.getC() - 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		maze.set(temp.getR(), temp.getC(), '.');
		System.out.println(this);
	    }	
	}
	if (i == 3) { //A*
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(maze.getStart());
	    int distToStart;
	    int distToGoal;
	    while (q.getSize() > 0) {
		Location temp = q.next();
	        if(distCalc(temp.getR(), temp.getC(), maze.getEnd()) == 0){
		    maze.set(temp.getR(), temp.getC(), 'E');
		    temp = temp.getPrev();
		    while (!temp.getPrev().equals(maze.getStart())) {
			maze.set(temp.getR(), temp.getC(), '@');
			temp = temp.getPrev();
			System.out.println(this);
		    }
		    maze.set(temp.getR(), temp.getC(), '@');
		    maze.set(maze.getStart().getR(), maze.getStart().getC(), 'S');
		    System.out.println(this);
		    return;
		}
		distToStart = distCalc(temp.getR(), temp.getC(), maze.getStart());
		distToGoal = distCalc(temp.getR(), temp.getC(), maze.getEnd());
		try{
		    if(maze.get(temp.getR() + 1, temp.getC()) == ' '){
			int r = temp.getR() + 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			maze.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR() - 1, temp.getC()) == ' '){
			int r = temp.getR() - 1;
			int c = temp.getC();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR(), temp.getC() + 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getR(), temp.getC() - 1) == ' '){
			int r = temp.getR();
			int c = temp.getC() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		maze.set(temp.getR(), temp.getC(), '.');
		System.out.println(this);
	    }
	}
    }

    public int distCalc(int r, int c, Location b){
	return (Math.abs(b.getR() - r) + Math.abs(b.getC() - c));
    }

    public String toString() {
	if (a) {
	    return maze.toString(100);
	}
	return maze.toString();
    }

    public static void main (String[]args) {
	MazeSolver a = new MazeSolver("maze2.txt", true);
	a.solve(2);
    }

}
