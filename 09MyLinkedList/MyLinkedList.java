public class MyLinkedList {

    private LNode start;
    private int size;

    public MyLinkedList() {

    }

    public void add(LNode new) {
	size += 1;
	new.next = start;
	start = new;
    }

    public String toString() {
	String ret = "";
	LNode current = start;
	for (int i = 0; i < this.size(); i ++) {
	    ret += current.next();
	}
	return ret;
    }
}
