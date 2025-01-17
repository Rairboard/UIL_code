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

public class oddnumbers {
    public static void main(String[] args) throws Exception {
        String Float  = "s";
//        new oddnumbers().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("oddnumbers").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            // S_n = S_1 * (n-1) * d -> S_n = n & S_1 = 1 for add sequence
            // sum of first odd n terms = n^2
            // n term = level^2
            int n = f.nextInt();
            int level = (n-1)/2 + 1;
            int ncl = level*level;
            int scl = ncl * ncl;
            int sll = (ncl-3) * (ncl-3);
            out.println(scl - sll);
        }
        f.close();
    }
}
