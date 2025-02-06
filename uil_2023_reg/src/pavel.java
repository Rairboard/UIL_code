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
            int row = f.nextInt(), col= f.nextInt(), s = f.nextInt();
            f.nextLine();
            int sr = -1, sc = -1;
            List<int[]> exit = new ArrayList<>();
            m = new char[row][col];
            shadow = new int[4][row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < 4; j++) {
                    Arrays.fill(shadow[j][i],Integer.MAX_VALUE);
                }
                m[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < col; j++) {
                    if(m[i][j]=='S'){
                        sr = i;
                        sc = j;
                    }
                    else if(m[i][j] == 'E'){
                        exit.add(new int[]{i,j});
                    }
                }
            }
            recur(sr,sc,0,0);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < exit.size(); i++) {
                for (int j = 0; j < 4; j++) {
                    min = Math.min(min,shadow[j][exit.get(i)[0]][exit.get(i)[1]]);
                }
            }
            if(exit.isEmpty() || min == Integer.MAX_VALUE) out.println("Aw, rats!");
            else out.println(min+" steps.");
            if(min<=s) out.println("I have had enough of these snakes.");
            else out.println("I'll see you in the Gulag Pavel.");
        }
        f.close();
    }
    public void recur(int r, int c, int step, int sec){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'&&step<shadow[sec][r][c]){
            if((m[r][c]+"").matches("[1-4]") && m[r][c] - '0' != sec + 1) return;
            shadow[sec][r][c] = step;
            recur( r-1,c,step+1,(sec+1)%4);
            recur( r+1,c,step+1,(sec+1)%4);
            recur( r,c-1,step+1,(sec+1)%4);
            recur( r,c+1,step+1,(sec+1)%4);
        }
    }
}
