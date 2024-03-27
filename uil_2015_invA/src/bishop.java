import java.util.*;
import java.io.*;

public class bishop {
	static int[][] m;
    public static void main(String[] args) throws Exception {
        new bishop().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("bishop.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        while (times-- > 0) {
			m = new int[f.nextInt()][f.nextInt()];
			int k = f.nextInt();
			for (int i = 0; i < k; i++) {
				int r= f.nextInt(), c = f.nextInt();
				m[r][c] = 1;
				marked(r,c);
			}
			System.out.println(safe());
        }
        f.close();
    }
	public int safe(){
		int s = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if(m[i][j] == 0){
					s++;
				}
			}
		}
		return s;
	}
	public void marked(int r, int c){
		int row = r-1, col = c-1;
		while(row>=0 && col>=0){
			m[row][col] = 1;
			row--;
			col--;
		}
		row = r+1;col = c+1;
		while(row<m.length && col < m[row].length){
			m[row][col] = 1;
			row++;
			col++;
		}
		row = r-1;col = c+1;
		while(row>=0 && col < m[row].length){
			m[row][col] = 1;
			row--;
			col++;
		}
		row = r+1;col = c-1;
		while(row < m.length && col >=0) {
			m[row][col] = 1;
			row++;
			col--;
		}
	}
}
