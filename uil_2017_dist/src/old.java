import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class old {
    char[][] m;
    int[][][] shadow;
    public static void main(String[] args) throws Exception {
        new old().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("old").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), s = f.nextInt(), o = f.nextInt();
            f.nextLine();
            int sr = -1, sc = -1;
            shadow = new int[o+1][row][col];
            for (int i = 0; i <= o; i++) {
                for(int j = 0;j < row;j++){
                    Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                }
            }
            m = new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='?'){
                        sr = i;
                        sc = j;
                    }
                }
            }
            recur(sr,sc,0,0);
//            for(int i = 0;i <= o;i++){
//                for (int j = 0; j < row; j++) {
//                    out.println(Arrays.toString(shadow[i][j]));
//                }
//                out.println();
//            }
            if(shadow[o][sr][sc]==Integer.MAX_VALUE){
                out.println("Time Runs Out.");
            }
            else{
                out.println(shadow[o][sr][sc] <= s ? "Olds Collected.":"Time Runs Out.");
            }
        }
        f.close();
    }
    public void recur(int r, int c, int level, int step){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'&&step<shadow[level][r][c]){
            shadow[level][r][c] = step;
            if(m[r][c] - 'A' == level){
                level++;
                shadow[level][r][c] = step;
                recur(r-1,c,level,step+1);
                recur(r+1,c,level,step+1);
                recur(r,c-1,level,step+1);
                recur(r,c+1,level,step+1);
            } else if (m[r][c]=='@') {
                recur(r-1,c,level,step+2);
                recur(r+1,c,level,step+2);
                recur(r,c-1,level,step+2);
                recur(r,c+1,level,step+2);
            }
            else{
                recur(r-1,c,level,step+1);
                recur(r+1,c,level,step+1);
                recur(r,c-1,level,step+1);
                recur(r,c+1,level,step+1);
            }
        }
    }
}
