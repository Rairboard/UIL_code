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

public class william {
    public static void main(String[] args) throws Exception {
        new william().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("william").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String ln = f.nextLine();
            String a = ln.substring(0,ln.length()/2);
            String b = new StringBuilder(ln.substring(ln.length()/2)).reverse().toString();
            int n = a.length(), m = b.length();
            String[][] dp = new String[n+1][m+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    if(i==0 || j == 0 ){
                        dp[i][j] = "";
                    }
                    else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = dp[i-1][j-1] + a.charAt(i-1);
                    }
                    else{
                        if(dp[i-1][j].length() > dp[i][j-1].length()){
                            dp[i][j] = dp[i-1][j];
                        }else{
                            dp[i][j] = dp[i][j-1];
                        }
                    }
                }
            }
            out.println(dp[n][m] + ":" + new StringBuilder(dp[n][m]).reverse());
        }
        f.close();
    }
}
