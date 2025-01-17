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

public class casting {
    public static void main(String[] args) throws Exception {
        new casting().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("casting").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            int w = f.nextInt();
            int[] value = new int[n];
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                value[i] = f.nextInt();
            }
            for (int i = 0; i < n; i++) {
                weight[i] = f.nextInt();
            }
            if(f.hasNext()) f.nextLine();
            int[][] dp = new int[n+1][w+1];
            for(int i = 1;i <= n;i++){
                for(int j = 1;j <= w;j++){
                    dp[i][j] = dp[i-1][j];
                    if(weight[i-1] <= j && dp[i-1][j-weight[i-1]] + value[i-1] > dp[i][j]){
                        dp[i][j] = dp[i-1][j-weight[i-1]] + value[i-1];
                    }
                }
            }
            out.println(dp[n][w]);
        }
        f.close();
    }
}
