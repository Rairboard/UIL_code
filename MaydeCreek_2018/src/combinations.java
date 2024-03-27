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

public class combinations {
    public static void main(String[] args) throws Exception {
        new combinations().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("combinations").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int w = f.nextInt(), n = f.nextInt();
            int[] coin = new int[n];
            for (int i = 0; i < n; i++) {
                coin[i] = f.nextInt();
            }
            Arrays.sort(coin);
            long[][] dp = new long[n+1][w+1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= w; j++) {
                    if(j==0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j]+=dp[i-1][j];
                        if(coin[i-1]<=j){
                            dp[i][j]+=dp[i][j-coin[i-1]];
                        }
                    }
                }
            }
            out.println(dp[n][w]);
        }
        f.close();
    }
}
