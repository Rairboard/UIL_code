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

public class HamiltonianCycle {
    public static void main(String[] args) throws Exception {
        TreeSet<Integer> ts =new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            ts.add(i);
        }
        out.println(ts);
        // lowest element that is greater than or equal to number
        out.println(ts.ceiling(2));
        // lowest element that is strictly greater than number
        out.println(ts.higher(2));
        // greatest element that is less than or equal to number
        out.println(ts.floor(8));
        // greatest element that is strictly lower smaller than number
        out.println(ts.lower(8));

        /*  Output will be
           2
           3
           8
           7
        */
//        new HamiltonianCycle().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("HamiltonianCycle").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);

        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {

        }
        f.close();
    }
}
