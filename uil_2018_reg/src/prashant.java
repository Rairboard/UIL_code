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

public class prashant {
    public static void main(String[] args) throws Exception {
        new prashant().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("prashant").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            Map<String,Integer> m = new HashMap<>();
            String[] ln = f.nextLine().split("\\s+");
            for (int i = 0; i < ln.length; i++) {
                m.putIfAbsent(ln[i],0);
                m.put(ln[i],m.get(ln[i])+1);
            }
            List<BigInteger> al = new ArrayList<>();
            int max = ln.length;
            for(String i : m.keySet()){
                max = Math.max(max,m.get(i));
            }
            BigInteger[] ar = new BigInteger[max+1];
            ar[0] = BigInteger.ONE;
            for (int i = 1; i <= max; i++) {
                ar[i] = BigInteger.valueOf(i).multiply(ar[i-1]);
            }
            BigInteger dup = BigInteger.ONE;
            for(String s : m.keySet()){
                dup = dup.multiply(ar[m.get(s)]);
            }
            out.println(ar[ln.length].divide(dup));
        }
        f.close();
    }
}
