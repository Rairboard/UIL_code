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

public class cupcakeria {
    public static void main(String[] args) throws Exception {
        new cupcakeria().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cupcakeria").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
			f.next();
			out.printf("$%.2f\n",f.nextDouble() * 1.50);
        }
        f.close();
    }
}
