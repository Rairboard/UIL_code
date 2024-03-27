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

public class fewwawi {
	char[][] m;
	int[][] shadow;
	int[][] cop;
	int min;
	boolean solved;

    public static void main(String[] args) throws Exception {
        new fewwawi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("fewwawi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int r = f.nextInt(), c = f.nextInt(),sr = -1, sc = -1;
			f.nextLine();
			m = new char[r][c];
			shadow = new int[r][c];
			cop = new int[r][c];
			solved = false;
			min = Integer.MAX_VALUE;

			for (int i = 0; i < r; i++) {
				String ln = f.nextLine();
				m[i] = ln.toCharArray();
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
				Arrays.fill(cop[i],Integer.MAX_VALUE);
				if (ln.contains("F")) {
					sr = i;
					sc = ln.indexOf("F");
				}
			}

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(m[i][j] == 'C'){
						fill(i,j,0);
					}
				}
			}

			recur(sr,sc,0);
			out.println(solved?min:"Caught");
        }
        f.close();
    }
	public void recur(int r, int c, int step){
		if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&step<shadow[r][c]&&step<cop[r][c]&&m[r][c]!='P'&&m[r][c]!='#'){
			shadow[r][c] = step;
			if(m[r][c]=='E'){
				min = step;
				solved = true;
				return;
			}
			char save = m[r][c];
			m[r][c] = '#';
			recur(r-1,c,step+1);
			recur(r+1,c,step+1);
			recur(r,c-1,step+1);
			recur(r,c+1,step+1);
			m[r][c] = save;
		}
	}
	public void fill(int r, int c, int step){
		if(r>=0&r<m.length&&c>=0&&c<m[r].length&&step<cop[r][c]&&m[r][c]!='P'&&m[r][c]!='#'){
			cop[r][c] = step;
			fill(r-1,c,step+1);
			fill(r+1,c,step+1);
			fill(r,c-1,step+1);
			fill(r,c+1,step+1);
		}
	}
}
