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
		for (int asdf = 0; asdf < times; asdf++) {
			int row = f.nextInt(), col = f.nextInt();
			int sr = -1, sc = -1, er = -1, ec = -1;
			f.nextLine();
			m = new char[row][col];
			shadow = new int[row][col];
			volcano = new int[row][col];
			List<int[]> al =new ArrayList<>();
			for (int i = 0; i < row; i++) {
				m[i] = f.nextLine().trim().toCharArray();
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
				Arrays.fill(volcano[i],Integer.MAX_VALUE);
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j]=='S'){
						sr = i;
						sc = j;
					}
					else if(m[i][j]=='C'){
						er = i;
						ec = j;
					}
					else if(m[i][j]=='V'){
						al.add(new int[]{i,j});
					}
				}
			}
			for(int[] pos : al){
				fill(pos[0],pos[1],0);
			}
			recur(sr,sc,0);
			if(volcano[sr][sc]== Integer.MAX_VALUE){
				out.println("NO");
			}
			else{
				if(shadow[er][ec]<volcano[er][ec]){
					out.println("NO");
				}
				else{
					out.println("YES");
				}
			}
//			for (int i = 0; i < row; i++) {
//				out.println(Arrays.toString(shadow[i]));
//			}
//			for (int i = 0; i < row; i++) {
//				out.println(Arrays.toString(volcano[i]));
//			}
//			out.println();
		}
        f.close();
    }
	public void fill(int r, int c, int step){
		if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='W'&&step<volcano[r][c]){
			volcano[r][c] = step;
			fill(r-1,c,step+1);
			fill(r+1,c,step+1);
			fill(r,c-1,step+1);
			fill(r,c+1,step+1);
		}
	}
	public void recur(int r, int c, int step){
		if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&!"WTV".contains(m[r][c]+"")&& step < shadow[r][c] && step<volcano[r][c]){
			shadow[r][c] = step;
			recur(r-1,c,step+1);
			recur(r+1,c,step+1);
			recur(r,c-1,step+1);
			recur(r,c+1,step+1);
		}
	}
}
