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

public class dilbert {
    public static void main(String[] args) throws Exception {
        new dilbert().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("dilbert").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int asdf = 1;
        while(f.hasNext()){
            long n = f.nextLong();
            String rev = new StringBuilder(Long.toString(n, 2)).reverse().toString();
            out.println("Test Case: " + asdf++ + ": " + Long.parseLong(rev, 2)+" " + rev.substring(rev.indexOf("1")));
        }
        f.close();
    }
}
