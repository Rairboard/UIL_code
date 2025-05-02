/*
ID: rairboard
LANG: JAVA
TASK: bishopattack
*/

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

public class bishopattack {
    public static void main(String[] args) throws Exception {
        new bishopattack().run();
    }

    public void run() throws Exception {
        IO f = new IO();
//        IO f = new IO("bishopattack");
        int sc = f.next().charAt(0) -'a', sr = 8 - f.nextInt();
        int ec = f.next().charAt(0) - 'a', er = 8 - f.nextInt();
        int pc = f.next().charAt(0) - 'a', pr = 8 - f.nextInt();
        int[][] shadow = new int[8][8];
        for(int[] each : shadow) Arrays.fill(each, Integer.MAX_VALUE);
        int[] vr = {-1,-1,1,1};
        int[] vc = {1,-1,-1,1};
        Queue<Integer> q = new LinkedList<>();
        q.offer(sr);
        q.offer(sc);
        q.offer(0);
        while(!q.isEmpty()){
            int r = q.remove(), c = q.remove(), step = q.remove();
            if(step>=shadow[r][c]) continue;
            shadow[r][c] = step;
            for(int i = 0;i < 4;i++){
                int nr = r + vr[i];
                int nc = c + vc[i];
                while(in(nr,nc,8,8) && !(nr == pr  && nc == pc)){
                    q.offer(nr);
                    q.offer(nc);
                    q.offer(step+1);
                    nr+= vr[i];
                    nc+= vc[i];
                }
            }
        }
        if(shadow[er][ec]==Integer.MAX_VALUE) out.println(0);
        else out.println(shadow[er][ec]);
        f.flush();
        f.close();
    }
    public boolean in (int r, int c, int row, int col){
        return r>=0&&c>=0&&r<row&&c<col;
    }
    public class IO extends PrintWriter {
        private BufferedReader r;
        private String line, token;
        private StringTokenizer st;


        public IO() {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(System.in));
        }


        public IO(String name) throws IOException {
            super(name + ".out");
            r = new BufferedReader(new FileReader(name + ".in"));
        }


        public boolean hasNext() {
            return peekToken() != null;
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public String next() {
            return nextToken();
        }

        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return str;
        }

        public void println(Object... args) {
            for (Object a : args) {
                print(a);
            }
            print('\n');
        }


        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }


        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null)
                            return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                }
            return token;
        }
    }
}