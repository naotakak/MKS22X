import java.util.*;

public class MyDeque{
    
    private String[] deck;
    private int front;
    private int back;

    public MyDeque() {
	deck = new String[10];
    }

    public void addFirst(String s) {
	if (s.equals(null)) {
	    throw new NullPointerException();
	}
	if (isFull()) {
	    resize();
	}
        front --;
	if (front < 0) {
	    front = deck.length - 1;
        }
	deck[front] = s;
    }

    public void addLast(String s) {
	if (s.equals(null)) {
	    throw new NullPointerException();
	}
	if (isFull()) {
	    resize();
	}
        deck[back] = s;
	back ++;
	if (back == deck.length) {
	    back = 0;
	}
    }

    public String removeFirst() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	String ret = deck[front];
	deck[front] = null;
	if (front < deck.length - 1) {
	    front += 1;
	}
	else {
	    front = 0;
	}
	return ret;
    }

    public String removeLast() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	String ret;
	if (back > 0) {
	    ret = deck[back - 1];
	    back -= 1;
	}
	else {
	    ret = deck[0];
	    back = deck.length - 1;
	}
	deck[back] = null;
	return ret;
    }

    public String getFirst() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return deck[front];
    }

    public String getLast() {
	if (isEmpty()) {
	    throw new NoSuchElementException();
	}
	return deck[back];
    }

    private void resize() {
	String[] newDeck = new String[deck.length * 2 + 1];
	int i = 0;
	int f = front;
	while (i < deck.length) {
	    if (f == deck.length) {
		f = 0;
	    }
	    newDeck[i] = deck[f];
	    f ++;
	    i++;
	}
	front = 0;
	back = deck.length;
	deck = newDeck;
    }
    
    private boolean isFull() {
	for (int i = 0; i < deck.length; i ++) {
	    if (deck[i] == null) {
		return false;
	    }
	}
	return true;
    }
    
    private boolean isEmpty() {
	for (int i = 0; i < deck.length; i ++) {
	    if (deck[i] != null) {
		return false;
	    }
	}
	return true;
    }

    public String toString() {
	String s = "[";
	for (int i = 0; i < deck.length; i ++) {
	    s += deck[i];
	    s += ", ";
	}
	s += "]";
	return s;
    }

    public static void main(String[]args) {
	MyDeque a = new MyDeque();
	a.addFirst("h");
	System.out.println(a);
	a.addLast("hi");
	System.out.println(a);
	a.addFirst("y");
	System.out.println(a);
	a.removeFirst();
	System.out.println(a);
	System.out.println(a.removeLast());
	System.out.println(a);
	a.removeFirst();
	System.out.println(a);
    }
}
    
