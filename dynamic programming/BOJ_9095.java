package dp;

import java.util.*;
public class BOJ_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int testNo = sc.nextInt();
		
		for(int i = 0 ; i < testNo; i++) {
			
			int no = sc.nextInt();
			
			if(no == 1) {
				System.out.println(1);
			}else if(no == 2) {
				System.out.println(2);
			}else {
				
				int[] arr = new int[12];
					
				arr[1] = 1;
				arr[2] = 2;
				arr[3] = 4;
				
				for(int j = 4; j <= no; j++) {
					arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
				}
				System.out.println(arr[no]);

			}			
			
		}
	}

}
