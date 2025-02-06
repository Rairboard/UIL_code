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

public class spice {
    public static void main(String[] args) throws Exception {
        new spice().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("spice").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        List<String> spice = new ArrayList<>();
        Map<String,String[]> m = new HashMap<>();

        for (int asdf = 0; asdf < times; asdf++) {
            String item  =f.next();
            String[] sub = f.nextLine().trim().split("\\s+");
            m.put(item, sub);
            spice.add(item);
        }
//        for(String s : m.keySet()){
//            out.println(s+  " "+ Arrays.toString(m.get(s)));
//        }
        times = f.nextInt();
        f.nextLine();
        for (int asdf = 0; asdf < times; asdf++) {
            int n= f.nextInt();
            f.nextLine();
            int[] index = new int[spice.size()];
            for (int i = 0; i < n; i++) {
                String ln = f.nextLine().trim();
                for(String s : m.keySet()){
                    if (ln.contains(s)) {
                        int a = ln.indexOf(s);
                        int b = a + s.length();
                        ln = ln.substring(0,a) + m.get(s)[index[spice.indexOf(s)]] + ln.substring(b);
                        index[spice.indexOf(s)]++;
                    }
                }
                out.println(ln);
            }
            out.println();
        }
        f.close();
    }
}
