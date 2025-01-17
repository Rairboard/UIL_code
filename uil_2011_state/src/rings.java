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

public class rings {
    public static void main(String[] args) throws Exception {
        new rings().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("rings").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String ln = f.nextLine();
			String clock = ln.replaceAll("B","1").replaceAll("W","0");
			int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
			for (int i = 0; i < clock.length(); i++) {
				String curClock = clock.substring(i) + clock.substring(0,i);
				int value = Integer.parseInt(curClock, 2);
				max = Math.max(value,max);
				min = Math.min(value, min);
			}
			clock = new StringBuilder(clock).reverse().toString();
			for (int i = 0;i < clock.length();i++) {
				String curClock = clock.substring(i) + clock.substring(0,i);
				int value = Integer.parseInt(curClock, 2);
				max = Math.max(value,max);
				min = Math.min(value, min);
			}
			clock = ln.replaceAll("B","0").replaceAll("W","1");
			for (int i = 0; i < clock.length(); i++) {
				String curClock = clock.substring(i) + clock.substring(0,i);
				int value = Integer.parseInt(curClock, 2);
				max = Math.max(value,max);
				min = Math.min(value, min);
			}
			clock = new StringBuilder(clock).reverse().toString();
			for (int i = 0;i < clock.length();i++) {
				String curClock = clock.substring(i) + clock.substring(0,i);
				int value = Integer.parseInt(curClock, 2);
				max = Math.max(value,max);
				min = Math.min(value, min);
			}
			out.println(min + " " + max);
        }
        f.close();
    }
}
