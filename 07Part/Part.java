import java.util.*;

public class Part {

    public Part() {
    }
    
    private static int part(int[]data, int start, int end) {
	int pivot = pickRandom(start, end);
	int pivotThing = data[pivot];
	for (int i = start; i <= end; i ++) {
	    int data1 = data[i];
	    if (data1 > pivotThing && i < pivot) {
		data = pushBack(data, i, pivot);
		pivot = i;
	    }
	    if (data1 < pivotThing && i > pivot) {
		data = pushBack(data, pivot, i);
		pivot = i - 1;
	    }
	}
	return pivot;
    }

    private static int[] pushBack(int[]data, int start, int end) {
	int endThing = data[end];
	for (int i = end; i > start; i --) {
	    int thingBefore = data[i - 1];
	    data[i] = thingBefore;
	}
	data[start] = endThing;
	return data;
    }
    
    private static int pickRandom(int start, int end) {
	int range = (end - start) + 1;
	return (int)(Math.random() * range) + start;
    }

    public static void main(String[]args) {
	int[]pivotary = new int[] {0, 5, 1, 4, 3, 2};
	System.out.println(part(pivotary, 0, 5));
    }
}
