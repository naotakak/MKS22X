import java.util.*;

public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help(words, s, "", 0);
	Collections.sort(words);
	return words;
    }
    
    private static void help( ArrayList<String> words, String s, String thing, int current){
        if (current >= s.length()) {
	    words.add(thing);
	}
	else {
	    help(words, s, thing, current + 1);
	    help(words, s, thing + s.charAt(current), current + 1);
	}
    }
    
    public static void main(String[]args) {
	System.out.println(combinations("abcd"));
    }
}
