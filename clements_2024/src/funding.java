import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class funding {
    public static void main(String[] args) throws Exception {
        new funding().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("funding").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int N = f.nextInt(), sum = f.nextInt();
            f.nextLine();
            int[] coin = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            boolean[][] dp = new boolean[N+1][sum+1];
            for (int i = 0; i < N + 1; i++) {
                Arrays.fill(dp[i],false);
            }
            dp[0][0] = true;
            for(int i =1;i <= N;i++){
                for(int j = 0;j<= sum;j++){
                    if(coin[i-1] <= j){
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-coin[i-1]];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            out.println(dp[N][sum] ? "Put the money in the bag.":"We're gonna need a bigger loan.");
        }
        f.close();
    }
//    public void run(){
//        String a = "abs", b = "def";
//        int n = a.length();
//        int m = b.length();
//        int[][] dp = new int[n+1][m+1];
//        for (int i = 0; i <=n ; i++) {
//            for (int j = 0; j <= m; j++) {
//                if(i==0){
//                    dp[i][j] = j;
//                }
//                if(j == 0){
//                    dp[i][j] = i;
//                }
//                if (a.charAt(i - 1) == b.charAt(j - 1)) {
//                    dp[i][j] = dp[i-1][j-1];
//                }
//                else{
//                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
//                }
//            }
//        }
//        out.println(dp[n][m]);
//    }
//    public void run(){
//        int[] coin = {1,2,6,4};
//        int sum = 10;
//        int N = coin.length;
//        int[][] dp = new int[N+1][sum+1];
//        for (int i = 0; i <= N; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        int ways = recur(N, sum, coin, dp);
//        out.println(ways);
//        dp[0][0] = 1;
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= sum; j++) {
//                dp[i][j] += dp[i-1][j];
//                if(coin[i-1] <= j){
//                    dp[i][j] += dp[i][j-coin[i-1]];
//                }
//            }
//        }
//        out.println(dp[N][sum]);
//    }
//    public boolean recur(int n, int sum, int[] coin, boolean[] dp){
//        if(sum < 0) return false;
//        if(n==0) return sum == 0;
//        if(sum==0) return true;
//        if(dp[sum]) return true;
//        dp[sum] = recur(n-1, sum-coin[n-1],coin ,dp) || recur(n-1, sum, coin, dp);
//        return dp[sum];
//    }


    //edit distance
//    public int recur(int i ,int j, String a, String b, int[][] dp){
//        if(i==0) return j;
//        if(j==0) return i;
//        if (dp[i][j] != -1) {
//            return dp[i][j];
//        }
//        if (a.charAt(i - 1) == b.charAt(j - 1)) {
//            return recur(i-1, j-1, a, b, dp);
//        }
//        int replace = recur(i-1, j- 1, a,b, dp);
//        int insert = recur(i, j-1, a, b, dp);
//        int delete = recur(i-1, j, a, b, dp);
//        dp[i][j] = 1 + Math.min(replace,Math.min(insert, delete));
//        return dp[i][j];
//    }

    // combination sum
//    public int recur(int n, int sum, int[] coin, int[][] dp){
//        if(sum < 0) return 0;
//        if(n== 0) return 0;
//        if(sum == 0) return 1;
//        if(dp[n][sum] != -1) return dp[n][sum];
//        dp[n][sum] = recur(n, sum-coin[n-1], coin, dp) + recur(n-1, sum, coin, dp);
//        return dp[n][sum];
//    }
}
