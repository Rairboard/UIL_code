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

public class conversion {
    public static void main(String[] args) throws Exception {
        new conversion().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("conversion").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
		Map<String,Double> m = new HashMap<>();
		String[] ln = f.nextLine().split("\\s+");
		for (int i = 0; i < ln.length; i+=2) {
			m.put(ln[i],Double.parseDouble(ln[i+1]));
		}
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			double d = f.nextDouble();
			String a = f.next(), b = f.next();
			out.printf("%.2f %s = %.2f %s\n",d,a,d/m.get(a) * m.get(b),b);
        }
        f.close();
    }
}
