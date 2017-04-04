public class MyLinkedList {

    private LNode start;
    private LNode end;
    private int size;

    public MyLinkedList() {
	start = new LNode();
	end = null;
	size = 0;
    }

    public boolean add(int value) {
	LNode n = new LNode(value);
	if (size < 1) {
	    start = n;
	}
	if (size == 1) {
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
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
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
	for (int i = 0; i < index - 1; i ++) {
	    thing = thing.next;
	}
	LNode oldNext = thing.next;
	thing.next = addition;
	addition.next = oldNext;
	oldNext.prev = addition;
	addition.prev = thing;
	size += 1;
    }

    public int remove(int index) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode thing = start;
	for (int i = 0; i < index - 1; i ++) {
	    thing = thing.next;
	}
	int val = (thing.next).value;
	LNode newNext = thing.next.next;
	thing.next = newNext;
	newNext.prev = thing;
	size -= 1;
	return val;
    }
	
    public int size() {
	return size;
    }

    public String toString() {
	String ret = "[";
	LNode current = start;
	for (int i = 0; i < this.size(); i ++) {
	    ret += current.value;
	    ret += ",";
	    current = current.next;
	}
	ret += current.value;
	ret += "]";
	return ret;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode thing = start;
	for (int i = 0; i < index; i ++) {
	    thing = thing.next;
	}
	return thing.value;
    }

    public int set(int index, int v) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	int old;
	LNode thing = start;
	for (int i = 0; i < index; i ++) {
	    thing = thing.next;
	}
	old = thing.value;
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
        e.add(2,0);
	System.out.println(e);
	System.out.println(e.remove(2));
	System.out.println(e);
    }
}

