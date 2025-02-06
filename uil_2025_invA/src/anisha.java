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

public class anisha {
    public static void main(String[] args) throws Exception {
        new anisha().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("anisha").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int c = f.nextInt();
            f.nextInt();
            out.println(c<15 ? "On my way to Dehydration Station.":"Way to go, H2O.");
        }
        f.close();
    }
}
