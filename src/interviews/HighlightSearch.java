package interviews;

import java.io.*;
import java.util.*;

/*
/**
* Curative
*/
public class HighlightSearch {
    // Highlight search
// text/corpus: banana
// query: ana
// result: b<b>ana</b>na



// finding the sequences that matches the query
// // banana : toCharArray

// b ,

// starPos =1 <b> a n a </b>

// query: ana
// a n n

// startPost + 1
// b, na as the result of the split
// []
    /*
     * Click `Run` to execute the snippet below!
     */
////
//     * To execute Java, please define "static void main" on a class
//     * named Solution.
//     *
//     * If you need more classes, simply define them inline.
//     */

        public static void main(String[] args) {
            System.out.println(highlightSearch("bananabanana", "ana"));

            System.out.println(highlightSearch("bannanabanana", "ana"));


        }

        public static String highlightSearch(String text, String query) {

            StringBuilder sb = new StringBuilder();

            char[] textArr = text.toCharArray();
            char[] queryArr = query.toCharArray();

            String openBold = "<b>";
            String closeBold = "</b>";

            int startPos = -1;
            int queryIndex = 0;


            // banana
            for(int index=0; index<textArr.length; index++) {

                if(textArr[index] == queryArr[queryIndex]) {
                    if(startPos == -1) {
                        startPos = index;
                    }
                    queryIndex++;

                } else if(startPos != -1) {
                    // reset the starPos index
                    // reset query Index as well
                    index = startPos;
                    sb.append(textArr[startPos]);
                    startPos = -1;
                    queryIndex = 0;


                } else {
                    sb.append(textArr[index]);
                }

                // if hit the limit, then append the <b> query</b>
                if(queryIndex == query.length()) {
                    sb.append(openBold);
                    sb.append(query);
                    sb.append(closeBold);
                    queryIndex = 0;
                    startPos = -1;
//                    sb.append(text.subSequence(index+1, text.length()));
//                    break;
                }

            }

            return sb.toString();
        }
    }

