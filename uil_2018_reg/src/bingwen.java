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

public class bingwen {
    public static void main(String[] args) throws Exception {
        new bingwen().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bingwen").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            out.printf("%.2f\n",Math.cbrt(f.nextDouble()));
        }
        f.close();
    }
}
