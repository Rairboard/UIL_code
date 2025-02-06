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

public class spooky {
    public static void main(String[] args) throws Exception {
        new spooky().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("spooky").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
		while (f.hasNext()) {
			String ln = f.next().trim();
			long n = Long.parseLong(ln);
			int bad = 0;
			if (ln.matches(".*[49]")) {
				bad++;
			}
			if (Long.toString(n, 16).toUpperCase().contains("F13")) {
				bad++;
			}
			if(n% 17 ==0 || n % 39 == 0|| n % 43 == 0){
				bad++;
			}
			if (ln.contains("666")) {
				bad++;
			}
			out.print(ln+" ");
			if(bad>1){
				out.println("AAAA!");
			}
			else if(bad==1){
				out.println("BOO!");
			}
			else{
				out.println("Candy");
			}
		}
        f.close();
    }
}
