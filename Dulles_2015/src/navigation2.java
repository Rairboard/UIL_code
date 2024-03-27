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

public class navigation2 {
	char[][][] m;
	int[][][] shadow;
	int[][][] star;
	int[][][] path;
	int min,ed;
	int[] vl = {-1,1,0,0,0,0};
	int[] vr = {0,0,-1,1,0,0};
	int[] vc = {0,0,0,0,-1,1};
    public static void main(String[] args) throws Exception {
        new navigation2().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("navigation").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int N =f.nextInt(),sl = -1, sr = -1, sc = -1;
			f.nextLine();
			m = new char[N][N][N];
			shadow = new int[N][N][N];
			star = new int[N][N][N];
			path = new int[N][N][N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					String ln = f.nextLine();
					m[i][j] = ln.toCharArray();
					Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
					Arrays.fill(star[i][j],Integer.MIN_VALUE);
					Arrays.fill(path[i][j],Integer.MAX_VALUE);
					if (ln.contains("B")) {
						sl = i;
						sr = i;
						sc = ln.indexOf("B");
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(m[i][j][k]=='*'){
							for (int x = 0; x < 6; x++) {
								int nl = i + vl[x];
								int nr = j + vr[x];
								int nc = k = vc[x];
								try{
									if(m[nl][nr][nc]!='*'&&m[nl][nr][nc]!='x'){
										m[nl][nr][nc] = '@';
									}
								}catch(Exception e){}
							}
						}
					}
				}
			}
			find(sl,sr,sc,0);
			recur(sl,sr,sc,0,0);
			out.println(min);
        }
        f.close();
    }
	public void find(int l ,int r, int c, int step){
		if(l>=0&&r>=0&&c>=0&&l<m.length&&r<m[l].length&&c<m[l][r].length&&m[l][r][c]!='x'&&m[l][r][c]!='*'&&step<path[l][r][c]){
			char save = m[l][r][c];
			m[l][r][c] = 'x';
			path[l][r][c] = step;
			for (int i = 0; i < 6; i++) {
				// if point adjacent to an asteroid take 3 step instead of 2
				if(save == '@'){
					find(l+vl[i],r + vr[i],c + vc[i],step+3);
				}else{
					// otherwise take only 2 step
					find(l+vl[i],r + vr[i],c + vc[i],step+2);
				}
			}
			m[l][r][c] = save;
		}
	}
	public void recur(int l,int r,int c, int step,int ast){
		if(l>=0&&r>=0&&c>=0&&l<m.length&&r<m[l].length&&c<m[l][r].length&&m[l][r][c]!='x' && (step < shadow[l][r][c]|| ast > star[l][r][c])){
			if(m[l][r][c] == '*'&& ast + 1 == 6){
				min = Math.min(step+path[l][r][c],min);
				return;
			}
			char save = m[l][r][c];
			shadow[l][r][c] = step;
			star[l][r][c] = ast;
			for (int i = 0; i < 6; i++) {
				if(save == '*'){
					recur(l+vl[i],r + vr[i],c + vc[i],step,ast+1);
				}
				else if(save == '@'){
					recur(l+vl[i],r + vr[i],c + vc[i],step+3,ast);
				}
				else{
					recur(l + vl[i],r + vr[i],c + vc[i],step+2,ast);
				}
			}
			m[l][r][c] = save;
		}
	}
}
