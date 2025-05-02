import java.util.*;
import java.io.*;
public class toffee {
	public static void main(String[] args)throws Exception {
		new toffee().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("toffee.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int size = f.nextInt();
            f.nextLine();
            long[][] m = new long[size][size];
            for (int i = 0; i < size; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            }
            long[][] dp = new long[size][size];
            dp[0][0] = m[0][0];
            for(int i = 0;i < size-1;i++){
                for(int j = 0;j < size;j++){
                    if(i==0){
                        dp[i][j] = m[i][j];
                    }
                    if(i + 1 < size){
                        dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + m[i+1][j]);
                        if(j + 1 < size){
                            dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + m[i+1][j+1]);
                        }
                    }
                }
            }
            long mx = 0;
            for(int i = 0;i <size;i++){
                mx = Math.max(mx, dp[size-1][i]);
            }
            System.out.println(mx);
        }
        f.close();
	}
}
