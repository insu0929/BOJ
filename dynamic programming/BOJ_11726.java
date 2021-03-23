package dp;

import java.util.*;

public class BOJ_11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		arr[0] = 1;
		
		if(n == 1) {
			System.out.println(arr[0]);
		}else if(n == 2) {
			arr[1] = 2;
			System.out.println(arr[1]);
		}else {
			arr[1] = 2;
			for(int i = 2; i < n ;i++) {
				arr[i] = Math.abs((arr[i - 1] + arr[i - 2]) % 10007);
			}
			System.out.println(arr[n - 1]);
		}
	}
}
