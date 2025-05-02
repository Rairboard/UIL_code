import java.util.*;
import java.io.File;

public class combinationSum {
    public static void main(String[] args) throws Exception {
        new combinationSum().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("combinationSum").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int[] coin = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int target = f.nextInt();
        int n = coin.length;
        int[][] dp = new int[n+1][target+1];

        // recursive solution
/*        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int waysToMakeSum = recur(n, target,dp, coin );
        System.out.println(waysToMakeSum);
        */

        // tabulation solution
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if(j==0) dp[i][j] = 1;
                else{
                    dp[i][j] += dp[i-1][j];
                    if(coin[i-1]<= j){
                        dp[i][j] += dp[i-1][j-coin[i-1]];
                        // dp[i][j] += dp[i][j-coin[i-1]]; if we can use same coin infinite times
                    }
                }
            }
        }

        System.out.println(dp[n][target]);
        f.close();
    }
    public int recur(int i, int target, int[][] dp, int[] coin ){
        if(target == 0) return 1;
        if(target < 0 || i == 0) return 0;
        if(dp[i][target]!=-1) return dp[i][target];
        dp[i][target] = recur(i-1, target - coin[i-1], dp, coin) + recur(i-1, target, dp, coin);
        // dp[i] = recur(i, target - coin[i-1], dp, coin) + recur(i - 1, target ,dp, coin); -> if we can use same coin multiple times
        return dp[i][target];
    }
}
