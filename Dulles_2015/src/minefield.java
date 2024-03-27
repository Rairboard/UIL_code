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

public class minefield {
    char[][] m;
    int[][] shadow;
    int min;
    boolean solved;
    public static void main(String[] args) throws Exception {
        new minefield().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("minefield.in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(), c = f.nextInt();
            f.nextLine();
            m = new char[r][c];
            shadow = new int[r][c];
            min = Integer.MAX_VALUE;
            solved = false;
            for (int i = 0; i < r; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            for (int i = 0; i < c; i++) {
                if(m[0][i]=='o'){
                    for (int j = 0; j < r; j++) {
                        Arrays.fill(shadow[j],Integer.MAX_VALUE);
                    }
                    if(recur(0,i,0)){
                        break;
                    }
                }
            }
            out.println(solved?"Roll out!":"Looks like we have to take a detour.");
        }
        f.close();
    }
    public boolean recur(int r, int c, int step){
        if(solved) return true;
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='*'){
            if(r==m.length-1 && m[r][c] == 'o'){
                solved = true;
                return true;
            }
            char save = m[r][c];
            m[r][c] = '*';
            int[] x = {-1,1,-1,1,0,0,-1,1};
            int[] y = {1,1,-1,-1,-1,1,0,0};
            for (int i = 0; i < 8; i++) {
                if(recur(r+y[i],c+x[i],step+1)){
                    m[r][c] = save;
                    return true;
                }
            }
            m[r][c] = save;
        }
        return false;
    }
}
