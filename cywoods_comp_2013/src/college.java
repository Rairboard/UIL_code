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

public class college {
	SimpleDateFormat ff = new SimpleDateFormat("EEE MMM dd");
	SimpleDateFormat time = new SimpleDateFormat("kk:mm");
    public static void main(String[] args) throws Exception {
        new college().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("college").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        HashSet<String> college = new HashSet<>();
		int essay = 0;
		while(f.hasNext()){
			college.add(f.next());
			essay+=f.nextInt();
		}
		essay*=45;
		essay+=college.size() * 60;
		Calendar c = new GregorianCalendar(2013,Calendar.OCTOBER,31,23,59,60);
		c.add(Calendar.MINUTE,essay*-1);
		out.println("Rish should start his application on or before " + ff.format(c.getTime()) + " at " + time.format(c.getTime()) + ".");
        f.close();
    }
}
