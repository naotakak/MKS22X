import java.util.*;
public class Merge {
    
    public static void mergesort(int[]ary) {
	if (ary.length == 1) {
	    return;
	}
	int i = (int)(Math.ceil(ary.length / 2.0));
	int[] left = copySide(ary, 0, i);
	int[] right = copySide(ary, i, ary.length);
	if (left.length > 1) {
	    mergesort(left);
	}
	if (right.length > 1) {
	    mergesort(right);
	}
	merge(left, right, ary);
	//return;
    }

    private static int[] copySide(int[]a, int start, int end) {
	int[]ret = new int[end - start];
	for (int i = 0; i < ret.length; i ++) {
	    ret[i] = a[start + i];
	}
	return ret;
    }

    private static void merge(int[]a, int[]b, int[]dest) {
	for (int aI = 0, bI = 0, i = 0; i < dest.length; i ++) {
	    if (aI == a.length) {
		for (int thing = bI; aI + thing < dest.length; thing ++) {
		    dest[i] = b[thing];
		    i ++;
		}
		break;
	    }
	    if (bI == b.length) {
		for (int thing = aI; bI + thing < dest.length; thing ++) {
		    dest[i] = a[thing];
		    i ++;
		}
		break;
	    }
	    if (a[aI] > b[bI]) {
		dest[i] = b[bI];
		bI ++;
	    }
	    else if (a[aI] < b[bI]) {
		dest[i] = a[aI];
		aI ++;
	    }
	    else {
		dest[i] = a[aI];
		aI ++;
		i ++;
		dest[i] = b[bI];
		bI ++;
	    }
	}
		
    }

    public static void main (String[]args) {
	int[]ary = {38,27,43,3,9,82,10};
	mergesort(ary);
	System.out.println(Arrays.toString(ary));
    }
}
