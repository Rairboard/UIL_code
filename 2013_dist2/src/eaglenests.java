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

public class eaglenests {
    public static void main(String[] args) throws Exception {
        new eaglenests().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("eaglenests").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            char[][] m = new char[10][10];
            for(int i = 0 ;i < 10;i++){
                m[i] = f.nextLine().toCharArray();
            }
            for(int i =0 ;i < 10;i++){
                for(int j =0 ;j < 10;j++){
                    if(m[i][j]=='E'){
                        out.println(i+1 + " " + (j+1));
//                        recur(i,j,m);
                    }
                }
            }
            out.println(    );
        }
        f.close();
    }
    public void recur(int r, int c, char[][] m){
        if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&m[r][c]=='E'){
            m[r][c] = '.';
            recur(r-1,c,m);
            recur(r+1,c,m);
            recur(r,c-1,m);
            recur(r,c+1,m);
        }
    }
}
