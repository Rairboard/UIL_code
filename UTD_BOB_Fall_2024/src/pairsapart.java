/*
ID: rairboard
LANG: JAVA
TASK: pairsapart
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

public class pairsapart {
    public static void main(String[] args) throws Exception {
        new pairsapart().run();
    }

    public void run() throws Exception {
        IO f = new IO();
//        IO f = new IO("pairsapart");
        int n = f.nextInt(), k = f.nextInt();
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(f.nextInt());
        }
        Collections.sort(al);
        int i = 0, j = al.size()-1;
        for (int p = 0; p < k; p++) {
            if(i > j){break;}
            f.print(al.get(i++) + al.get(j--)+" ");
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