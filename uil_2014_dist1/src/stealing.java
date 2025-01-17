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

public class stealing {
    public static void main(String[] args) throws Exception {
        new stealing().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("stealing").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), m = f.nextInt(), t = f.nextInt();
            int minTime = n/m*t*2;
            n%=m;
            if (n > 0) {
                minTime+=t;
            }
            else if(n==0){
                minTime-=t;
            }
            out.println(minTime);
        }
        f.close();
    }
}
