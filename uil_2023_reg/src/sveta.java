import java.time.temporal.IsoFields;
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

public class sveta {
    public static void main(String[] args) throws Exception {
//        out.println(Long.toBinaryString(Long.parseLong("8E",16)));
        new sveta().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("sveta").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String bits = f.nextLine();
            String one = f.nextLine();
            String zero = f.nextLine();
            String invert = f.nextLine();
            f.nextLine();
            int operation = 0;
            if (!one.matches(".*n/a")) {
                operation++;
            }
            if (!zero.matches(".*n/a")) {
                operation++;
            }
            if (!invert.matches(".*n/a")) {
                operation++;
            }
            if(operation>1){
                out.println("This can not be done with a single bitwise operator.");
            }
            else{
                if (!one.matches(".*n/a")) {
                    long i = 0;
                    String[] ln = one.split("\\s+")[3].split(",");
                    for (int j = 0; j < ln.length; j++) {
                        i |= 1L << Long.parseLong(ln[j]);
                    }
                    out.printf("opnd | %X\n", i);
                }
                else if (!zero.matches(".*n/a")) {
                    long i = (1L << Long.parseLong(bits.split("=")[1])) -1;
                    String[] ln = zero.split("\\s+")[3].split(",");
                    for (int j = 0; j < ln.length; j++) {
                        i ^= 1L << Long.parseLong(ln[j]);
                    }
                    out.printf("opnd & %X\n", i);
                }
                else if (!invert.matches(".*n/a")) {
                    long i = 0;
                    String[] ln = invert.split("\\s+")[1].split(",");
                    for (int j = 0; j < ln.length; j++) {
                        i |= 1L << Long.parseLong(ln[j]);
                    }
//                    out.println(Long.toBinaryString(i));
                    out.printf("opnd ^ %X\n", i);
                }
            }
        }
        f.close();
    }
}
