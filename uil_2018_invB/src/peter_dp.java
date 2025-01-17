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
//        new peter_dp().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("peter").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			int tgt = f.nextInt(); f.nextLine();
			int[] coin = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int n = coin.length;
			int[][] dp = new int[n+1][tgt+1];
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], tgt+1);
			}
			for(int i = 0;i <= n;i++){
				for(int j = 0;j<= tgt;j++){
					if(i==0 || j == 0){
						dp[i][j] = 0;

                    }
					else if(coin[i-1] <= j){
						int before = dp[i][j];
						dp[i][j] = Math.min(dp[i][j], dp[i][j-coin[i-1]] + 1);
//						if(dp[i][j]!=before){
//						}
					}
					else{
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			List<Integer> al = new ArrayList<>();
			int sum = tgt;
			for(int i = n;i>0 && sum > 0;i--){
				if(dp[i][sum]!=dp[i-1][sum]){
					for (int j = 0; j < sum/coin[i - 1]; j++) {
						al.add(coin[i-1]);
					}
					sum%=coin[i-1];
				}
			}
			Collections.sort(al);
			out.print(tgt + " " + dp[n][tgt] + " ");
			for(int i = 0 ;i < al.size();i++){
				out.print(al.get(i)+" ");
			}
			out.println();
		}
        f.close();
    }
}
