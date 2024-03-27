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

public class city {
    SimpleDateFormat ff = new SimpleDateFormat("MM/dd/yyyy");
    public static void main(String[] args) throws Exception {
        new city().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("city").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Calendar c = new GregorianCalendar(2023,Calendar.APRIL,14);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int d = f.nextInt(), m = f.nextInt();
            Calendar cal = new GregorianCalendar(2023,m-1,d);
            if (Math.abs(cal.get(Calendar.DAY_OF_YEAR) - c.get(Calendar.DAY_OF_YEAR))<=30) {
                out.println("outstanding work gentlemen");
            }
            else{
                out.println("this is the worst of all possible worlds");
            }
        }
        f.close();
    }
}
