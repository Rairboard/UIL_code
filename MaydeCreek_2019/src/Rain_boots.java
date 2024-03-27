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

public class Rain_boots {
    char[][] m;
    int[][] shadow;;
    int min;
    public static void main(String[] args) throws Exception {
        new Rain_boots().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Rain_boots").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            m = new char[8][8];
            shadow = new int[8][8];
            min = Integer.MAX_VALUE;
            int sr = -1,sc = -1;
            for (int i = 0; i < m.length; i++) {
                String s = f.nextLine();
                m[i] = s.toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                if (s.contains("S")) {
                    sr =i;
                    sc = s.indexOf("S");
                }
            }
            if(f.hasNext()){
                f.nextLine();
            }
            recur(sr,sc,0);
            out.println(min);
        }
        f.close();
    }
    public void recur(int r, int c, int puddle){
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#' && puddle < shadow[r][c]){
            if(m[r][c]=='E'){
                min = Math.min(min,puddle);
            }
            else{
                if(m[r][c]=='M'){
                    puddle++;
                }
                char save = m[r][c];
                m[r][c] = '#';
                shadow[r][c] = puddle;
                recur(r-1,c,puddle);
                recur(r+1,c,puddle);
                recur(r,c-1,puddle);
                recur(r,c+1,puddle);
                m[r][c] = save;
            }
        }
    }
}
