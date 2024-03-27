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

public class ThePasscodeIs {
    public static void main(String[] args) throws Exception {
        new ThePasscodeIs().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ThePasscodeIs").toLowerCase()));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int ll = f.nextInt();
            BigInteger b = f.nextBigInteger();
            BigInteger power = BigInteger.ONE;
            for (int i = 0; i < ll-1; i++) {
                power = power.multiply(f.nextBigInteger());
            }
            b = b.modPow(power,BigInteger.valueOf(1000000007));
            out.println(b);
        }
        f.close();
    }
}
