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

public class knight {
    public static void main(String[] args) throws Exception {
        new knight().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("knight").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        int p = f.nextInt();
        f.nextLine();
        boolean[][] m = new boolean[n][n];
        int[][] shadow = new int[n][n];
        for (int i = 0; i < p; i++) {
            int c = f.nextInt(), r = f.nextInt();
            m[r][c] = true;
        }
        for(int i =0;i < n;i++){
            Arrays.fill(shadow[i], Integer.MIN_VALUE);
        }
        recur(0,0,0,m,shadow);
        int max = 0;
        for(int i = 0;i < n;i++){
            max = Math.max(max, shadow[i][n-1]);
        }
        out.println(max);
        f.close();
    }
    public void recur(int r, int c, int capture, boolean[][] m, int[][]shadow){
        if(r>=0&&c>=0&&r<shadow.length&&c<shadow[r].length && capture > shadow[r][c]){
            shadow[r][c] = capture;
            if(c==m.length-1) {
                if(m[r][c]) shadow[r][c]++;
                return;
            }
            if(m[r][c]){
                recur(r-1,c+2,capture+1, m, shadow);
                recur(r+1,c+2,capture+1,m,shadow);
                recur(r-2,c+1,capture+1,m,shadow);
                recur(r+2,c+1,capture+1,m, shadow);
            }
            else{
                recur(r-1,c+2,capture, m, shadow);
                recur(r+1,c+2,capture,m,shadow);
                recur(r-2,c+1,capture,m,shadow);
                recur(r+2,c+1,capture,m, shadow);
            }
        }
    }
}
