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

public class lucas {
    public static void main(String[] args) throws Exception {
        new lucas().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lucas").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            long sum = Arrays.stream(ar).sum();
            Arrays.sort(ar);
            if(ar.length>=3){
                sum = sum-ar[0] - ar[ar.length-1];
                sum/=ar.length-2;
            }else{
                sum/=ar.length;
            }
            long m = sum/60;
            long s = sum%60;
            out.printf("%d:%02d\n",m,s);
        }
        f.close();
    }
}
