import java.util.*;

public class MyHeap {
    
    private ArrayList<Integer> heap;
    private int size;
    private boolean max = true;
    
    public MyHeap() {
	heap = new ArrayList<Integer>();
	heap.add(0);
	size = 0;
    }

    public MyHeap(boolean m) {
	max = m;
	heap = new ArrayList<Integer>();
	heap.add(0);
	size = 0;
    }

    public Integer remove() {
	Integer ret = heap.get(1);
	heap.set(1, heap.remove(size));
	size -= 1;
	pushDown(1);
	return ret;
    }

    public void add(Integer s) {
	heap.add(s);
	size += 1;
	pushUp(size);
    }

    public Integer peek() {
	return heap.get(1);
    }

    private void pushUp(int index) {
	Integer temp;
	if (max) {
	    if (index > 0 && 
		heap.get(index).compareTo(heap.get(index / 2)) < 0) {
		System.out.println(index);
		temp = heap.get(index / 2);
		heap.set(index / 2, heap.get(index));
		heap.set(index, temp);
		pushUp(index / 2);
	    }
	}
	else {
	   if (index > 0 && 
		heap.get(index).compareTo(heap.get(index / 2)) > 0) {
		temp = heap.get(index / 2);
		heap.set(index / 2, heap.get(index));
		heap.set(index, temp);
		pushUp(index / 2);
	    }
	}
    }

    public int getSize() {
	return size;
    }

    private int checkChildren(int index, boolean max) {
	if (index * 2 < size && index * 2 + 1 >= size) {
	    if (max && heap.get(index).compareTo(heap.get(index * 2)) < 0) {
		return index * 2;
	    }
	    else if (!max && heap.get(index).compareTo(heap.get(index * 2)) > 0) {
		return index * 2;
	    }
	}
	if (index * 2 < size && index * 2 + 1 < size) {
	    if (max) {
		if (heap.get(index * 2).compareTo(heap.get(index * 2 + 1)) > 0) {
		    return index * 2;
		}
		else {
		    return index * 2 + 1;
		}
	    }
	    if (!max) {
		if (heap.get(index * 2).compareTo(heap.get(index * 2 + 1)) < 0) {
		    return index * 2;
		}
		else {
		    return index * 2 + 1;
		}
	    }
	}
	return -1;
    }
    
    private void pushDown(int index) {
        Integer temp;
	if (max) {
	    int whichToSwitch = checkChildren(index, true);
	    if (whichToSwitch != -1) {
		temp = heap.get(whichToSwitch);
		heap.set(whichToSwitch, heap.get(index));
		heap.set(index, temp);
		pushDown(whichToSwitch);
	    }
	}
	else {
	   int whichToSwitch = checkChildren(index, false);
	    if (whichToSwitch != -1) {
		temp = heap.get(whichToSwitch);
		heap.set(whichToSwitch, heap.get(index));
		heap.set(index, temp);
		pushDown(whichToSwitch);
	    }
	}
    }

    public String toString() {
	return (Arrays.toString(heap.toArray()));
    }

    public static void main (String[]args) {
	MyHeap z = new MyHeap(true);
    }
}
