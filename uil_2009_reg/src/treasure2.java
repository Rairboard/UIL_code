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

public class treasure2 {
	char[][] m;
	int[][] gold;
	int max, k;
    public static void main(String[] args) throws Exception {
        new treasure2().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("treasure").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			k = f.nextInt();
			int r = f.nextInt()+2, c =f.nextInt()+2, sr = -1, sc = -1;
			f.nextLine();
			m = new char[r][c];
			gold = new int[r][c];
			max = Integer.MIN_VALUE;
			for (int i = 0; i < r; i++) {
				String ln = f.nextLine();
				m[i] = ln.toCharArray();
				Arrays.fill(gold[i],Integer.MIN_VALUE);
				if(ln.contains("*")){
					sr = i;
					sc = ln.indexOf("*");
				}
			}
			recur(sr,sc,0,0);
			out.println(max);
        }
        f.close();
    }
	public void recur(int r, int c, int step, int g){
		if(r>=0&&r<m.length&&c>=0&&c<m[r].length && step <= k){
			int val = m[r][c] - '0';
			if(step==k){
				if(Character.isDigit(m[r][c])){
					max = Math.max(g+val,max);
				}
				else{
					max = Math.max(g,max);
				}
				return;
			}
			char save = m[r][c];
			m[r][c] = '.';
			if(Character.isDigit(save)){
				recur(r-1,c,step+1,g+val);
				recur(r+1,c,step+1,g+val);
				recur(r,c-1,step+1,g+val);
				recur(r,c+1,step+1,g+val);
			}
			else{
				recur(r-1,c,step+1,g);
				recur(r+1,c,step+1,g);
				recur(r,c-1,step+1,g);
				recur(r,c+1,step+1,g);
			}
			m[r][c] = save;
		}
	}
}
