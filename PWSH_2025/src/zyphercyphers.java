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

public class zyphercyphers {
    public static void main(String[] args) throws Exception {
        new zyphercyphers().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("zyphercyphers").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        int invalid = 0;
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            if (!ln.contains("1") || !ln.contains("0")) {
                invalid++;
                continue;
            }
            if(ln.startsWith("00")||ln.startsWith("11")||ln.endsWith("00")||ln.endsWith("11")){
                invalid++;
            }
        }
        out.println(times - invalid + " " + invalid);
        f.close();
    }
}
