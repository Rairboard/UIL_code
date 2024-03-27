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

public class sands {
	char[][][] m;
	boolean[][][] v;
	int[] vr = {-1,-1,1,1,-1,1,0,0};
	int[] vc = {-1,1,1,-1,0,0,-1,1};
	double total,trapped;
    public static void main(String[] args) throws Exception {
        new sands().run();
    }
	class Point{
		int d,x,y,px,py;
		double sand;
		boolean[][][] safe;
		public Point(int layer, int row, int col){
			this.d = layer;
			this.x = row;
			this.y = col;
		}
		public Point(int layer, int row, int col, double s,int x,int y,boolean[][][] v){
			this.d = layer;
			this.x = row;
			this.y = col;
			this.sand = s;
			this.px = x;
			this.py = y;
			this.safe = v;
		}
	}
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sands").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			double o = 0;
			int layer =f.nextInt(),row = f.nextInt(), col =f.nextInt();
			f.nextLine();
			total = 0;
			trapped =0;
			m = new char[layer][row][col];
			v = new boolean[layer][row][col];
			List<Point> loc =new ArrayList<>();
			Queue<Point> q = new LinkedList<>();
			for (int i = 0; i < layer; i++) {
				for (int j = 0; j < row; j++) {
					String ln = f.nextLine();
					Arrays.fill(v[i][j],true);
					for (int k = 0; k < col; k++) {
						if(ln.charAt(k)=='o'){
							o++;
							loc.add(new Point(i,j,k));
						}
						m[i][j][k] = ln.charAt(k);
					}
				}
			}
			if(o>0){
				for(Point p : loc){
					q.offer(new Point(p.d,p.x,p.y,100.0/o,-1,-1,v));
				}
				while (!q.isEmpty()) {
					Point p = q.remove();
					int l = p.d;
					int r = p.x;
					int c = p.y;
					double amt = p.sand;
					if(m[l][r][c]=='#'){
						trapped+=amt;
					}
					else if(m[l][r][c]=='^'){
						for (int i = 0; i < 8; i++) {
							int nl = l + 1;
							int nr = r + vr[i];
							int nc = c + vc[i];
							p.safe[l][r][c] = false;
							if (nl>=0&&nl<m.length&&nr >= 0 && nc >= 0 && nr < m[nl].length && nc < m[nl][nr].length && p.safe[nl][nr][nc]) {
								q.offer(new Point(nl,nr,nc,amt/8.0,r,c,p.safe));
							}
						}
					}
					else if(m[l][r][c]=='.'&&l == m.length-1){
						total+=amt;
					}else{
						q.offer(new Point(l+1,r,c,amt,-1,-1,p.safe));
					}
				}
				out.printf("%.2f%s made it to the floor and %.2f%s was trapped\n",total,"%",trapped,"%");
			}
			else{
				out.printf("%.2f%s made it to the floor and %.2f%s was trapped\n",total,"%",100.0-total,"%");
			}
        }
        f.close();
    }
}
