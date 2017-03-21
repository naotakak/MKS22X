public class Recursion {

    public static double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException("n must be greater than 0");
	}
	return helper(n, n / 2);
    }

    private static double helper(double n, double guess) {
	if (n == 0) {
	    return 0;
	}
	if ((n - guess * guess) / n <= .000000000000001 && n - guess * guess >= 0) {
	    return guess;
	}
	return helper(n, (n / guess + guess) / 2);
    }
    
    public static String name() {
	return "Kinoshita,Naotaka";
    }

}
