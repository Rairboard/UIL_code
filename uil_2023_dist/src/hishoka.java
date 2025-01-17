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

public class hishoka {
    public static void main(String[] args) throws Exception {
        new hishoka().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hisoka").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			double p = f.nextDouble(), apr = f.nextDouble()/100, month = f.nextDouble() * 12;
			double rate = apr/12;
			double money = p * (Math.pow(1+rate,month)-1) / rate;
			double sum = p * month;
			double earn = money - sum;
			out.printf("%.2f %.2f %.2f\n", sum, earn, money);
        }
        f.close();
    }
}
