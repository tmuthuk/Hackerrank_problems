package warmup;

import java.util.Scanner;

public class Mars_Exploration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	Scanner sc = new Scanner(System.in);		
		String input = "SOSSPSSQSSOR"; // sc.next();
		
		//char[] inputChar = input.toCharArray();
		
		int total = 0;
		int i=1;
		
		while(i < input.length()){
			String subStr = input.substring(i, i+3);
			total = findChars(subStr);
			i += 3;
		}
		
		System.out.println(total);
	}
	
	public static int findChars(String subStr) {
		char[] inputSeq = subStr.toCharArray();
		char[] seq = {'S','O','S'};
		int total = 0;
		int i = 0;
		if(inputSeq[0] != seq[0]){
			total++;
		}
		if(inputSeq[1] != seq[1]) {
			total++;
		}
		if(inputSeq[2] != seq[2]) {
			total++;
		}
		return total;
	}
}
