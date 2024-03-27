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

public class Jimmy {
	char[][] m;
	int[][] score;
	int max;
    public static void main(String[] args) throws Exception {
        new Jimmy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Jimmy").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int r = f.nextInt(), c = f.nextInt(), maxScore = 0;
			m = new char[r][c];
			score = new int[r][c];
			f.nextLine();

			for (int i = 0; i < r; i++) {
				m[i] = f.nextLine().toCharArray();
				for (int j = 0; j < m[i].length; j++) {
					if (m[i][j] == 'G') {
						score[i][j] = 1;
					} else if (m[i][j] == 'V') {
						score[i][j] = 5;
					} else if (m[i][j] == 'S') {
						score[i][j] = -3;
					} else {
						score[i][j] = 0;
					}
				}
			}
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j]!='N'){
						max = 0;
						recur(i,j);
						maxScore = Math.max(max,maxScore);
					}
				}
			}
			out.println(maxScore);
        }
        f.close();
    }
	public void recur(int r, int c){
		if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='N'){
			max+=score[r][c];
			m[r][c]='N';
			recur(r-1,c);
			recur(r+1,c);
			recur(r,c-1);
			recur(r,c+1);
		}
	}
}
