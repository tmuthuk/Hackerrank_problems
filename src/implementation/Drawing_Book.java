package implementation;

import java.util.*;

public class Drawing_Book {

    static int solve(int n, int p){
        // Complete this function
        int retVal;
        // from the beginning
        int fromBeginning = p/2;
        // from the end
        int fromEnd = (n - p)/2;

        if(n%2 == 0 && p %2 !=0 && p != n ) {
            fromEnd ++;
        }

        // if from beghinning < end then beginning
        if (fromBeginning < fromEnd)
            retVal = fromBeginning;
        else
            retVal = fromEnd;
        // else from end

        return retVal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
