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

public class vincent {
    public static void main(String[] args) throws Exception {
        new vincent().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("vincent").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        SimpleDateFormat ff = new SimpleDateFormat("MMMM dd, yyyy - hh:mm a");
        while(f.hasNext()){
            Calendar c = new GregorianCalendar(f.nextInt(),f.nextInt()-1,f.nextInt(),f.nextInt(),f.nextInt());
            f.nextLine();
            int[] ar = Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            out.println(ff.format(c.getTime()));
            out.println("-".repeat(5));
            for (int i = 0; i < ar.length; i++) {
                Calendar tmp = new GregorianCalendar();
                tmp.setTime(c.getTime());
                tmp.add(Calendar.MINUTE,ar[i]);
                out.println(ff.format(tmp.getTime()));
            }
            out.println("=".repeat(5));
        }
        f.close();
    }
}
