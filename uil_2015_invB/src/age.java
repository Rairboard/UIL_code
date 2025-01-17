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

public class age {
    public static void main(String[] args) throws Exception {
        new age().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("age").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int a = f.nextInt(), b = f.nextInt(), m = f.nextInt();
			int c = a, d = b;
			boolean before = false;
			while (c > 0 && d > 0) {
				if ((double) d / c == m) {
					out.println(c + " " + d);
					before = true;
					break;
				}
				c--;
				d--;
			}
			if (!before) {
				boolean upper = false;
				while((double)b/a >= m){
					if((double)b/a==m){
						upper = true;
						out.println(a + " " + b);
						break;
					}
					b++;
					a++;
				}
				if(!upper) out.println("NEVER");
			}
		}
        f.close();
    }
}