import java.util.*;
import java.io.*;
public class ignacio {
	public static void main(String[] args)throws Exception {
		new ignacio().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("ignacio.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int n = f.nextInt(), r = f.nextInt()-1, c = f.nextInt()-1;
            int[][] m = new int[n][n];
            int cur = 1;
            int i = n-1, j = n/2;
            while(cur <= n * n){
                if(cur==1){
                    m[i][j] = cur++;
                }
                else if(i == n-1 && j != n-1){
                    i= 0;
                    j++;
                    m[i][j] = cur++;
                }
                else if(i!=n-1 && j == n-1){
                    i++;
                    j = 0;
                    m[i][j] = cur++;
                }
                else if(i==n-1 && j == n-1){
                    i--;
                    m[i][j] = cur++;
                }
                else if(i + 1 < n && j + 1 < n && m[i+1][j+1] == 0){
                    i++;
                    j++;
                    m[i][j] = cur++;
                }
                else {
                    i--;
                    m[i][j] = cur++;
                }
            }
            System.out.println(m[r][c]);
        }
        f.close();
	}
}
