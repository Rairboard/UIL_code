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

public class spring {
    public static void main(String[] args) throws Exception {
        new spring().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("spring").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            out.print(f.next());
            int t = f.nextInt();
            f.nextLine();
            double m = 0;
            for (int i = 0; i < t; i++) {
                String[] ln = f.nextLine().trim().split("\\s+");
                for (int j = 0; j < ln.length; j++) {
                    if(ln[j].charAt(0)=='P'){
                        m += .48*14 * Integer.parseInt(ln[j].substring(1));
                    }
                    else if(ln[j].charAt(0)=='T'){
                        m+= .45*15 * Integer.parseInt(ln[j].substring(1));
                    }
                    else if(ln[j].charAt(0)=='D'){
                        m+= Integer.parseInt(ln[j].substring(1));
                    }
                }
            }
            if(m>500){
                out.printf(" OVER $%.2f\n", m - 500);
            }
            else{
                out.printf(" $%.2f\n", 500-m);
            }
        }
        f.close();
    }
}
