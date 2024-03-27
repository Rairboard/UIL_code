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

public class grab {
    public static void main(String[] args) throws Exception {
        new grab().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("grab").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int w = f.nextInt(), t = f.nextInt(), n = f.nextInt();
            f.nextLine();
            List<Item> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().split("\\s+");
                String name = "";
                int val = Integer.parseInt(ln[ln.length-3]), sp = Integer.parseInt(ln[ln.length-2]), time = Integer.parseInt(ln[ln.length-1]);
                for (int j = 0; j < ln.length - 3; j++) {
                    name+=ln[j]+" ";
                }
                al.add(new Item(name.trim(),val,sp,time));
            }
            Collections.sort(al, Comparator.comparingInt(a -> a.w));
            int[][] weight = new int[n+1][w+1];
            int[][] time = new int[n+1][t+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= w; j++) {
                    if(i==0||j==0){
                        weight[i][j] = 0;
                    }
                    else if(al.get(i-1).w<=j){
                        weight[i][j] = Math.max(weight[i-1][j],weight[i-1][j-al.get(i-1).w]+al.get(i-1).v);
                    }
                    else{
                        weight[i][j] = weight[i-1][j];
                    }
                }
            }
            Collections.sort(al,Comparator.comparingInt(a -> a.t));
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= t; j++) {
                    if(i==0||j==0){
                        time[i][j] = 0;
                    }
                    else if(al.get(i-1).t<=j){
                        time[i][j] = Math.max(time[i-1][j],time[i-1][j-al.get(i-1).t]+al.get(i-1).v);
                    }
                    else{
                        time[i][j] = time[i-1][j];
                    }
                }
            }
            out.println(Math.min(time[n][t],weight[n][w]));
        }
        f.close();
    }
    class Item{
        int w, t,v;
        String name;
        public Item(String n, int val, int sp, int time){
            v = val;
            w = sp;
            t = time;
            name =n;
        }
    }
}
