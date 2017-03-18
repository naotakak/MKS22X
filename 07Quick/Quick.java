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
	int a = start;
	int b = end - 1;
	data[pivot] = data[end];
	data[end] = pivotThing;
        while (a <= b) {
	    if (data[a] < data[b]) {
		a ++;
	    }
	    if (data[a] >= data[b]) {
		int dataA = data[a];
		data[a] = data[b];
		data[b] = dataA;
		b --;
	    }
	}
	int finalSwap = data[a];
	data[a] = data[end];
	data[end] = finalSwap;
	return a;
    }
    
    private static int pickRandom(int start, int end) {
	int range = (end - start) + 1;
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
