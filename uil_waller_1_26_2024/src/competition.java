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

public class competition {
    public static void main(String[] args) throws Exception {
        new competition().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("competition").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			long[] val = Arrays.stream(f.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
			int[] dp = new int[val.length];
			int max = 0;
			Arrays.fill(dp,1);
			for(int i = 1;i < dp.length;i++){
				for (int j = 0; j < i; j++) {
					if(val[j]<= val[i] && dp[i] < dp[j] + 1){
						dp[i] = dp[j]+1;
					}
				}
			}
			for (int i = 0; i < dp.length; i++) {
				max = Math.max(dp[i],max);
			}
			out.println(dp.length-max);
        }
        f.close();
    }
}
