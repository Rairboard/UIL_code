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

public class eggs {
    char[][] m;
    int cnt;
    public static void main(String[] args) throws Exception {
        new eggs().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("eggs").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int r = f.nextInt(), c = f.nextInt(), max = 0;
            f.nextLine();
            m = new char[r][c];
            for (int i = 0; i < r; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j <c; j++) {
                    if(m[i][j]=='0'){
                        cnt = 0;
                        recur(i,j);
                        max = Math.max(max,cnt);
                    }
                }
            }
            out.println(max);
        }
        f.close();
    }
    public void recur(int r, int c){
        if(r==-1||c==-1||r==m.length||c==m[r].length||m[r][c] == '_') return;
        if(m[r][c] == '0'){
            cnt++;
        }
        m[r][c] = '_';
        recur(r-1,c);
        recur(r+1,c);
        recur(r,c-1);
        recur(r,c+1);
    }
}
