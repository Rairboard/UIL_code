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

public class SmokeOnTheWater {
    public static void main(String[] args) throws Exception {
        new SmokeOnTheWater().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("SmokeOnTheWater").toLowerCase()));
        //Scanner f = new Scanner(System.in);
        int r = f.nextInt(), c = f.nextInt(), cnt = 0;
		f.nextLine();
		char[][] m = new char[r][c];
		int[] vr = {-1,1,0,0};
		int[] vc = {0,0,-1,1};
		double total = 0;
		for (int i = 0; i < r; i++) {
			m[i] = f.nextLine().toCharArray();
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(m[i][j]=='.'){
					cnt++;
					int sp = 0;
					Queue<Integer> q = new LinkedList<>();
					q.offer(i);
					q.offer(j);
					while(!q.isEmpty()){
						int rr = q.remove(), cc = q.remove();
						if(rr>=0&&rr<r && cc>=0&&cc<c &&m[rr][cc]=='.'){
							sp++;
							for (int k = 0; k < 4; k++) {
								q.offer(rr+vr[k]);
								q.offer(cc+vc[k]);
							}
							m[rr][cc]='#';
						}
					}
					total+=Math.pow(1.05,sp-1);
				}
			}
		}
		out.println(cnt);
		out.printf("$%.2f\n",total);
        f.close();
    }
}
