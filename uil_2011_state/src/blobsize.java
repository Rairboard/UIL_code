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

public class blobsize {
    char[][] m;
    int[] vr = {-1,1,0,0,-1,-1,1,1};
    int[] vc = {0,0,-1,1,-1,1,-1,1};
    public static void main(String[] args) throws Exception {
        new blobsize().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("blobsize").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), test = f.nextInt();
            f.nextLine();
            m = new char[row][col];
            char[][] copy = new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().trim().toCharArray();
                copy[i] = new String(m[i]).toCharArray();
            }
            for (int t = 0; t < test; t++) {
                int r = f.nextInt()-1, c = f.nextInt()-1;
                if(m[r][c]=='.'){
                    out.println("NO BLOB");
                }
                else{
                    int size = recur(r,c);
                    out.println(size);
                    for (int i = 0; i < row; i++) {
                        m[i] = new String(copy[i]).toCharArray();
                    }
                }

            }
        }
        f.close();
    }
    public int recur(int r, int c){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]=='*'){
            m[r][c] = '.';
            int cnt = 0;
            for (int i = 0; i < 8; i++) {
                cnt+= recur(r + vr[i],  c + vc[i]);
            }
            return cnt + 1;
        }
        return 0;
    }
}
