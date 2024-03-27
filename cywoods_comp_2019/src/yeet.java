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

public class yeet {
    public static void main(String[] args) throws Exception {
        new yeet().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("yeet").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int a = f.nextInt(), b = f.nextInt();
            int c = (int)Math.pow(a,b);
            int d = Integer.parseInt(b + "" + a);
            out.println(d + " " + (c ==d ? "Yeet":"Get Yate"));
        }
        f.close();
    }
}
