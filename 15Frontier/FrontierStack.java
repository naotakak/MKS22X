import java.util.*;

public class FrontierStack implements Frontier {
    
    private Stack<Location> s;
    private int size;

    public FrontierStack() {
	s = new Stack<Location>();
	size = 0;
    }
    
    public void add(Location l) {
	s.push(l);
	size ++;
    }

    public int getSize() {
	return size;
    }

    public Location next() {
	size --;
	return s.pop();
    }

}
