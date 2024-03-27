import java.util.*;
import java.io.*;

public class ethan {
    public static void main(String[] args) throws Exception {
        new ethan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("ethan.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        for(int t=1;t<=times;t++){
			int N =f.nextInt();
			int[][] m =new int[N][N];
			int max = N * N;
			double distance = 0;
			f.nextLine();
			for (int i = 0; i < N; i++) {
				m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			}
			int[] cp = FCP(m,1);
			int x = cp[0], y = cp[1];
			for(int num = 2; num <= max;num++){
				cp = FCP(m, num);
				distance+=Math.sqrt(Math.pow(cp[0]-x,2) + Math.pow(cp[1]-y,2));
				x = cp[0];
				y = cp[1];
			}
			System.out.printf("Case %d distance: %.4f%n",t,distance);
        }
        f.close();
    }
	public static int[] FCP(int[][] m, int num){
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[r].length; c++) {
				if(m[r][c] == num){
					return new int[]{r,c};
				}
			}
		}
		return new int[]{-1,-1};
	}
}
