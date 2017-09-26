package warmup;

import java.util.Scanner;


/**
 * Consider a staircase of size : n = 4

    #
   ##
  ###
 ####
 Observe that its base and height are both equal to n, and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.

 Write a program that prints a staircase of size n.

 Input Format

 A single integer, n, denoting the size of the staircase.

 Output Format

 Print a staircase of size n using # symbols and spaces.
 */
public class Staircase {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		for(int i=n; i>0; i--) {
			for(int j=1; j<=n; j++) {
				if(j >= i) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}


	}

}
