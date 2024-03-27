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

public class sale {
    public static void main(String[] args) throws Exception {
        new sale().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("sale.dat"));
        //Scanner f = new Scanner(System.in);
        double[]ar = new double[3];
        for (int i = 0; i < 3; i++) {
            ar[i] = f.nextDouble();
        }
        Arrays.sort(ar);
        ar[0]/=2;
        out.printf("%.2f\n",Arrays.stream(ar).sum() + (Arrays.stream(ar).sum() * .0825));
        f.close();
    }
}
