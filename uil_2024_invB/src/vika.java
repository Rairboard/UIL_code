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

public class vika {
    public static void main(String[] args) throws Exception {
        new vika().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("vika").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();

        String a = f.next(), b = f.next();
        f.nextLine();
        int n = 2, m = 3;
//        int[][] dp = new int[n+1][m+1];
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                if(i==0) dp[i][j] = j;
//                else if(j==0) dp[i][j] = i;
//                else if (a.charAt(i - 1) == b.charAt(j - 1)) {
//                    dp[i][j] = dp[i-1][j-1];
//                }
//                else{
//                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]));
//                }
//            }
//        }
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;
        
        f.close();
    }
}
