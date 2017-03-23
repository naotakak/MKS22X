import java.util.*;
public class Merge {
    
    public static void mergesort(int[]ary) {
	if (ary.length == 1) {
	    return;
	}
	int i = (int)(Math.floor(ary.length / 2.0));
	System.out.println(i);
	int[] left = copySide(ary, 0, i);
	int[] right = copySide(ary, i, ary.length);
	mergesort(left);
	mergesort(right);
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
	    if (bI >= b.length || (aI < a.length && a[aI] <= b[bI])) {
		dest[i] = a[aI];
		aI ++;
		i ++;
	    }
	    if (aI >= a.length || (bI < b.length && b[bI] < a[aI])) {
		dest[i] = b[bI];
		bI ++;
		i ++;
	    }
	}
    }

    public static void main (String[]args) {
	int[]ary = {38,27,43,3,9,82,10};
	mergesort(ary);
	System.out.println(Arrays.toString(ary));
    }
}
