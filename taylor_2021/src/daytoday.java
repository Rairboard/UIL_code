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

public class daytoday {
    public static void main(String[] args) throws Exception {
        new daytoday().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("daytoday.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int m1 = f.nextInt()-1, d1 = f.nextInt(), y1= f.nextInt(), m2= f.nextInt()-1,d2 =f.nextInt(),y2=f.nextInt();
			Calendar one = new GregorianCalendar(y1,m1,d1);
			Calendar two = new GregorianCalendar(y2,m2,d2);
			long day = 0;
			while(one.compareTo(two)!=0){
				day++;
				one.add(Calendar.DATE,1);
			}
			out.println(day-1);
        }
        f.close();
    }
}
