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

public class ghoabudgeting {
    public static void main(String[] args) throws Exception {
        new ghoabudgeting().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("ghoabudgeting").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        long money = f.nextLong();
        long total = 0;
        int times = f.nextInt();
        if(times>0){
            f.nextLine();
            long[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            for (int i = ar.length-1;i>-1;i--) {
                if(ar[i]>0){
                    total+=money/ar[i];
                    money = money - money/ar[i];
                }

            }
        }
        out.println(money+" " +total);
        f.close();
    }
}
