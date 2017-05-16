import java.util.*;

public class FrontierQueue implements Frontier{

    private ArrayList<Location> queue;
    
    public FrontierQueue() {
	queue = new ArrayList<Location>();
    }

    public void add(Location l) {
	queue.add(l);
    }

    public Location next() {
	return queue.remove(0);
    }

}
