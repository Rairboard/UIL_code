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

public class discount {
    public static void main(String[] args) throws Exception {
        new discount().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("discount").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String[] ln = f.nextLine().split(",\\s+");
			String[] a = ln[0].split("\\s+");
			String[] b = ln[1].split("\\s+");
			double one = Double.parseDouble(a[1].substring(1));
			double two = Double.parseDouble(b[1].substring(1));
			one-= one * Integer.parseInt(a[2].replace("%",""))/100.0;
			two-= two * Integer.parseInt(b[2].replace("%",""))/100.0;
			if(one-two==0){
				out.printf("Buy %s, Paid the Same\n",a[0]);
			}else if(one < two){
				out.printf("Buy %s, Saves: $%.02f\n",a[0],two-one);
			}else{
				out.printf("Buy %s, Saves: $%.02f\n",b[0],one-two);
			}
        }
        f.close();
    }
}
