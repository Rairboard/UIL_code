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

public class herons {
    public static void main(String[] args) throws Exception {
        new herons().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("herons.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            double[] ar = Arrays.stream(f.nextLine().split(",")).mapToDouble(Double::parseDouble).toArray();
            double s = Arrays.stream(ar).sum()/2;
            double a = Math.sqrt(s * (s-ar[0]) * (s-ar[1]) * (s-ar[2]));
            out.printf("%.3f\n",a);
        }
        f.close();
    }
}
