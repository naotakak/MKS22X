import java.util.*;

public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help( words , s);
	Collections.sort(words);
	return words;
    }
    
    private static void help( ArrayList<String> words, String s){
	if (s.length() == 0) {
	    return;
	}
	String add = s.substring(0,1);
	if (words.indexOf(add) == -1) {
	    words.add(add);
	}
	for (int c = 1 ; c < s.length(); c ++) {
	    add += s.charAt(c);
	    if (words.indexOf(add) == -1) {
		words.add(add);
	    }
	}
	help(words , s.substring(1));
	if (words.indexOf("") == -1) {
	    words.add("");
	}
    }

    public static void main(String[]args) {
	System.out.println(combinations("abcd"));
    }
}
