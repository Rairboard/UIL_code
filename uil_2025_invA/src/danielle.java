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

public class danielle {
    public static void main(String[] args) throws Exception {
        new danielle().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("danielle").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			long[] d = Arrays.stream(f.nextLine().trim().split(",")).mapToLong(Long::parseLong).toArray();
			long ans = 1;
            ans += d[0] - 1;
            ans += (d[1] - 2) * 9;
            ans += (d[2] - 3) * 72;
            ans += (d[3] - 4) * 504;
            out.println(ans);
        }
        f.close();
    }
}
