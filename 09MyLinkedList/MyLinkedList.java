public class MyLinkedList {

    private LNode start;
    private int size;

    public MyLinkedList(int v) {
	start = new LNode(v);
	size += 1;
    }

    public boolean add(int value) {
	size += 1;
	LNode n = new LNode(value, start);
	start = n;
	return true;
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
	ret += "]";
	return ret;
    }

    public int get(int index) {
	if (index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode old = start;
	LNode thing = new LNode(0);
	for (int i = 0; i < index; i ++) {
	    thing = start.next;
	    start.next = thing;
	}
	return thing.value;
    }

    public int set(int index, int v) {
	if (index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	int old;
	LNode thing = new LNode(0);
	for (int i = 0; i < index; i ++) {
	    thing = start.next;
	}
	old = thing.value;
	thing.value = v;
	return old;
    }

    public class LNode {
    
	private int value;
	private LNode next;
	
	public LNode(int v, LNode n) {
	    value = v;
	    next = n;
	}
	
	public LNode(int v) {
	    value = v;
	}	
    }

    public static void main(String[]args) {
	MyLinkedList e = new MyLinkedList(10);
	for (int i = 9; i >= 0; i --) {
	    e.add(i);
	}
	System.out.println(e);
	System.out.println(e.get(9));
    }
}

