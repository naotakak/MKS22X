import java.util.*;
public class Quick {

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
	int i = start;
	int gt = end;
	int lt = start;
	data[pivot] = data[start];
	data[start] = pivotThing;
        while (i <= gt) {
	    if (data[i] == data[lt]) {
		i ++;
	    }
	    else if (data[i] < data[lt]) {
		swap(data, i, lt);
		lt ++;
		i++;
	    }
	    else {
		swap(data, i , gt);
		gt --;
	    }
	}
	return i;
    }
    
    private static void swap(int[]data, int in1, int in2) {
	int old = data[in1];
	data[in1] = data[in2];
	data[in2] = old;
    }

    private static int pickRandom(int start, int end) {
	int range = (end - 1 - start) + 1;
	return (int)(Math.random() * range) + start;
    }

    public static void main(String[]args) {
	int[]pivotary = new int[] {2, 10, 15, 23, 0,  5};
	System.out.println(quickselect(pivotary, 0));
	System.out.println(quickselect(pivotary, 1));
	System.out.println(quickselect(pivotary, 2));
	System.out.println(quickselect(pivotary, 3));
	System.out.println(quickselect(pivotary, 4));
	System.out.println(quickselect(pivotary, 5));
	
    }
}
