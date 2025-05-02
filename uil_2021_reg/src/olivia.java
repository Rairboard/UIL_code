import javax.management.ValueExp;
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

public class olivia {
    public static void main(String[] args) throws Exception {
        new olivia().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("olivia").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            long row = f.nextLong(), col = f.nextLong(), k = f.nextLong();
            List<Long> factor = new ArrayList<>();
            for(long i = 1;i<=Math.sqrt(k);i++){
                if(k%i==0){
                    if(!factor.contains(i)) factor.add(i);
                    if(!factor.contains(k/i)) factor.add(k/i);
                }
            }
            factor.removeIf(e -> e > col || k/e > row);
            long total = 0;
            Collections.sort(factor);
//            out.println(factor);
            for (int i = 0; i < factor.size(); i++) {
                long r = k/factor.get(i);
                total+= r * factor.get(i);
                if(i>0){
                    total-=r* factor.get(i-1);
                }
            }
            out.println("Case #" + asdf + ": " + total);
        }
        f.close();
    }
}
