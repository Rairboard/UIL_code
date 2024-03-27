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

public class date {
    SimpleDateFormat ff = new SimpleDateFormat("M/dd/yyyy");
    public static void main(String[] args) throws Exception {
        new date().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("date").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        Calendar birth = new GregorianCalendar(1998,Calendar.MARCH,8);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            Calendar c = new GregorianCalendar();
            c.setTime(ff.parse(f.nextLine()));
            int cnt = 1;
            while (!c.equals(birth)) {
                c.add(Calendar.DATE,1);
                cnt++;
            }
            out.println(cnt+1);
        }
        f.close();
    }
}
