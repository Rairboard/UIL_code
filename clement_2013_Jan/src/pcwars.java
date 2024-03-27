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

public class pcwars {
	char[][] m, v;
	int[][] shadow;
	Map<Character, Integer> cost;
    public static void main(String[] args) throws Exception {
        new pcwars().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pcwars").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		cost = new HashMap<>();
		String w = "-TM";
		int[] val = {1,2,4};
		for (int i = 0; i < 3; i++) {
			cost.put(w.charAt(i),val[i]);
		}
		int r = f.nextInt(), c = f.nextInt(), sr = f.nextInt() - 1, sc = f.nextInt()-1, max = f.nextInt();
		f.nextLine();
		m = new char[r][c];
		v = new char[r][c];
		shadow = new int[r][c];
		for (int i = 0; i < r; i++) {
			String ln = f.nextLine();
			m[i] = ln.toCharArray();
			v[i] = ln.toCharArray();
			Arrays.fill(shadow[i],Integer.MAX_VALUE);
		}
		recur(sr,sc,0,max);
		for(char[] cc : v){
			System.out.println(cc);
		}

        f.close();
    }
	public void recur(int r, int c, int step, int max){
		if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&m[r][c]!='x' && step < shadow[r][c]){
			char save = m[r][c];
			if(step==0){
				shadow[r][c] = step;
				m[r][c] = 'x';
				v[r][c] = 'x';
				recur(r-1,c,step,max);
				recur(r+1,c,step,max);
				recur(r,c-1,step,max);
				recur(r,c+1,step,max);
			}
			else if(step + cost.get(m[r][c]) <= max){
				shadow[r][c] = step;
				m[r][c] = 'x';
				v[r][c] = 'x';
				recur(r-1,c,step+cost.get(m[r][c]),max);
				recur(r+1,c,step+cost.get(m[r][c]),max);
				recur(r,c-1,step+cost.get(m[r][c]),max);
				recur(r,c+1,step+cost.get(m[r][c]),max);
			}
			m[r][c] = save;
		}
	}
}
