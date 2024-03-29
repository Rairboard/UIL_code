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

public class lab {
	char[][][] m;
	boolean[][] v;
	int[][] shadow;
	boolean found;
	int min;
    public static void main(String[] args) throws Exception {
        new lab().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lab").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int row =f.nextInt(), col = f.nextInt(), sr= -1, sc = -1;
			f.nextLine();
			m = new char[3][row][col];
			shadow =new int[row][col];
			found = true;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < row; i++) {
				String ln = f.nextLine();
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
				m[0][i] = ln.toCharArray();
				m[1][i] = ln.replaceAll("\\.","*").replaceAll("#",".").replaceAll("\\*","#").toCharArray();
				m[2][i] = ln.replaceAll("#",".").toCharArray();
				if (ln.contains("S")) {
					sr =i;
					sc = ln.indexOf("S");
				}
			}
			recur(0,sr,sc,0);
			out.println(found && min!=Integer.MAX_VALUE?"ESCAPED IN " + min + " STEPS": "WELCOME TO THE BORG");
        }
        f.close();
    }
	public void recur(int l, int r, int c, int step){
		if(r>=0&&c>=0&&r<m[l].length&&c<m[l][r].length&&m[l][r][c]!='#' && step < shadow[r][c]){
			if(m[l][r][c]=='E'){
				min = Math.min(min,step);
				found = true;
			}
			shadow[r][c] = step;
			recur((l+1)%3,r+1,c,step+1);
			recur((l+1)%3,r-1,c,step+1);
			recur((l+1)%3,r,c+1,step+1);
			recur((l+1)%3,r,c-1,step+1);
		}
	}
}
