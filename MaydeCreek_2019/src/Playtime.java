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

public class Playtime {
    public static void main(String[] args) throws Exception {
        new Playtime().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Playtime").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] l = f.nextLine().split(",");
            String name = l[0];
            long min = Long.parseLong(l[1]);
            long[] time = new long[4];
            String[] s = {"year(s)","day(s)","hour(s)","minute(s)"};
            time[3] = min;
            time[2] = time[3]/60;
            time[3]%=60;
            time[1] = time[2]/24;
            time[2]%=24;
            time[0] = time[1]/365;
            time[1]%=365;
            out.print(name + " - ");
            for (int i = 0; i < 4; i++) {
                if(time[i]>0){
                    out.print(time[i] + " " + s[i] + " ");
                }
            }
            out.println();
        }
        f.close();
    }
}
