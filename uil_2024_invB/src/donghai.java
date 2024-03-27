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

public class donghai {
    public static void main(String[] args) throws Exception {
        new donghai().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("donghai").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().replaceAll("[^a-zA-Z]","");
            Map<String,Integer> m = new TreeMap<>();
            for (int i = 0; i < ln.length(); i++) {
                m.putIfAbsent(ln.substring(i,i+1).toUpperCase(),0);
                m.put(ln.substring(i,i+1).toUpperCase(),m.get(ln.substring(i,i+1).toUpperCase()) + 1);
            }
            for(String ss : m.keySet()){
                out.println(ss + ":" + m.get(ss));
            }
            out.println("=".repeat(10));
        }
        f.close();
    }
}
