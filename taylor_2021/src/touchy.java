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

public class touchy {
    public static void main(String[] args) throws Exception {
        new touchy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("touchy.dat"));
        //Scanner f = new Scanner(System.in);
		String power = "0123";
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			int init = f.nextInt(),t = f.nextInt() % 4;
			int in = (power.indexOf(""+init) + t) %power.length();
			out.println(power.charAt(in));
        }
        f.close();
    }
}
