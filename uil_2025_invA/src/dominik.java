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
import java.time.*;
import java.time.temporal.*;

public class dominik {
    public static void main(String[] args) throws Exception {
        new dominik().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dominik").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        int cases = f.nextInt();
        f.nextLine();
        Map<String,LocalDate> m = new HashMap<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[]ln = f.nextLine().trim().split("\\s+",2);
            String[] date = ln[0].split("/");
            LocalDate d = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]),Integer.parseInt(date[2]));
            m.put(ln[1], d);
        }
        for (int i = 0; i < cases; i++) {
            String[] ln = f.nextLine().trim().split(":");
            LocalDate a = m.get(ln[0]);
            LocalDate b = m.get(ln[1]);
            long days = Math.abs(ChronoUnit.DAYS.between(a,b));
            out.printf("%,d\n", days);
        }
        f.close();
    }
}
