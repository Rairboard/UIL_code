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

public class five {
    public static void main(String[] args) throws Exception {
        new five().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("five").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            char[] ln = f.nextLine().trim().toCharArray();
            Arrays.sort(ln);
            out.println(ln);
        }
        f.close();
    }
}
