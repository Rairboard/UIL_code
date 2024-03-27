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

public class timeline {
	SimpleDateFormat ff = new SimpleDateFormat("M/d/yyyy");
    public static void main(String[] args) throws Exception {
        new timeline().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("timeline").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.next();
			Calendar c = new GregorianCalendar(1975,6,1);
			c.add(Calendar.DAY_OF_YEAR,12 * f.nextInt());
			out.println(ff.format(c.getTime()));
        }
        f.close();
    }
}
