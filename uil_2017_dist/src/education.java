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

public class education {
    public static void main(String[] args) throws Exception {
        new education().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("education").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("\\s+");
            long sum = 0;
            for (int i = 0; i < ln.length; i++) {
                sum+=Long.parseLong(ln[i]);
            }
            out.println(sum);
        }
        f.close();
    }
}
