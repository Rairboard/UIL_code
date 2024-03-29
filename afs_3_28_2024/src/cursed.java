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

public class cursed {
	SimpleDateFormat ff = new SimpleDateFormat("MMddyyyy");
    List<String> al = new ArrayList<>(Arrays.asList("January,February,March,April,May,June,July,August,September,October,November,December".split(",")));
    public static void main(String[] args) throws Exception {
        new cursed().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cursed").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while (f.hasNext()) {
            String[] ln = f.nextLine().split("[ ,]+");
            Calendar c = new GregorianCalendar(Integer.parseInt(ln[2]),al.indexOf(ln[0]),Integer.parseInt(ln[1]));
            String date = ff.format(c.getTime());
            if (!date.equals(new StringBuilder(date).reverse().toString())) {
                out.println(date + ": OK TO TRAVEL");
            }
            else{
                out.println(date + ": DON'T TRAVEL");
            }
        }
        f.close();
    }
}
