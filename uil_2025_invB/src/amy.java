import com.sun.source.tree.Tree;

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

public class amy {
    public static void main(String[] args) throws Exception {
        new amy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("amy").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            out.println(BigInteger.valueOf(36).pow(f.next().length()).divide(f.nextBigInteger()));
        }
        f.close();
    }
}
