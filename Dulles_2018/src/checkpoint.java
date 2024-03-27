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

public class checkpoint {
    char[][] m,copy;
    int[][] shadow;
    boolean solved;
    int min,R,C;
    public static void main(String[] args) throws Exception {
        new checkpoint().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("checkpoint.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r =f.nextInt(), c = f.nextInt(),n=f.nextInt();f.nextLine();
            m = new char[r][c];
            shadow = new int[r][c];
            copy = new char[r][c];
            int minStep=0;
            for (int i = 0; i < r; i++) {
                String s = f.nextLine();
                m[i] = s.toCharArray();
                copy[i] = s.toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                if (s.contains("S")) {
                    R = i;
                    C = s.indexOf("S");
                }
            }
            for (int i = 1; i <= n; i++) {
                solved = false;
                min = 0;
                recur(R,C,0,(i+"").charAt(0));
                minStep+=min;
                for (int j = 0; j < r; j++) {
                    Arrays.fill(shadow[j],Integer.MAX_VALUE);
                    m[j] = new String(copy[j]).toCharArray();
                }
                m[R][C] = '.';
                for (int j = 0; j < r; j++) {
                    copy[j] = new String(m[j]).toCharArray();
                }
            }
            solved = false;
            min = 0;
            recur(R,C,0,'E');
            minStep+=min;
            out.println(minStep);
        }
        f.close();
    }
    public void recur(int r,int c, int step,char e){
        if(solved) return;
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'&&step<shadow[r][c]){
            if(m[r][c] == e){
                R = r;
                C = c;
                min = step;
                solved = true;
                return;
            }
            shadow[r][c] = step;
            char save = m[r][c];
            m[r][c] = '#';
            int[] y = {-1,1,0,0};
            int[] x = {0,0,-1,1};
            for (int i = 0; i < 4; i++) {
                recur(r+y[i],c+x[i],step+1,e);
            }
            m[r][c] = save;
        }
    }
}
