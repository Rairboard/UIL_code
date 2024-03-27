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

public class purse {
    public static void main(String[] args) throws Exception {
        new purse().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("purse").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int item = f.nextInt(), w = f.nextInt();
            f.nextLine();
            List<Item> al = new ArrayList<>();
            for (int i = 0; i < item; i++) {
                al.add(new Item(f.nextInt(),f.nextInt(),f.nextLine().trim()));
            }
            Collections.sort(al);
            int[][] dp = new int[item+1][w+1];
            for (int i = 0; i <= item; i++) {
                for (int j = 0; j <= w; j++) {
                    if(i==0||j==0){
                        dp[i][j] = 0;
                    }
                    else if(al.get(i-1).weight<= j){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-al.get(i-1).weight] + 1);
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
//            out.println(al);
//            for(int[] ar : dp){
//                out.println(Arrays.toString(ar));
//            }
            List<String> ts = new ArrayList<>();
            int i = item, j = w;
            while (i> 0 && j > 0) {
                if(dp[i][j]!= dp[i-1][j]){
                    ts.add(al.get(i).name);
                    i--;
                    j-=al.get(i).weight;
                }
                else{
                    i--;
                }
            }
            Collections.sort(ts);
            out.println(ts);
        }
        f.close();
    }
    class Item implements Comparable<Item>{
        int key;
        int weight;
        String name;
        public Item(int w, int k, String n) {
            key = k;
            weight = w;
            name = n;
        }
        public int compareTo(Item o){
            return weight-o.weight;
        }
        public String toString(){
            return key +" " + weight +" " + name;
        }
    }
}
