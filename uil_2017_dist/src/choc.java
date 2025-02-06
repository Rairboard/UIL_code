import java.time.format.DateTimeFormatter;
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

public class choc {
    SimpleDateFormat ff = new SimpleDateFormat("M/d/yyyy");
    public static void main(String[] args) throws Exception {
        new choc().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("choc").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Calendar c =new GregorianCalendar(2025, Calendar.JULY,21);
            int n = f.nextInt();
            for (int i = 0; i < n; i++) {
                c.add(Calendar.DATE,1);
            }
            out.println(ff.format(c.getTime()));
        }
        f.close();
    }
}
