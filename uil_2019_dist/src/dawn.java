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

public class dawn {
    public static void main(String[] args) throws Exception {
        new dawn().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dawn").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        double totalInvest = 0, totalMonthly = 0, totalPayment = 0, totalProfit = 0;
        out.println("     Amount                             Monthly         Total of\n" +
                    "....Invested........APR......Years......Payment.........Payments............Profit..");
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            double a = f.nextDouble(), apr = f.nextDouble()/100, n = f.nextDouble(), r = apr/12;
            double monthlyPayment = (a * r) / (1 - Math.pow(1+r,-(n*12)));
            monthlyPayment = Double.parseDouble(String.format("%.2f", monthlyPayment));
            double total = monthlyPayment * n * 12;
            out.printf("$%,12.2f  |%8.3f%s  |%5d  |  $%,9.2f  |  $%,12.2f  |  $%,12.2f\n", a, apr * 100, "%", (long)n, monthlyPayment, total, total - a);
            totalInvest+=a;
            totalMonthly+=monthlyPayment;
            totalPayment += total;
            totalProfit+=Double.parseDouble(String.format("%.2f", total)) - Double.parseDouble(String.format("%.2f", a));
        }
        out.printf("$%,12.2f  |           |       |  $%,9.2f  |  $%,12.2f  |  $%,12.2f\n", totalInvest, totalMonthly, totalPayment, totalProfit);
        f.close();
    }
}
