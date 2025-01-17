/*
ID: rairboard
LANG: JAVA
TASK: A
*/

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

public class A {
    char[][] m;
    int[][] shadow;
    public static void main(String[] args) throws Exception {
        new A().run();
    }

    public void run() throws Exception {
        IO f = new IO();
//        IO f = new IO("A");
        int row = f.nextInt(), col = f.nextInt();
        int sr = -1, sc = -1, er = -1, ec = -1;
        m = new char[row][col];
        shadow = new int[row][col];
        for (int i = 0; i < row; i++) {
            String ln = f.nextLine();
            m[i] =ln.toCharArray();
            Arrays.fill(shadow[i], Integer.MAX_VALUE);
            if (ln.contains("A")) {
                sr = i;
                sc = ln.indexOf("A");
            }
            if (ln.contains("B")) {
                er = i;
                ec = ln.indexOf("B");
            }
        }
        if(er == -1 && ec == -1) f.println("NO");
        else{
            Queue<Object> q = new LinkedList<>();
            q.offer(sr);
            q.offer(sc);
            q.offer(0);
            q.offer("");
            int[] vr = {-1,1,0,0};
            int[] vc = {0,0,-1,1,};
            String dir = "UDLR";
            boolean visited = false;
            while(!q.isEmpty()){
                int r = (int)q.remove();
                int c = (int)q.remove();
                int step = (int)q.remove();
                String path = (String)q.remove();
                if(m[r][c]=='B'){
                    visited = true;
                    f.println("YES\n" + step);
                    f.println(path);
                    break;
                }
                m[r][c] = '#';
                for (int i = 0; i < 4; i++) {
                    int nr = r + vr[i];
                    int nc = c + vc[i];
                    String np = path + dir.charAt(i);
                    if(nr>=0&&nc>=0&&nr<row&&nc<col&&m[nr][nc]!='#'){
                        q.offer(nr);
                        q.offer(nc);
                        q.offer(step+1);
                        q.offer(np);
                    }
                }
            }
            if(!visited)f.println("NO");
        }
        f.flush();
        f.close();
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
            r = new BufferedReader(new FileReader(name + ""));
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