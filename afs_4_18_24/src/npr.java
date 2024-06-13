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

public class npr {
    public static void main(String[] args) throws Exception {
        new npr().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("npr").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long r = f.nextLong(), n = f.nextLong();
            if(n == 0) out.println( r  + " out of " + n + " bunnies can be arranged in 1 different ways");
            else if(r == 0) out.println(r + " out of " + n + " bunnies can be arranged in 0 different ways");
            else if(n==r) out.println(r + " out of " + n + " bunnies can be arranged in 1 different ways");
            else{
                long a = factorial(n);
                long b = factorial(n-r);
                out.println(r + " out of " + n + " bunnies can be arranged in " + a/b + " different ways");
            }
        }
        f.close();
    }
    public long factorial(long n){
        long ff = 1;
        for (int i = 2; i <= n; i++) {
            ff*=i;
        }
        return ff;
    }
}
