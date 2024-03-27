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

public class puddle {
	char[][] m;
    public static void main(String[] args) throws Exception {
        new puddle().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("puddle.dat"));
        //Scanner f = new Scanner(System.in);
		int r = f.nextInt(), c = f.nextInt();
		f.nextLine();
		m = new char[r][c];
		for (int i = 0; i < r; i++) {
			m[i] = f.nextLine().toCharArray();
		}
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			r = f.nextInt(); c = f.nextInt();
			if(m[r][c]=='G'){
				out.println("OK");
			}else if(m[r][c] == 'W'){
				recur(r,c,m[r][c]);
				out.println("PUDDLE");
			}
			else if(m[r][c] == 'R' || m[r][c] == 'S'){
				out.println("OOPS");
			}
        }
		out.println();
		for(char[] cc : m){
			out.println(cc);
		}
        f.close();
    }
	public void recur(int r, int c, char cc){
		if(r>=0&&c>=0&&c<m[r].length&&r<m.length&&m[r][c]==cc){
			m[r][c] ='F';
			recur(r-1,c,cc);
			recur(r+1,c,cc);
			recur(r,c-1,cc);
			recur(r,c+1,cc);
		}
	}
}
