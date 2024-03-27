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

public class Portmanteau {
    public static void main(String[] args) throws Exception {
        new Portmanteau().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Portmanteau").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String tgt = f.next();
            String a = f.next(), b = f.next();
            boolean solved = false;
            for (int i = 0; i < tgt.length(); i++) {
                String first = tgt.substring(0,i);
                String second = tgt.substring(i);
                if(a.contains(first) && b.contains(second)){
                    solved = true;
                    break;
                }
                if (a.contains(second) && b.contains(first)) {
                    solved = true;
                    break;
                }
            }
            out.println(solved?"YES":"NO");
        }
        f.close();
    }
}
