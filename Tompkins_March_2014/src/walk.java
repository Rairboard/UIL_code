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

public class walk {
    public static void main(String[] args) throws Exception {
        new walk().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("walk").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            double a = f.nextDouble(), b = f.nextDouble();
            double d = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
            out.printf("%.3f\n",d+a+b);
        }
        f.close();
    }
}
