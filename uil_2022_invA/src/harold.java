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

public class harold {
    public static void main(String[] args) throws Exception {
        new harold().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("harold").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
			int n = f.nextInt();
			out.print(n + "=");
			double conversion = n / Math.pow(10, ("" + n).length()-1);
			if(n == (int)conversion){
				out.println(n + "*10^" + ((n+"").length()-1));
			}
			else{
				out.println(conversion + "*10^" + ((n+"").length()-1));
			}
        }
        f.close();
    }
}
