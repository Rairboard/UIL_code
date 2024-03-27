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

public class banu {
    SimpleDateFormat ff = new SimpleDateFormat("MMMM");
    public static void main(String[] args) throws Exception {
        new banu().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("banu").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            Calendar c = new GregorianCalendar();
            c.set(Calendar.MONTH,f.nextInt()-1);
            out.println(ff.format(c.getTime()));
        }
        f.close();
    }
}
