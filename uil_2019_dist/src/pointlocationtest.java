/*
ID: rairboard
LANG: JAVA
TASK: pointlocationtest
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

public class pointlocationtest {
    public static void main(String[] args) throws Exception {
        new pointlocationtest().run();
    }

    public void run() throws Exception {
//        IO f = new IO();
        IO f = new IO("pointlocationtest");
        int n = f.nextInt();
        for (int i = 0; i < n; i++) {
            double x1 = f.nextDouble(), y1 = f.nextDouble(), x2 = f.nextDouble(), y2 = f.nextDouble(), x3 = f.nextDouble(), y3 = f.nextDouble();
            double m = (y2 - y1) / (x2 - x1);
            double b = (m * -x1) + y1;
            double ans = m * x3 + b;
            if (m > 0) {
                if(ans == y3){
                    out.println("TOUCH");
                }
                else if(y3 > ans){
                    out.println("LEFT");
                }
                else{
                    out.println("RIGHT");
                }
            }
            else{
                if(ans==y3){
                    out.println("TOUCH");
                }
                else if(y3 < ans){
                    out.println("LEFT");
                }
                else{
                    out.println("RIGHT");
                }
            }
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