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

public class stardeath {
	char[][][] m;
	int[][][] shadow;
    public static void main(String[] args) throws Exception {
        new stardeath().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("stardeath").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int l = f.nextInt(), r = f.nextInt(), c = f.nextInt(), t = f.nextInt();
			f.nextLine();
			m = new char[l][r][c];
			shadow = new int[l][r][c];
			boolean solved = false,g = false;
			Point s= null, e = null;
			List<Point> loc = new ArrayList<>();
			List<Point> wall = new ArrayList<>();
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String ln = f.nextLine();
					for (int k = 0; k < c; k++) {
						m[i][j][k] = ln.charAt(k);
						if(ln.charAt(k) == 'R'){
							s = new Point(i,j,k);
						}
						if(ln.charAt(k) == 'g'){
							g = true;
						}
						if(ln.charAt(k) == 'e'){
							loc.add(new Point(i,j,k));
						}
						if(ln.charAt(k) == 'G'){
							e = new Point(i,j,k);
						}
						if(ln.charAt(k) == 'D' || ln.charAt(k) == 'P'){
							wall.add(new Point(i,j,k));
						}
					}
				}
			}
			if(g){
				out.println("Get Grinced.");
			}else{
				if(s!=null && e!=null){
					for(Point p : wall){
						for (int i = -2; i <= 2; i++) {
							for (int j = -2; j <= 2; j++) {
								int nr = p.x + i;
								int nc = p.y + j;
								if(nr==p.x && nc==p.y) continue;
								if(nr>=0&&nr<m[p.d].length && nc>=0&&nc<m[p.d][nr].length&&m[p.d][nr][nc]!='D' && m[p.d][nr][nc]!='P'&&m[p.d][nr][nc]!='#'){
									m[p.d][nr][nc] = '!';
								}
							}
						}
					}
					for(int i = 0; i < loc.size(); i++){
						for (int j = 0; j < l; j++) {
							for (int k = 0; k < r; k++) {
								Arrays.fill(shadow[j][k],Integer.MAX_VALUE);
							}
						}
						int ll = loc.get(i).d, rr = loc.get(i).x,cc = loc.get(i).y;
						recur(s.d,s.x,s.y,0);
						if(shadow[ll][rr][cc]!=Integer.MAX_VALUE){
							for (int j = 0; j < l; j++) {
								for (int k = 0; k < r; k++) {
									Arrays.fill(shadow[j][k],Integer.MAX_VALUE);
								}
							}
							recur(ll,rr,cc,0);
							if(shadow[e.d][e.x][e.y]!=Integer.MAX_VALUE){
								solved = true;
								break;
							}
						}
					}
				}
				if(solved){
					for (int i = 0; i < l; i++) {
						for (int j = 0; j < r; j++) {
							for (int k = 0; k < c; k++) {
								if("DP!Se".contains(m[i][j][k]+"")){
									m[i][j][k] = '.';
								}
							}
						}
					}
					for (int j = 0; j < l; j++) {
						for (int k = 0; k < r; k++) {
							Arrays.fill(shadow[j][k],Integer.MAX_VALUE);
						}
					}
					recur(e.d,e.x,e.y,0);
					if(shadow[s.d][s.x][s.y]<t){
						out.println("Do it " + shadow[s.d][s.x][s.y]);
					}else{
						out.println("I HATE YOU!!!");
					}
				}else{
					out.println("I HATE YOU!!!");
				}
			}
        }
        f.close();
    }
	public void recur(int l,int r, int c, int step){
		if(l>=0&&l<m.length&&r>=0&&r<m[l].length&&c>=0&&c<m[l][r].length&&!"DSP!#".contains(m[l][r][c]+"")&&step<shadow[l][r][c]){
			char save =m[l][r][c];
			m[l][r][c] = '#';
			shadow[l][r][c] = step;
			recur(l-1,r,c,step+1);
			recur(l+1,r,c,step+1);
			recur(l,r-1,c,step+1);
			recur(l,r+1,c,step+1);
			recur(l,r,c-1,step+1);
			recur(l,r,c+1,step+1);
			m[l][r][c] = save;
		}
	}
	class Point{
		int d,x,y;
		public Point(int layer,int row,int col){
			d = layer;
			x = row;
			y = col;
		}
	}
}
