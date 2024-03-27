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

public class tiles {
    public static void main(String[] args) throws Exception {
        new tiles().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("tiles.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			double a = f.nextDouble() * f.nextDouble();
			a+=a*.1;
			out.println((int)a == a ? (int)a : (int)Math.ceil(a));
        }
        f.close();
    }
}
