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

public class ricardo {
    public static void main(String[] args) throws Exception {
        new ricardo().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("ricardo").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().replaceAll("[()]","").split(",");
            out.print("Case #" +asdf + ": ");
            if(ln.length==0) out.println(0);
            else{
                long ans = 1;
                for (int i = 0; i < ln.length; i++) {
                    String[] option = ln[i].split("\\|");
                    if(option.length>0){
                        ans*=option.length;
                    }
                }
                out.println();
            }
        }
        f.close();
    }
}
