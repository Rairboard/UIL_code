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

public class dice {
    public static void main(String[] args) throws Exception {
        new dice().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("dice").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        int sum = f.nextInt();
        long[][] dp = new long[n+1][sum+1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = f.nextInt();
        }
        for(int i = 0;i <= n;i++){
            for(int j =0;j <= sum;j++){
                if(i==0){
                    dp[i][j] = 0;
                }
                else if(j==0){
                    dp[i][j] = 1;
                }
                else if(coin[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        out.println(dp[n][sum] % 1000000007);
        f.close();
    }
}
