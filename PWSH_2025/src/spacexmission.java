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

public class spacexmission {
    public static void main(String[] args) throws Exception {
        new spacexmission().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("spacexmission").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        long total = 0;
        for (int asdf = 1; asdf <= times; asdf++) {
            total+=f.nextLong();
        }
        out.println(total==0?"SAFE":"NOT SAFE");
        f.close();
    }
}
