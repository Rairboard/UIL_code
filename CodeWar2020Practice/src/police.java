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

public class police {
    char[][] m;
    int[][] shadow;
    int[][] cop;
    boolean solved, escape;
    public static void main(String[] args) throws Exception {
        new police().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("police").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), sr = -1, sc = -1, or = -1, oc = -1, er = -1, ec = -1;
            f.nextLine();
            m = new char[row][col];
            shadow = new int[row][col];
            cop = new int[row][col];
            solved = false;
            escape = false;
            for (int i = 0; i < row; i++) {
                String ln = f.nextLine();
                m[i] = ln.toCharArray();
                if (ln.contains("$")) {
                    sr = i;
                    sc = ln.indexOf("$");
                }
                if (ln.contains("o")) {
                    or = i;
                    oc = ln.indexOf("o");
                }
            }
            for (int i = 0; i < row; i++) {
                Arrays.fill(cop[i],Integer.MAX_VALUE);
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
            }
            fill(or,oc,0);
            if(escape) {
                recur(sr,sc,0);
                out.println(solved?"The party don't stop":"Put your hands up");
            }
            else{
                out.println("The party don't stop");
            }
        }
        f.close();
    }
    public void recur(int r, int c, int step){
        if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&step<shadow[r][c]&&step<cop[r][c]&&m[r][c]!='x'&& m[r][c]!='o'){
            if(m[r][c]=='B'){
                solved = true;
                return;
            }
            char save = m[r][c];
            shadow[r][c] = step;
            recur(r-1,c,step+1);
            recur(r+1,c,step+1);
            recur(r,c-1,step+1);
            recur(r,c+1,step+1);
            m[r][c] = save;
        }
    }
    public void fill(int r, int c, int step){
        if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&step<cop[r][c] && m[r][c]!='x'){
            if(m[r][c]=='B'){
                escape = true;
            }
            cop[r][c] = step;
            char save = m[r][c];
            fill(r-1,c,step+1);
            fill(r+1,c,step+1);
            fill(r,c-1,step+1);
            fill(r,c+1,step+1);
            m[r][c] = save;
        }
    }
}
