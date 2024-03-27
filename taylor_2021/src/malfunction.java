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

public class malfunction {
    public static void main(String[] args) throws Exception {
        new malfunction().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("malfunction.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            double a = f.nextDouble(), b = f.nextDouble() , c = f.nextDouble(), x =f.nextDouble();
            double res = a * Math.pow(x,2) + b * x + c;
            out.printf("%.3f\n",res);
        }
        f.close();
    }
}
