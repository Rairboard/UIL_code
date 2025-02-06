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

public class jason {
    public static void main(String[] args) throws Exception {
        new jason().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("jason").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int[] date = {31,28,31,30,31,30,31,31,30,31,30,31};
        long max = 0;
        long[] count = new long[date.length];
        for (int i = 0; i < date.length; i++) {
            double sum = 0;
            for (int j = 0; j < date[i]; j++) {
                sum+=f.nextDouble();
            }
            sum/=date[i];
            max = Math.max(max, Math.round(sum));
            count[i] = Math.round(sum);
        }
        for(long i = max;i>=1;i--){
            for (int j = 0; j < count.length; j++) {
                if(i > count[j]){
                    out.print("      ");
                }
                else{
                    out.print("***** ");
                }
            }
            out.println();
        }
        out.println(" Jan   Feb   Mar   Apr   May   Jun   Jul   Aug   Sep   Oct   Nov   Dec");
        f.close();
    }
}
