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

public class maze {
    char[][] m;
    boolean found;
    public static void main(String[] args) throws Exception {
        new maze().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("maze").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            m = new char[20][20];
            int sr = -1, sc = -1;
            for (int i = 0; i < 20; i++) {
                String ln = f.nextLine().trim();
                if (ln.contains("S")) {
                    sr = i;
                    sc = ln.indexOf("S");
                }
                m[i] = ln.toCharArray();
            }
            found = false;
            recur(sr,sc);
            out.println("Maze #" + asdf + ": " + (found? "YES":"NO"));
        }
        f.close();
    }
    public void recur(int r, int c){
        if(found) return;
        if(r>=0&&c>=0&&r<m.length&&c<m[r].length&&m[r][c]!='#'){
            if(m[r][c]=='E'){
                found = true;
                return;
            }
            char ch = m[r][c];
            m[r][c] = '#';
            recur(r-1,c);
            recur(r+1,c);
            recur(r,c-1);
            recur(r,c+1);
            m[r][c] = ch;
        }
    }
}
