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

public class train {
    public static void main(String[] args) throws Exception {
        new train().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("train").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int pspeed = f.nextInt(), sd = f.nextInt();
            int trainspeed = f.nextInt(), traindis = f.nextInt();
            double petetime = (double)sd / pspeed, traintime = (double)traindis/trainspeed;
            out.println(petetime<traintime?"Yes":"No");
        }
        f.close();
    }
}
