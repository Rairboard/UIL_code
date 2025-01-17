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

public class mining {
	int[][] shadow;
	char[][] m;
	int cnt;
    public static void main(String[] args) throws Exception {
        new mining().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mining").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int row =f.nextInt(), col = f.nextInt();
			f.nextLine();
			m = new char[row][col];
			shadow= new int[row][col];
			int sr = -1, sc = -1;
			for (int i = 0; i < row; i++) {
				String ln = f.nextLine().trim();
				if (ln.contains("S")) {
					sr = i;
					sc = ln.indexOf("S");
				}
				m[i] = ln.toCharArray();
				Arrays.fill(shadow[i],Integer.MIN_VALUE);
			}
			cnt = 0;
			recur(sr,sc);
			out.println(cnt);
        }
        f.close();
    }
	public void recur(int r, int c){
		if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='O'){
			char ch = m[r][c];
			m[r][c] = 'O';
			if(ch=='C'){
				cnt++;
			}
			recur(r-1,c);
			recur(r+1,c);
			recur(r,c-1);
			recur(r,c+1);
		}
	}
}
