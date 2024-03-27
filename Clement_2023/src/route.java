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

public class route {
	int[][] m;
	boolean[][] visited;
	int distance;
	int sr, sc;
    public static void main(String[] args) throws Exception {
        new route().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("route.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int r = f.nextInt(), c = f.nextInt();
			f.nextLine();
			m = new int[r][c];
			int max = 1;
			for (int i = 0; i < r; i++) {
				m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					visited = new boolean[r][c];
					distance = 1;
					sr = i;
					sc = j;
					recur(i,j,m[i][j],1);
					max = Math.max(distance,max);
				}
			}
			out.println(max);
        }
        f.close();
    }
	public void recur(int r, int c, int val, int step){
		if (r >= 0 && r < m.length && c >= 0 && c < m[r].length&&!visited[r][c]&& (sr == r && sc == c ||  val < m[r][c])) {
			distance = Math.max(step,distance);
			visited[r][c] = true;
			recur(r-1,c,m[r][c],step+1);
			recur(r+1,c,m[r][c],step+1);
			recur(r,c-1,m[r][c],step+1);
			recur(r,c+1,m[r][c],step+1);
			visited[r][c] = false;
		}
	}
}
