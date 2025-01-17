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

public class strong {
    public static void main(String[] args) throws Exception {
        new strong().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("strong").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            boolean good = ln.length() >= 8;
            good &= ln.matches(".*[!@#$%^&*()_+=]+.*");
            good &= ln.matches(".*[0-9]+.*");
            good &= ln.matches("[a-zA-Z0-9!@#$%^&*()_+=]{8,}");
            out.println(good ? "STRONG":"INVALID");
        }
        f.close();
    }
}
