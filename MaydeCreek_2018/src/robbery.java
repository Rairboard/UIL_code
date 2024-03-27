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

public class robbery {
    public static void main(String[] args) throws Exception {
        new robbery().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("robbery").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int w = f.nextInt(), max = 0, n = f.nextInt();
            f.nextLine();
            long[] val = Arrays.stream(f.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
            long[] weight = Arrays.stream(f.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
            List<Item> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                al.add(new Item(val[i],weight[i]));
            }
            Collections.sort(al);
            long[][] dp = new long[n+1][w+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= w; j++) {
                    if(i==0 || j == 0){
                        dp[i][j] = 0;
                    }
                    else if(al.get(i-1).weight <= j){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][(int)(j-al.get(i-1).weight)] + al.get(i-1).val);
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
                    }
                }
            }
            out.println(dp[n][w]);
        }
        f.close();
    }
    class Item implements Comparable<Item>{
        long val, weight;
        double percent;
        public Item(long v, long w){
            val = v;
            weight = w;
            percent = (double)val / weight;
        }
        public int compareTo(Item o){
            return Long.compare(weight,o.weight);
        }
        public String toString(){
            return "weight: " + weight + " value: " + val;
        }
    }
}
