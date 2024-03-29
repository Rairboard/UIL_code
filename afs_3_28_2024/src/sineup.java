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

public class sineup {
    public static void main(String[] args) throws Exception {
        new sineup().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sineup").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while (f.hasNext()) {
            long D = f.nextLong(), A = f.nextLong(), B = f.nextLong(), C = 180-A-B;
            long a = Math.round(D * Math.sin(Math.toRadians(A)));
            long b = Math.round(D * Math.sin(Math.toRadians(B)));
            long c = Math.round(D * Math.sin(Math.toRadians(C)));
            out.println("Circumcircle diameter = " + D);
            out.println("Angles are " + A+", " + B + " and " + C);
            out.println("Corresponding sides are " + a + ", " + b + " and " + c);
        }
        f.close();
    }
}
