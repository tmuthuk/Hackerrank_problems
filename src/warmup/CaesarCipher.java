package warmup;

import java.util.Scanner;

/**** 
 * @author Tamilthaaragai
 *PROBLEM STATEMENT
 *Julius Caesar protected his confidential information from his enemies by encrypting it. 
 *Caesar rotated every letter in the string by a fixed number K. This made the string unreadable by the enemy. You are 
 *given a string S and the number K. Encrypt the string and print the encrypted string.
 *For example: If the string is middle-Outz and K=2, the encoded string is okffng-Qwvb. Note that only the letters 
 *are encrypted while symbols like - are untouched. 'mbecomes 'o' when letters are rotated twice, 'i' becomes 'k', '-'
 * remains the same because only letters are encoded, 'z' becomes 'b' when rotated twice.
 * 
 * Input Format
 * Input consists of an integer N equal to the length of the string, followed by the string S and an integer K.
 * Constraints 
 * 1≤N≤100 
 * 0≤K≤100 
 * S is a valid ASCII string and doesn't contain any spaces.
 * 
 * TIME COMPLEXITY - O(n)
 * SPACE COMPLEXITY - O(n)
 */

public class CaesarCipher {

	public static void main(String[] args) {	
 
		//Scan the input from STDIN
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		
		if(N >= 1 && N <= 100){
			String c = sc.next();
			int k = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			if(k >=0 && k <= 100) {
			for(int i=0;i<c.length();i++) {
				char d = c.charAt(i);				
				if((d >= 'a' && d <= 'z') || (d >='A' && d <= 'Z')) {					 
					char incr = 0; 		
					char start_ltr = 0;
					int diff = 0;
					if(d >= 'a' && d <= 'z') {
						start_ltr = 'a';
						diff = (int) 'z' - d;
					}
					else {
						start_ltr = 'A';
						diff = (int) ('Z' - (char)d);
					}

						 if(k > diff) {
							 int lap = k%26;
							 if(lap > diff) {
								 incr = (char) (start_ltr +((lap - diff) - 1));
							 }	
							 else if(lap == diff){
								 incr = (char) (d +lap);
							 }
							 else if(lap < diff){
							incr = (char) (d +lap);  
							}
						}
						else {
							incr = (char) (d + k);
						}

					sb.append(incr);
				}
			//if the character is any special character, Just append it
				else{
					sb.append(d);
				}
			}				
		}
		System.out.println(sb.toString());
	}
	}
}
