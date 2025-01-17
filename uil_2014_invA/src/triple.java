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

public class triple {
    public static void main(String[] args) throws Exception {
        new triple().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("triple").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			List<BigInteger> fact = new ArrayList<>();
			BigInteger n = f.nextBigInteger();
			BigInteger prime = BigInteger.TWO;
			out.print(n+" ");
			while(n.compareTo(BigInteger.ONE) > 0){
				if (n.mod(prime).equals(BigInteger.ZERO)) {
					fact.add(prime);
					n = n.divide(prime);
				}
				else{
					prime = prime.nextProbablePrime();
				}
			}
			out.print("[");
			HashSet<BigInteger> hs = new HashSet<>();
			for (int i = 0; i < fact.size(); i++) {
				out.print(fact.get(i));
				if(i<fact.size()-1){
					out.print(", ");
				}
				hs.add(fact.get(i));
			}
			out.print("] ");
			out.println(hs.size() == 3 && fact.size() == 3 ?"YES":"NO");
        }
        f.close();
    }
}
