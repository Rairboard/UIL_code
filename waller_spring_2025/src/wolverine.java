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

public class wolverine {
    SimpleDateFormat ff = new SimpleDateFormat("MM/dd/yyyy");
    public static void main(String[] args) throws Exception {
        new wolverine().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("wolverine").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Calendar c = new GregorianCalendar();
            c.setTime(ff.parse(f.nextLine()));
            String s = f.next();
            int n = f.nextInt();
            if(f.hasNext())f.nextLine();
            if (s.equals("D")) {
                c.add(Calendar.DATE,n);
            } else if (s.equals("M")) {
                c.add(Calendar.MONTH,n);
            } else if (s.equals("Y")) {
                c.add(Calendar.YEAR,n);
            }
            SimpleDateFormat fff = new SimpleDateFormat("MMMM dd, yyyy");
            out.println(fff.format(c.getTime()));
        }
        f.close();
    }
}
