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

public class slinky {
    public static void main(String[] args) throws Exception {
        new slinky().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("slinky").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			out.printf("%.2f\n",(f.nextDouble() * Math.pow(f.nextDouble(),2))/2);
        }
        f.close();
    }
}
