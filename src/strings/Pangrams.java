package strings;

import java.util.ArrayList;
import java.util.Scanner;

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

