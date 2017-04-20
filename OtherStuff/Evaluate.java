import java.util.Stack;

public class Evaluate {

    public static double eval(String s) {
	Stack thing = new Stack();
	double[] ary = s.split(" ");
	for (int i = 0; i < ary.length; i ++) {
	    if (isOperator(ary[i])) {
		thing.push(apply(thing.pop(), thing.pop(), ary[i]));
	    }
	    else {
		thing.push(ary[i]);
	    }
	}
	return thing.pop();
    }

    private static boolean isOperator(String s) {
	return s.equals("+") || s.equals("-") 
	    || s.equals("*") || s.equals("/") || s.equals("%");
    }

    private static double apply(String a, String b, String op) {
	return 0.0;
    }

}
