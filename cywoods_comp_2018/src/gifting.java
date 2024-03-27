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

public class gifting {
    public static void main(String[] args) throws Exception {
        new gifting().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("gifting").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0){
            int n = f.nextInt(), w = f.nextInt(), min = Integer.MAX_VALUE;
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                f.next();
                f.nextInt();
                weight[i] = f.nextInt();
                min = Math.min(min,weight[i]);
            }
            if(min > w){
                out.println("WE WANT PRESENTS! ".repeat(2));
            }else{
                Arrays.sort(weight);
                int[][] m = new int[n+1][w+1];
                for (int i = 0; i <= n; i++) {
                    for (int j = 0; j <= w; j++) {
                        if(i==0 || j==0){
                            m[i][j] = 0;
                        }else{
                            if(weight[i-1]<=j){
                                m[i][j] = Math.max(m[i-1][j],1 + m[i-1][j-weight[i-1]]);
                            }else{
                                m[i][j] = m[i-1][j];
                            }
                        }
                    }
                }
                out.println(m[n][w]);
            }
        }
        f.close();
    }
}
