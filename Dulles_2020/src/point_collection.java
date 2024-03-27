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

public class point_collection {
    char[][] m;
    long max;
    public static void main(String[] args) throws Exception {
        new point_collection().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("point_collection.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int N = f.nextInt(), sr = -1, sc = -1;
            m = new char[8][8];
            f.nextLine();
            for (int i = 0; i < 8; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if (m[i][j] == 'S') {
                        sr = i;
                        sc = j;
                        break;
                    }
                }
            }
            max =0;
            recur(sr,sc,N,0);
            out.println(max);
        }
        f.close();
    }
    public void recur(int r, int c, int step,int point){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c] != 'W'&&step>=0) {
            char save = m[r][c];
            m[r][c] = 'W';
            if(Character.isDigit(save)){
                recur(r-1,c,step-1,point+Integer.parseInt(save+""));
                recur(r+1,c,step-1,point+Integer.parseInt(save+""));
                recur(r,c-1,step-1,point+Integer.parseInt(save+""));
                recur(r,c+1,step-1,point+Integer.parseInt(save+""));
            }else{
                recur(r-1,c,step-1,point);
                recur(r+1,c,step-1,point);
                recur(r,c-1,step-1,point);
                recur(r,c+1,step-1,point);
            }
            m[r][c] = save;
        }else{
            max = Math.max(max,point);
        }
    }
}