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

public class gael {
    public static void main(String[] args) throws Exception {
        new gael().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("gael").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim();
            out.println(ln);
            for (int i = 1; i < ln.length()-1; i++) {
                out.println(ln.charAt(i) + " ".repeat(ln.length()-2) + ln.charAt(ln.length()-1-i));
            }
            out.println(new StringBuilder(ln).reverse());
        }
        f.close();
    }
}