import java.util.*;
import java.io.*;
public class experience {
	public static void main(String[] args)throws Exception {
		new experience().run();
	}
	public void run() throws Exception{
//        Scanner f = new Scanner(new File("experience.dat"));
        Scanner f = new Scanner(System.in);
        int[] coin = {1,3,7,17,37,73,149, 307,617, 1237, 2477};
        int n = coin.length;
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int w = f.nextInt();
            long[][] dp = new long[n+1][w+1];
            for(int i = 0;i <= n;i++){
                Arrays.fill(dp[i], w+1);
                for(int j = 0;j<=w;j++){
                    if(i==0||j==0){
                        dp[i][j] = 0;
                    }
                    else if(coin[i-1]<=j && dp[i][j-coin[i-1]] + 1 < dp[i][j]){
                        dp[i][j] = dp[i][j-coin[i-1]] + 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            for (int i = 0; i < n+1; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
            System.out.println();
            long[] used = new long[n];
            int weight = w;
            for(int i = n;i>0;i--){
                if(dp[i][weight] != dp[i][weight-coin[i-1]]){
                    used[i-1] = dp[i][weight] - dp[i][weight-coin[i-1]];
                    weight-=coin[i-1];
                }
            }
            System.out.println(Arrays.toString(used).replaceAll("[\\[\\],]",""));
        }
        f.close();
	}
}
