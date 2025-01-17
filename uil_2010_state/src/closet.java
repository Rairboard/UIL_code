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

public class closet {
    public static void main(String[] args) throws Exception {
        new closet().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("closet").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int n = ar.length;
			int[] dp = new int[n];
			Arrays.fill(dp, 1);
			for(int i = 1;i < n;i++){
				for(int j = 0;j < i;j++){
					if(ar[i]>ar[j] && dp[j]+1 > dp[i]){
						dp[i] = dp[j]+1;
					}
				}
			}
//			out.println(Arrays.toString(ar));
//			out.println(Arrays.toString(dp));
			int max = 1;
			for(int i : dp){
				max = Math.max(max, i);

			}
			out.println(n-max);
        }
        f.close();
    }
}
