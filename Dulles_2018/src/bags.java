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

public class bags {
    public static void main(String[] args) throws Exception {
        new bags().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File("bags.dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt();
            f.nextLine();
            int[] w = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int t = f.nextInt();
            Arrays.sort(w);
            int[] dp = new int[t+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i < t+1; i++) {
                for (int j = 0; j < n; j++) {
                    int sub = i - w[j];
                    if(sub<0){
                        break;
                    }else{
                        if(1 + dp[sub] <= dp[i]){
                            dp[i] = 1 + dp[sub];
                        }
                    }
                }
            }
            out.println(dp[t]==Integer.MIN_VALUE || dp[t] == Integer.MAX_VALUE ? "NOT POSSIBLE":dp[t]);
        }
        f.close();
    }
}
