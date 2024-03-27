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

public class spookynames {
    public static void main(String[] args) throws Exception {
        new spookynames().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("spookynames").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			String ln = f.nextLine();
			if (ln.matches("[JKSX].+")) {
				out.println("Stay away from the " + ln + " family.");
			} else if (ln.matches("[BHLR].+")) {
				out.println("Don't ask the " + ln + " family for too much candy.");
			}else{
				out.println("Tell The " + ln + " family I said hi!");
			}
        }
        f.close();
    }
}
