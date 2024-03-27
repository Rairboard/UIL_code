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

public class cost {
    public static void main(String[] args) throws Exception {
        new cost().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cost").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt();
            String name = f.next();
            int[] num = new int[n];
            double[] pres = new double[n];
            double sum = 0;
            for (int i = 0; i < n; i++) {
                num[i] = f.nextInt();
            }
            for (int i = 0; i < n; i++) {
                sum+= f.nextDouble() * num[i];
            }
            if (sum == 0) {
                out.println("It will be free for Samny Klaws to make " + name + " happy this Christmas!");
            }else{
                out.printf("It will cost Sammy Klaws $%d to make %s happy this Christmas!\n",Math.round(sum),name);
            }
        }
        f.close();
    }
}
