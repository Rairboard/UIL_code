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

public class tyler {
    public static void main(String[] args) throws Exception {
        new tyler().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tyler").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int n = f.nextInt(), m = f.nextInt(), max = 0;
        f.nextLine();
        int[] coin = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < ar.length; i++) {
            max = Math.max(max,ar[i]);
        }
        boolean[] dp = new boolean[max+1];
        dp[1] = true;
        for (int i = 1; i <= max; i++) {
            if(!dp[i]){
                continue;
            }
            for (int j = 0; j < coin.length; j++) {
                if(i * coin[j] <= max && i * coin[j] > 1){
                    dp[i * coin[j]] = true;
                }
            }
        }
        for (int i = 0; i < ar.length; i++) {
            out.println("Target " + ar[i]  + ": " + (dp[ar[i]]?"YES":"NO"));
        }
        f.close();
    }
}
