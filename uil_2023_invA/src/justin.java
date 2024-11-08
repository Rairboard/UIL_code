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

public class justin {
    public static void main(String[] args) throws Exception {
        new justin().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("justin").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			double purchasePrice = f.nextDouble(), downPayment = f.nextDouble(), apr = f.nextDouble()/100;
            int month = f.nextInt();
			double r = apr/12;
            double monthlyPayment = ((purchasePrice - downPayment) * r) / (1 - Math.pow((1+r),-month));
            monthlyPayment = Double.parseDouble(String.format("%.2f", monthlyPayment));
			double totalPayment = monthlyPayment * month + downPayment;
            totalPayment = Double.parseDouble(String.format("%.2f", totalPayment));
            double interest = totalPayment - purchasePrice;
            interest = Double.parseDouble(String.format("%.2f", interest));
            out.printf("$%9.2f $%9.2f $%9.2f\n", monthlyPayment, totalPayment, interest);
        }
        f.close();
    }
}
