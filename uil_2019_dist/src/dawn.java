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

public class dawn {
    public static void main(String[] args) throws Exception {
        new dawn().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dawn").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            double a = f.nextDouble(), apr = f.nextDouble(), n = f.nextDouble(), r = apr/12;
            double payment = (a * r) / (1 - Math.pow(1+r,-n));
            out.println(a + " " + payment);
        }
        f.close();
    }
}
