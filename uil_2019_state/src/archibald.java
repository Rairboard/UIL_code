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

public class archibald {
    public static void main(String[] args) throws Exception {
        new archibald().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("archibald").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    out.print("@");
                }
                out.println();
            }
            out.println();
        }
        f.close();
    }
}
