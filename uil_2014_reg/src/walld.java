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

public class walld {
    long[][] shadow;
    long[][] m;
    boolean found;
    int k;
    int[] vr = {-1,1,0,0};
    int[] vc = {0, 0,-1,1};
    public static void main(String[] args) throws Exception {
        new walld().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("walld").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n =f.nextInt();
            k = f.nextInt();
            f.nextLine();
            found = false;
            m = new long[n][n];
            shadow = new long[n][n];
            for (int i = 0; i < n; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
                Arrays.fill(shadow[i], Long.MAX_VALUE);
            }
            long min = recur(n/2,n/2,0,0);
            if(found){
                out.println(min);
            }
            else{
                out.println(-1);
            }
        }
        f.close();
    }
    public long recur(int r, int c, long step, long total){
        if(r>=0&&r<m.length&&c>=0&&c<m[r].length){
            if(total+m[r][c]>k) return Long.MAX_VALUE;
            if(k-total >= shadow[r][c]) return Long.MAX_VALUE;
            if(m[r][c] + total == k) {
                found = true;
                return step;
            }
            shadow[r][c] = k-total;
            long minStep = Long.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                minStep = Math.min(minStep, recur(r+vr[i], c + vc[i],step+1,total+m[r][c]));
            }
            return minStep;
        }
        return Long.MAX_VALUE;
    }
}
