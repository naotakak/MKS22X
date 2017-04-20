import java.util.Stack;

public class Evaluate {

    public static double eval(String s) {
	Stack<String> thing = new Stack<String>();
	String[] ary = s.split(" ");
	for (int i = 0; i < ary.length; i ++) {
	    if (isOperator(ary[i])) {
		thing.push("" + apply(thing.pop(), thing.pop(), ary[i]));
	    }
	    else {
		thing.push(ary[i]);
	    }
	}
	return Double.parseDouble(thing.pop());
    }

    private static boolean isOperator(String s) {
	return s.equals("+") || s.equals("-") 
	    || s.equals("*") || s.equals("/") || s.equals("%");
    }

    private static double apply(String a, String b, String op) {
	if (op.equals("+")) {
	    return Double.parseDouble(a) + Double.parseDouble(b);
	}
	else if (op.equals("-")) {
	    return Double.parseDouble(a) - Double.parseDouble(b);
	}
	else if (op.equals("*")) {
	    return Double.parseDouble(a) * Double.parseDouble(b);
	}
	else if (op.equals("/")) {
	    return Double.parseDouble(a) / Double.parseDouble(b);
	}
        else {
	    return Double.parseDouble(a) % Double.parseDouble(b);
	}
    }

    public static void main (String[]args) {
	System.out.println(eval("2 3 + 5 * 5 % 2 2 - +"));
    }
}
