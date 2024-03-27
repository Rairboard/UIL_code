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

public class wrapping {
    String[] box = "No Box,Cardboard Box,Fancy Carboard Box,Autographed Box".split(",");
    String[] card = "No Wrapping Paper,Grocery Wrapping Paper,Budge Wrapping Paper,Fancy Wrapping Paper,North Pole Wrapping Paper".split(",");
    double[] boxPrice = {0,1.08,2.15,15.0};
    double[] paperPrice = {0,.33,.87,1.73,3.46};

    public static void main(String[] args) throws Exception {
        new wrapping().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("wrapping").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] ln = f.nextLine().split("\\s+");
            String name = "";
            double cost = Double.parseDouble(ln[ln.length-5]);
            double bud = Double.parseDouble(ln[ln.length-4]);
            double l = Double.parseDouble(ln[ln.length-3]);
            double w = Double.parseDouble(ln[ln.length-2]);
            double h = Double.parseDouble(ln[ln.length-1]);
            for (int i = 0; i < ln.length-5; i++) {
                name+=ln[i]+" ";
            }
            double bp = (l * w * h)/12;
            double wp = (l * w)/12;

        }
        f.close();
    }
}
