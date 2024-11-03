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

public class boa {
    char[][] m;
    public static void main(String[] args) throws Exception {
        new boa().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("boa").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
       loop: for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            int sr = -1, sc = -1;
            m = new char[row][col];
            for (int i = 0; i < row; i++) {
                String ln = f.nextLine();
                if (ln.contains("C")) {
                    sr = i;
                    sc = ln.indexOf("C");
                }
                m[i] = ln.toCharArray();
            }
            int[] vr  = {-1,1,0,0};
            int[] vc = {0,0,-1,1};
            Queue<Integer> q = new LinkedList<>();
            q.offer(sr);
            q.offer(sc);
            q.offer(0);
            while(!q.isEmpty()){
                int r = q.poll(), c = q.poll(), step = q.poll();
                if(r>=0&&c>=0&&r<row&&c<col && m[r][c]!='#'){
                    if(m[r][c]=='E'){
                        out.println(step);
                        continue loop;
                    }
                    m[r][c]='#';
                    for (int i = 0; i < 4; i++) {
                        int nr = r + vr[i];
                        int nc = c + vc[i];
                        q.offer(nr);
                        q.offer(nc);
                        q.offer(step+1);
                    }
                }
            }
           out.println("Squish.");
        }
        f.close();

    }
}
