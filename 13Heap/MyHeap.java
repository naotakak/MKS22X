import java.util.*;

public class MyHeap {
    
    private ArrayList<String> heap;
    private int size;
    private boolean max;
    
    public MyHeap() {
	heap = new ArrayList<String>();
	heap.add("");
	size = 1;
    }

    public MyHeap(boolean m) {
	max = m;
	heap = new ArrayList<String>();
	heap.add("");
	size = 1;
    }

    public String remove() {
	String ret = heap.get(1);
	heap.set(1, heap.remove(size));
	size -= 1;
	pushDown();
	return ret;
    }

    public void add(String s) {
	heap.add(s);
	size += 1;
	pushUp();
    }

    public String peek() {
	return heap.get(1);
    }

    private void pushUp() {

    }

    private void pushDown() {

    }

}
