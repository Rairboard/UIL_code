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

public class sonic {
	char[][] m;
	int[][] shadow;
	boolean solved;
	int min;
    public static void main(String[] args) throws Exception {
        new sonic().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("sonic.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
			int r = f.nextInt(), c = f.nextInt(), sr = -1, sc = -1;f.nextLine();
			m = new char[r][c];
			shadow = new int[r][c];
			solved = false;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < r; i++) {
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
				String s = f.nextLine();
				m[i] = s.toCharArray();
				if(s.contains("M")){
					sr = i;
					sc = s.indexOf("M");
				}
			}
			recur(sr,sc,0,false);
			out.println(solved ? "Nice try, Robotnik":"Darn");
        }
        f.close();
    }
	public void recur(int r,int c, int step, boolean rings){
		if(r>=0 && r < m.length && c >=0 && c < m[r].length && step < min && step < shadow[r][c] && m[r][c] != 'X'){
			if(m[r][c] == 'E'){
				min = step;
				solved = true;
				return;
			}
			char save = m[r][c];
			shadow[r][c] = step;
			m[r][c] = 'X';
			if(save == 'R'){
				rings = true;
				recur(r-1,c,step+1,rings);
				recur(r+1,c,step+1,rings);
				recur(r,c-1,step+1,rings);
				recur(r,c+1,step+1,rings);
			}
			else if(save== 'F'){
				if(rings){
					rings =false;
					recur(r-1,c,step+1,rings);
					recur(r+1,c,step+1,rings);
					recur(r,c-1,step+1,rings);
					recur(r,c+1,step+1,rings);
				}
			}
			else if(save == 'S'){
				recur(r-3,c,step+1,rings);
				recur(r+3,c,step+1,rings);
				recur(r,c-3,step+1,rings);
				recur(r,c+3,step+1,rings);
			}
			else if(save == 'Y'){
				recur(r-2,c,step+1,rings);
				recur(r+2,c,step+1,rings);
				recur(r,c-2,step+1,rings);
				recur(r,c+2,step+1,rings);
			}else{
				recur(r-1,c,step+1,rings);
				recur(r+1,c,step+1,rings);
				recur(r,c-1,step+1,rings);
				recur(r,c+1,step+1,rings);
			}
			m[r][c] = save;
		}
	}
}
