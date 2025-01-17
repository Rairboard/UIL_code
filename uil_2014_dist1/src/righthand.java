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

public class    righthand {
    public static void main(String[] args) throws Exception {
        new righthand().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("righthand").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        out: for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            char[][] m =new char[n][n];
            for (int i = 0; i < n; i++) {
                m[i] = f.nextLine().trim().toCharArray();
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            q.offer(0);
            int[] vr  = {-1,1,0,0};
            int[] vc = {0,0,-1,1,};
            while(!q.isEmpty()){
                int r = q.remove(), c = q.remove();
                if(m[r][c]=='#') continue;
                if(r==n-1&&c==n-1){
                    out.println("YES");
                    continue out;
                }
                m[r][c] = '#';
                for (int i = 0; i < 4; i++) {
                    int nr = r + vr[i];
                    int nc = c + vc[i];
                    if(nr>=0&&nc>=0&&nr<n&&nc<n){
                        q.offer(nr);
                        q.offer(nc);
                    }
                }
            }
            out.println("NO");
        }
        f.close();
    }
}
