package strings;

import java.util.ArrayList;
import java.util.Scanner;

/***
 * 
 * @author Tamilthaaragai
 *Problem Statement

Roy wanted to increase his typing speed for programming contests. 
So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly, because it is a pangram. (Pangrams are sentences constructed by using every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence s, tell Roy if it is a pangram or not.

Input Format Input consists of a line containing s.

Constraints 
Length of s can be at most 103 (1≤|s|≤103) and it may contain spaces, 
lower case and upper case letters. Lower case and upper case instances of a letter are considered the same.

Output Format Output a line containing pangram if s is a pangram, 
otherwise output not pangram.
 */

public class Pangrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String c = sc.nextLine();
		c = c.toLowerCase();
		ArrayList list = new ArrayList();
		 
		if(c.length() >= 1 && c.length()<= Math.pow(10, 3)) {
			for(int i=0;i<c.length();i++) {
				if((c.charAt(i)>='a' && c.charAt(i)<='z') || (c.charAt(i)>='A' && c.charAt(i)<='Z')) {				
				if(!(list.contains(c.charAt(i)))) {
					list.add(c.charAt(i));
				}
			}
			}
			
			if(list.size() == 26) {
				System.out.println("pangram");
				return;
			}
			else {
				System.out.println("not pangram");
			}
		
		}
	}
}

