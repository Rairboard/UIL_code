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

public class roads {
    char[][] m;
    int cnt;
    public static void main(String[] args) throws Exception {
        new roads().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("roads.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            m =new char[10][10];
            int sr = -1, sc = -1, tot =0 ;
            for (int i = 0; i < 10; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j] == '*'){
                        sr = i;
                        sc = j;
                        tot++;
                    }
                }
            }
            if(f.hasNext()){
                f.nextLine();
            }
            cnt=0;
            recur(sr,sc);
            out.println(cnt == tot?"Accept":"Reject");

        }
        f.close();
    }
    public void recur(int r, int c){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c] !='I'){
            if(m[r][c] == '*'){
                cnt++;
            }
            m[r][c] = 'I';
            recur(r-1,c);
            recur(r+1,c);
            recur(r,c-1);
            recur(r,c+1);
        }
    }
}
