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

public class arcade {
    char[][][]m;
    int[][][] shadow;
    public static void main(String[] args) throws Exception {
        new arcade().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("arcade").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), t = f.nextInt();
            int sr = -1, sc = -1;
            f.nextLine();
            m = new char[4][row][col];
            shadow= new int[4][row][col];
            List<int[]> exit = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                m[0][i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < 4; j++) {
                    Arrays.fill(shadow[j][i],Integer.MAX_VALUE);
                }
                for (int j = 0; j < m[0][i].length; j++) {
                    if(m[0][i][j] == 'S'){
                        sr = i;
                        sc = j;
                    }
                    else if(m[0][i][j] == 'E'){
                        exit.add(new int[]{i,j});
                    }
                }
            }
            for (int i = 1; i < 4; i++) {
                m[i] = rotate(m[i-1]);
                int[] lastExit = exit.get(exit.size()-1);
                exit.add(new int[]{lastExit[1],col-lastExit[0]-1});
            }
            recur(sr,sc,0,0);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                min = Math.min(min,shadow[i][exit.get(i)[0]][exit.get(i)[1]]);
            }
            out.println(min<=t?"Escaped the Arcade in " + min + " steps.":"Total Knockout.");
        }
        f.close();
    }
    public char[][] rotate(char[][] m){
        char[][] mat = new char[m.length][m.length];
        for (int c = 0; c < m.length; c++) {
            for (int r = 0; r < m.length; r++) {
                mat[c][m.length-r-1] = m[r][c];
            }
        }
        return mat;
    }
    public void recur(int r, int c, int step, int level){
        if(r>=0&&c>=0&&r<m[level].length&&c<m[level][r].length&&step<shadow[level][r][c]){
            shadow[level][r][c] = step;
            if(m[level][r][c]=='J'){
                recur(r,c,step+1,(level+1)%4);
            }
            else{
                recur(r,c,step+1,(level+1)%4);
                recur(r-1,c,step+1,(level+1)%4);
                recur(r+1,c,step+1,(level+1)%4);
                recur(r,c-1,step+1,(level+1)%4);
                recur(r,c+1,step+1,(level+1)%4);
            }
        }
    }
}
