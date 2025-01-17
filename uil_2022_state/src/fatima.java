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

public class fatima {
    public static void main(String[] args) throws Exception {
        new fatima().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("fatima").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double tStep = f.nextDouble(), hStep = f.nextDouble();

            double[] air = new double[(int)((125-80)/tStep) + 1];
            double[] humidity = new double[(int)((100-20)/hStep) + 1];
            air[0] = 80;
            humidity[0] = 20;
            for (int i = 1; i < air.length; i++) {
                air[i] = air[i-1] + tStep;
            }
            for (int i = 1; i < humidity.length; i++) {
                humidity[i] = humidity[i-1] + hStep;
            }
            double[][] m = new double[humidity.length][air.length];
            for (int i = 0; i < humidity.length; i++) {
                Arrays.fill(m[i],-1);
                for (int j = 0; j < air.length; j++) {
                    double HI = -42.379 + 2.04901523 * air[j] + 10.14333127 * humidity[i] - 0.22475541 * air[j] * humidity[i] - 6.83783 * Math.pow(10,-3) * Math.pow(air[j],2) - 5.481717 * Math.pow(10,-2) * Math.pow(humidity[i],2) + 1.22874 * Math.pow(10,-3) * Math.pow(air[j],2) * humidity[i] + 8.5282 * Math.pow(10,-4) * air[j] * Math.pow(humidity[i],2) - 1.99 * Math.pow(10,-6) * Math.pow(air[j], 2) * Math.pow(humidity[i],2);
                    if(humidity[i] > 85){
                        HI += ((humidity[i] - 85.0) /  10.0) * ((87.0-air[j])/5.0);
                    }
                    m[i][j] = HI;
                }
            }
            out.print("Temp ");
            for (int i = 0; i < air.length; i++) {
                out.printf("%6.1f", air[i]);
            }
            out.println();
            out.println("Humid " + "=".repeat(95));
            for (int i = 0; i < m.length; i++) {
                out.printf("%5.1f", humidity[i]);
                for (int j = 0; j < m[i].length; j++) {
                    if(m[i][j]<=140){
                        out.printf("%6.1f", m[i][j]);
                    }
                    else{
                        break;
                    }
                }
                out.println();
            }
            out.println("=".repeat(30));
        }
        f.close();
    }
}
