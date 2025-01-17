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

public class pingpong {
    public static void main(String[] args) throws Exception {
        new pingpong().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pingpong").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double a = f.nextDouble(), b = f.nextDouble();
            int n = f.nextInt();
            double[] p1 = new double[n+1];
            double[] p2 = new double[n+1];
            p1[1]= a;
            p2[1] =b;
//            for(int i = 2;i<=n;i++){
//                p1[i]*=
//            }
            out.printf("%.4f\n", p1[n]);
            out.println(Arrays.toString(p1));
        }
        f.close();
    }
}
