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

public class rescue {
    char[][][] m;
    int[][][] shadow;
    public static void main(String[] args) throws Exception {
        new rescue().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rescue").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col =f.nextInt(), level = f.nextInt();
            f.nextLine();
            int[] s = new int[3], e = new int[3];
            m = new char[level][row][col];
            shadow = new int[level][row][col];
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < row; j++) {
                    Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                    String ln = f.nextLine();
                    m[i][j] = ln.toCharArray();
                    if (ln.contains("S")) {
                        s = new int[]{i,j,ln.indexOf("S")};
                    }
                    if (ln.contains("E")) {
                        e = new int[]{i,j,ln.indexOf("E")};
                    }
                }
            }
            recur(s[0],s[1],s[2],0);
            if(shadow[e[0]][e[1]][e[2]] == Integer.MAX_VALUE){
                out.println("Rescue #" + asdf + ": NO");
            }
            else{
                out.println("Rescue #" + asdf + ": " + shadow[e[0]][e[1]][e[2]]);
            }
        }
        f.close();
    }
    public void recur(int l, int r, int c, int step){
        if (l >= 0 && r >= 0 && c >= 0 && l < m.length && r < m[l].length && c < m[l][r].length && m[l][r][c]!='#' && step < shadow[l][r][c]) {
            char save = m[l][r][c];
            shadow[l][r][c] = step;
            m[l][r][c] = '#';
            recur(l-1,r,c,step+1);
            recur(l+1,r,c,step+1);
            recur(l,r-1,c,step+1);
            recur(l,r+1,c,step+1);
            recur(l,r,c-1,step+1);
            recur(l,r,c+1,step+1);
            m[l][r][c] = save;
        }
    }
}
