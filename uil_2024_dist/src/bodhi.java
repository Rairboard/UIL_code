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

public class bodhi {
    public static void main(String[] args) throws Exception {
        new bodhi().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bodhi").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double m = f.nextDouble(), apr = f.nextDouble(), cp = f.nextDouble(), n = f.nextDouble();
            f.nextLine();
            double FV = m * Math.pow((1 + (apr/cp)/100),n);
            out.printf("$%.2f $%.2f\n", FV, FV-m);
        }
        f.close();
    }
}
