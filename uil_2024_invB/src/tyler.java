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

public class tyler {
    public static void main(String[] args) throws Exception {
        new tyler().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tyler").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int n = f.nextInt(), m = f.nextInt();
        int mx = 0;
        f.nextLine();
        int[] coin = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] target = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < target.length; i++) {
            mx = Math.max(mx, target[i]);
        }
        boolean[] dp = new boolean[mx+1];
        dp[0] = true;
        for (int i = 0; i < coin.length; i++) {
            dp[coin[i]] = true;
        }
        for (int i = 1; i <= mx; i++) {
            if(!dp[i]) continue;
            for (int j = 0; j < coin.length; j++) {
                if(i * coin[j] < dp.length && i * coin[j]>0){
                    dp[i*coin[j]] = true;
                }
            }
        }
        for (int i = 0; i < target.length; i++) {
            out.println("Target " + target[i] + ": " + (dp[target[i]] ? "YES":"NO"));
        }
        f.close();
    }
}
