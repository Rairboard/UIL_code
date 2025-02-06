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

public class max {
    public static void main(String[] args) throws Exception {
        new max().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("max").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), m = f.nextInt();
            f.nextLine();
            int[] time = new int[n];
            double[] val = new double[n];
            for (int i = 0; i < n; i++) {
                time[i] = f.nextInt();
            }
            for (int i = 0; i < n; i++) {
                val[i] = f.nextDouble();
            }
            double[] dp = new double[m+1];
            for(int j=1;j<=m;j++){
                for(int i = 0;i < n;i++){
                    if(j - time[i]==0){
                        dp[j] = Math.max(dp[j], val[i]);
                    }
                    else if(j - time[i] > 0 &&dp[j-time[i]] != 0){
                        dp[j] = Math.max(dp[j], dp[j-time[i]] + val[i]);
                    }
                }
            }
            double max = 0;
            for (int i = 0; i < dp.length; i++) {
                max = Math.max(max, dp[i]);
            }
            if(max==0) out.println("Should have picked better games...");
            else out.printf("%.2f\n", max);
        }
        f.close();
    }
}
