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

public class empire {
    public static void main(String[] args) throws Exception {
        new empire().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("empire").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String[] ln = f.nextLine().split("\\s+");
			int n = Integer.parseInt(ln[0]);
			String s = f.nextLine();
			for (int i = 0; i < n; i++) {
				out.println(s);
				out.println("The Empire Loves the Citizens of " + ln[1] + "!");
			}
			out.println();
        }
        f.close();
    }
}
