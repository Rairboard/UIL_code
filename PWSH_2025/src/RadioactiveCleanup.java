import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class RadioactiveCleanup {
    public static void main(String[] args) throws Exception {
        new RadioactiveCleanup().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("RadioactiveCleanup").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);

            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            int sr = -1, sc =-1;
            char[][] m  =new char[row][col];
            for (int i = 0; i < row; i++) {
                m[i] = f.nextLine().replaceAll("\\s+","").toCharArray();
                for (int j = 0; j < col; j++) {
                    if(m[i][j]=='@'){
                        sr = i;
                        sc = j;
                    }
                }
            }
            if(sr==-1&&sc==-1) {
                out.println(0);
                return;
            }
            int cnt = 0;
            int[] vr = {-1,1,0,0};
            int[] vc = {0,0,-1,1};
            Queue<Integer> q = new LinkedList<>();
            q.offer(sr);
            q.offer(sc);
            while(!q.isEmpty()){
                int r = q.remove() , c = q.remove();
                if(r<0||c<0||r>=row||c>=col) continue;
                if(m[r][c]=='*'||m[r][c]=='#') continue;
                cnt++;
                m[r][c] = '#';
                for (int i = 0; i < 4; i++) {
                    int nr = r + vr[i];
                    int nc = c + vc[i];

                        q.offer(nr);
                        q.offer(nc);

                }
            }
            out.println(cnt);

        f.close();
    }
}
