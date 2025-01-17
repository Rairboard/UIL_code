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

public class shreya {
    public static void main(String[] args) throws Exception {
        new shreya().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("shreya").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int[] coin = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int w = f.nextInt();
            if(f.hasNext())f.nextLine();
            int n = coin.length;
            boolean[][] dp = new boolean[n+1][w+1];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i],false);
            }
            Arrays.sort(coin);
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= w; j++) {
                    if(coin[i-1]<= j){
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-coin[i-1]];
                    }
                    else{
                        dp[i][j] |= dp[i-1][j];
                    }
                }
            }
            out.println(dp[n][w] ? "Business as usual.":"Dine and Dash.");
        }
        f.close();
    }
}
