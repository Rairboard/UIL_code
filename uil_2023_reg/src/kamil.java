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

public class kamil {
    public static void main(String[] args) throws Exception {
        new kamil().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("kamil").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Map<String,String> tm =new TreeMap<>();
            String[] ln = f.nextLine().trim().split("\\s+");
            for (int i = 0; i < ln.length; i++) {
                tm.put(new StringBuilder(ln[i]).reverse().toString().toLowerCase(),ln[i]);
            }
            for(String s : tm.keySet()){
                out.print(tm.get(s)+" ");
            }
            out.println();
        }
        f.close();
    }
}
