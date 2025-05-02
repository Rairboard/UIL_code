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

public class blackhole {
    public static void main(String[] args) throws Exception {
        new blackhole().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("blackhole").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        long fuel = f.nextLong(), d = f.nextLong();
        List<String> al  =new ArrayList<>();
        out : for (int asdf = 0; asdf < 6; asdf++) {
            String s = f.next();
            String ln = f.nextLine().trim();
            long a = fuel, b = d;
            for (int i = 0; i < ln.length(); i++) {
                if (ln.substring(i, i + 1).matches("[1-9]")) {
                    int n = Integer.parseInt(ln.substring(i,i+1));
                    b+=n;
                    a-= n * 2L;
                }
                else if(ln.charAt(i)=='r'){
                    a+=3;
                    b-=4;
                }
                if(a<0||b<0){
                    continue out ;
                }
            }
            al.add(s);
        }
        out.println(al);
        if(al.isEmpty()) out.println("none");
        else out.println(al.get(0));
        f.close();
    }
}
