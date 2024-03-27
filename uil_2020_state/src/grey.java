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

public class grey {
    SimpleDateFormat ff = new SimpleDateFormat("MM/dd/yyyy");
    public static void main(String[] args) throws Exception {
        new grey().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("grey").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            Calendar c = new GregorianCalendar();
            c.setTime(ff.parse(f.next()));
            c.add(Calendar.DATE, 7 * f.nextInt() * -1);
            out.println(ff.format(c.getTime()));
        }
        f.close();
    }
}
