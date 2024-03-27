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

public class bautista {
    public static void main(String[] args) throws Exception {
        new bautista().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bautista").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String ln = f.nextLine().toLowerCase();
            for (int i = 0; i < ln.length(); i++) {
                if(ln.substring(i,i+1).matches("[aeiou]")){
                    out.print("OUCH!!!");
                }else{
                    out.print(ln.substring(i,i+1));
                }
            }
            out.println();
        }
        f.close();
    }
}
