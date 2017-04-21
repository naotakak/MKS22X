import java.util.*;

public class MyDeque{
    
    private String[] deck;
    public int front;
    public int back;

    public MyDeque(String s) {
	deck = new String[1];
	deck[deck.length - 1] = s;
	front = deck.length - 1;
	back = front;
    }

    public void addFirst(String s) {
	if (s.equals(null)) {
	    throw new NullPointerException();
	}
	if (isFull()) {
	    resize();
	}
	if (front == 0) {
	    deck[deck.length - 1] = s;
	    front = deck.length - 1;
	}
	else {
	    deck[front - 1] = s;
	    front -= 1;
	}
    }

    public void addLast(String s) {
	if (s.equals(null)) {
	    throw new NullPointerException();
	}
	if (isFull()) {
	    resize();
	}
	if (back == deck.length - 1) {
	    deck[0] = s;
	    back = 0;
	}
	else {
	    deck[back + 1] = s;
	    back += 1;
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
	String ret = deck[back];
	deck[back] = null;
	if (back > 0) {
	    back -= 1;
	}
	else {
	    back = deck.length - 1;
	}
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
	int a = newDeck.length - 1;
        if (front < back && deck[front + 1] != null) {
	    for (int i = front ; i < back - front ; i ++) {
		newDeck[a] = deck[i];
		a --;
	    }
	    front = a;
	    back = newDeck.length - 1;
	}
	else if (front == back) {
	    newDeck[a] = deck[front];
	    front = a;
	    back = a;
	}
	else if (back < front) {
	    for (int i = 0; i < back; i ++) {
		newDeck[a] = deck[i];
		a --;
	    }
	    for (int i = front; i < deck.length; i ++) {
		newDeck[a] = deck[i];
		a --;
	    }
	    front = a;
	    back = newDeck.length - 1;
	}
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
	MyDeque a = new MyDeque("H");
	a.addFirst("h");
	System.out.println(a);
	a.addLast("hi");
	System.out.println(a);
	a.addFirst("y");
	System.out.println(a);
	System.out.println(a.front);
	System.out.println(a.back);
    }
}
    
