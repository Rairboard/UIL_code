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

public class krithika {
    public static void main(String[] args) throws Exception {
        new krithika().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("krithika").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            int k = f.nextInt();
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = f.nextLong();
            }
            long ans = 0;
            for(long bit = 1L << 61; bit > 0;bit>>=1){
                ans|= bit;
                int count = 0;
                for(long number : ar){
                    if((ans & number) == ans){
                        count++;
                    }
                }
                if(count < k) ans^=bit;
            }
//            out.println(Arrays.toString(ar));
            out.println("Case #" + asdf + ": " + ans);
        }
        f.close();
    }
}
