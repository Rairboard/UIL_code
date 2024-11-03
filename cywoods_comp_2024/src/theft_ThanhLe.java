import java.util.*;
import java.io.File;
import java.util.Arrays;

import static java.lang.System.*;

public class theft_ThanhLe {
    public static void main(String[] args) throws Exception {
        new theft_ThanhLe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("theft").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int w = f.nextInt(), item = f.nextInt();
			f.nextLine();
			int[] weight = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int[] profit = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			String[] name = f.nextLine().trim().split(",\\s+");
			int[][] dp = new int[item+1][w+1];
			String[][] list = new String[item+1][w+1];
			for (int i = 0; i < list.length; i++) {
				Arrays.fill(list[i],"");
			}
			for(int i = 1; i <= item;i++){
				for(int j = 1;j <= w;j++){
					dp[i][j] = dp[i-1][j];
					list[i][j] = list[i-1][j];
					if(weight[i-1] <= j && dp[i][j]  < dp[i-1][j-weight[i-1]] + profit[i-1]){
						dp[i][j] =dp[i-1][j-weight[i-1]] + profit[i-1];
						list[i][j] = list[i-1][j-weight[i-1]] + name[i-1] + ",";
					}
				}
			}

			out.println("Max Capacity: " + w);
			out.println("Max Profit: $" + dp[item][w]);
			if(dp[item][w]==0){
				out.println("Nothing could be stolen...");
			}
			else{
				String[] itemUsed = list[item][w].split(",");
				for (int i = 0; i < itemUsed.length; i++) {
					out.println(itemUsed[i]);
				}
			}
			out.println();
		}
        f.close();
    }
}
