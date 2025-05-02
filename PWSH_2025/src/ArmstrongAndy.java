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

public class ArmstrongAndy {
    public static void main(String[] args) throws Exception {
        new ArmstrongAndy().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("ArmstrongAndy").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        long a = f.nextLong() , b = f.nextLong();
        int cnt = 0;
        for(long i = a;i<=b;i++){
            if(BigInteger.valueOf(i).isProbablePrime(Integer.MAX_VALUE)){
                cnt++;
                continue;
            }
            int length = (i+"").length();
            long tmp = i;
            long total = 0;
            while(tmp>0){
                total+=(long)Math.pow(tmp%10, length);
                tmp/=10;
            }
            if(total==i) cnt++;
        }
        out.println(cnt);
        f.close();
    }
}
