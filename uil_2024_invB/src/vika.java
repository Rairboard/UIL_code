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
        for (int asdf = 1; asdf <= times; asdf++) {
            String a = f.next(), b = f.next();
            int n = a.length(), m = b.length();
            int[][] dp = new int[n+1][m+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    if(i==0||j==0){
                        dp[i][j] = 0;
                    }
                    else if(a.charAt(i-1) == b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            out.println(dp[n][m]);
        }
        f.close();
    }
}
