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

public class lucas {
    public static void main(String[] args) throws Exception {
        new lucas().run();
    }

    public void run() throws Exception {
        BigInteger[] ar = new BigInteger[31];
		ar[0] = BigInteger.TWO;
		ar[1] = BigInteger.ONE;
		for (int i = 2; i < ar.length; i++) {
			ar[i] = ar[i-1].add(ar[i-2]);
		}
		for (int i = 0; i < ar.length; i++) {
			out.println(ar[i]);
		}
    }
}
