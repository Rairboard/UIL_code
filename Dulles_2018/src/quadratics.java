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

public class quadratics {
    public static void main(String[] args) throws Exception {
        new quadratics().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("quadratics.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            double a = f.nextDouble(), b = f.nextDouble(),c = f.nextDouble();
            double one = (b*-1 + Math.sqrt(b*b - 4*a*c))/(2*a);
            double two = (b*-1 - Math.sqrt(b*b - 4*a*c))/(2*a);
            out.printf("%.3f, %.3f\n",one,two);
        }
        f.close();
    }
}
