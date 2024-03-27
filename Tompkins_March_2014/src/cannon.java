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

public class cannon {
    public static void main(String[] args) throws Exception {
        new cannon().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cannon").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            String[] one = f.nextLine().split("\\s+"), two = f.nextLine().split("\\s+");
            double vel = Double.parseDouble(one[1]);
            double angle = Double.parseDouble(two[1]);
            double th = vel * Math.sin(Math.toRadians(angle)) / 9.8;
            double time = 2 * th;
            double h = vel * Math.sin(Math.toRadians(angle)) * th - .5 * 9.8 * Math.pow(th,2);
            double xdis = vel * Math.cos(Math.toRadians(angle)) * time;
            out.printf("Distance: %.2f\n",xdis);
            out.printf("Time: %.2f\n",time);
            out.printf("Height: %.2f\n",h);
            out.println();
        }
        f.close();
    }
}
