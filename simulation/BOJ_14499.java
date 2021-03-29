import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int rowSize;
	static int colSize;
	static int[][] dice;
	static int[] cmds;
	static int curCol;
	static int curRow;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] info = br.readLine().split(" ");
		rowSize = Integer.parseInt(info[0]);
		colSize = Integer.parseInt(info[1]);
		curRow = Integer.parseInt(info[2]);
		curCol = Integer.parseInt(info[3]);
		int cmdCnt = Integer.parseInt(info[4]);

		map = new int[rowSize][colSize];
		dice = new int[4][3];
		cmds = new int[cmdCnt];
		for(int i = 0; i < rowSize; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j = 0; j < colSize; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		String[] mvs = br.readLine().split(" ");
		for(int i = 0; i < cmdCnt; i++) {
			cmds[i] = Integer.parseInt(mvs[i]);
		}

		for(int i = 0 ; i < cmdCnt; i++) {
			int nxt = cmds[i];
			move(nxt);
			//printDice();
		}

	}

	static void move(int cmd) {
		//check which direction
		//check if dice can move to next position
		if(canGo(cmd)) {
			//move
			//compare map vs dice
			//mark accordingly
			//print

			if(cmd == 1) { //east
				curCol++;
				eastDice();
			}else if(cmd == 2) { //west
				curCol--;
				westDice();
			}else if(cmd == 3) { //north
				curRow--;
				northDice();
			}else { //south;
				curRow++;
				southDice();
			}
			mark();
			System.out.println(dice[1][1]);

		}else {
			//System.out.println("cannot go next");
		}
	}

	static boolean canGo(int cmd) {
		int nxtRow = -1;
		int nxtCol = -1;

		if(cmd ==  1) { //east
			nxtCol = curCol + 1;
			nxtRow = curRow;
		}else if(cmd == 2) { //west
			nxtCol = curCol - 1;
			nxtRow = curRow;
		}else if(cmd == 3) { //north
			nxtCol = curCol;
			nxtRow = curRow - 1;
		}else if(cmd == 4) { //south
			nxtCol = curCol;
			nxtRow = curRow + 1;
		}else {
			//System.out.println("direction error");
		}

		if(nxtCol >= colSize || nxtRow >= rowSize || nxtCol < 0 || nxtRow < 0) {
			return false;
		}else {
			return true;
		}
	}
	static void printDice() {
		for(int i = 0; i < dice.length; i++) {
			for(int j = 0; j < dice[0].length; j++) {
				System.out.print(dice[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void eastDice() {
		int tmp1 = dice[1][0];
		int tmp2 = dice[1][1];
		int tmp3 = dice[1][2];

		dice[1][0] = dice[3][1];
		dice[1][1] = tmp1;
		dice[1][2] = tmp2;
		dice[3][1] = tmp3;

	}

	static void westDice() {
		int tmp1 = dice[1][0];
		int tmp2 = dice[1][1];
		int tmp3 = dice[1][2];

		dice[1][0] = tmp2;
		dice[1][1] = tmp3;
		dice[1][2] = dice[3][1];
		dice[3][1] = tmp1;
	}

	static void northDice() {

		int tmp1 = dice[0][1];
		int tmp2 = dice[1][1];
		int tmp3 = dice[2][1];

		dice[0][1] = tmp2;
		dice[1][1] = tmp3;
		dice[2][1] = dice[3][1];
		dice[3][1] = tmp1;
	}

	static void southDice() {

		int tmp1 = dice[0][1];
		int tmp2 = dice[1][1];
		int tmp3 = dice[2][1];

		dice[0][1] = dice[3][1];
		dice[1][1] = tmp1;
		dice[2][1] = tmp2;
		dice[3][1] = tmp3;


	}
	static void mark() {
		if(map[curRow][curCol] == 0) {
			map[curRow][curCol] = dice[3][1];

		}else {
			dice[3][1] = map[curRow][curCol];
			map[curRow][curCol] = 0;
		}
	}
}
