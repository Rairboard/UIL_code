import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class luana {
	char[][]orig, m , copy;
	int[][] dir = {{-1,-1,},{-1,0},{-1,1},{0,-1},{0,1},{1,1},{1,-1,},{1,0}};
    public static void main(String[] args) throws Exception {
        new luana().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("luana.dat"));
        //Scanner f = new Scanner(System.in);
		orig = new char[10][10];
		for (int i = 0; i < 10; i++) {
			orig[i] = f.nextLine().toCharArray();
		}
		int times = f.nextInt();
		while(times-->0){
			m = new char[10][10];
			for (int i = 0; i < orig.length; i++) {
				for (int j = 0; j < orig[i].length; j++) {
					m[i][j] = orig[i][j];
				}
			}
			List<Integer> dead = new ArrayList<>();
			List<Integer> alive = new ArrayList<>();
			int d = f.nextInt();
			for (int i = 0; i < d; i++) {
				dead.add(f.nextInt());
			}
			int a = f.nextInt();
			for (int i = 0; i < a; i++) {
				alive.add(f.nextInt());
			}
			int gen = f.nextInt();
			int sr = f.nextInt()-1, sc= f.nextInt()-1;
			out.print(m[sr][sc]=='*'?"A":"D");
			for (int i = 0; i < gen; i++) {
				copy = new char[10][10];
				for (int r = 0; r < m.length; r++) {
					for (int c = 0; c < m[r].length; c++) {
						int cell = count(r,c);
						if (m[r][c] == '*' && alive.contains(cell) || m[r][c] == '-' && dead.contains(cell)) {
							copy[r][c] = '*';
						}else{
							copy[r][c] = '-';
						}
					}
				}
				m = copy;
				out.print(m[sr][sc]=='*'?"A":"D");
			}
			out.println();
		}
        f.close();
    }
	public int count(int r, int c){
		int cnt = 0;
		for(int[] d : dir){
			int nr = r + d[0], nc = c + d[1];
			if(nr >=0 && nc >=0 && nr < m.length&&nc < m[nr].length&&m[nr][nc] == '*'){
				cnt++;
			}
		}
		return cnt;
	}
}