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

public class neeraj {
    public static void main(String[] args) throws Exception {
        new neeraj().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("neeraj").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            double d = f.nextDouble();
            out.print(d + " is equal to ");
            long decimalPlaces = (long)Math.pow(10,(d+"").length()-1);
            d *= decimalPlaces;
            long gcf = gcf((long)d, decimalPlaces);
            out.println(d/gcf + "/" + decimalPlaces/gcf);
        }
        f.close();
    }
    public long gcf (long a, long b){
        for(long i = Math.min(a,b);i>=1;i--){
            if(a%2==0&&b%i==0){
                return i;
            }
        }
        return 1;
    }
}
