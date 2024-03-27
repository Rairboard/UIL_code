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

public class samantha {
    public static void main(String[] args) throws Exception {
        new samantha().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("samantha").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            double[] ar = Arrays.stream(f.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            double sub = 0;
            double tax = 0;
            double total = 0;
            for (int i = 0; i < ar.length; i++) {
                sub+=ar[i];
            }
            tax = sub*.0825;
            total = sub+tax;
            String a = String.format("%.2f",sub), b = String.format("%.2f",tax), c = String.format("%.2f",total);
            int max = Math.max(a.length(),Math.max(b.length(),c.length()))+1;
            out.printf("%-8s: $%" + max+"s\n","Subtotal",a);
            out.printf("%-8s: $%"+ max+"s\n","Tax",b);
            out.printf("%-8s: $%"+ max+"s\n","Total",c);
            out.println("=".repeat(5));
        }
        f.close();
    }
}
