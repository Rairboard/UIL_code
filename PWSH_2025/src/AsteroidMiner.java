import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class AsteroidMiner {
    public static void main(String[] args) throws Exception {
        new AsteroidMiner().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("AsteroidMiner").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int n = f.nextInt(), ff = f.nextInt();
        long[][] dp = new long[n+1][ff+1];
        long[] profit = new long[n];
        long[] weight = new long[n];
        for (int i = 0; i < n; i++) {
            profit[i] = f.nextLong();
            weight[i] = f.nextLong();
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= ff; j++) {
                if(i==0||j==0){
                    dp[i][j] = 0;
                }
                else if(weight[i-1]<= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][(int)(j-weight[i-1])] + profit[i-1]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        out.println(dp[n][ff]);
        f.close();
    }
}
