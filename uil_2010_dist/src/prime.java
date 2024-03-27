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

public class prime {
    public static void main(String[] args) throws Exception {
        new prime().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("prime").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            BigInteger b = BigInteger.ONE;
            BigInteger limit = f.nextBigInteger();
            BigInteger tmp = BigInteger.ONE;

            while(b.compareTo(limit)<=0){
                BigInteger mod = limit.mod(b);
                if (b.isProbablePrime(1) & mod.compareTo(BigInteger.ZERO) == 0 ) {
                    tmp = b;
                }
                b = b.nextProbablePrime();
            }
            out.println(tmp);
        }
        f.close();
    }
}
