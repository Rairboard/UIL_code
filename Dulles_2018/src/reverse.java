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

public class reverse {
    public static void main(String[] args) throws Exception {
        new reverse().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("reverse.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String s = f.next();
            String part = s.substring(f.nextInt(),f.nextInt());
            out.println(s.replace(part,""));
        }
        f.close();
    }
}
