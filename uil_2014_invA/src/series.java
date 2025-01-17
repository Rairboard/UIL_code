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

public class series {
    public static void main(String[] args) throws Exception {
        new series().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("series").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int a = f.nextInt(), b = f.nextInt(), c = f.nextInt(), n = f.nextInt();
            long[] ar = new long[n+1];
            ar[1] = a;
            for(int i = 2;i <=n;i++){
                ar[i] = b * (long)Math.pow(c,i) * ar[i-1];
            }
            out.println(ar[n]);
        }
        f.close();
    }
}
