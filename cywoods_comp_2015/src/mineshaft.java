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

public class Mineshaft {
	char[][][] m;
	int[][][] shadow;
	int min;
	boolean solved;
    public static void main(String[] args) throws Exception {
        new Mineshaft().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Mineshaft").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int l = f.nextInt(), r = f.nextInt(), c = f.nextInt(), shovel = f.nextInt(), sl = -1, sr = -1, sc = -1;
			f.nextLine();
			m = new char[l][r][c];
			shadow = new int[l][r][c];
			min = Integer.MAX_VALUE;
			solved = false;
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String ln = f.nextLine();
					if (ln.contains("S")) {
						sl = i;
						sr = j;
						sc = ln.indexOf("S");
					}
					m[i][j] = ln.toCharArray();
					Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
				}
			}
			recur(sl,sr,sc,0,shovel);
			if(solved && min != Integer.MAX_VALUE){
				out.println(min + " SECONDS");
			}else{
				out.println("DEAD");
			}
        }
        f.close();
    }
	public void recur(int l, int r, int c, int step, int d){
		if(l>=0&&r>=0&&c>=0&&l<m.length&& r<m[l].length&&c<m[l][r].length && m[l][r][c]!='#'&&step < shadow[l][r][c]){
			shadow[l][r][c] = step;
			if(m[l][r][c]=='E'){
				min = step;
				solved = true;
				return;
			}
			if(m[l][r][c] == '%'){
				if(d == 0){
					return;
				}
				char save= m[l][r][c];
				m[l][r][c] = '#';
				step+=3;
				recur(l-1,r,c,step+3,d-1);
				recur(l+1,r,c,step+2,d-1);
				recur(l,r-1,c,step+1,d-1);
				recur(l,r+1,c,step+1,d-1);
				recur(l,r,c-1,step+1,d-1);
				recur(l,r,c+1,step+1,d-1);
				m[l][r][c] = save;
			}
			else{
				char save= m[l][r][c];
				m[l][r][c] = '#';
				recur(l-1,r,c,step+3,d);
				recur(l+1,r,c,step+2,d);
				recur(l,r-1,c,step+1,d);
				recur(l,r+1,c,step+1,d);
				recur(l,r,c-1,step+1,d);
				recur(l,r,c+1,step+1,d);
				m[l][r][c] = save;
			}
		}
	}
}
