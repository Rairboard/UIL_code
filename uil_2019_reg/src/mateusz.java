import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class mateusz {
    public static void main(String[] args) throws Exception {
       
//        new mateusz().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mateusz").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt() ;
            for (int i = 0; i < n; i++) {
                int x = f.nextInt(), y = f.nextInt(), w = f.nextInt(), h = f.nextInt();
                Rectangle2D r = new Rectangle(x,y,w,h);

            }
        }
        f.close();
    }
}
