import java.awt.*;
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

public class YouSnoozeYouLose {
    public static void main(String[] args) throws Exception {
        new YouSnoozeYouLose().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("YouSnoozeYouLose").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            char[][] m = new char[10][10];
            int[][] shadow = new int[10][10];
            int sr = -1 , sc = -1, er = -1, ec = -1;
            for (int i = 0; i < 10; i++) {
                String ln = f.nextLine();
                m[i] = ln.toCharArray();
                Arrays.fill(shadow[i],Integer.MAX_VALUE);
                if (ln.contains("S")) {
                   sr = i;
                   sc = ln.indexOf("S");
                }
                if (ln.contains("K")) {
                    er = i;
                    ec = ln.indexOf("K");
                }
            }
            int[] vr = {-1,1,0,0};
            int[] vc = {0,0,-1,1};
            Queue<Integer> q = new LinkedList<>();
            q.offer(sr);
            q.offer(sc);
            q.offer(0);
            while(!q.isEmpty()){
                int r = q.poll(), c = q.poll(), step = q.poll();
                if(r == -1 || c == -1 || r == 10 || c == 10 || step >= shadow[r][c] || m[r][c]=='#') continue;
                shadow[r][c] = step;
                if(m[r][c]=='K') continue;
                for (int i = 0; i < 4; i++) {
                    q.offer(r + vr[i]);
                    q.offer(c + vc[i]);
                    q.offer(step+1);
                }
            }
            if(shadow[er][ec] > 15){
                out.printf("Late: %d minutes\n",shadow[er][ec] - 15);
            }
            else{
                out.printf("On time: %d minutes\n",shadow[er][ec]);
            }
        }
        f.close();
    }
}
