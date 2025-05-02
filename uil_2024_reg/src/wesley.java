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

public class wesley {
    char[][] m;
    int[][][] shadow;

    public static void main(String[] args) throws Exception {
        new wesley().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("wesley").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int adsf = 0; adsf < times; adsf++) {
            int row = f.nextInt(), col = f.nextInt();
            int sr = -1, sc = -1;
            f.nextLine();
            List<int[]> exit = new ArrayList<>();
            m = new char[row][col];
            shadow = new int[5][row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='S'){
                        sr = i;
                        sc = j;
                    }
                    else if(m[i][j] == 'E'){
                        exit.add(new int[]{i,j});
                    }
                }
                for (int j = 0; j < 5; j++) {
                    Arrays.fill(shadow[j][i], Integer.MAX_VALUE);
                }
            }
            recur(sr,sc,0,0);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < exit.size(); i++) {
                for (int j = 0; j < 5; j++) {
                    min = Math.min(shadow[j][exit.get(i)[0]][exit.get(i)[1]], min);
                }
            }
            if(min==Integer.MAX_VALUE) out.println("Guess I won't be home in time for dinner.");
            else out.println("The Great Escape.");
        }
        f.close();
    }
    //SE.#135
    public void recur(int r, int c, int level, int step){
        if(r<0||c<0||r>=m.length||c>=m[r].length||level<0||level>=shadow.length) return;
        if(level + 1 == 1 && "#35".contains(m[r][c]+"")) return;
        if(level+1 == 3 && "#15".contains(m[r][c]+"")) return;
        if(level+1 == 5 && "#13".contains(m[r][c]+"")) return;
        if(level+1 == 4 && "SE.".contains(m[r][c]+"")) return;
        if(step>=shadow[level][r][c]) return;
        shadow[level][r][c] = step;
        recur(r-1,c,(level+1)%5, step+1);
        recur(r+1,c,(level+1)%5, step+1);
        recur(r,c-1,(level+1)%5, step+1);
        recur(r,c+1,(level+1)%5, step+1);
    }
}
