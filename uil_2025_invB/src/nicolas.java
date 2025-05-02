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

public class nicolas {
    char[][] m;
    int[] vr = {-1,1,0,0};
    int[] vc = {0,0,-1,1};
    String dir = "NSWE";
    boolean[][] visited;

    public static void main(String[] args) throws Exception {
        new nicolas().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("nicolas").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int row = f.nextInt(), col = f.nextInt();
            f.nextLine();
            m = new char[row][col];
            visited = new boolean[row][col];
            String path = "";
            int sr = -1, sc = -1;
            for (int i = 0; i < row; i++) {
                String ln = f.nextLine().trim();
                m[i] = ln.toCharArray();
                if (ln.contains("S")) {
                    sr = i;
                    sc = ln.indexOf("S");
                }
            }
            PriorityQueue<State> pq = new PriorityQueue<>();
            pq.offer(new State(sr,sc,""));
            out: while(!pq.isEmpty()){
                State cur = pq.remove();
                int r = cur.r;
                int c =cur.c;
                String p = cur.path;
                visited[r][c] = true;
                if(m[r][c]=='E'){
                    path = p;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nr = r;
                    int nc = c;
                    while(in(nr + vr[i], nc + vc[i]) && m[nr+vr[i]][nc+vc[i]]!='#'){
                        nr+=vr[i];
                        nc+=vc[i];
                        if(m[nr][nc]=='E'){
                            path = p + dir.charAt(i);
                            break out;
                        }
                    }
                    if(!visited[nr][nc]) pq.offer(new State(nr, nc, p + dir.charAt(i)));
                }
            }
            out.println(path);
        }
        f.close();
    }
    class State implements Comparable<State>{
        int r, c;
        String path;
        public State(int r,int c,String path){
            this. r = r;
            this.c = c;
            this.path = path;
        }
        public int compareTo(State o){
            if(path.length()==o.path.length()){
                return path.compareTo(o.path);
            }
            return path.length()-o.path.length();
        }
    }
    public boolean in(int r,int c){
        return r>=0&&c>=0&&r<m.length&&c<m[r].length;
    }
}
