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

public class holes {
    char[][] m;
    int sp,sec;
    public static void main(String[] args) throws Exception {
        new holes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("holes.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(),c=f.nextInt();
            m = new char[r][c];
            sec=0;
            sp=0;
            f.nextLine();
            for (int i = 0; i < r; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < c; j++) {
                    if(m[i][j]!='#'){
                        sec++;
                        recur(i,j);
                    }
                }
            }
            out.println(sec + (sec==1?" section":" sections") + ", " + sp + (sp==1?" space":" spaces"));
        }
        f.close();
    }
    public void recur(int r, int c){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'){
            sp++;
            m[r][c] = '#';
            recur(r-1,c);
            recur(r+1,c);
            recur(r,c-1);
            recur(r,c+1);
        }
    }
}
