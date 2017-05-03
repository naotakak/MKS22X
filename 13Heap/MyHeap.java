import java.util.*;

public class MyHeap {
    
    private ArrayList<String> heap;
    private int size;
    
    public MyHeap() {
	heap = new ArrayList<String>();
	heap.add("");
	size = 1;
    }

    public String pop() {
	String ret = heap.get(1);
	heap.set(1, heap.remove(size));
	size -= 1;
	pushBack(1);
	return ret;
    }

    public void add() {
	
    }

    public void remove() {

    }

    public String peek() {
	return heap.get(1);
    }

    private void pushForward(int index) {

    }

    private void pushBack(int index) {

    }

}
