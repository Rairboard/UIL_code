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

public class charles {
    public static void main(String[] args) throws Exception {
        new charles().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("charles").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Set<Integer> hs = new TreeSet<>();
            int n = f.nextInt();
            for(int i = 1;i <= Math.sqrt(n);i++){
                if(n%i==0){
                    hs.add(i);
                    hs.add(n/i);
                }
            }
            int sum = 0;
            String ln = "";
            for(int i : hs){
                sum+=i;
                ln+=i+"+";
            }
            ln = ln.substring(0,ln.length()-1) + "=" + sum;
            out.println(ln);
        }
        f.close();
    }
}
