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

public class danger {
    public static void main(String[] args) throws Exception {
        new danger().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("danger").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
		String[][] m = new String[times][2];
		for (int i = 0; i < times; i++) {
			m[i] = f.nextLine().trim().split("\\s+");
		}
		Arrays.sort(m, (a,b) ->{
			String[] time1 = a[0].split(":");
			String[] time2 = b[0].split(":");
			return (Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1])) - (Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]));
		});
		for (int i = 0; i < m.length; i++) {
			out.println(m[i][0] + " " + m[i][1]);
		}
        f.close();
    }
}
