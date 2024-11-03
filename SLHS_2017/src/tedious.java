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

public class tedious {
    public static void main(String[] args) throws Exception {
        new tedious().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("tedious").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double a = f.nextDouble(), b = f.nextDouble(), c = f.nextDouble(), d = f.nextDouble() , x = f.nextDouble();
            out.printf("%.3f\n", (2 * x * Math.pow(a + b, 3) * (b - 3 * c * d  + a * b -23))/ (Math.pow(c,3) * Math.pow(d, 4) * Math.pow(x,2)));
        }
        f.close();
    }
}
