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

public class multiple {
    public static void main(String[] args) throws Exception {
        new multiple().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("multiple").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            long n = f.nextLong(), fact = 2;
            String s = f.next();
            while(true){
                long num = n * fact;
                int tmp = s.replaceAll("[" + num+"]","").length();
                if(tmp==s.length()){
                    out.println(num);
                    break;
                }
                fact++;
            }
        }
        f.close();
    }
}
