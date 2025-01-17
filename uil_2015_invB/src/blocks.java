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

public class blocks {
    public static void main(String[] args) throws Exception {
        new blocks().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("blocks").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int target = f.nextInt();
			f.nextLine();
			int[] weight = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			boolean[][] dp = new boolean[weight.length+1][target+1];
			dp[0][0] = true;
			for(int i = 1;i <= weight.length;i++){
				for(int j = 0;j<=target;j++){
					if(j==0){
						dp[i][j] = true;
					}
					else if(weight[i-1] <= j){
						dp[i][j] = dp[i-1][j] | dp[i-1][j-weight[i-1]];
					}
					else{
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			out.println(dp[weight.length][target] ? "YES":"NO");
        }
        f.close();
    }
}
