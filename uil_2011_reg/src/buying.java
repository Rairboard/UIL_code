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

public class buying {
    public static void main(String[] args) throws Exception {
        new buying().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("buying").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("--");
            double oldgas = 2000 * 2.65;
            double newgas = 24000.0/Integer.parseInt(ln[1]) * 2.65;
            int pay =  Integer.parseInt(ln[2]) - 4500;
            out.printf("%s $%d $%.2f\n", ln[0], pay, Math.abs(newgas - oldgas));
        }
        f.close();
    }
}
