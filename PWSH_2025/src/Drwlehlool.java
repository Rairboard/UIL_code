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

public class Drwlehlool {
    public static void main(String[] args) throws Exception {
        new Drwlehlool().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("Drwlehlool").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim();
            if(ln.isEmpty()) out.println();
            int i = 0, j = ln.length()-1;
            String s = "";
            if(ln.length()%2==1){
                s = ln.charAt(ln.length()-1)+"";
                j--;
            }
            while(i<j){
                s = "" + ln.charAt(j) + ln.charAt(i) + s;
                i++;
                j--;
            }
            out.println(s);
        }
        f.close();
    }
}
