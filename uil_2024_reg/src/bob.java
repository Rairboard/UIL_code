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

public class bob {
    public static void main(String[] args) throws Exception {
        new bob().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bob").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int[] ar = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(ar);
			out.println((ar[0] * ar[1]) + ar[2] + (ar[3] * ar[4]));
        }
        f.close();
    }
}
