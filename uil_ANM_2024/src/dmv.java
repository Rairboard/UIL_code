//import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;

public class dmv {
    public static void main(String[] args) throws Exception {
        new dmv().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("dmv.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String a = f.nextLine(), b = f.nextLine();
            int[][] dp = new int[a.length()+1][b.length()+1];
            for (int i = 0; i <= a.length(); i++) {
                for (int j = 0; j <= b.length(); j++) {
                    if(i==0||j==0){
                        dp[i][j] = 0;
                    }
                    else if(a.charAt(i-1)==b.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            System.out.println(Math.max(a.length()-dp[a.length()][b.length()],b.length()-dp[a.length()][b.length()]));
        }
        f.close();
    }
}
