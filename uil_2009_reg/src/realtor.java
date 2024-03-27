import java.util.*;
import java.io.*;

public class realtor {
	static int max;
	static int[][] m;
    public static void main(String[] args) throws Exception {
        new realtor().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("realtor.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
			int r = f.nextInt(), c =f.nextInt();
			m = new int[r][c];
			f.nextLine();
			for (int i = 0; i < r; i++) {
				m[i] = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			}
			max = 0;
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					for(int row = i;row < r;row++){
						for(int col = j;col < c;col++){
							max = Math.max(sum(i,j,row,col),max);
						}
					}
				}
			}
			System.out.println(max);
        }
        f.close();
    }
	public int sum(int sr, int sc, int er, int ec){
		int s =0 ;
		for(int i=sr;i<=er;i++){
			for(int j=sc;j<=ec;j++){
				s+= m[i][j];
			}
		}
		return s;
	}
}
