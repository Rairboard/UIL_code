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

public class E {
    public static void main(String[] args) throws Exception {
        new E().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("E").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            double sum = 0;
            for (int i = 0; i < 3; i++) {
                sum+=f.nextDouble();
            }
            sum/=3;
            double tgt = f.nextDouble();
            double ans = (Math.abs((sum-tgt)/tgt))* 100;
            out.printf("%.2f%s\n",ans,"%");
        }
        f.close();
    }
}
