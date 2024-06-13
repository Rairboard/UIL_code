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

public class isha {
	int[][] time = {{0,119,173,263,0},{119,0,125,0,0},{173,125,0,130,131},{263,0,130,0,89},{0,0,131,89,0}};
    public static void main(String[] args) throws Exception {
        new isha().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("isha").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {

        }
        f.close();
    }
}
