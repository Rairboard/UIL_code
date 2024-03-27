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

public class coins {
    public static void main(String[] args) throws Exception {
        new coins().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("coins").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int tgt = f.nextInt(), c = f.nextInt();
			f.nextLine();
			int[] coin = new int[c];
			int[] dp = new int[tgt+1];
			Arrays.fill(dp,tgt+1);
			for (int i = 0; i < c; i++) {
				coin[i] = f.nextInt();
			}
			if(f.hasNext()){
				f.nextLine();
			}
			dp[0] = 0;
			for (int i = 0; i <= tgt; i++) {
				for (int j = 0; j < c; j++) {
					if(coin[j]<=i){
						dp[i] = Math.min(dp[i],dp[i-coin[j]] + 1);
					}
				}
			}
			out.println(dp[tgt] == tgt+1 ? "Not Possible":"Possible");
        }
        f.close();
    }
}
