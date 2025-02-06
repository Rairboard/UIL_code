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

public class michal {
    public static void main(String[] args) throws Exception {
        new michal().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("michal").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		String[] num = new String[10];
		num[0] = "***" +
				" _ " +
				"| |" +
				"|_|" +
				"   " +
				"***";
		num[1] = "***" +
				"   " +
				"  |" +
				"  |" +
				"   " +
				"***";
		num[2] = "***" +
				" _ " +
				" _|" +
				"|_ " +
				"   " +
				"***";
		num[3] = "***" +
				" _ " +
				" _|" +
				" _|" +
				"   " +
				"***";
		num[4] = "***" +
				"   " +
				"|_|" +
				"  |" +
				"   " +
				"***";
		num[5]  ="***" +
				" _ " +
				"|_ " +
				" _|" +
				"   " +
				"***";
		num[6] = "***" +
				" _ " +
				"|_ " +
				"|_|" +
				"   " +
				"***";
		num[7] = "***" +
				" _ " +
				"  |" +
				"  |" +
				"   " +
				"***";
		num[8] = "***" +
				" _ " +
				"|_|" +
				"|_|" +
				"   " +
				"***";
		num[9] = "***" +
				" _ " +
				"|_|" +
				"  |" +
				"   " +
				"***";
		int times = f.nextInt();
		f.nextLine();
		for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine().trim();
//			out.println(ln);
			for (int i = 0; i < 6; i++) {
				out.print("*");
				for (int j = 0; j < ln.length(); j++) {
					int n = Integer.parseInt(ln.substring(j,j+1));

                    out.print(num[n].substring(i * 3, i * 3 + 3));
				}
				out.println("*");
			}
		}
        f.close();
    }
}
