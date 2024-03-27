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

public class ramiro {
    public static void main(String[] args) throws Exception {
        new ramiro().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ramiro").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String a = f.next(), b = f.next();
            String x =Long.toBinaryString(Long.parseLong(a,16));
            String y = Long.toBinaryString(Long.parseLong(b,16));
            int max = Math.max(x.length(),y.length());
            while(x.length()<max){
                x = "0" + x;
            }
            while(y.length()<max){
                y = "0" + y;
            }
            int cnt = 0;
            for (int i = 0; i < x.length() && i < y.length(); i++) {
                if(x.charAt(i)!=y.charAt(i)){
                    cnt++;
                }
            }
            out.println(cnt);
        }
        f.close();
    }
}
