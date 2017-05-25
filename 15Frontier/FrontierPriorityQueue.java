import java.util.*;

public class FrontierPriorityQueue implements Frontier{

    private ArrayList<Location>queue;
    private int size;
    
    public FrontierPriorityQueue() {
	queue = new ArrayList<Location>();
	queue.add(new Location(-1,-1,null,-1,-1));
	size = 0;
    }

    public void add(Location l) {
	queue.add(l);
	size ++;
	pushUp(size);
    }

    public Location next() {
	Location ret = queue.get(1);
	queue.set(1, queue.get(size));
	queue.remove(size);
	size --;
	pushDown(1);
	return ret;
    }

    private void pushUp(int index) {
	Location temp;
        if (index / 2 > 0 && 
	    queue.get(index / 2).compareTo(queue.get(index)) > 0) {
	    temp = queue.get(index / 2);
	    queue.set(index / 2, queue.get(index));
	    queue.set(index, temp);
	    pushUp(index / 2);
	}
    }

    public int getSize() {
	return size;
    }

    private int checkChildren(int index) {
	if (index * 2 > size){
	    return -1;
	}
        if (index * 2 + 1 > size){
	    return index * 2;
	}
        if (queue.get(index * 2 + 1).compareTo(queue.get(index * 2)) < 0){
	    return index * 2 + 1;
	}
	else{
	    return index * 2;
	}
    }
    
    private void pushDown(int index) {
        Location temp;
	int whichToSwitch = checkChildren(index);
	if (whichToSwitch != -1 &&
	    queue.get(whichToSwitch).compareTo(queue.get(index)) < 0) {
	    temp = queue.get(whichToSwitch);
	    queue.set(whichToSwitch, queue.get(index));
	    queue.set(index, temp);
	    pushDown(whichToSwitch);
	}
    }

}
