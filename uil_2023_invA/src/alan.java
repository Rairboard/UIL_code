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

public class alan {
    public static void main(String[] args) throws Exception {
        new alan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("alan").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double F = f.nextDouble();
            double K = 5 * (F - 32)/9.0 + 273.15;
            out.printf("%d degrees Fahrenheit is equal to %.2f Kelvin\n", (int)F, K);
        }
        f.close();
    }
}
