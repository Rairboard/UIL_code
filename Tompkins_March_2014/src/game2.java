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

public class game2 {
	char[][] m;
	int[][] shadow;
	Map<Character,List<Point>> hm;
    public static void main(String[] args) throws Exception {
        new game2().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("game2").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String cor = f.nextLine();
			int r = Integer.parseInt(cor.substring(0,1));
			int c = Integer.parseInt(cor.substring(2));
			int sr = -1, sc = -1;
			m = new char[r][c];
			shadow = new int[r][c];
			hm = new HashMap<>();
			Map<Character,Point> upper = new HashMap<>();
			Map<Character,Point> lower = new HashMap<>();
			for (int i = 0; i < r; i++) {
				m[i] = f.nextLine().toCharArray();
				for (int j = 0; j < m[i].length; j++) {
					if ("AB".contains(m[i][j] + "")) {
						upper.put(m[i][j],new Point(i,j));
					}
					if ("ab".contains(m[i][j] + "")) {
						lower.put(m[i][j],new Point(i,j));
					}
					if(m[i][j]=='S'){
						sr = i;
						sc = j;
					}
				}
			}
			hm.put('S',new ArrayList<>());
			hm.put('a',new ArrayList<>());
			hm.put('b',new ArrayList<>());
			for(Character cc : lower.keySet()){
				for (int i = 0; i < r; i++) {
					Arrays.fill(shadow[i],Integer.MAX_VALUE);
				}
				Point p = lower.get(cc);
				recur(sr,sc,0,cc);
				if(shadow[p.x][p.y]!=Integer.MAX_VALUE){
					hm.get('S').add(new Point(p.x,p.y,shadow[p.x][p.y]));
					for (int i = 0; i <r; i++) {
						Arrays.fill(shadow[i],Integer.MAX_VALUE);
					}
					for(Character ch : lower.keySet()){
						if(ch!=cc){
							recur(p.x,p.y,0,ch);

						}
					}
				}
			}
        }
        f.close();
    }
	public void recur(int r, int c, int step,char ch){
		if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&step<shadow[r][c]&&m[r][c]!='W'){
			if(m[r][c]=='X'){
				shadow[r][c] = step;
				return;
			}
			if(Character.isAlphabetic(m[r][c]) && m[r][c]!='S'  && Character.toLowerCase(m[r][c])!=ch) return;
			shadow[r][c] = step;
			recur(r-1,c,step+1,ch);
			recur(r+1,c,step+1,ch);
			recur(r,c-1,step+1,ch);
			recur(r,c+1,step+1,ch);
		}
	}
	class Point{
		int x, y, d;
		public Point(int r, int c){
			x = r;
			y = c;
		}
		public Point(int r, int c,int w){
			x = r;
			y = c;
			d = w;
		}
	}
}
