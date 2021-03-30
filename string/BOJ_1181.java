import java.io.*;
import java.util.*;


class Word implements Comparable<Word>{
	String word;
	int length;

	public Word(String word) {
		this.word = word;
		this.length = word.length();
	}

	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub

		if(this.length > o.length) {
			return 1;
		}else if(this.length < o.length) {
			return -1;
		}else {

			for(int i = 0 ; i < this.length; i++) {

				if(this.word.charAt(i) > o.word.charAt(i)) {
					return 1;
				}else if (this.word.charAt(i) < o.word.charAt(i)){
					return -1;
				}else {
					continue;
				}
			}
			return 0;
		}
	}

}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = Integer.parseInt(br.readLine());

		TreeSet<Word> ts = new TreeSet();

		for(int i = 0 ; i < len; i++) {
			String word = br.readLine();
			Word w = new Word(word);
			ts.add(w);
		}

		Iterator<Word> w = ts.iterator();

		while(w.hasNext()) {
			Word wo = w.next();
			System.out.println(wo.word);
		}

	}

}