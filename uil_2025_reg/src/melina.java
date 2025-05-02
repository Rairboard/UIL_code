import java.util.*;
import java.io.*;
public class melina {
	public static void main(String[] args)throws Exception {
		new melina().run();
	}
	public void run() throws Exception{
        Scanner f = new Scanner(new File("melina.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int target = (int)(Math.abs(f.nextDouble() - f.nextDouble())* 100);
            f.nextLine();
            String[] ln = f.nextLine().trim().split("\\s+");
            long[] coin = new long[ln.length];
            for (int i = 0; i < ln.length; i++) {
                coin[i] = (long)(Double.parseDouble(ln[i]) * 100);
            }
            int n = coin.length;
            long[][] dp = new long[n+1][target+1];
            dp[0][0] = 1;
            for(int i = 1;i <= n;i++){
                for(int j = 0;j <= target;j++){
                    if(j==0)dp[i][j] = 1;
                    else{
                        dp[i][j] += dp[i-1][j];
                        if(coin[i-1]<= j){
                            dp[i][j] += dp[i][(int)(j-coin[i-1])];
                        }
                    }
                }
            }
            System.out.println(dp[n][target]);
        }
        f.close();
	}
}
