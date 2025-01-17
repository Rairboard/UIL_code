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

public class resources {
    public static void main(String[] args) throws Exception {
        new resources().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("resources").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int g = f.nextInt(), n = f.nextInt();
            int[] count = new int[86401];
            for (int i = 0; i < n; i++) {
                int m = f.nextInt(), s = f.nextInt(), d = f.nextInt();
                count[s]+=m;
                count[s+d]-=m;
            }
            int currentMax = 0, max = 0;
            for (int i = 0; i < count.length; i++) {
                currentMax += count[i];
                max = Math.max(max, currentMax);
            }
            if(max <= g) out.println("SUFFICIENT");
            else out.println("OUT OF MEMORY: " + max + "KB REQUESTED");
        }
        f.close();
    }
}
