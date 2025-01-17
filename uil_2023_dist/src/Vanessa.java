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

public class vanessa{
	public static void main(String[] args)throws Exception {
		new vanessa().run();
	}
    public void run()throws Exception{
        Scanner f = new Scanner(new File("vanessa.dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while(times-->0){
            int[] coin = Arrays.stream(f.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
            int n = coin.length;
            int m = f.nextInt();
            f.nextLine();
            f.nextLine();
            int[][] dp = new int[n+1][m+1];
            dp[0][0] = 1;
            for(int i = 1;i <= n;i++){
                for(int j = 0;j <= m;j++){
                    if(j==0){
                        dp[i][j] = 0;
                    }
                    // adding all possible combinations using all of previous coins up until but excluding current coins
                    dp[i][j]+=dp[i-1][j];

                    // then check if current coin is smaller then current value if so can use current coin
                    if(coin[i-1]<=j){

                        // adding all of combinations using current coins
                        dp[i][j]+=dp[i][j-coin[i-1]];

                        // if finite coin => dp[i][j] += dp[i-1][j-coin[i-1]];
                        // because finite so we have to move our coin position back to only use possible combinations from previous coin
                    }
                }
            }
            out.println(dp[n][m]);
        }
    }
//    recursive solution optimize with dp[][]
//	public void run() throws Exception{
//	  Scanner f = new Scanner(new File(("vanessa").toLowerCase() + ".dat"));
//	  //Scanner f = new Scanner(System.in);
//	  int times = f.nextInt();
//	  f.nextLine();
//	  for(int asdf = 1;asdf <= times;asdf++){
//		  int[] coin = Arrays.stream(f.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
//          int n = coin.length;
//          int m = f.nextInt();
//          f.nextLine();
//          f.nextLine();
//          int[][] dp = new int[n+1][m+1];
//          for (int i = 0; i < dp.length; i++) {
//              Arrays.fill(dp[i],-1);
//          }
//          int ways = recur(coin.length, m, coin, dp);
//          out.println(ways);
//	  }
//	  f.close();
//	}
//    public int recur(int i, int sum, int[] coin, int[][] dp){
//        if(sum == 0){
//            return 1;
//        }
//        if(sum < 0){
//            return 0 ;
//        }
//        if(i == 0){
//            return 0;
//        }
//        if(dp[i][sum]!=-1){
//            return dp[i][sum];
//        }
//        return dp[i][sum] = recur(i, sum-coin[i-1],coin,  dp) + recur(i-1, sum,coin,dp);
//    }
}
