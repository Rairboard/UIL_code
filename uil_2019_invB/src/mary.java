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

public class mary {
    public static void main(String[] args) throws Exception {
        new mary().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mary").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while(times-->0){
            int n = f.nextInt();
            f.nextLine();
            String[] w = new String[n];
            for (int i = 0; i < n; i++) {
                w[i] = f.nextLine();
            }
            int[][] dp = new int[n][26];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i],Integer.MAX_VALUE);
                for (int j = 0; j < w[i].length(); j++) {
                    int letter = w[i].charAt(j) - 'A';
                    dp[i][letter] = Math.min(dp[i][letter],Math.min(j,w[i].length() - j));
                }
            }
            int totalStep = 0;
            char[] palindrome = new char[n];
            for(int start = 0,end = n-1; start < end; start++,end--){
                int indivStep = Integer.MAX_VALUE;
                char c = 'A';
                for (int i = 0; i < 26; i++) {
                    if(dp[start][i] == Integer.MAX_VALUE || dp[end][i] == Integer.MAX_VALUE){
                        continue;
                    }
                    int cur = dp[start][i]  + dp[end][i];
                    if (cur < indivStep){
                        indivStep = cur;
                        c = (char)('A' + i);
                    }
                }
                if(indivStep != Integer.MAX_VALUE){
                    totalStep+=indivStep;
                    palindrome[start] = c;
                    palindrome[end] = c;
                }else{
                    totalStep = -1;
                    break;
                }
            }
            if(n%2==1){
                palindrome[n/2] = w[n/2].charAt(0);
            }
            if(totalStep == -1){
                out.println("IMPOSSIBLE");
            }
            else{
                out.println(new String(palindrome)+ " " + totalStep);
            }
        }
        f.close();
    }
}
