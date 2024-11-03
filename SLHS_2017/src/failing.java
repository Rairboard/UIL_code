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

public class failing {
    public static void main(String[] args) throws Exception {
        new failing().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("failing").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String first = f.next(), last = f.next();
            long grade = f.nextLong();
            if(f.hasNext())f.nextLine();
            if(grade < 70){
                out.println(first + " " + last);
            }
        }
        f.close();
    }
}
