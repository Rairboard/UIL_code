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

public class carol {
    public static void main(String[] args) throws Exception {
        new carol().run();
    }
    public void run() throws Exception {
        Scanner f = new Scanner(new File(("carol").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			String orig = f.nextLine();
			String ln = orig.toLowerCase();
			if (ln.equals(new StringBuilder(ln).reverse().toString())) {
				out.println("0 character(s) need to be added to convert "+ln+" into a palindrome.");
			}
			else{
				int max = Integer.MAX_VALUE;
				for (int i = 0; i < ln.length(); i++) {
					String a = new StringBuilder(ln.substring(0,i+1)).reverse().toString();
					String b = ln.substring(i);
					if (a.matches(b + ".+") || b.matches(a + ".*")) {
						max = Math.min(max,Math.abs(a.length()-b.length()));
					}
				}
				max  = Math.min(max,ln.length()-1);
				out.println(max + " character(s) need to be added to convert " + orig + " into a palindrome.");
			}
        }
        f.close();
    }
}
