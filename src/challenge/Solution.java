package challenge;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;

/**
 * Created by Tamilthaaragai on 8/15/2016.
 *
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }


        for(int a_i=0; a_i < n; a_i++){
            b[a_i] = in.nextInt();
        }
        MatchingSets ms = new MatchingSets(a, b);
        ms.matchingSetsDriver();
    }
}
