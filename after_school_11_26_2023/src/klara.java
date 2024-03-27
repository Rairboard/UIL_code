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

public class klara {
	char[][] m;
    public static void main(String[] args) throws Exception {
        new klara().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("klara.dat"));
        //Scanner f = new Scanner(System.in);
		while(f.hasNext()){
			int N = f.nextInt();
			m = new char[N][N];
			f.nextLine();
			for (int i = 0; i < N; i++) {
				m[i] = f.nextLine().toCharArray();
			}
			char mid = m[N/2][N/2];
			recur(N/2,N/2,mid);
			for (int i = 0; i < N; i++) {
				out.println(new String(m[i]));
			}
			out.println("=".repeat(5));
		}
        f.close();
    }
	public void recur(int r, int c, char cc){
		if(r>=0 && c>=0 && r < m.length && c < m.length && m[r][c] == cc){
			m[r][c] = '-';
			recur(r-1,c,cc);
			recur(r+1,c,cc);
			recur(r,c-1,cc);
			recur(r,c+1,cc);
		}
	}
}
