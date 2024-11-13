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

public class cynthia {
    public static void main(String[] args) throws Exception {
        new cynthia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cynthia").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double x = f.nextDouble(), y = f.nextDouble(), w = f.nextDouble();
            double max = 0;
            max = Math.max((x+y)/2.0*w,max);
            max = Math.max((x+w)/2.0*y,max);
            max = Math.max((y+w)/2.0*x,max);
            out.printf("%,.2f\n", max);
        }
        f.close();
    }
}
