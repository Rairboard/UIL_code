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

public class shortwalk {
    public static void main(String[] args) throws Exception {
        new shortwalk().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("shortwalk").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            out.println(f.nextLine());
            int n = f.nextInt();
            f.nextLine();
            Map<Long,Integer> m = new TreeMap<>();
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = f.nextLong();
            }
            f.nextLine();
            for(int i = 0;i < ar.length;i++){
                for(int j = i+1;j<ar.length;j++){
                    long diff = Math.abs(ar[i]-ar[j]);
                    m.put(diff, m.getOrDefault(diff,0)+1);
                }
            }
            long minDiff = new ArrayList<>(m.keySet()).getFirst();
            long count = new ArrayList<>(m.values()).getFirst();
            out.println("min distance: " + minDiff);
            out.println("number of pairs: " + count);
        }
        f.close();
    }
}
