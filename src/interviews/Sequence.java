package interviews;
/*
 * Click `Run` to execute the snippet below!
 */
/**
 * Changes made AFTER the call
 * 1. optimized qMark to be a counter (as opposed to a list of indexes)
 * 2. Fixed escape character error in replaceFirst() method
 * 3. Added a return statement to convert the arrayList into the HashSet
 */

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named LogsAnalyzer.
 *
 * If you need more classes, simply define them inline.
 */

class Sequence {
    public static void main(String[] args) {

        String input = "0?1?";
        Set<String> output = replaceWildcards(input);
        System.out.println(output);
    }

    /**
     * Given a String containing the characters '0', '1' and '?',
     * return all the strings produced by replacing each '?' for both '0' and '1'.
     * i.e. '0?1?' -> '0010', '0011', '0110', '0111'
     */
    public static Set<String> replaceWildcards(String input) {
        // Your solution here

        // ? - 1,0 - 2 combinations
        // ?? - 4 combinations
        // ??? - 000, 001, 010, 011, 100, 101, 110, 111

        // 2^3
        // identify


        char[] chr = input.toCharArray();

        int qMark = 0;
        List<String> tempList = new ArrayList<String>();

        for (int i = 0; i < chr.length; i++) {
            if (chr[i] == '?') {
                qMark++;
            }
        }
            tempList.add(input);

            for (int j = 0; j < qMark; j++) {
                List<String> tempList1 = new ArrayList<String>();
                for (String str : tempList) {
                    tempList1.add(str.replaceFirst("\\?", "0"));
                    tempList1.add(str.replaceFirst("\\?", "1"));
                }
                tempList = tempList1;
            }

        return new HashSet<>(tempList);
        }
    }

