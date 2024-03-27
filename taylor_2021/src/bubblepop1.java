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

public class bubblepop1 {
	int cnt;
    public static void main(String[] args) throws Exception {
        new bubblepop1().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("bubblepop1.dat"));
        //Scanner f = new Scanner(System.in);
		char[][] m = new char[10][];
		for (int i = 0; i < 10; i++) {
			m[i] = f.nextLine().toCharArray();
		}
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			cnt = 0;
			int r = f.nextInt(), c = f.nextInt();
			recur(r,c,m[r][c], m);
			out.println(cnt >= 3 ? "YES " + cnt : "NO");
        }
        f.close();
    }
	public void recur(int r, int c, char cc,char[][] m){
		if(r >=0&&c>=0&&r < m.length&&c<m[r].length&&m[r][c] == cc){
			cnt++;
			m[r][c] ='0';
			recur(r-1,c,cc,m);
			recur(r+1,c,cc,m);
			recur(r,c+1,cc,m);
			recur(r,c-1,cc,m);
		}
	}
}
