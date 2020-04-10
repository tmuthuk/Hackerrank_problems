package implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/encryption/problem
 *
 */
public class Encryption {
    // Complete the encryption function below.
    static String encryption(String s) {

        // remove hte character spaces
        char[] charArray = s.toCharArray();
        int len = charArray.length;

        // find the square root
        double sqRt = Math.sqrt(len);
        int flor = (int) Math.floor(sqRt);
        int cel = (int) Math.ceil(sqRt);

        if((flor * cel) < len) {
            flor = cel;
        }

        // init two dim char array
        char[][] initCharArray = new char[flor][cel];
        int counter = 0;
        for (int i=0; i<flor; i++) {
            for (int j=0; j<cel; j++) {
                if (counter< len) {
                    initCharArray[i][j] = charArray[counter];
                } else {
                    initCharArray[i][j] = ' ';
                }
                counter++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int j=0; j<cel; j++) {
            for (int i=0; i<flor; i++) {

                if(initCharArray[i][j] != ' ') {
                    builder.append(initCharArray[i][j]);
                }
            }
            builder.append(" ");
        }
        String finalResult = builder.toString();
        return finalResult;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        String s = scanner.nextLine();

        String result = encryption(s);

        System.out.println(result);
        scanner.close();
    }
}
