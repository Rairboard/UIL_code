import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;
import java.util.regex.Pattern;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class knapSack {
    public static void main(String[] args) throws Exception {
        Scanner f = new Scanner("aeiouKaeiouKaeiouKaeiou");
        Object one = new HashSet<>();
        Object two = one.toString();
        out.println(one == two);
        out.println(one.equals(two));


        //        new knapSack().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("knapSack").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int[] weight = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] profit = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] item = f.nextLine().trim().split("\\s+");
        int target = f.nextInt();
        int n = profit.length;
        int[][] dp = new int[n+1][target+1];
        String[][] list = new String[n+1][target+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if(i==0||j==0) {
                    dp[i][j] = 0;
                    list[i][j] = "";
                }
                else{
                    dp[i][j] = dp[i-1][j];
                    list[i][j] = list[i-1][j];
                    if(weight[i-1] <= j && dp[i-1][j-weight[i-1]] + profit[i-1] > dp[i][j]){
                        dp[i][j] = dp[i-1][j-weight[i-1]] + profit[i-1];
                        list[i][j] = list[i-1][j] + item[i-1] + ",";
                    }
                }
            }
        }
        out.println(dp[n][target]);
        String[] finalItemUsed = list[n][target].split(",");
        for(String s : finalItemUsed){
            out.println(s);
        }
        f.close();
    }
}
