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

public class distance {
    public static void main(String[] args) throws Exception {
        new distance().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("distance").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long r = f.nextLong(), n = f.nextLong();
            double total = 0;
            Random rand = new Random(r);
            for (int i = 0; i < n; i++) {
                int x1 = rand.nextInt(1000);
                int y1 = rand.nextInt(1000);
                int x2 = rand.nextInt(1000);
                int y2 = rand.nextInt(1000);
                double distance = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
                total += distance ;
            }
            total/=n;
            total = total - total % .001;
            out.printf("%.3f\n",total);
        }
        f.close();
    }
}
