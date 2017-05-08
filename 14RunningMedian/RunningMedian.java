import java.util.*;

public class RunningMedian {

    private MyHeap smaller;
    private MyHeap larger;
    private double median;

    public RunningMedian() {
	smaller = new MyHeap(true);
	larger = new MyHeap(false);
    }

    public void add(Integer a) {
	if (a.intValue() > median) {
	    larger.add(a);
	    if (larger.getSize() > smaller.getSize() + 1) {
		smaller.add(larger.remove());
	    }
	}
	else {
	    smaller.add(a);
	    if (smaller.getSize() > larger.getSize() + 1) {
		larger.add(smaller.remove());
	    }
	}
	median = updateMedian();
    }

    private double updateMedian() {
	if (smaller.getSize() > larger.getSize()) {
	    return smaller.peek().intValue();
	}
	else if (smaller.getSize() < larger.getSize()) {
	    return larger.peek().intValue();
	}
	else {
	    return (smaller.peek().intValue() + larger.peek().intValue()) / 2.0;
	}
    }

    public double getMedian() {
	return median;
    }

    public static void main (String[]args) {
	RunningMedian a = new RunningMedian();
	for (int i = 0; i < 10; i ++) {
	    a.add(new Integer(i));
	    System.out.println("" + i + " " + a.getMedian());
	}
    }
}
