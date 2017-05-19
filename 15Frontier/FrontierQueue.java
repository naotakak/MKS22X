import java.util.*;

public class FrontierQueue implements Frontier{

    private LinkedList<Location> queue;
    private int size;

    public FrontierQueue() {
	queue = new LinkedList<Location>();
	size = 0;
    }

    public void add(Location l) {
	queue.add(l);
	size ++;
    }

    public Location next() {
	size --;
	return queue.remove();
    }

    public int getSize() {
	return size;
    }
}
