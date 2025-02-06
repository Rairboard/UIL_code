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

public class martyn {
    public static void main(String[] args) throws Exception {
        new martyn().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("martyn").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        String s = "";
        for(int i = 0;i<=9;i++){
            s+=i;
        }
        for(char c = 'A';c<='Z';c++){
            s+=c;
        }
        for(char c = 'a';c<='z';c++){
            s+=c;
        }
        s+="+/";
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            BigInteger b = f.nextBigInteger();
            String ln = "";
            for(long i = 2;i<=64;i++){
                BigInteger copy = b;
                String conversion = "";
                while(copy.compareTo(BigInteger.ZERO) > 0){
                    conversion+= s.charAt(copy.mod(BigInteger.valueOf(i)).intValue());
                    copy = copy.divide(BigInteger.valueOf(i));
                }
                if(conversion.equals(new StringBuilder(conversion).reverse().toString())){
                    ln += i + ", ";
                }
            }
            if(!ln.isEmpty()) out.println(ln.substring(0,ln.lastIndexOf(",")));
            else out.println("None.");
        }
        f.close();
    }
}
