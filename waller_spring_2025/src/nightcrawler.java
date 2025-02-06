import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class nightcrawler {
    public static void main(String[] args) throws Exception {
        new nightcrawler().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("nightcrawler").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String[] ln = f.nextLine().trim().split("\\s+");
			double max = 0;
			for (int i = 0; i < ln.length; i++) {
				for (int j = i+1; j < ln.length; j++) {
					String[] a = ln[i].replaceAll("[()]","").split(",");
					String[] b = ln[j].replaceAll("[()]","").split(",");
					double dis = Math.sqrt(Math.pow(Double.parseDouble(a[0]) - Double.parseDouble(b[0]), 2) + Math.pow(Double.parseDouble(a[1])- Double.parseDouble(b[1]),2));
					max = Math.max(max, dis);
				}
			}
			out.printf("%.2f\n", max);
        }
        f.close();
    }
}
