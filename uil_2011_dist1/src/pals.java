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

public class pals {
    public static void main(String[] args) throws Exception {
        new pals().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("pals").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), d = f.nextInt();
            if(n%10==0){
                out.println(0);
                continue;
            }
            int m = (int)Math.pow(10,d-1) / n;
            if(n* m < Math.pow(10,d-1)) m++;
            int i = n * m;
            int cnt = 0;
            for(;i<Math.pow(10,d);i+=n){
                String ln = i+"";
                if(ln.equals(new StringBuilder(ln).reverse().toString())){
                    cnt++;
                }
            }
            out.println(cnt);
        }
        f.close();
    }
}
