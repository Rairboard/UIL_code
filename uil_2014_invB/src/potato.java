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

public class potato {
    public static void main(String[] args) throws Exception {
        new potato().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("potato").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt(), k = f.nextInt();
            int[][] dp = new int[k+1][n+1];
            dp[0][n] = 1;
            for(int t = 1;t<=k;t++){
                for (int i = 0; i <= n; i++) {
                    for (int j = 0; j <= n; j++) {
                        if(i!=j){
                            dp[t][i] += dp[t-1][j]% 100003;
                        }
                    }
                }
            }
            out.println(dp[k][n] % 100003);
        }
        f.close();
    }
}
