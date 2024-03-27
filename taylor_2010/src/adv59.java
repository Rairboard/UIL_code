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

public class adv59 {
    public static void main(String[] args) throws Exception {
        new adv59().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("adv59").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int sum = f.nextInt() + f.nextInt();
			String a = Integer.toString(sum,2), b = Integer.toString(sum,8),c = Integer.toString(sum,16);
			int max = Math.max(a.length(),Math.max(b.length(),c.length()));
			out.printf("%" + max + "s\n%" + max + "s\n%" + max + "s\n",a,b,c);
        }
        f.close();
    }
}
