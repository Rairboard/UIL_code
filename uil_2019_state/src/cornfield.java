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

public class cornfield {
    public static void main(String[] args) throws Exception {
        new cornfield().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cornfield").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int r = f.nextInt(), c = f.nextInt();
            f.nextLine();
            for (int i = 0; i < r; i++) {
                String ln = f.nextLine();
                if (ln.contains("@")) {
                    out.println("[" + i + "," + ln.indexOf("@") + "]");
                }
            }
        }
        f.close();
    }
}
