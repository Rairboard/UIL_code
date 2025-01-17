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

public class optimize {
    public static void main(String[] args) throws Exception {
        new optimize().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("optimize").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int[] profit = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int n = profit.length;
			int target = f.nextInt();
			f.nextLine();
			int[] dp = new int[target+1];
			for(int i = 1;i<=target;i++){
				for(int j = 1;j<=n;j++){
					if(i-j>=0){
						dp[i] = Math.max(dp[i], profit[j-1] + dp[i-j]);
					}
				}
			}
			out.println(dp[target]);
        }
        f.close();
    }
}
