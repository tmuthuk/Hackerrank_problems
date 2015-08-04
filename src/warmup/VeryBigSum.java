package warmup;

import java.io.*;
import java.util.*;
import java.math.*;

public class VeryBigSum {
	/*
	 * PROBLEM STATEMENT FROM HACKERRANK
	 * Problem Statement :

		You are given an array of integers of size N. You need to print the sum of the elements of the array.		

		Input Format

		The first line of the input consists of an integer N. The next lines contain N space separated integers describing the array.

		Constraints 
		1≤N≤10 
		0≤A[i]≤1010

		Output Format

		Output a single value equal to the sum of the elements of the array.
	 */
	
	public static void main(String[] args) {
		//get the N value 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		 
		long sum = 0;
		if(N >= 0 && N <= 10) {				
			while (sc.hasNext()) {
				//loop until N and fill the array with integer values => can be long too
				int num = sc.nextInt();
				if(num >= 0 && num <= Math.pow(10, 10)) {
					sum = sum + num;
				}
			}
		}
		System.out.println(sum);
	}
	
}
