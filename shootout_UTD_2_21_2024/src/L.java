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

public class L {
    public static void main(String[] args) throws Exception {
        new L().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("L").toLowerCase() + ".txt"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int N = f.nextInt(), m = f.nextInt();
            List<BigInteger> al = new ArrayList<>();
            al.add(BigInteger.ONE);
            al.add(BigInteger.ONE);
            while(true){
                BigInteger b = al.get(al.size()-1).add(al.get(al.size()-2));
                b = b.mod(BigInteger.valueOf(m));
                if(al.contains(b)){
                    break;
                }
                al.add(b);
                out.println(b);
            }
            out.println(N +" "+al);
            out.println();
        }
        f.close();
    }
}
