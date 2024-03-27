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

public class paint {
    char[][]m;
    boolean[][]v;
    public static void main(String[] args) throws Exception {
        new paint().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("paint").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            List<int[]> door = new ArrayList<>();
            int n = f.nextInt(), sr = -1, sc = -1,cnt = 0, w =0 ;
            f.nextLine();
            m = new char[n][];
            v = new boolean[n][];
            for (int i = 0; i < n; i++) {
                String ln = f.nextLine();
                m[i] = ln.toCharArray();
                v[i] =new boolean[ln.length()];
                Arrays.fill(v[i],false);
                if (ln.contains("*")) {
                    sr = i;
                    sc = ln.indexOf("*");
                }
            }
            Queue<Integer> q = new LinkedList<>();
            q.offer(sr);
            q.offer(sc);
            while(!q.isEmpty()){
                int r = q.remove(), c = q.remove();
                if(r>=0&&r<m.length && c>=0&&c<m[r].length && m[r][c]!='X' && m[r][c]!='=' && !v[r][c]){
                    v[r][c] = true;
                    if(m[r][c]!='-'){
                        m[r][c] = 'C';
                    }
                    else{
                        door.add(new int[]{r,c});
                    }
                    m[r][c] = 'C';
                    int[] vr = {-1,1,0,0};
                    int[] vc = {0,0,-1,1};
                    for (int i = 0; i < 4; i++) {
                        q.offer(r + vr[i]);
                        q.offer(c+vc[i]);
                    }
                }
            }
            for (int i = 0; i < door.size(); i++) {
                int[] cor = door.get(i);
                int[] vr = {-1,1,0,0};
                int[] vc = {0,0,-1,1};
                for (int k = 0; k < 4; k+=2) {
                    int nr  = cor[0] + vr[k];
                    int nc = cor[1]+ vc[k];
                    if(nr>=0&&nr<m.length && nc>=0&&nc<m[nr].length && m[nr][nc]!='X'){
                        m[nr][nc]='-';
                        nr = cor[0] + vr[k+1];
                        nc = cor[1] + vc[k+1];
                        if(nr>=0&&nr<m.length && nc>=0&&nc<m[nr].length && m[nr][nc]!='X'){
                            m[nr][nc] = '-';
                            m[cor[0]][cor[1]] = '-';
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='X' || m[i][j]=='='){
                        int[] vr = {-1,1,0,0};
                        int[] vc = {0,0,-1,1};
                        for (int k = 0; k < 4; k++) {
                            int nr  = i + vr[k];
                            int nc = j+ vc[k];
                            if(nr>=0&&nr<m.length && nc>=0&&nc<m[nr].length && m[nr][nc]=='C'){
                                m[nr][nc] ='W';
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]=='-'){
                        m[i][j] = 'C';
                    }
                    if(m[i][j]=='C'){
                        cnt++;
                    }
                    if(m[i][j]=='W'){
                        w++;
                    }
                }
            }
            for(char[] cc :m){
                out.println(cc);
            }
            double gallon = cnt*.1 + w * .2;
            out.println((long)Math.ceil(gallon));
            out.println();
        }
        f.close();
    }
}
