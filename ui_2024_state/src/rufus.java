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

public class rufus {
    public static void main(String[] args) throws Exception {
        new rufus().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rufus").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int s = f.nextInt(), q = f.nextInt();
		f.nextLine();
		for (int i = 0; i < q; i++) {
			String key = f.nextLine().trim();
			double avg = 0;
			for (int j = 0; j < s; j++) {
				String ans = f.nextLine().trim();
				int score = edit(key.toLowerCase(),ans.toLowerCase());
				avg+= key.length() - score;
			}
			if (s != 0) {
				avg/=s;
			}
			out.printf("%s Quiz Average: %.2f\n", key, avg);
		}
        f.close();
    }
	public int edit(String a, String b){
		int n = a.length();
		int m = b.length();
		int[][] dp = new int[n+1][m+1];
		for (int i = 0; i <= n; i++) {
			for(int j = 0;j <= m;j++){
				if(i==0) dp[i][j] = j;
				else if(j==0) dp[i][j] = i;
				else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.min(1+ dp[i-1][j-1], Math.min(1+ dp[i][j-1], 1+ dp[i-1][j]));
				}
			}
		}
		return dp[n][m];
	}
}
