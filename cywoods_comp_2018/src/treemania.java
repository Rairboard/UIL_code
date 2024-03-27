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

public class treemania {
    public static void main(String[] args) throws Exception {
        new treemania().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("treemania").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            out.println("Thank You " + f.nextLine() +"! I love trees.");
        }
        f.close();
    }
}
