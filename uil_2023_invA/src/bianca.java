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

public class bianca {
    public static void main(String[] args) throws Exception {
        new bianca().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bianca").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            out.printf("%.2f\n", Math.sqrt(Math.pow(f.nextDouble(),2) + Math.pow(f.nextDouble(),2)));
        }
        f.close();
    }
}
