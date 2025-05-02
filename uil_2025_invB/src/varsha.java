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

public class varsha {
    public static void main(String[] args) throws Exception {
        new varsha().run();
    }
    int size;
    char[][][] m;
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("varsha").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int level = f.nextInt(), row = f.nextInt(), col = f.nextInt();
            m = new char[level][row][col];
            f.nextLine();
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < row; j++) {
                    m[i][j] = f.nextLine().toCharArray();
                }
            }
            int mx = 0;
            for (int i = 0; i < level; i++) {
                for (int j = 0; j < row; j++) {
                    for (int k = 0; k < col; k++) {
                        if (m[i][j][k] == 'V') {
                            size =0;
                            recur(i,j,k, m[i][j][k]);
                            mx = Math.max(mx, size);
                        }
                    }
                }
            }
            out.println(mx);
        }
        f.close();
    }
    public void recur(int l, int r, int c,char ch){
        if(l>=0&&r>=0&&c>=0&&l<m.length&&r<m[l].length&&c<m[l][r].length&&m[l][r][c]=='V'){
            size++;
            m[l][r][c] = '#';
            recur(l-1,r,c,ch);
            recur(l+1,r,c,ch);
            recur(l,r-1,c,ch);
            recur(l,r+1,c,ch);
            recur(l,r,c-1,ch);
            recur(l,r,c+1,ch);
        }
    }
}
