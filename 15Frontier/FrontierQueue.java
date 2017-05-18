import java.util.*;

public class FrontierQueue implements Frontier{

    private ArrayList<Location> queue;
    private int size;

    public FrontierQueue() {
	queue = new ArrayList<Location>();
	size = 0;
    }

    public void add(Location l) {
	queue.add(l);
	size ++;
    }

    public Location next() {
	size --;
	return queue.remove(0);
    }

    public int getSize() {
	return size;
    }
}
