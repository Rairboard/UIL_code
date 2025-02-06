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

public class renata {
    public static void main(String[] args) throws Exception {
        new renata().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("renata").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            f.nextLine();
            long[][] m = new long[n][n];
            for (int i = 0; i < n; i++) {
                m[i] = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
            }
            int s = f.nextInt();
            f.nextLine();
            long sum = 0;
            for (int i = 0; i < s; i++) {
                int r = f.nextInt()-1, c = f.nextInt()-1;
                if(r>=0&&c>=0&&r<m.length&&c<m[r].length) sum+=m[r][c];
            }
            out.println(asdf + ": " + sum);
        }
        f.close();
    }
}
