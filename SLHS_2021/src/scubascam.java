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

public class scubascam {
    public static void main(String[] args) throws Exception {
        new scubascam().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ScubaScam").toLowerCase()));
        //Scanner f = new Scanner(System.in);
        int tank = f.nextInt(), n = f.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = f.nextInt();
        }
        Arrays.sort(v);
        int[] dp = new int[v[v.length-1] * tank];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < v.length; j++) {
                if(v[j] <= i){
                    dp[i]++;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < v.length; j++) {
                if(i - v[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i-v[j]] + dp[v[j]]);
                }
            }
            if(dp[i] >= tank){
                break;
            }
        }
        out.println(Arrays.toString(dp));
        f.close();
    }
}
