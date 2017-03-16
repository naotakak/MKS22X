import java.util.*;
public class Quick {

    public static int[] quicksort(int[]data) {
	int[]fin = new int[data.length];
	for (int i = 0; i < data.length; i ++) {
	    fin[i] = quickselect(data, i);
	}
	return fin;
    }

    public static int quickselect(int[]data, int k) {
	int start = 0;
	int end = data.length - 1;
	for (int i = 0 ; i < data.length; i ++) {
	    int partReturn = part(data, start, end);
	    if (partReturn > k) {
		end = partReturn;
	    }
	    if (partReturn < k) {
		start = partReturn;
	    }	     	
	}
	return data[k];
    }

    private static int part(int[]data, int start, int end) {
	int pivot = pickRandom(start, end);
	int pivotThing = data[pivot];
	for (int i = start; i <= end; i ++) {
	    int data1 = data[i];
	    if (data1 >= pivotThing && i < pivot) {
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
	int[]pivotary = new int[] {2, 10, 15, 23, 0,  5};
	/*
	System.out.println(quickselect(pivotary, 0));
	System.out.println(quickselect(pivotary, 1));
	System.out.println(quickselect(pivotary, 2));
	System.out.println(quickselect(pivotary, 3));
	System.out.println(quickselect(pivotary, 4));
	System.out.println(quickselect(pivotary, 5));
	*/
	System.out.println(Arrays.toString(quicksort(pivotary)));
    }
}
