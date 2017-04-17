package warmup;

import java.util.Scanner;

public class ChocFeast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//total amount
		int n;
		
		//price per choc
		int c;
		
		//no of wrappers to exchange
		int m;
		
		//total lines of input
		int t;
		
		Scanner sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		while(t!=0) {
			
			n = sc.nextInt();
			c = sc.nextInt();
			m = sc.nextInt();
			
			int totChoc = 0;
			
			int remChoc = 0;
			
			totChoc = n/c;
			
			remChoc = totChoc;
			
			while(remChoc >= m) {
				 totChoc++;
				 remChoc = remChoc - m;
				 remChoc++;
			}
			
			System.out.println(totChoc);
			
			t--;
		}

	}

}
