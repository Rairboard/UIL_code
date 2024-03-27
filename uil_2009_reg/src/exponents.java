import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class exponents {
    public static void main(String[] args) throws Exception {
        new exponents().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("exponents.dat"));
        //Scanner f = new Scanner(System.in);
        while (f.hasNext()) {
			BigInteger a = f.nextBigInteger(), b = f.nextBigInteger();
			System.out.println((long)(Math.log10(b.doubleValue())/Math.log10(a.doubleValue())));
        }
        f.close();
    }
}
