import java.util.*;

public class MyHeap {
    
    private ArrayList<String> heap;
    private int size;
    private boolean max = true;
    
    public MyHeap() {
	heap = new ArrayList<String>();
	heap.add("");
	size = 0;
    }

    public MyHeap(boolean m) {
	max = m;
	heap = new ArrayList<String>();
	heap.add("");
	size = 0;
    }

    public String remove() {
	String ret = heap.get(1);
	heap.set(1, heap.remove(size));
	size -= 1;
	pushDown(1);
	return ret;
    }

    public void add(String s) {
	heap.add(s);
	size += 1;
	pushUp(size);
    }

    public String peek() {
	return heap.get(1);
    }

    private void pushUp(int index) {
	String temp;
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

    private void pushDown(int index) {
	String temp;
	if (max) {
	    if (index < size && 
		heap.get(index).compareTo(heap.get(index * 2)) < 0) {
		temp = heap.get(index * 2);
		heap.set(index * 2, heap.get(index));
		heap.set(index, temp);
		pushDown(index * 2);
	    }
	}
	else {
	   if (index < size && 
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
	System.out.println(z);
	z.add("a");
	System.out.println(z);
	z.add("b");
	System.out.println(z);
	z.add("c");
	System.out.println(z);
	z.remove();
	System.out.println(z);
    }
}
