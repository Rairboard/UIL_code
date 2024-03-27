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

public class runner {
    public static void main(String[] args) throws Exception {
        new runner().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("runner.dat"));
        //Scanner f = new Scanner(System.in);
        double ft =0;
        double min = 0;
        while(f.hasNext()){
            ft+=f.nextDouble();
            min+=f.nextInt();
        }
        ft/=5280;
        min/=60;
        double mph = ft/min;
        out.printf("Your speed was %.3f %s per hour.\n",mph,mph<=1?"mile":"miles");
        out.flush();
        out.close();
        f.close();
    }
}