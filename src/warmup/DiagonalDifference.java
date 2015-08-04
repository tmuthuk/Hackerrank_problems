package warmup;

import java.io.*;
import java.util.*;
import java.math.*;

public class DiagonalDifference {
	
	/*PROBLEM STATEMENT */
	public static void main(String[] args) {
		
		/***Algorithm 
		 * Get N value from STDIN
		 * Check constraint 1<=N <= 100
		 * Loop until N and get the values in each column 'j' in row 'i'
		 * Check constraint -100<=A[i]<=100
		 * var1=left diagonal
		 * var2 = right diagonal
		 * absolute(var1 - var2)
		 * Time Complexity: O(n)
		 * Space Complexity: O(1)		 * 
		 */
		//Scan the input from STDIN
		Scanner sc = new Scanner(System.in);
		int diag1 = 0;
		int diag2 = 0;
		int N = sc.nextInt();		
		if(N >= 1 && N <= 100){
			
			int i = 0, j =0;
			//Pointer that indicates the position for right->left diagonal
			int lastCol = N-1;
			while(sc.hasNextInt()) {
				//if the column iterator has reached the end, reinitialize it to 0 and increment the row
				if(j == N) {
					i++;
					j = 0;
				}
				
				int next = sc.nextInt();
				
				//sums the diagonal that runs from left to right
				if(i == j) {
					diag1 += next;
				}
				
				//sums the diagonal that runs from right to left
				if(j == lastCol) {
					diag2 += next;
					lastCol--;
				}				
				j++;
			}			
		}
		
		System.out.println(Math.abs(diag1 - diag2));
	}

}
