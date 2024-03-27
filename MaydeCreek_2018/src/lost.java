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

public class lost {
    char[][] m;
    int[][] shadow;
    public static void main(String[] args) throws Exception {
        new lost().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lost").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int r = f.nextInt(), c = f.nextInt(), sr = -1, sc = -1,er = -1, ec = -1;
            f.nextLine();
            m = new char[r][c];
            shadow = new int[r][c];
            for (int i = 0; i < r; i++) {
                String ln = f.nextLine();
                m[i] = ln.toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                if (ln.contains("S")) {
                    sr = i;
                    sc = ln.indexOf("S");
                }
                if(ln.contains("E")){
                    er = i;
                    ec = ln.indexOf("E");
                }
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(sr);
            q.offer(sc);
            q.offer(0);
            while(!q.isEmpty()){
                int nr = q.remove(), nc = q.remove(), step = q.remove();
                if(nr == -1 || nr == r || nc == -1 || nc == c) continue;
                if(step>=shadow[nr][nc] || m[nr][nc]=='#') continue;
                shadow[nr][nc] = step;
                int[] vr = {-1,1,0,0};
                int[] vc = {0,0,-1,1};
                for (int i = 0; i < 4; i++) {
                    q.offer(nr+vr[i]);
                    q.offer(nc+vc[i]);
                    q.offer(step+1);
                }
            }
            out.println(shadow[er][ec] == Integer.MAX_VALUE?"Not Possible": shadow[er][ec]);
        }
        f.close();
    }
}
