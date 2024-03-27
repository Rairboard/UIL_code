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

public class prob04 {
    public static void main(String[] args) throws Exception {
        new prob04().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("prob04").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			double rate = f.nextDouble()/100;
			double money = f.nextDouble();
			double pretax = money / (1.0 + rate);
			double tax = pretax * rate;
			out.printf("On your $%.2f purchase, the tax amount was $%.2f\n",money,tax);
        }
        f.close();
    }
}
