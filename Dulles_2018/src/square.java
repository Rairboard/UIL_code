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

public class square {
    public static void main(String[] args) throws Exception {
        new square().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("square.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String s = f.nextLine();
            out.println(s);
            for (int i = 1; i < s.length()-1; i++) {
                out.println(s.charAt(i) + " ".repeat(s.length()-2) + s.charAt(s.length()-1-i));
            }
            out.println(new StringBuilder(s).reverse());
        }
        f.close();
    }
}
