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

public class adv54 {
    public static void main(String[] args) throws Exception {
        new adv54().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv54").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			BigInteger bi = f.nextBigInteger();
			BigInteger fact = BigInteger.TWO;
			BigInteger sum = BigInteger.ZERO;
			while(bi.compareTo(BigInteger.ONE)>0){
				while (bi.mod(fact).equals(BigInteger.ZERO)) {
					sum = sum.add(fact);
					bi = bi.divide(fact);
				}
				fact = fact.nextProbablePrime();
			}
			out.println(sum);
        }
        f.close();
    }
}
