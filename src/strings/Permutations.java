package strings;

/**
 * Created by Tamilthaaragai on 4/16/2017.
 * Reference: Cracking the Coding Interview
 */
public class Permutations {

    public static void main(String args[]) {
        permutations("abcde");
    }

    static void permutations(String str) {
         permutation(str, "");
    }

    static void permutation(String str, String prefix) {
        if(str.length() == 0) {
            System.out.println(prefix);
        } else {
            for(int i=0; i< str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}
