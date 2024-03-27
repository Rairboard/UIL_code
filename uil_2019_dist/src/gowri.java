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

public class gowri {
    public static void main(String[] args) throws Exception {
        new gowri().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("gowri").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int star = f.nextInt(), space = star;
            out.println(" ".repeat(4)+"*".repeat(star));
            for (int i = 0; i < 3; i++) {
                out.println(" ".repeat(3-i)+"*"+" ".repeat(space)+"*");
                space+=2;
            }
            for (int i = 0; i < star; i++) {
                out.println("*"+" ".repeat(space)+"*");
            }
            for (int i = 0; i < 3; i++) {
                space-=2;
                out.println(" ".repeat(i+1)+"*"+" ".repeat(space)+"*");
            }
            out.println(" ".repeat(4)+"*".repeat(star));
            out.println("-".repeat(20));
        }
        f.close();
    }
}
