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

public class diana {
    public static void main(String[] args) throws Exception {
        new diana().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("diana").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);

        while(f.hasNext()){
            double x1 = f.nextDouble(), y1 = f.nextDouble(), z1 = f.nextDouble(), x2 = f.nextDouble(), y2 = f.nextDouble(), z2 = f.nextDouble();
            out.printf("%.2f\n", Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2) + Math.pow(z2-z1,2)));
        }
        f.close();
    }
}
