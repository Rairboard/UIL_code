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

public class emirp {
    public static void main(String[] args) throws Exception {
        new emirp().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("emirp").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()) {
            BigInteger a = f.nextBigInteger();
            BigInteger b = f.nextBigInteger();
            boolean found = false;
            while(a.compareTo(b)<=0){
                if (a.isProbablePrime(Integer.MAX_VALUE)) {
                    if (!a.toString().equals(new StringBuilder(a.toString()).reverse().toString())) {
                        BigInteger rev = new BigInteger(new StringBuilder(a.toString()).reverse().toString());
                        if (rev.isProbablePrime(Integer.MAX_VALUE)) {
                            found = true;
                            out.print(a+" ");
                        }
                    }
                }
                a = a.nextProbablePrime();
            }
            if(found){
                out.println();
            }
            else{
                out.println("NONE");
            }
        }
        f.close();
    }
}
