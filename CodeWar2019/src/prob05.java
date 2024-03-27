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

public class prob05 {
    public static void main(String[] args) throws Exception {
        new prob05().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("prob05").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        BigInteger times = f.nextBigInteger();
        BigInteger sum = BigInteger.ZERO;
        for(BigInteger b  = BigInteger.ONE; b.compareTo(times)<=0;b = b.add(BigInteger.ONE)){
            sum = sum.add(b.pow(2));
        }
        out.println(sum);
        f.close();
    }
}
