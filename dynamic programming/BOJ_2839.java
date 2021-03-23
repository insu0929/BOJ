import java.util.*;

public class BOJ_2839{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int totWeight = sc.nextInt();


		int answer = 0;

		while(totWeight >= 3) {
			//System.out.println(totWeight);
			if(totWeight % 5 != 0) {

				totWeight -= 3;
				answer++;

			}else {
				//divisible by 5
				answer += totWeight / 5;
				totWeight = 0;
			}
		}

		if(totWeight == 0) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}


	}
}