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

public class nap {
    public static void main(String[] args) throws Exception {
        new nap().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("nap").toLowerCase() + ".in"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        String bestRoom = "";
        int max = Integer.MAX_VALUE;
        while (times-- > 0) {
            String room = f.next();
            int field = f.next().replaceAll("z","").length();
            if(f.hasNext()){
                f.nextLine();
            }
            if(field< max){
                max = field;
                bestRoom = room;
            }
        }
        out.println(bestRoom);
        f.close();
    }
}
