import java.io.*;
import java.util.*;

class Pos{
	int row;
	int col;
	public Pos(int row, int col) {
		this.row = row;
		this.col = col;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Pos p = (Pos)obj;
		if(p.row == this.row && this.col == p.col)
			return true;
		else
			return false;
	}
}


public class Main {
	static int dir = 1;
	static int n = 0;
	static int k = 0;
	static int l = 0;
	static int[][] map;
	static String[] cmds = new String[10000];
	static int curRow = 1;
	static int curCol = 1;
	static ArrayList<Pos> snake = new ArrayList();
	static int t = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n+2][n+2];
		initMap();
		k = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < k ; i++) {
			String[] aps = br.readLine().split(" ");
			int apRow = Integer.parseInt(aps[0]);
			int apCol = Integer.parseInt(aps[1]);

			map[apRow][apCol] = 2;

		}

		l = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < l; i++) {
			String[] mvs = br.readLine().split(" ");
			int time = Integer.parseInt(mvs[0]);
			String mv = mvs[1];
			cmds[time] = mv;
		}

		snake.add(new Pos(curRow, curCol));
		turn(t);
		while(true) {
			turn(t);
			if(!moveable()) break;
			move();
			apple();
			t++;
			//printSnake();
		}
		System.out.println(t);
	}
	static void apple(){
		if(map[curRow][curCol] != 2) {
			snake.remove(0);
		}else {
			map[curRow][curCol] = 0;
		}
	}

	static void move() {
		if(dir == 1) { //east
			curCol++;
		}else if(dir == 2) { //south
			curRow++;
		}else if(dir == 3) { //west
			curCol--;
		}else { //north
			curRow--;
		}
		Pos cur = new Pos(curRow, curCol);
		snake.add(cur);
	}

	static void turn(int t){
		String cmd = cmds[t];
		if(cmd == null) return;

		if(dir == 1) { //east
			if(cmd.contentEquals("L")) {
				dir = 4;
			}else if(cmd.contentEquals("D")) {
				dir = 2;
			}
		}else if(dir == 2) { //south
			if(cmd.contentEquals("L")) {
				dir = 1;
			}else if(cmd.contentEquals("D")) {
				dir = 3;
			}
		}else if(dir ==  3) { //west
			if(cmd.contentEquals("L")) {
				dir = 2;
			}else if(cmd.contentEquals("D")) {
				dir = 4;
			}
		}else { //north
			if(cmd.contentEquals("L")) {
				dir = 3;
			}else if(cmd.contentEquals("D")) {
				dir = 1;
			}
		}
	}

	static void printSnake() {
		for(int i = 0 ; i < snake.size(); i++) {
			Pos p = snake.get(i);
			System.out.println(p.row + " " + p.col);
		}
		System.out.println();
	}

	static boolean moveable() {
		int nxtRow = 0;
		int nxtCol = 0;

		if(dir == 1) { //east
			nxtCol = curCol + 1;
			nxtRow = curRow;
		}else if(dir == 2) { //south
			nxtRow = curRow + 1;
			nxtCol = curCol;
		}else if(dir == 3) { //west
			nxtRow = curRow;
			nxtCol = curCol - 1;
		}else { //north
			nxtRow = curRow - 1;
			nxtCol = curCol;
		}
		Pos p = new Pos(nxtRow, nxtCol);
		if(map[curRow][curCol] == 0) {
			if(!snake.contains(p)) {
				return true;
			}else {
				t++;
				return false;
			}
		}else
			return false;
	}

	static void printMap() {
		for(int i = 0; i < map.length ; i++) {
			for(int j = 0 ; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void initMap(){
		for(int i = 0; i < map.length; i++) {
			map[0][i] = 1;
			map[i][0] = 1;
			map[map.length-1][i] = 1;
			map[i][map.length-1] = 1;
		}
	}
}