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

public class dungeons {
    public static void main(String[] args) throws Exception {
        new dungeons().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dungeons").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int item = f.nextInt(),weight = f.nextInt(), attack = f.nextInt(), armor = f.nextInt();
            f.nextLine();
            List<Item> al = new ArrayList<>();
            for (int i = 0; i < item; i++) {
                String[] ln = f.nextLine().split("\\s+");
                al.add(new Item(ln[0],ln[1],Integer.parseInt(ln[2]),Integer.parseInt(ln[3]),attack,armor));
            }
            Collections.sort(al);
            int[][] dp = new int[item+1][weight+1];
            for (int i = 0; i <= item; i++) {
                for (int j = 0; j <= weight; j++) {
                    if(i==0 || j == 0){
                        dp[i][j] = 0;
                    }
                    else if(al.get(i-1).w <= j){
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j - al.get(i-1).w] + al.get(i-1).v);
                    }
                    else{
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
                    }
                }
            }
            out.println(dp[item][weight]);
        }
        f.close();
    }
    class Item implements Comparable<Item>{
        String n, t;
        int v, w, at, ar;
        public Item(String a, String b , int c, int d, int att, int armor){
            n = a;
            t = b;
            w = d;
            at = att;
            ar = armor;
            switch(b){
                case "weapon": v = c *  at * 2;break;
                case "armor": v = c *  (22 - ar);break;
                case "item": v = c;break;
            }
        }
        public int compareTo(Item o){
            return w - o.w;
        }
        public String toString(){
            return n + " " + t + " val " + v + " weight " + w;
        }
    }
}
