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

public class peter_dp {
    public static void main(String[] args) throws Exception {
        new peter_dp().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("peter").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int tgt = f.nextInt();
			f.nextLine();
			int[] coin = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int[] dp = new int[tgt+1];
			Arrays.fill(dp,tgt+1);
			dp[0] = 0;
			for (int i = 1; i <= tgt; i++) {
				for (int j = 0; j < coin.length; j++) {
					if(coin[j]<= i){
						dp[i] = Math.min(dp[i],1 + dp[i-coin[j]]);
					}
				}
			}
			out.println(dp[tgt]);
		}
        f.close();
    }
}
