/*
ID: rairboard
LANG: JAVA
TASK: maxSubSum
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

public class maxSubSum {
    public static void main(String[] args) throws Exception {

        out.println(Integer.MAX_VALUE);
//        new maxSubSum().run();
    }
    public void run() throws Exception{
        IO f = new IO();
//        IO f = new IO("maxSubSum");
        int n =f.nextInt();
        long[] ar = new long[n];
        for(int i =0 ;i < n;i++){
            ar[i] = f.nextLong();
        }
        long maxSubSum = Long.MIN_VALUE;
        long pref = 0;
        for(long i : ar){
            pref+=i;
            maxSubSum = Math.max(maxSubSum, pref);
            if(pref < 0){
                pref = 0;
            }
        }
        f.println(maxSubSum);
        f.flush();
        f.close();
    }
    public class IO extends PrintWriter {
        private BufferedReader r;
        private String line, token;
        private StringTokenizer st;


        public IO () {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(System.in));
        }


        public IO (String name) throws IOException {
            super(name+".out");
            r = new BufferedReader(new FileReader(name+".in"));
        }


        public boolean hasNext() { return peekToken() != null; }
        public int nextInt() { return Integer.parseInt(nextToken()); }
        public double nextDouble() { return Double.parseDouble(nextToken()); }
        public long nextLong() { return Long.parseLong(nextToken()); }
        public String next() { return nextToken(); }
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return str;
        }
        public void println (Object... args) {
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
                }
                catch (IOException e) {}
            return token;
        }
    }
}