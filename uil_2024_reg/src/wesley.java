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

public class wesley {
    char[][] m;
    int[][] shadow;

    public static void main(String[] args) throws Exception {
        new wesley().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("wesley").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int r = f.nextInt(), c = f.nextInt(), sr = -1, sc = -1, er = -1,ec = -1;
            f.nextLine();
            m = new char[r][c];
            shadow = new int[r][c];
            for (int i = 0; i < r; i++) {
                String ln = f.nextLine().trim();
                if (ln.contains("S")) {
                    sr = i;
                    sc = ln.indexOf("S");
                }
                if (ln.contains("E")) {
                    er = i;
                    ec = ln.indexOf("E");
                }
                m[i] = ln.toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
            }
            recur(sr,sc,0,1);
            if(shadow[er][ec]!=Integer.MAX_VALUE){
                out.println("The Great Escape.");
            }
            else{
                out.println("Guess I won't be home in time for dinner.");
            }
        }
        f.close();
    }
    public void recur(int r, int c, int step,int dimen){
        try{
            if ((m[r][c] == '1' && dimen != 1) || (m[r][c] == '3' && dimen != 3) || (m[r][c]=='5' && dimen!=5)) return;
            if(m[r][c]=='#' && dimen !=2 && dimen != 4)return;
            if(m[r][c]=='.' && dimen == 4) return;
            if(m[r][c]=='S' && dimen == 4) return;
            if(m[r][c]=='E'&&dimen==4) return;
            if(step>=shadow[r][c]) return;
            shadow[r][c] = step;
            if(dimen==5){
                dimen = 1;
            }
            else{
                dimen++;
            }
            if(m[r][c]=='E'){

            }
            recur(r-1,c,step+1,dimen);
            recur(r+1,c,step+1,dimen);
            recur(r,c-1,step+1,dimen);
            recur(r,c+1,step+1,dimen);
        }
        catch(Exception e){}
    }
}
