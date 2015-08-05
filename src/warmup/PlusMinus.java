package warmup;

import java.math.BigDecimal;
import java.util.Scanner;

public class PlusMinus {
	
	/***
	 * PROBLEM STATEMENT
	 * You're given an array containing integer values. 
	 * You need to print the fraction of count of positive numbers, 
	 * negative numbers and zeroes to the total numbers. 
	 * Print the value of the fractions correct to 3 decimal places.
	
		Input Format
	
		First line contains N, which is the size of the array. 
		Next line contains N integers A1,A2,A3,⋯,AN, separated by space.
		
		Constraints 
		1≤N≤100 
		−100≤Ai≤100
		Output Format
		
		Output three values on different lines equal to the fraction of count of 
		positive numbers, negative numbers and zeroes to the total numbers respectively correct to 3 decimal places.
		
		Complexity :Time O(n)
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//Precision can be well manipulated using BigDecimal in Java
		BigDecimal posFraction;
		
		int pos = 0;
		int neg = 0;
		int zer = 0;
		int total = 0;
		if(N >= 1 && N <=100) {
			int i = 0;
			while(sc.hasNext()) {
				int val = sc.nextInt();				
				if(val >= -100 && val <= 100) {
				
					if(val<0) {
						neg++;
					}
					else if(val == 0) {
						zer++;
					}
					else {
						pos++;
					}					
					total++;
				}
				//i++;
			}
			 posFraction = new BigDecimal((float)pos/total).setScale(3,BigDecimal.ROUND_DOWN);
			 			 
			 System.out.println(posFraction);
			 
			 posFraction = new BigDecimal((float)neg/total).setScale(3,BigDecimal.ROUND_DOWN);
			 System.out.println(posFraction);
			 
			 posFraction = new BigDecimal((float)zer/total).setScale(3,BigDecimal.ROUND_DOWN);
			 System.out.println(posFraction);
		}
		 
	}

}
