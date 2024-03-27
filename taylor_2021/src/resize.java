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

public class resize {
    public static void main(String[] args) throws Exception {
        new resize().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("resize.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			double[] l = Arrays.stream(f.nextLine().replaceAll("[byto\\s]+"," ").split(" ")).mapToDouble(Double::parseDouble).toArray();
			double a = l[0]/l[2];
			double b = l[1]/l[3];
			out.printf("%.2f by %.2f or %.2f by %.2f\n",l[0]/a,l[1]/a,l[0]/b,l[1]/b);

        }
        f.close();
    }
}
