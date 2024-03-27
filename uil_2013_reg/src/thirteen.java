import java.util.*;
import java.io.*;

public class thirteen {
	char[][] m;
	int[][] shadow;
	int min;
	Map<String,List<Point>> hm;

	public static void main(String[] args) throws Exception {
		new thirteen().solve();
	}
	void solve()throws Exception{
		Scanner f = new Scanner(new File("thirteen.dat"));
		int times = f.nextInt();
		f.nextLine();
		while(times-->0){
			hm = new LinkedHashMap<>();
			m = new char[10][10];
			shadow = new int[10][10];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < 10; i++) {
				m[i] = f.nextLine().toCharArray();
			}
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j]=='*'||m[i][j]=='E'||m[i][j]=='S'){
						hm.put(i+""+j,new ArrayList<>());
					}
				}
			}
			for(String p : hm.keySet()){
				int x = Integer.parseInt(p.substring(0,1));
				int y = Integer.parseInt(p.substring(1));
				for (int i = 0; i < 10; i++) {
					Arrays.fill(shadow[i],Integer.MAX_VALUE);
				}
				fill(x,y,0);
				for (int i = 0; i < shadow.length; i++) {
					for (int j = 0; j < shadow[i].length; j++) {
						if(!(x==i&&y==j) && (m[i][j] == 'S'||m[i][j] == 'E'||m[i][j] == '*')){
							hm.get(p).add(new Point(m[i][j],i,j,shadow[i][j]));
						}
					}
				}
			}
			for (int i = 0; i < shadow.length; i++) {
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
			}
			recur(0,0,0,0);
			System.out.println(min);
		}
	}
	public void recur(int r, int c, int step,int jw){
		if(m[r][c]!='#'&&step<shadow[r][c]){
			if(m[r][c]=='E'){
				if(jw==13) {
					min = Math.min(step,min);
				}
				return;
			}
			char save = m[r][c];
			shadow[r][c] = step;
			m[r][c] = '#';
			if(save == '*'){
				jw++;
			}
			for(Point neighbor : hm.get(r+""+c)){
				recur(neighbor.x,neighbor.y,step+neighbor.d,jw);
			}
			m[r][c] = save;
		}
	}
	public void fill(int r, int c, int step){
		if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&step<shadow[r][c]&&m[r][c]!='#'){
			shadow[r][c] = step;
			char save = m[r][c];
			m[r][c] = '#';
			fill(r-1,c,step+1);
			fill(r+1,c,step+1);
			fill(r,c-1,step+1);
			fill(r,c+1,step+1);
			m[r][c] = save;
		}
	}
	class Point{
		int x,y;
		char ch;
		int d;
		public Point(char cc,int r,int c,int distance){
			ch = cc;
			x = r;
			y = c;
			d = distance;
		}
	}
}
