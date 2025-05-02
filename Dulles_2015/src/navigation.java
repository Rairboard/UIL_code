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

public class navigation {
    public static void main(String[] args) throws Exception {
        out.println("\r");
//        new navigation().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("navigation.in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        int[] vl = {-1,1,0,0,0,0};
        int[] vr = {0,0,-1,1,0,0};
        int[] vc = {0,0,0,0,-1,1};
        for (int asdf = 0; asdf < times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            char[][][] m = new char[n][n][n];
            int[][][][] shadow = new int[1 << 6][n][n][n];
            int[][][] base = new int[n][n][n];
            int obj = 0,sl = -1, sr = -1, sc = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 1 << 6; k++) {
                        Arrays.fill(shadow[k][i][j], Integer.MAX_VALUE);
                    }
                    m[i][j] = f.nextLine().trim().toCharArray();
                    Arrays.fill(base[i][j], Integer.MAX_VALUE);
                    for (int k = 0; k < n; k++) {
                        if(m[i][j][k]=='B'){
                            sl = i;
                            sr = j;
                            sc = k;
                        }
                        else if(m[i][j][k] == '*'){
                            m[i][j][k] = (char) (obj+'0');
                            obj++;
                        }
                    }
                }
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(sl);
            q.offer(sr);
            q.offer(sc);
            q.offer(0);
            while(!q.isEmpty()){
                int l = q.remove(), r = q.remove(), c = q.remove(), step = q.remove();
                if(!in(l,r,c,n)||m[l][r][c]=='x'||step>=base[l][r][c]) continue;
                base[l][r][c] = step;
                int increase = 0;
                if(m[l][r][c]!='B'){
                    increase = 2;
                    for (int i = 2; i < 6; i++) {
                        int nl = l + vl[i];
                        int nr = r + vr[i];
                        int nc = c + vc[i];
                        if(in(nl,nr,nc,n) && m[nl][nr][nc] == 'x'){
                            increase = 3;
                            break;
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    q.offer(l + vl[i]);
                    q.offer(r + vr[i]);
                    q.offer(c + vc[i]);
                    q.offer(step + increase);
                }
            }
            q = new LinkedList<>();
            q.offer(0);
            q.offer(sl);
            q.offer(sr);
            q.offer(sc);
            q.offer(0);
            while(!q.isEmpty()){
                int o = q.remove(), l = q.remove(), r = q.remove(), c = q.remove(), step = q.remove();
                if(!in(l,r,c,n) || m[l][r][c]=='x'||step>=shadow[o][l][r][c]) continue;
                shadow[o][l][r][c] = step;
                if(Character.isDigit(m[l][r][c])) {
                    o |= 1 << m[l][r][c] - '0';
                }
                if(o== (1 << 6)-1){
                    minDist = Math.min(minDist, step + base[l][r][c]);
                }
                int increase = 0;
                if(m[l][r][c]!='B'){
                    increase = 2;
                    for (int i = 2; i < 6; i++) {
                        int nl = l + vl[i];
                        int nr = r + vr[i];
                        int nc = c + vc[i];
                        if(in(nl,nr,nc,n) && m[nl][nr][nc] == 'x'){
                            increase = 3;
                            break;
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    q.offer(o);
                    q.offer(l + vl[i]);
                    q.offer(r + vr[i]);
                    q.offer(c + vc[i]);
                    q.offer(step + increase);
                }
            }
            out.println(minDist);
        }
        f.close();
    }
    public boolean in(int l, int r, int c, int n){
        return l>=0&&r>=0&&c>=0&&l<n&&r<n&&c<n;
    }

}
