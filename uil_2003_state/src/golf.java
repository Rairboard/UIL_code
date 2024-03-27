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

public class golf {
    String[] score = {"Ealge","Birdie","Par","Bogey","Double Bogey"};
    char[][]m;
    int[][] shadow;
    int[] hit = {1,3,5,10};
    int min;
    public static void main(String[] args) throws Exception {
        new golf().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("golf").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            int c = f.nextInt(), r = f.nextInt(), p = f.nextInt(),sr = -1, sc = -1;
            f.nextLine();
            min = Integer.MAX_VALUE;
            m = new char[r][c];
            shadow = new int[r][c];
            for (int i = 0; i < r; i++) {
                String ln = f.nextLine();
                m[i] = ln.toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                if (ln.contains("*")) {
                    sr = i;
                    sc = ln.indexOf("*");
                }
            }
            recur(sr,sc,0);
            out.println(score[score.length/2+(min-p)]);
        }
        f.close();
    }
    public void recur(int r, int c, int st){
        if(r>=0&&r<m.length&&c>=0&&c<m[r].length&&m[r][c]!='T'&&st < shadow[r][c]){
            char save = m[r][c];
            shadow[r][c] = st;
            if(m[r][c]=='O'){
                min = Math.min(min,st);
                return;
            }
            m[r][c] = 'T';
            for (int i = 0; i < hit.length; i++) {
                int[] vr = {-hit[i],hit[i],0,0};
                int[] vc = {0,0,-hit[i],hit[i]};
                for (int j = 0; j < 4; j++) {
                    recur(r + vr[j],c + vc[j],st+1);
                }
            }
            m[r][c] = save;
        }
    }
}
