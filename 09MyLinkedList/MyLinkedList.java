import java.util.*;
public class MyLinkedList implements Iterable<Integer> {

    private LNode start;
    private LNode end;
    private int size = 0;

    public MyLinkedList() {
	start = new LNode();
    }

    public Iterator<Integer> iterator() {
	return new MLLI(this);
    }

    public int size() {
	return size;
    }

    public boolean add(int value) {
	LNode n = new LNode(value);
	if (size < 1) {
	    start = n;
	}
	else if (size == 1) {
	    start.next = n;
	    n.prev = start;
	    end = n;
	}
	else {
	    end.next = n;
	    n.prev = end;
	    end = n;
	}
	size += 1;
	return true;
    }

    public void add(int index, int value) {
	LNode addition = new LNode(value);
	LNode thing = start;
	if (size == 1) {
	    start.next = addition;
	    addition.prev = start;
	    end = addition;
	}
	if (index == 0) {
	    addition.next = thing;
	    addition = start;
	}
	if (index == size - 1) {
	    add(value);
	}
        thing = getNode(index);
	insertAfter(addition, thing.prev);
	size += 1;
    }

    public int remove(int index) {
	LNode thing = getNode(index);
	int val = thing.value;
	remove(thing);
	size -= 1;
	return val;
    }

    public int get(int index) {  
        return getNode(index).value;
    }

    public int set(int index, int v) {
	LNode thing = getNode(index);
	int old = thing.value;
	thing.value = v;
	return old;
    }

    public int indexOf(int value) {
	LNode thing = start;
	for (int i = 0; i < size; i ++) {
	    if (thing.value == value) {
		return i;
	    }
	    thing = thing.next;
	}
	return -1;
    }
	
    private boolean chooseSide(int index) {
	return (index < (size / 2.0));
    }

    private LNode getNode(int index) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	else{
	    LNode temp = start;
	    int i = 0;
	    while(i < index){
		temp = temp.next;
		i++;
	    }
	    return temp;
	}
    }

    private void remove(LNode node) {
	if (node == start) {
	    start = node.next;
	}
	else if (node == end) {
	    end = node.prev;
	}
	else {
	    node.prev.next = node.next;
	    node.next.prev = node.prev;
	}
    }

    private void insertAfter(LNode toAdd, LNode location) {
	location.next.prev = toAdd;
	toAdd.next = location.next;
	location.next = toAdd;
	toAdd.prev = location;
    }
    
    public String toString() {
	String ret = "[";
	LNode current = start;
	for (int i = 0; i < this.size() - 1; i ++) {
	    ret += current.value;
	    ret += ",";
	    current = current.next;
	}
	ret += current.value;
	ret += "]";
	return ret;
    }

    public class LNode {
    
	private int value;
	private LNode next;
	private LNode prev;
	
	public LNode() {
	}

	public LNode(int v, LNode n) {
	    value = v;
	    next = n;
	}
	
	public LNode(int v) {
	    value = v;
	}	
    }

    public static void main(String[]args) {
	MyLinkedList e = new MyLinkedList();
	for (int i = 0; i < 10; i ++) {
	    e.add(i);
	}
	System.out.println(e);
        Iterator a = e.iterator();
        while (a.hasNext()) {
	    System.out.println(a.next());
	}
    }

    public class MLLI implements Iterator<Integer> {
	
	private MyLinkedList linkedList;
	private int i;

	public MLLI(MyLinkedList a) {
	    linkedList = a;
	    i = 0;
	}

	public boolean hasNext() {
	    return linkedList.size > i;
	}

	public Integer next() {
	    if (hasNext()) {
		i ++;
		return linkedList.get(i - 1);
	    }
	    else {
		throw new NoSuchElementException();
	    }
	}

	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
}

