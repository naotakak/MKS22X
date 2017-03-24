import java.util.*;
public class Merge {
    
    public static void mergesort(int[]ary) {
	int i = (int)(Math.ceil(ary.length / 2.0));
	System.out.println(i);
	int[] left = copySide(ary, 0, i);
	int[] right = copySide(ary, i, ary.length);
	if (ary.length > 1) {
	    mergesort(left);
	    mergesort(right);
	}
	merge(left, right, ary);
    }

    private static int[] copySide(int[]a, int start, int end) {
	int[]ret = new int[end - start];
	for (int i = 0; i < ret.length; i ++) {
	    ret[i] = a[start + i];
	}
	return ret;
    }

    private static void merge(int[]a, int[]b, int[]dest) {
	int aI = 0;
	int bI = 0;
	int i = 0;
	while (aI < a.length || bI < b.length) {
	    	}
    }

    public static void main (String[]args) {
	int[]ary = {38,27,43,3,9,82,10};
	mergesort(ary);
	System.out.println(Arrays.toString(ary));
    }
}
