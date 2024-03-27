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

public class prob02 {
    public static void main(String[] args) throws Exception {
        new prob02().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("prob02").toLowerCase() + "-1-in.txt"));
        //Scanner f = new Scanner(System.in);
			double a =f.nextDouble(), b= f.nextDouble(), c = f.nextDouble();
			out.println((int)a + " " + (int)b + " " + (int)c + (b/c <= a ? ". I will make it!":". I will be late"));
        f.close();
    }
}
