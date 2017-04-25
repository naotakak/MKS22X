import java.util.Stack;

public class StackCalc {

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

    private static double apply(String b, String a, String op) {
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
        System.out.println(eval("10 2 +"));//12.0
	System.out.println(eval("10 2 -"));//8.0
	System.out.println(eval("10 2.0 +"));//12.0
	System.out.println(eval("11 3 - 4 + 2.5 *"));//30.0
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
	System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }
}
