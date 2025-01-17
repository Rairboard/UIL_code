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

public class frogger {
	char[][] m;
	int[][] shadow;
    public static void main(String[] args) throws Exception {
        new frogger().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("frogger").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int row = f.nextInt(), col = f.nextInt();
			int sr = -1, sc = -1, er = -1, ec = -1;
			f.nextLine();
			m= new char[row][col];
			shadow = new int[row][col];
			for (int i = 0; i < row; i++) {
				String ln = f.nextLine().trim();
				if (ln.contains("$")) {
					sr = i;
					sc = ln.indexOf("$");
				}
				if (ln.contains("@")) {
					er = i;
					ec = ln.indexOf("@");
				}
				m[i] = ln.toCharArray();
				Arrays.fill(shadow[i], Integer.MAX_VALUE);
			}
			recur(sr, sc, 1);
			out.println(shadow[er][ec]);
        }
        f.close();
    }
	public void recur(int r, int c, int step){
		 if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='*' && step < shadow[r][c]){
			 shadow[r][c] = step;
			 if(m[r][c]=='@'){
				 return;
			 }
			 if (Character.isDigit(m[r][c])) {
				 int jump = m[r][c] - '0';
				 recur(r-jump-1, c, step+1);
				 recur(r+jump+1, c, step+1);
				 recur(r,c-jump-1, step+1);
				 recur(r,c+jump+1, step+1);
			 }
			 recur(r-1,c,step+1);
			 recur(r+1,c,step+1);
			 recur(r,c-1,step+1);
			 recur(r,c+1,step+1);
		 }
	}
}
