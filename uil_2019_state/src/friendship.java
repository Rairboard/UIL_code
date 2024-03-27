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

public class friendship {
    public static void main(String[] args) throws Exception {
        new friendship().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("friendship").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < 5; i++) {
				max = Math.max(max,f.nextInt());
			}
			out.println(max);
        }
        f.close();
    }
}
