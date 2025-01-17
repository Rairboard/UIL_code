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

public class proddiv {
    public static void main(String[] args) throws Exception {
        new proddiv().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("proddiv").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            BigInteger a = f.nextBigInteger();
            BigInteger b = f.nextBigInteger();
            int cnt = 0;
            while(a.compareTo(b)<=0){
                if (a.isProbablePrime(Integer.MAX_VALUE)) {
                    cnt++;
                }
                a = a.nextProbablePrime();
            }
            out.println(cnt);
        }
        f.close();
    }
}
