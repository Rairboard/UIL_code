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

public class dijkstra {
	char[][] m;
	int[][] shadow;
	int min;
    public static void main(String[] args) throws Exception {
        new dijkstra().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dijkstra").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int c = f.nextInt(), r = f.nextInt(),t = f.nextInt(), sr = -1, sc = -1;
			f.nextLine();
			m = new char[r][c];
			shadow = new int[r][c];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < r; i++) {
				String ln = f.nextLine();
				m[i] = ln.toCharArray();
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
				if (ln.contains("S")) {
					sr = i;
					sc = ln.indexOf("S");
				}
			}
			Queue<Integer> q = new LinkedList<>();
			q.offer(sr);
			q.offer(sc);
			q.offer(0);
			while(!q.isEmpty()){
				int rr = q.remove(), cc = q.remove(), step = q.remove();
				if(m[rr][cc] == 'E'){
					min = Math.min(min,step);
					continue;
				}
				int[] vr = {-1,1,0,0};
				int[] vc = {0,0,-1,1};
				for (int i = 0; i < 4; i++) {
					int nr = rr + vr[i];
					int nc = cc + vc[i];
					if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length && (m[nr][nc]=='E' || m[nr][nc] == 'e')){
						q.offer(nr);
						q.offer(nc);
						q.offer(step+1);
					}
				}
				m[rr][cc] = 'W';
			}
			out.println(min*3 <= t? "He escaped in " + min*3 + " minutes." : "All hail Lord Dijkstra!");
        }
        f.close();
    }
}
