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

public class steeds {
    public static void main(String[] args) throws Exception {
        new steeds().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("steeds").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int n = f.nextInt(), amt = 0;
			f.nextLine();
			long money = 0;
			for (int i = 0; i < n; i++) {
				long cost = f.nextLong();
				String an = f.next();
				if(f.hasNext()){
					f.nextLine();
				}
				if(an.toLowerCase().equals("horse")){
					money+=cost;
					amt++;
				}
			}
			out.println(amt + " " + money);
        }
        f.close();
    }
}
