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

public class galacticspeedlimit {
    public static void main(String[] args) throws Exception {
        new galacticspeedlimit().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("galacticspeedlimit").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("\\s+");
            for (int i = 0; i < ln.length; i++) {
                int n = Integer.parseInt(ln[i]);
                if(n>=10&&n<=100) out.print("safe ");
                else out.print("unsafe ");
            }
            out.println();
        }
        f.close();
    }
}
