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

public class ugly {
    public static void main(String[] args) throws Exception {
        new ugly().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ugly").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int o = f.nextInt();
			double max = f.nextDouble();
			double l = 0, r = 0;
			boolean fall = false;
			out.println("Let's get decorating!");
			for (int i = 0; i < o; i++) {
				f.next();
				double m = f.nextDouble(), g = f.nextDouble();
				if (fall) {
					out.println("There's no use wasting ornaments on a fallen tree!");
					continue;
				}
				double w = m * 1.1 * Math.abs(g);
				if (g < 0) {
					l += w;
				}
				if (g == 0) {
					l += w / 2;
					r += w / 2;
				}
				if (g > 0) {
					r += w;
				}
				if(Math.abs(r-l)>max){
                    fall = true;
                    out.println("TIMBER!!!");
                    continue;
                }
                if(Math.abs(r-l) > max * 2.0 / 3.0){
                    if(r>l){
                        out.println("Looks a little tilted to the right...");
                    }
                    else if(r<l){
                        out.println("Looks a little tilted to the left...");
                    }
                }
                else{
                    out.println("It looks a little better I guess.");
                }
			}
			out.println("It's still really ugly.");
        }
        f.close();
    }
}
