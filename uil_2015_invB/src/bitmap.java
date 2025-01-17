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

public class bitmap {
    public static void main(String[] args) throws Exception {
        new bitmap().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bitmap").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int r = f.nextInt(), c = f.nextInt();
		f.nextLine();
		char[][] m = new char[r][c];
		for (int i = 0; i < r; i++) {
			m[i] = f.nextLine().trim().toCharArray();
		}
		int mx = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for(int ii = i;ii< r;ii++){
					for(int jj = j;jj < c;jj++){
						int area = calculate(i,j,ii,jj,m);
						if(area!=-1){
							mx = Math.max(mx, area);
						}
					}
				}
			}
		}
		out.println(mx);
        f.close();
    }
	public int calculate(int sr, int sc , int er, int ec, char[][] m){
		for(int i = sr;i<=er;i++){
			for(int j = sc;j<=ec;j++){
				if(m[i][j] == '0') return -1;
			}
		}
		return (er - sr + 1) * (ec - sc + 1);
	}
}
