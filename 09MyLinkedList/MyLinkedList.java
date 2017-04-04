public class MyLinkedList {

    private LNode start;
    private LNode end;
    private int size = 0;

    public MyLinkedList() {
	start = new LNode();
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
        thing = getNode(index);
	insertAfter(addition, thing.prev);
	size += 1;
    }

    public int remove(int index) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode thing = getNode(index);
	int val = thing.value;
	remove(thing);
	size -= 1;
	return val;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	LNode thing = getNode(index);
	return thing.value;
    }

    public int set(int index, int v) {
	if (index >= size || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
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
	LNode startNode;
	if (chooseSide(index)) {
	    startNode = start;
	    for (int i = 0; i < index; i ++) {
		startNode = startNode.next;
	    }
	}
	else {
	    startNode = end;
	    for (int i = size - 1; i > index; i ++) {
		startNode = startNode.prev;
	    }
	}
	return startNode;
    }

    private void remove(LNode node) {
	node.prev.next = node.next;
	node.next.prev = node.prev;
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
        e.add(2,0);
	System.out.println(e);
	System.out.println(e.remove(2));
	System.out.println(e);
	System.out.println(e.indexOf(2));
	System.out.println(e.get(2));
	System.out.println(e.set(2,0));
	System.out.println(e);
    }
}

