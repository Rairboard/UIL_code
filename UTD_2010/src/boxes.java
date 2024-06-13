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

public class boxes {
    public static void main(String[] args) throws Exception {
        new boxes().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("boxes").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int b = f.nextInt();
			f.nextLine();
			long max = 0, min = Long.MAX_VALUE, sum = 0;
			for (int i = 0; i < b; i++) {
				long vol = f.nextLong() * f.nextLong() * f.nextLong();
				max = Math.max(vol,max);
				min = Math.min(vol,min);
				sum+=vol;
			}
			out.println("Box Set " + asdf);
			out.println(sum+"\n" + max + ", " + min);
        }
        f.close();
    }
}
