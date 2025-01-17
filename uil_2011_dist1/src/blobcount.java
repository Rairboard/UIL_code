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

public class blobcount {
    char[][] m;
    int maxR, maxC;
    public static void main(String[] args) throws Exception {
        new blobcount().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("blobcount").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), test = f.nextInt();
            f.nextLine();
            m = new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().toCharArray();
            }
            for (int t = 0; t < test; t++) {
                int r = f.nextInt()-1, c = f.nextInt()-1;
                if(m[r][c]=='.'){
                    out.println("NO BLOB");
                }
                else{
                    maxR = r;
                    maxC = c;
                    recur(r,c);
                    boolean blob = true;
                    int cnt = 0;
                    out: for(int i = r;i<=maxR;i++){
                        for(int j = c;j<=maxC;j++){
                            if(m[i][j] == '.'){
                                blob = false;
                                break out;
                            }
                            cnt++;
                        }
                    }
                    if(blob){
                        out.println(cnt);
                    }
                    else{
                        out.println("NO BLOB");
                    }
                }
            }
        }
        f.close();
    }
    public void recur(int r, int c){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]=='*'){
            if(r > maxR){
                maxR = r;
                maxC = c;
            }
            else if(r == maxR){
                maxC = Math.max(maxC, c);
            }
            m[r][c] = '.';
            recur(r-1,c);
            recur(r+1,c);
            recur(r,c-1);
            recur(r,c+1);
            m[r][c] = '*';
        }
    }
}
