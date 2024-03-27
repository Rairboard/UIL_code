import java.util.*;
import java.io.*;

public class change {
    long[] coin;
    public static void main(String[] args) throws Exception {
        new change().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("change.dat"));
        //Scanner f = new Scanner(System.in);
        int t = f.nextInt();
        f.nextLine();
        while (t-- > 0) {
           int m = f.nextInt(), c = f.nextInt();
           int[] coin = new int[m];
           int[] dp = new int[c+1];
            for (int i = 0; i < m; i++) {
                coin[i] = f.nextInt();
            }
            Arrays.sort(coin);
            Arrays.fill(dp,c+1);
            dp[0] = 0;
            for (int i = 1; i <= c; i++) {
                for (int j = 0; j < m; j++) {
                    if(coin[j]<=i){
                        dp[i] = Math.min(dp[i],1+dp[i-coin[j]]);
                    }
                }
            }
            System.out.println(dp[c]!= c+1 ? "Very good chef.":"Idiot sandwich.");
        }
        f.close();
    }
}