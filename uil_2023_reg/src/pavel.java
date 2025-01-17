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

public class pavel {
    int[][][] shadow;
    char[][] m;
    public static void main(String[] args) throws Exception {
        new pavel().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pavel").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), s = f.nextInt();
            f.nextLine();
            m = new char[row][col];
            shadow = new int[4][row][col];
            int sr = -1, sc = -1, er = -1, ec = -1;
            for (int i = 0; i < 4; i++) {
                shadow[i] = new int[row][col];
                for (int j = 0; j < row; j++) {
                    Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                }
            }
            for (int i = 0; i < row; i++) {
                String ln = f.nextLine().trim();
                if (ln.contains("S")) {
                    sr = i;
                    sc = ln.indexOf("S");
                }
                if (ln.contains("E")) {
                    er = i;
                    ec = ln.indexOf("E");
                }
                m[i] = ln.toCharArray();
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if ("1234".contains(m[i][j] + "")) {
                        m[i][j] = (char)(m[i][j]-1);
                    }
                }
            }
            recur(sr,sc,0,0);
            int minStep = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
               minStep = Math.min(minStep, shadow[i][er][ec]);

            }
            if(minStep==Integer.MAX_VALUE || (er == -1 && ec == -1)) out.println("Aw, Rats!");
            else out.println(minStep + " steps.");
            if(minStep<=s) out.println("I have had enough of these snakes.");
            else out.println("I'll see you in the Gulag Pavel.");
        }
        f.close();
    }
    public void recur(int r, int c, int step, int sec){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#' && step < shadow[sec][r][c]){
            if("0123".contains(m[r][c]+"")){
                if(m[r][c]-'0' !=sec) return;
            }
            shadow[sec][r][c] = step;
            recur(r-1,c,step+1,(sec+1)%4);
            recur(r+1,c,step+1,(sec+1)%4);
            recur(r,c-1,step+1,(sec+1)%4);
            recur(r,c+1,step+1,(sec+1)%4);
        }
    }
}
