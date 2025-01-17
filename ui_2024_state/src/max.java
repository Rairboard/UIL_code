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
            int m = f.nextInt(), t = f.nextInt();
            double[] dp = new double[t+1];
            int[] time = new int[m];
            double[] val = new double[m];
            for (int i = 0; i < m; i++) {
                time[i] = f.nextInt();
            }
            for (int i = 0; i < m; i++) {
                val[i] = f.nextDouble();
            }
            for(int i =1 ;i<= t;i++){
                for(int j =0;j < m;j++){
                    if(i - time[j]>0&&dp[i-time[j]]!=0){
                        dp[i] = Math.max(dp[i], dp[i-time[j]] + val[j]);
                    }
                    else if(i-time[j]==0){
                        dp[i] = Math.max(dp[i], val[j]);
                    }
                }
            }
            double max = 0;
            for(double d : dp){
                max = Math.max(d, max);
            }
            if(max==0){
                out.println("Should have picked better games...");
            }
            else{
                out.printf("%.2f\n", max);
            }
        }
        f.close();
    }
}
