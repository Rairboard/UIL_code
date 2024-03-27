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

public class prob03 {
    public static void main(String[] args) throws Exception {
        new prob03().run();
    }

    public void run() throws Exception {
//        Scanner f = new Scanner(new File(("prob03").toLowerCase() + ".dat"));
        Scanner f = new Scanner(System.in);
        double radius = f.nextDouble() / Math.sqrt(2) * 2;
		out.printf("%.2f\n",radius * radius * PI);
        f.close();
    }
}
