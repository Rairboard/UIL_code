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

public class krish {
    public static void main(String[] args) throws Exception {
        new krish().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("krish").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long n = f.nextLong();
            if (n > 0){
                long sum = 0;
                long product = 1;
                long rev = Long.parseLong(new StringBuilder(n +"").reverse().toString());
                long revProduct = rev * n;
                out.print(n + " ");
                while(n > 0){
                    sum += n % 10;
                    if(n % 10 != 0) product*=n %10;
                    n/=10;
                }
                out.println(sum + " "  + product + " " + rev + " " + revProduct );
            }
            else{
                long sum = 0;
                long product = 1;
                long rev = -Long.parseLong(new StringBuilder(Math.abs(n) + "").reverse().toString());
                long revProduct = n * rev;
                out.print(n + " ");
                n = Math.abs(n);
                while(n > 0){
                    sum += -(n%10);
                    if(n%10 != 0) product *= -(n%10);
                    n/=10;
                }
                out.println(sum + " " + product + " " + rev + " "  + revProduct);
            }
        }
        f.close();
    }
}
