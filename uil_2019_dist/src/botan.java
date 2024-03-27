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

public class botan {
    public static void main(String[] args) throws Exception {
        new botan().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("botan").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf<=times;asdf++){
            out.print("Case #" + asdf + ":");
            int n = f.nextInt();
            if(n<10){
                out.println(BigInteger.valueOf(n).isProbablePrime(1000000000)?"BOTAN-PRIME":"NOT BOTAN-PRIME");
            }
            else{
                String ln = n+"";
                boolean found = true;
                for (int i = 0; i < ln.length(); i++) {
                    BigInteger bi = new BigInteger(ln.substring(i,i+1));
                    if(!bi.isProbablePrime((int)Math.pow(10,9))){
                        found = false;
                        break;
                    }
                }
                if(!found){
                    out.println("NOT BOTAN-PRIME");
                }
                else{
                    out.println("BOTAN-PRIME");
                }
            }
        }
        f.close();
    }
}
