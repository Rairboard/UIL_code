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

public class guozhi {
    char[][]m;
    int[][][] shadow;
    HashSet<Integer>[][] block;
    public static void main(String[] args) throws Exception {

//        new guozhi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("guozhi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt(), sr = -1, sc = -1, er =-1, ec = -1;
            f.nextLine();
            m = new char[row][col];
            shadow = new int[4][row][col];
            List<int[]> al = new ArrayList<>();
            block = new HashSet[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().toCharArray();
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='G'){
                        sr = i;
                        sc = j;
                    }
                    if("NSWE".contains(m[i][j]+"")){
                        al.add(new int[]{m[i][j],i,j});
                    }
                    if(m[i][j]=='H'){
                        er = i;
                        ec = j;
                    }
                }
            }
            for (int i = 0; i < block.length; i++) {
                block[i] = new HashSet[col];
                for (int j = 0; j < block[i].length; j++) {
                    block[i][j] = new HashSet<>();
                }
            }
            for (int i = 0; i < shadow.length; i++) {
                for (int j = 0; j < shadow[i].length; j++) {
                    Arrays.fill(shadow[i][j],Integer.MAX_VALUE);
                }
            }
            for(int[] ar : al){
                char ch = (char)ar[0];
                int dr = -1, dc =-1;
                switch (ch){
                    case 'N' -> {dr = -1;dc = 0;}
                    case 'S' -> {dr = 1;dc = 0;}
                    case 'E' -> {dr = 0;dc = 1;}
                    case 'W' -> {dr = 0;dc = -1;}
                }

                for (int i = 0; i < 4; i++) {
                    int r = ar[1];
                    int c = ar[2];
                    while(in(r+dr, c+dc) && m[r+dr][c+dc]!='#'&&m[r+dr][c+dc]!='H'){
                        r+=dr;
                        c+=dc;
                        block[r][c].add(i);
                    }
                    int t = dr;
                    dr = dc;
                    dc = -t;
                }
            }
//            for (int i = 0; i < row; i++) {
//                for (int j = 0; j < col; j++) {
//                    out.println(block[i][j]);
//                }
//                out.println();
//            }
            recur(sr,sc,0);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                min = Math.min(min , shadow[i][er][ec]);
            }
            out.println("Case #" + asdf + ": " + (min==Integer.MAX_VALUE?-1:min));
        }
        f.close();
    }
    public boolean in(int r, int c){
        return r>=0&&c>=0&&r<m.length&&c<m[r].length;
    }
    public void recur(int r, int c, int time){
        if (in(r,c) && m[r][c] != '#' && !"NSWE".contains(m[r][c] + "") && time < shadow[time%4][r][c]) {
            if(block[r][c].contains(time%4)){
                return;
            }
            shadow[time%4][r][c] = time;
            if(m[r][c]=='H'){
                return;
            }
            recur(r, c, time+1);
            recur(r-1,c,time+1);
            recur(r+1,c,time+1);
            recur(r,c-1,time+1);
            recur(r,c+1,time+1);
        }
    }
}
