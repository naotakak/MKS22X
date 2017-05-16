
public class Location implements Comparable<Location> {
    
    private int distToGoal, distToStart, r, c;
    private boolean aStar;
    private Location previous;

    public Location(int row, int col, Location prev, int distS, int distE) {
	r = row;
	c = col;
	previous = prev;
	distToGoal = distE;
	distToStart = distS;
    }
    
    public Location(int row, int col, Location prev, 
		    int distS, int distE, boolean star) {
	r = row;
	c = col;
	previous = prev;
	distToGoal = distE;
	distToStart = distS;
	aStar = star;
    }
    
    public int getR() {
	return r;
    }
    
    public int getC() {
	return c;
    }
    
    public Location getPrev() {
	return previous;
    }
    
    public int getDistToStart() {
	return distToStart;
    }
    
    public int getDistToGoal() {
	return distToGoal;
    }
    
    public boolean getStar() {
	return aStar;
    }

    public int compareTo(Location other) {
	if (!(this.getStar() && other.getStar())) {
	    return this.getDistToGoal() - other.getDistToGoal();
	}
	return (this.getDistToStart() + this.getDistToGoal()) 
	    - (other.getDistToStart() + other.getDistToGoal());
    }

}
    
