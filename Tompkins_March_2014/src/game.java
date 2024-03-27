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

public class game {
    char[][] m;
    int[][] shadow;
    public static void main(String[] args) throws Exception {
        new game().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("game").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] cor = f.nextLine().split("x");
            int r = Integer.parseInt(cor[0]), c = Integer.parseInt(cor[1]);
            m = new char[r][c];
            shadow = new int[r][c];
            for (int i = 0; i < r; i++) {
                m[i] = f.nextLine().toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            q.offer(0);
            q.offer(0);
            while(!q.isEmpty()){
                int nr = q.remove(), nc = q.remove(), step =q.remove();
                if(nr==-1 || nr == r || nc == -1 || nc == c) continue;
                if(step>= shadow[nr][nc]) continue;
                shadow[nr][nc] = step;
                int[] vr = {-1,1,0,0};
                int[] vc = {0,0,-1,1};
                for (int i = 0; i < 4; i++) {
                    q.offer(nr+vr[i]);
                    q.offer(nc+vc[i]);
                    q.offer(step+1);
                }
            }
            out.println(shadow[r-1][c-1]);
        }
        f.close();
    }
}
