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

public class xwing {
    public static void main(String[] args) throws Exception {
        new xwing().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("xwing").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			BigInteger n = f.nextBigInteger(), t = f.nextBigInteger(), s = f.nextBigInteger();
			BigInteger[] ar = new BigInteger[2];
			Arrays.fill(ar,BigInteger.ONE);
			for(BigInteger i = BigInteger.ONE;i.compareTo(n)<=0;i = i.add(BigInteger.ONE)){
				ar[0] = ar[0].multiply(i);
			}
			for(BigInteger i = BigInteger.ONE;i.compareTo(t)<=0;i = i.add(BigInteger.ONE)){
				ar[1] = ar[1].multiply(i);
			}
			out.println(n.subtract(t).multiply(n.subtract(t)).abs().add(ar[0]).add(ar[1]).compareTo(s)>0? "Ethan X-Wing Spontaneously Combusts":"Ethan X-Wing is okay");
        }
        f.close();
    }

}
