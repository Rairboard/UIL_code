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

public class taxing {
    public static void main(String[] args) throws Exception {
        new taxing().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("taxing.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			double d = f.nextDouble();
			out.printf("$%.2f\n", d + (d*.0825));
        }
        f.close();
    }
}
