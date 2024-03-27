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
	boolean solved;
	int min;
	List<Point> portal;
    public static void main(String[] args) throws Exception {
        new Tang().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Tang").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int r = f.nextInt(), c = f.nextInt(), sr = -1, sc = -1,er = -1, ec = -1;
			f.nextLine();
			m = new char[r][c];
			shadow = new int[r][c];
			portal = new ArrayList<>();
			solved = false;
			min = Integer.MAX_VALUE;

			for (int i = 0; i < r; i++) {
				String s = f.nextLine();
				m[i] = s.toCharArray();
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
				if (s.contains("T")) {
					sr = i;
					sc = s.indexOf("T");
				}
				if (s.contains("P")) {
					er = i;
					ec = s.indexOf("P");
				}
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j] == 'O'){
						portal.add(new Point(i,j));
					}
				}
			}

			recur(sr,sc,0);
			if(solved && min <= 30){
				out.println("It took Tang " + min + " minute(s) to get his PearBook to the nearest Pear Inc. Store");
			}else {
				out.println("Tang isn't great at thinking with portals.");
			}
        }
        f.close();
    }
	public void recur(int r, int c, int step){
		if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'&&m[r][c]!='+'&&step<shadow[r][c]){
			char save = m[r][c];
			shadow[r][c] = step;
			m[r][c] = '+';
			if(save=='P'){
				m[r][c] = save;
				solved = true;
				min = step;
				return;
			}
			if(save=='O'){
				for(Point p : portal){
					if (!(p.r == r && p.c == c)) {
						recur(p.r,p.c,step+1);
					}
				}
			}
			recur(r-1,c,step+1);
			recur(r+1,c,step+1);
			recur(r,c-1,step+1);
			recur(r,c+1,step+1);
			m[r][c] = save;
		}
	}
	class Point{
		int r,c;
		public Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
