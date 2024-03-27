import java.util.*;
import java.io.*;
public class mountain {
	static int[][] m;
	static boolean[][] visit;
	static int[] x = {0,0,-1,1};
	static int[] y = {-1,1,0,0};
    public static void main(String[] args) throws Exception {
        new mountain().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("mountain.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
			int N = f.nextInt(),highest = 1;
			m = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					m[i][j] = f.nextInt();
					highest = Math.max(highest, m[i][j]);
				}
				Arrays.fill(visit[i],false);
			}
			System.out.println(recur(0,0,highest)?"YES":"NO");
        }
        f.close();
    }
	public boolean recur(int r, int c, int h){
		if(!visit[r][c]&&r>=0&&r<m.length&&c>=0&&c<m[r].length){
			if(m[r][c] == h){
				return true;
			}
			visit[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int row = r+x[i], col = c+y[i];
				if(row>=0&&row<m.length&&col>=0&&col<m[row].length){
					if((m[r][c]+1==m[row][col]||m[r][c]-2==m[row][col])&& recur(row,col,h)){
						return true;
					}
				}
			}
		}
		return false;
	}
}
