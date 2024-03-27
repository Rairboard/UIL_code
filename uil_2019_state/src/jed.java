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

public class jed {
    public static void main(String[] args) throws Exception {
        new jed().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("jed").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine();
            ln+=ln.substring(0,1);
            out.println(ln);
            for (int i = 1; i < ln.length()-1; i++) {
                out.println(ln.charAt(ln.length()-1-i) + " ".repeat(ln.length()-2) + ln.charAt(i));
            }
            out.println(new StringBuilder(ln).reverse());
            out.println();
        }
        f.close();
    }
}
