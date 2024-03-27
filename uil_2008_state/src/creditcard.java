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

public class creditcard {
    public static void main(String[] args) throws Exception {
        new creditcard().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("creditcard").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] ln = f.nextLine().split("");
            for (int i = 0; i < ln.length-1; i+=2) {
                int n = Integer.parseInt(ln[i]);
                n*=2;
                if(n>=10){
                    ln[i] = n % 10 + n / 10 + "";
                }
                else{
                    ln[i] = n+"";
                }
            }
            long sum = 0;
            for (int i = 0; i < ln.length; i++) {
                sum+=Long.parseLong(ln[i]);
            }
            out.println(sum%10==0?"VALID":"INVALID");
        }
        f.close();
    }
}
