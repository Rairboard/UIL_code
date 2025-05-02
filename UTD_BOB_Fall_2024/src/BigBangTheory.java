/*
ID: rairboard
LANG: JAVA
TASK: BigBangTheory
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

public class BigBangTheory {
    public static void main(String[] args) throws Exception {
        new BigBangTheory().run();
    }

    public void run() throws Exception {
        IO f = new IO();
//        IO f = new IO("BigBangTheory");
        int N = f.nextInt();
        List<long[]> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            al.add(new long[]{f.nextLong(),f.nextLong()});
        }
        int M = f.nextInt();
        for (int i = 0; i < M; i++) {
            int x = f.nextInt();
            long cnt = 0;
            for(long[] pair : al){
                if(gcf(pair[0],pair[1]) % x == 0){
                    cnt++;
                }
            }
            f.println(cnt);
        }
        f.flush();
        f.close();
    }
    public long gcf(long a,long b){
        if(a==0){
            return b;
        }
        return gcf(b % a, a);
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