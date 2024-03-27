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

public class etch {
    public static void main(String[] args) throws Exception {
        new etch().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("etch").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            char[][] m = new char[15][25];
            int r = f.nextInt()-1, c = f.nextInt()-1;
            f.nextLine();
            String[] ln = f.nextLine().split("\\s+");
            for (int i = 0; i < m.length; i++) {
                Arrays.fill(m[i],'.');
            }
            m[r][c]='*';
            for (int i = 0; i < ln.length; i++) {
                char cc = ln[i].charAt(0);
                int n = Integer.parseInt(ln[i].substring(1));
                for (int j = 0; j < n; j++) {
                    int[] d = move(cc);
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr>=0&&nr<m.length&&nc>=0&&nc<m[nr].length){
                        r = nr;
                        c = nc;
                    }
                    m[r][c] = '*';
                }
            }
            for(char[] cc : m){
                out.println(cc);
            }
            out.println();
        }
        f.close();
    }
    public int[] move(char c){
        if(c == 'R'){
            return new int[]{0,1};
        }
        if(c=='L'){
            return new int[]{0,-1};
        }
        if(c == 'U'){
            return new int[]{-1,0};
        }
        return new int[]{1,0};
    }
}
