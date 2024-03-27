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

public class presents {
    public static void main(String[] args) throws Exception {
        new presents().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("presents").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            long peri = f.nextLong()/2;
            long bestPerimeter = 0;
            String para = f.next();
            Map<Long,long[]> m = new TreeMap<>(Collections.reverseOrder());
            for (long i = peri/2; i >= 1; i--) {
                long a = i;
                long b = peri - i == 0 ? 1 : peri-i;
                long area = a * b;
                long[] pair = new long[2];
                if(!m.containsKey(area)){
                    if(a < b){
                        pair[0] = a;
                        pair[1] = b;
                    }else{
                        pair[0] = b;
                        pair[1] = a;
                    }
                    m.put(area,pair);
                    if(a!=b && area > bestPerimeter){
                        bestPerimeter = area;
                    }
                }
            }
            long[] best = m.get(bestPerimeter);
            if(peri%2==0){
                if(bestPerimeter==0){
                    out.println("coal");
                }else{
                    out.println(best[0] +  " x " + best[1] + " = " + bestPerimeter + " " + para + " squared.");
                }
            }else{
                out.println(best[0] +  " x " + best[1] + " = " + bestPerimeter + " " + para + " squared.");
            }
        }
        f.close();
    }
}
