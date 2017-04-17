package warmup;

import java.util.ArrayList;
import java.util.Scanner;

public class Cut_The_Sticks {

	public static int findMin(int[] arr) {
		int min = 1001;
		
		for(int i=0;i<arr.length;i++){
			
			if(arr[i]<min && arr[i]!=-1)
				min = arr[i];
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
//		ArrayList<Integer> al = new ArrayList<Integer>();
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		 
		int i=0;
		
		int no_of_nulls = 0;
		int temp = n;
		 
		
		
		while(temp!=0){			
			arr[i] = sc.nextInt();			 
		    i++;
			temp--;
		}
		
		while(no_of_nulls < n) {
			int min = findMin(arr);
			int total = 0;
			for(int j = 0;j<arr.length;j++) {
				if(arr[j]>min) {
					arr[j] = arr[j] - min;
					total++;
				}
				else if(arr[j] == min) {
					arr[j] = -1;
					total++;
					no_of_nulls++;
				}
			}
			System.out.println(total);
		}
		
		
	}

}
