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
	    if (index > 1 && 
		heap.get(index).compareTo(heap.get(index / 2)) > 0) {
		System.out.println(index);
		temp = heap.get(index / 2);
		heap.set(index / 2, heap.get(index));
		heap.set(index, temp);
		pushUp(index / 2);
	    }
	}
	else {
	   if (index > 1 && 
		heap.get(index).compareTo(heap.get(index / 2)) < 0) {
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

    private void pushDown(int index) {
        Integer temp;
	if (max) {
	    if (index * 2 < size && 
		heap.get(index).compareTo(heap.get(index * 2)) < 0) {
		temp = heap.get(index * 2);
		heap.set(index * 2, heap.get(index));
		heap.set(index, temp);
		pushDown(index * 2);
	    }
	}
	else {
	   if (index * 2 < size && 
		heap.get(index).compareTo(heap.get(index * 2)) > 0) {
		temp = heap.get(index * 2);
		heap.set(index * 2, heap.get(index));
		heap.set(index, temp);
		pushDown(index * 2);
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
