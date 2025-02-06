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

public class carolina {
    public static void main(String[] args) throws Exception {
        new carolina().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("carolina").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
			double p = f.nextDouble();
			String name = f.nextLine().trim();
			out.printf("$%.2f  + $%.2f = $%.2f %s\n", p, p * .0825, p * 1.0825, name);
		}
        f.close();
    }
}
