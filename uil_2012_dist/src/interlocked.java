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

public class interlocked {
    public static void main(String[] args) throws Exception {
        new interlocked().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("interlocked").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String one = ".*", two = ".*";
            String[] ln = f.nextLine().split("\\s+");
            for (int i = 0; i < ln[0].length(); i++) {
                one+=ln[0].substring(i,i+1)+".*";
            }
            for (int i = 0; i < ln[1].length(); i++) {
                two+=ln[1].substring(i,i+1)+".*";
            }
            if (ln[ln.length - 1].matches(one) && ln[ln.length - 1].matches(two)) {
                out.println("YES");
            }
            else{
                out.println("NO");
            }
        }
        f.close();
    }
}
