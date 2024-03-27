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

public class boxes {
    public static void main(String[] args) throws Exception {
        new boxes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("boxes").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String s = f.nextLine();
            int big = s.replaceAll("[^B]","").length();
            int small = s.replaceAll("[^b]","").length();
            s = s.replaceAll("[Bb]","");
            s = "B".repeat(big) + s + "b".repeat(small);
            out.println(s);
        }
        f.close();
    }
}
