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

public class minimizecoin {
    public static void main(String[] args) throws Exception {
        new minimizecoin().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("minimizecoin").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        int sum = f.nextInt();
        int[][] dp = new int[n+1][sum+1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = f.nextInt();
        }
        for(int i = 0;i <= n;i++){
            for(int j =0 ;j <= sum;j++){
                if(i==0){
                    dp[i][j] = j==0 ? 0 : sum+1;
                }
                else if(j==0){
                    dp[i][j] = 0;
                }
                else if(coin[i-1] <=j ){
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coin[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        out.println(dp[n][sum] == sum+1 ? -1 : dp[n][sum]);
        f.close();
    }
}
