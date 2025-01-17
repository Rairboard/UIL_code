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

public class volcano {
	char[][] m;
	int[][] shadow;
	int[][] volcano;
    public static void main(String[] args) throws Exception {
        new volcano().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("volcano").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int row = f.nextInt(), col = f.nextInt();
			int sr = -1, sc = -1, er = -1, ec =-1;
			f.nextLine();
			m = new char[row][col];
			shadow = new int[row][col];
			volcano = new int[row][col];
			List<int[]> al = new ArrayList<>();
			for (int i = 0; i < row; i++) {
				String ln = f.nextLine().trim();
				m[i] = ln.toCharArray();
				if (ln.contains("S")) {
					sr = i;
					sc = ln.indexOf("S");
				}
				if (ln.contains("C")) {
					er = i;
					ec = ln.indexOf("C");
				}
				for (int j = 0; j < col; j++) {
					if(ln.charAt(j)=='V'){
						al.add(new int[]{i,j});
					}
				}
				Arrays.fill(shadow[i], Integer.MAX_VALUE);
				Arrays.fill(volcano[i], Integer.MAX_VALUE);
			}
			for(int[] p : al){
				fill(p[0], p[1], 0);
			}
			if(volcano[sr][sc]!=Integer.MAX_VALUE){
				recur(sr,sc,0);
				if(shadow[er][ec]== Integer.MAX_VALUE || shadow[er][ec]>=volcano[er][ec]){
					out.println("YES");
				}
				else{
					out.println("NO");
				}
			}
			else{
				out.println("NO");
			}
        }
        f.close();
    }
	public void fill(int r, int c, int step){
		if(r>=0&&c>=0&&r<volcano.length&&c<volcano[r].length && m[r][c]!='W' && step < volcano[r][c]){
			volcano[r][c] = step;
			fill(r-1,c,step+1);
			fill(r+1,c,step+1);
			fill(r,c-1,step+1);
			fill(r,c+1,step+1);
		}
	}
	public void recur(int r, int c ,int step){
		if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&!"WT".contains(m[r][c]+"")&&step < shadow[r][c] && step < volcano[r][c]){
			shadow[r][c] = step;
			recur(r-1,c,step+1);
			recur(r+1,c,step+1);
			recur(r,c-1,step+1);
			recur(r,c+1,step+1);
		}
	}
}
