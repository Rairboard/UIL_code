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

public class phonenumbers {
    public static void main(String[] args) throws Exception {
        new phonenumbers().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("phonenumbers").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim();
            out.println(ln.matches("([0-9]{3}-?){3}[0-9]")  ?ln : "INVALID PHONE NUMBER");
        }
        f.close();
    }
}
