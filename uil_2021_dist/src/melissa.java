/*
ID: rairboard
LANG: JAVA
TASK: template
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

public class melissa {
    public static void main(String[] args) throws IOException {
        //IO f = new IO();
        IO f = new IO("melissa");
        //IO f = new IO("melissa","melissa");
        int n = f.nextInt();
        for (int i = 0; i < n; i++) {
            long N = f.nextLong();
            boolean print = false;
            out.print(N+ " -> ");
            while(N>=10){
                long prod = 1;
                long tmp = N;
                while(tmp>0){
                    if(tmp%10 != 0){
                        prod*=tmp%10;
                    }
                    tmp/=10;
                }
                N=prod;

            }
            out.println(N);
        }
    }

    public static class IO extends PrintWriter {
        private BufferedReader r;
        private String line, token;
        private StringTokenizer st;


        public IO() {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(System.in));
        }


        public IO(String name) throws IOException {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new FileReader(name + ".dat"));
        }
        public IO(String in,String out) throws  IOException{
            super(out + ".out");
            r = new BufferedReader(new FileReader(in + ".dat"));
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