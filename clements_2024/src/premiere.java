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

public class premiere {
    public static void main(String[] args) throws Exception {
        new premiere().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("premiere").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int c = f.nextInt();
            f.nextLine();
            int[] ar = new int[360];
            for (int i = 0; i < c; i++) {
                String[] t = f.next().split(":");
                int m = f.nextInt();
                int start = (Integer.parseInt(t[0]) - 6)* 60 + Integer.parseInt(t[1]);
                int end = start + m;
                for(int j = start;j< end && j < ar.length;j++){
                    ar[j]++;
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < ar.length; i++) {
                max = Math.max(ar[i], max);
            }
            out.println(max);
        }
        f.close();
    }
}
