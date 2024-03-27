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

public class terry {
    public static void main(String[] args) throws Exception {
        new terry().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("terry").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), k = f.nextInt();
            List<Painting> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                al.add(new Painting(f.nextDouble(),f.nextDouble()));
            }
            Collections.sort(al);
            double[][] dp = new double[n+1][k+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }

                }
            }
        }
        f.close();
    }
    class Painting implements Comparable<Painting>{
        double p, v;
        public Painting(double V, double P){
            v = V;
            p = P/100;
        }
        public int compareTo(Painting o){
            if(p == o.p){
                return Double.compare(o.v,v);
            }
            return Double.compare(p,o.p);
        }
    }
}
