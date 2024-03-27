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

public class Bodies {
    char[][]m;
    int[][] shadow;
    boolean  solved;
    public static void main(String[] args) throws Exception {
        new Bodies().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Bodies").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r= f.nextInt(), c = f.nextInt(),sr = -1, sc = -1;
            f.nextLine();
            m = new char[r][c];
            shadow = new int[r][c];
            solved = false;

            for (int i = 0; i < r; i++) {
                String ln = f.nextLine();
                m[i] = ln.toCharArray();
                if (ln.contains("T")) {
                    sr = i;
                    sc = ln.indexOf("T");
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(m[i][j]=='P'){
                        for(int nr = i-1;nr<=i+1;nr++){
                            for(int nc = j-1;nc <= j+1;nc++){
                                if(nr>=0&&nc>=0&&nr<m.length&&nc<m[nr].length&&m[nr][nc]!='P'){
                                    m[nr][nc] = '#';
                                }
                            }
                        }
                    }
                }
            }
            recur(sr,sc,0);
            out.println(solved?"Bravo Six Going Dark... at the end of the tunnel is a light.":"Bravo Six Going Dark... Mission Failed. We'll get em next time.");
        }
        f.close();
    }
    public void recur(int r, int c,int step){
        if(solved)return;
        try{
            if(m[r][c]=='#'){
                return;
            }
            if(step<shadow[r][c]){
                return;
            }
        }catch(Exception e){return;}
        if(m[r][c]=='S'){
            solved = true;
            return;
        }
        char save = m[r][c];
        m[r][c] = '#';
        shadow[r][c] = step;
        recur(r-1,c,step+1);
        recur(r+1,c,step+1);
        recur(r,c-1,step+1);
        recur(r,c+1,step+1);
        m[r][c] = save;
    }
}
