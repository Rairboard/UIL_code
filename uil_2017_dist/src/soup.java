import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class soup {
    public static void main(String[] args) throws Exception {
        new soup().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("soup").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String a = f.nextLine().toLowerCase().replaceAll("\\s+","");
			String b = f.nextLine().toLowerCase().replaceAll("\\s+","");
			int n = a.length();
			int m = b.length();
			String[][] dp = new String[n+1][m+1];
			for(int i = 0;i<=n;i++){
				for(int j =0 ;j <= m;j++){
					if(i==0||j==0) dp[i][j] = "";
					else if(a.charAt(i-1) == b.charAt(j-1)){
						dp[i][j] = dp[i-1][j-1] + a.charAt(i-1);
					}
					else{
						if(dp[i-1][j].length() > dp[i][j-1].length()){
							dp[i][j] = dp[i-1][j];
						}
						else{
							dp[i][j] = dp[i][j-1];
						}
					}
				}
			}
			out.println(dp[n][m].length());
        }
        f.close();
    }
}
