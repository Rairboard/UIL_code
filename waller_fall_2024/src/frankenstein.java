import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class frankenstein {
	char[][] m;
	char[][] copy;
	int[][] shadow;
    public static void main(String[] args) throws Exception {
        new frankenstein().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("frankenstein").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			int sr = -1, sc = -1;
			f.nextLine();
			m = new char[n][n];
			shadow = new int[n][n];
			for (int i = 0; i < n; i++) {
				m[i] = f.nextLine().trim().toCharArray();
				Arrays.fill(shadow[i], Integer.MAX_VALUE);
				for (int j = 0; j < n; j++) {
					if(m[i][j]=='@'){
						sr = i;
						sc = j;
					}
				}
			}
			recur(sr,sc,0);
			for(char[] line : copy){
				out.println(line);
			}
			out.println();
        }
        f.close();
    }
	public void recur(int r, int c, int step){
		if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'&step<shadow[r][c]&&m[r][c]!='+'){
			shadow[r][c] = step;
			if(m[r][c]=='!'){
				copy = new char[m.length][m.length];
				m[r][c] = '+';
				for (int i = 0; i < m.length; i++) {
					copy[i] = new String(m[i]).replaceAll("[^+]","#").replaceAll("\\+","*").toCharArray();
				}
				m[r][c] = '!';
				return;
			}
			char save = m[r][c];
			m[r][c] = '+';
			recur(r-1,c,step+1);
			recur(r+1,c,step+1);
			recur(r,c-1,step+1);
			recur(r,c+1,step+1);
			m[r][c] = save;
		}
	}
}
