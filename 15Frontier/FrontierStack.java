import java.util.*;

public class FrontierStack implements Frontier {
    
    private Stack<Location> s;

    public FrontierStack() {
	s = new Stack<Location>();
    }
    
    public void add(Location l) {
	s.push(l);
    }

    public Location next() {
	return s.pop();
    }

}
