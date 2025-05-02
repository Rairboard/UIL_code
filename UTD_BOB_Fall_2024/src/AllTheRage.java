/*
ID: rairboard
LANG: JAVA
TASK: AllTheRage
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

public class AllTheRage {
    public static void main(String[] args) throws Exception {
        new AllTheRage().run();
    }

    public void run() throws Exception {
        IO f = new IO();
//        IO f = new IO("AllTheRage");
        int n = f.nextInt(), M = f.nextInt();
        int[] shadow = new int[n];
        Arrays.fill(shadow,-1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int yes = f.nextInt();
            if(yes==1){
                q.offer(i);
                q.offer(1);
                shadow[i] = 1;
            }
        }
        Map<Integer,List<Integer>> m = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int a = f.nextInt()-1, b = f.nextInt()-1;
            m.putIfAbsent(a,new ArrayList<>());
            m.putIfAbsent(b, new ArrayList<>());
            m.get(a).add(b);
            m.get(b).add(a);
        }
        while(!q.isEmpty()){
            int u = q.remove();
            int day = q.remove();
            if(m.get(u)==null) continue;
            for(int v : m.get(u)){
                if(shadow[v]==-1){
                    shadow[v] = day + 1;
                    q.offer(v);
                    q.offer(day+1);
                }
            }
        }
        for(int i : shadow){
            f.println(i);
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