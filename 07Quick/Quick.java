import java.util.*;
public class Quick {

    public static void quicksort(int[]data) {
	quicksortH(data, 0, data.length - 1);
    }
    
    private static void quicksortH(int[]data, int start, int end) {
	if (end <= start + 1) {
	    return;
	}
        int pivot = pickRandom(start, end);
	int pivotThing = data[pivot];
	int i = start + 1;
	int gt = end;
	int lt = start;
	data[pivot] = data[start];
	data[start] = pivotThing;
        while (i <= gt) {
	    if (data[i] == pivotThing) {
		i ++;
	    }
	    else if (data[i] < pivotThing) {
		swap(data, i, lt);
		lt ++;
		i++;
	    }
	    else {
		swap(data, i , gt);
		gt --;
	    }
	}
	quicksortH(data, start, lt);
	quicksortH(data, gt, end);
	
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
	    if (partReturn == k) {
		return data[k];
	    }
	}
	return data[k];
    }

    private static int part(int[]data, int start, int end) {
	int pivot = pickRandom(start, end);
	int pivotThing = data[pivot];
	int i = start + 1;
	int gt = end;
	int lt = start;
	data[pivot] = data[start];
	data[start] = pivotThing;
        while (i <= gt) {
	    if (data[i] == pivotThing) {
		i ++;
	    }
	    else if (data[i] < pivotThing) {
		swap(data, i, lt);
		lt ++;
		i++;
	    }
	    else {
		swap(data, i , gt);
		gt --;
	    }
	}
	return lt;
    }
    
    private static void swap(int[]data, int in1, int in2) {
	int old = data[in1];
	data[in1] = data[in2];
	data[in2] = old;
    }

    private static int pickRandom(int start, int end) {
	int range = (end - start) + 1;
	return (int)(Math.random() * range) + start;
    }

    public static void main(String[]args) {
	int[]pivotary = new int[] {2, 10, 15, 23, 0, 5, 5, 5, 5};
	quicksort(pivotary);
	System.out.println(Arrays.toString(pivotary));
    }
}
