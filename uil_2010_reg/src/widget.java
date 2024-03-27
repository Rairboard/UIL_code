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

public class widget {
    public static void main(String[] args) throws Exception {
        new widget().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("widget").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int m = f.nextInt(), c = f.nextInt(), w = f.nextInt();
            int buy = m/c, have = buy, total = buy;
            while(have >= w){
                have-=w-1;
                total++;
            }
            out.println(total);
        }
        f.close();
    }
}
