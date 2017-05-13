import java.util.*;

public class MyHeap {
    
    private ArrayList<String> heap;
    private int size;
    private boolean max = true;
    
    public MyHeap() {
	heap = new ArrayList<String>();
	heap.add(0);
	size = 0;
    }

    public MyHeap(boolean m) {
	max = m;
	heap = new ArrayList<String>();
	heap.add(0);
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
	    if (index / 2 > 0 && 
		heap.get(index / 2).compareTo(heap.get(index)) < 0) {
		temp = heap.get(index / 2);
		heap.set(index / 2, heap.get(index));
		heap.set(index, temp);
		pushUp(index / 2);
	    }
	}
	else {
	   if (index / 2 > 0 && 
		heap.get(index / 2).compareTo(heap.get(index)) > 0) {
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
	if (index*2> size){
	    return -1;
	}
        if (index*2+1 > size){
	    return index*2;
	}
        if(max){
	    if(heap.get(index*2+1).compareTo(heap.get(index*2))>0){
		return index*2+1;
	    }
	    else{
		return index*2;
	    }
	}
	else{
	    if(heap.get(index*2+1).compareTo(heap.get(index*2))<0){
		return index*2+1;
	    }
	    else{
		return index*2;
	    }
	}
    }
    
    private void pushDown(int index) {
        String temp;
	if (max) {
	    int whichToSwitch = checkChildren(index, true);
	    if (whichToSwitch != -1 &&
		heap.get(whichToSwitch).compareTo(heap.get(index)) > 0) {
		temp = heap.get(whichToSwitch);
		heap.set(whichToSwitch, heap.get(index));
		heap.set(index, temp);
		pushDown(whichToSwitch);
	    }
	}
	else {
	    int whichToSwitch = checkChildren(index, false);
	    if (whichToSwitch != -1 &&
		heap.get(whichToSwitch).compareTo(heap.get(index)) < 0) {
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
