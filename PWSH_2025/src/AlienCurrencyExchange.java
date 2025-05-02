import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class AlienCurrencyExchange {
    public static void main(String[] args) throws Exception {
        new AlienCurrencyExchange().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("AlienCurrencyExchange").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        String ln = f.nextLine().trim();
		if(ln.charAt(0)=='-') ln= ln.substring(1);
		BigInteger ghoa = BigInteger.valueOf(7552701074431167L);
		BigInteger total = BigInteger.ZERO;
		for (int i = 0; i < ln.length(); i++) {
			BigInteger times = BigInteger.valueOf(10).pow(ln.length()-1-i);
			times = times.multiply(BigInteger.valueOf(Long.parseLong(ln.substring(i,i+1))));
			total = total.add(ghoa.multiply(times));
			ghoa = ghoa.multiply(BigInteger.valueOf(80)).divide(BigInteger.valueOf(100));
		}
		out.println(total);
        f.close();
    }
}
