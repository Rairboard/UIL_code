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

public class Tang {
	char[][] m;
	int[][] shadow;
	List<int[]> portal;
    public static void main(String[] args) throws Exception {
        new Tang().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Tang").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		int times = f.nextInt();
		f.nextLine();
		for (int asdf = 0; asdf < times; asdf++) {
			int row = f.nextInt(),col = f.nextInt();
			f.nextLine();
			int sr = -1, sc = -1, er = -1, ec = -1;
			portal = new ArrayList<>();
			m = new char[row][col];
			shadow = new int[row][col];
			for (int i = 0; i < row; i++) {
				m[i] = f.nextLine().trim().toCharArray();
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
				for (int j = 0; j < col; j++) {
					if(m[i][j]=='T'){
						sr = i;
						sc = j;
					}
					else if(m[i][j]=='P'){
						er = i;
						ec = j;
					}
					else if(m[i][j]=='O'){
						portal.add(new int[]{i,j});
					}
				}
			}
			recur(sr,sc,0);
			if((er == -1 && ec == -1) || shadow[er][ec]==Integer.MAX_VALUE || shadow[er][ec]>30){
				out.println("Tang isn't great at thinking with portals.");
			}
			else{
				out.println("It took Tang " + shadow[er][ec] + " minute(s) to get to the nearest Pear Inc. Store.");
			}
//			for (int i = 0; i < row; i++) {
//				out.println(Arrays.toString(shadow[i]));
//			}
		}
        f.close();
    }
	public void recur(int r, int c, int step){
		if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'&&step<shadow[r][c]){
			shadow[r][c] = step;
			if(m[r][c]=='P') return;
			if(m[r][c]=='O'){
				for (int i = 0; i < portal.size(); i++) {
					int nr = portal.get(i)[0];
					int nc = portal.get(i)[1];
					if(nr==r && nc == c) continue;
					recur(nr,nc,step+1);
				}
			}
			recur(r-1,c,step+1);
			recur(r+1,c,step+1);
			recur(r,c-1,step+1);
			recur(r,c+1,step+1);
		}
	}
}
