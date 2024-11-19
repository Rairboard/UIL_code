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

public class ewa {
    public static void main(String[] args) throws Exception {
        new ewa().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ewa").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int event = f.nextInt();
            double total = 0;
            for (int i = 0; i < event; i++) {
                String action = f.next();
                if (action.equals("BRING")) {
                    total+= PI * Math.pow(f.nextDouble(),2) * f.nextDouble();
                }
                else{
                    total -= f.nextDouble();
                }
                out.printf("%.2f\n",total);
            }
            out.println("-".repeat(10));
        }
        f.close();
    }
}
