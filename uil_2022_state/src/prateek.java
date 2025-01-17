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

public class prateek {
    public static void main(String[] args) throws Exception {
        new prateek().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("prateek").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), a = f.nextInt(), b = f.nextInt(), d = f.nextInt();
            f.nextLine();
            PriorityQueue<Item> pq = new PriorityQueue<>();
            String[] ln = new String[n];
            for (int i = 0; i < n; i++) {
                String w = f.nextLine().trim();
                pq.add(new Item(w,a));
                ln[i] = w;
            }
            for (int i = 1; i < n; i++) {
                String m = ln[i-1];
                String nn = ln[i];
                int[][] dp = new int[m.length()+1][nn.length()+1];
                for (int j = 0; j <= m.length(); j++) {
                    for (int k = 0; k <= nn.length(); k++) {
                        if(j==0) dp[j][k] = k;
                        else if(k==0) dp[j][k] = j;
                        else if(m.charAt(j-1) == nn.charAt(k-1)){
                            dp[j][k] = dp[j-1][k-1];
                        }
                        else{
                            dp[j][k] = 1 + Math.min(dp[j-1][k-1],Math.min(dp[j-1][k],dp[j][k-1]));
                        }
                    }
                }
                pq.offer(new Item(ln[i],b + d * dp[m.length()][nn.length()]));
            }
            List<String> al = new ArrayList<>(Arrays.asList(ln));
            int min = 0;
            while(!al.isEmpty()){
                while(!pq.isEmpty()){
                    Item e = pq.poll();
                    if (al.contains(e.name)) {
                        min += e.cost;
                        al.remove(e.name);
                        break;
                    }
                }
            }
            out.println("Case #" + asdf + ": " + min);
        }
        f.close();
    }
    public int recur(int i, int j, String a, String b,int[][] dp){
        if(i==0){
            return j;
        }
        if(j==0){
            return i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(a.charAt(i-1) == b.charAt(j-1)){
            return recur(i-1,j-1,a,b,dp);
        }
        int replace = recur(i-1,j-1,a,b,dp);
        int delete = recur(i-1,j,a,b,dp);
        int insert = recur(i,j-1, a, b, dp);
        dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
        return dp[i][j];
    }
    class Item implements Comparable<Item>{
        String name;
        int cost;
        public Item(String n, int c){
            name = n;
            cost = c;
        }
        public int compareTo(Item o){
            return cost - o.cost;
        }
        public String toString(){
            return name + " " + cost;
        }
    }
}
