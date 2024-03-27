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

public class race {
    public static void main(String[] args) throws Exception {
        new race().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("race").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int c = f.nextInt(), r = f.nextInt(),sr = -1, sc = -1;
            f.nextLine();
            char[][] m = new char[r][c];
            for (int i = 0; i < r; i++) {
                String ln= f.nextLine();
                m[i] = ln.toCharArray();
                if (ln.contains("@")) {
                    sr = i;
                    sc = ln.indexOf("@");
                }
            }
            boolean found = false;
            Queue<Integer> q = new LinkedList<>();
            q.offer(sr);
            q.offer(sc);
            while(!q.isEmpty()){
                int nr = q.remove(), nc = q.remove();
                if(nr==-1||nc==-1||nr==r||nc==c || m[nr][nc] =='*') continue;
                if(nr == 0 || nc == 0 || nr == r-1 || nc == c-1){
                    if(m[nr][nc]=='#' ){
                        found = true;
                        break;
                    }
                }
                int[] vr = {-1,1,0,0};
                int[] vc = {0,0,-1,1};
                for (int i = 0; i < 4; i++) {
                    q.offer(nr + vr[i]);
                    q.offer(nc + vc[i]);
                }
                m[nr][nc] = '*';
            }
            out.println(found?"OUTSTANDING. I can escape from my predicament":"OH NO. I am very stuck and must call for help");
        }
        f.close();
    }
}
