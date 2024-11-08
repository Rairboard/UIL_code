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

public class damian {
    public static void main(String[] args) throws Exception {
        new damian().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("damian").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long n = f.nextLong();
            List<Long> factor = new ArrayList<>();
//            out.print(n+" ");
            for(long i = 1;i <= Math.sqrt(n);i++){
                long otherFactor = n/i;
                if(otherFactor * i == n){
                    factor.add(i);
                    factor.add(otherFactor);

                }
            }
//            out.println(factor);
            Set<Long> ts = new TreeSet<>();
            for (int i = 0; i < factor.size(); i++) {
                boolean good = true;
                String ln = Long.toString(factor.get(i));
                for (int j = 1; j < ln.length(); j++) {
                    if(ln.charAt(j) - ln.charAt(j-1) <= 0){
                        good = false;
                        break;
                    }
                }
                if(good){
                    ts.add(factor.get(i));
                }
            }
            ts.forEach(e -> out.print(e+" "));
            out.println();
        }
        f.close();
    }
}
