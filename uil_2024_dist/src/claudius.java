import java.util.*;
import java.io.*;

public class claudius {
	char[][] m;
	int[][] shadow;

    public static void main(String[] args) throws Exception {
        new claudius().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("claudius.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int row = f.nextInt(), col = f.nextInt(), s = f.nextInt();
			f.nextLine();
			m = new char[row][col];
			shadow = new int[row][col];
			int sr = -1, sc = -1;
			List<int[]> exit = new ArrayList<>();
			List<int[]> al =new ArrayList<>();
			for (int i = 0; i < row; i++) {
				m[i] = f.nextLine().trim().toCharArray();
				Arrays.fill(shadow[i],Integer.MAX_VALUE);
				for (int j = 0; j < m[i].length; j++) {
					if(m[i][j]=='S'){
						sr = i;
						sc = j;
					}
					else if(m[i][j]=='E'){
						exit.add(new int[]{i,j});
					}
					else if("RV".contains(m[i][j]+"")){
						m[i][j] ='#';
					} else if ("AB".contains(m[i][j] + "")) {
						al.add(new int[]{i,j, m[i][j]});
					}
				}
			}
			for(int[] p : al){
				int r = p[0], c = p[1];
				if((char)p[2] == 'A'){
					for(int i = r-1;i<=r+1;i++){
						for(int j = c-1;j<=c+1;j++){
							if(i>=0&&j>=0&&i<row&&j<col) m[i][j]='#';
						}
					}
				}
				else if((char)p[2]=='B'){
					for(int i = r-2;i<=r+2;i++){
						for(int j = c-2;j<=c+2;j++){
							if(i>=0&&j>=0&&i<row&&j<col) m[i][j]='#';
						}
					}
				}
			}
			recur(sr,sc,0);
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < exit.size(); i++) {
				min = Math.min(min, shadow[exit.get(i)[0]][exit.get(i)[1]]);
			}
			System.out.println(min <= s ? "Free at last, Free at last. " + (s-min)  +" hour(s) to spare.":"Smokey the Bear is en route.");
        }
        f.close();
    }
	public boolean safe(int r, int c){
		int[] vr = {-1,1,0,0};
		int[] vc = {0,0,-1,1};
		for (int i = 0; i < 4; i++) {
			int nr = r + vr[i];
			int nc = c + vc[i];
			if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length){
				if(m[nr][nc]=='T') return true;
			}
		}
		return false;
	}
	public void recur(int r, int c, int step){
		if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'&&step<shadow[r][c]){
			if(m[r][c]=='Q'&&!safe(r,c)) return;
			shadow[r][c] = step;
			if(m[r][c]=='M'||m[r][c]=='Q'){
				recur(r-1,c,step+3);
				recur(r+1,c,step+3);
				recur(r,c-1,step+3);
				recur(r,c+1,step+3);
			}
			else if(m[r][c]=='T'){
				recur(r-1,c,step+2);
				recur(r+1,c,step+2);
				recur(r,c-1,step+2);
				recur(r,c+1,step+2);
			}
			else{
				recur(r-1,c,step+1);
				recur(r+1,c,step+1);
				recur(r,c-1,step+1);
				recur(r,c+1,step+1);
			}
		}
	}
}