import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> sents = new ArrayList();

		String str;
		String cut = "";

		//input process
		while(true) {

			str = br.readLine();
			if(str.contentEquals(".")) break;
			cut += str;

			int start = 0;
			for(int i = 0; i < cut.length(); i++) {
				if(cut.charAt(i) == '.') {
					String proced = cut.substring(start, i);
					cut = cut.substring(i, cut.length()-1);
					start = i;
					sents.add(proced);
				}
			}
		}
		//check parenthesis validity
		for(String sentence: sents) {
			//System.out.println(sentence);
			//parenthesis
			Stack<Integer> stack = new Stack();
			//bracket
			int type = 0;
			boolean flag1 = false;
			boolean flag2 = false;

			for(int i = 0; i < sentence.length(); i++) {
				char c = sentence.charAt(i);

				if(c == '(') {
					stack.push(1);
				}

				if(c == '[') {
					stack.push(2);
				}

				if(c == ')') {
					if(stack.isEmpty()) {
						flag1 = true;
						break;
					}else {
						if(stack.peek() != 1) {
							flag1 = true;
							break;
						}else
							stack.pop();
					}
				}

				if(c == ']') {
					if(stack.isEmpty()) {
						flag2 = true;
						break;
					}else {
						if(stack.peek() != 2) {
							flag2 = true;
							break;
						}else {
							stack.pop();

						}
					}
				}
			}

			if(stack.isEmpty()&& !flag1 && !flag2)
				System.out.println("yes");
			else
				System.out.println("no");
		}



	}



}
