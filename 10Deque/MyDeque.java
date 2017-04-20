import java.util.*;

public class MyDeque{
    
    private String[] deck;
    private int front;
    private int back;

    public MyDeque() {
	deck = new String[10];
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
	String[] newDeck = new String[deck.length * 2];
	int i = back;
	int a = 0;
	while (i > 0 && i >= front) {
	    newDeck[newDeck.length - a] = deck[i];
	    //something happens here
	    i --;
	    a ++;
	}
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

}
    
