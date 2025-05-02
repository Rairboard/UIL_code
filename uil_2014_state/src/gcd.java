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

public class gcd {
    public static void main(String[] args) throws Exception {
        new gcd().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("gcd").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            BigInteger gcd = f.nextBigInteger().gcd(f.nextBigInteger());
            for (int i = 0; i < n - 2; i++) {
                gcd = gcd.gcd(f.nextBigInteger());
            }
            out.println(gcd);
        }
        f.close();
    }
}
