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

public class joe {
    public static void main(String[] args) throws Exception {
        new joe().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("joe").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            Map<Integer,Set<String>> m = new TreeMap<>();
            String[] ln = f.nextLine().toLowerCase().replaceAll("[^a-z\\s+]","").split("\\s+");
            for (int i = 0; i < ln.length; i++) {
                m.putIfAbsent(ln[i].length(),new TreeSet<>());
                m.get(ln[i].length()).add(ln[i].toUpperCase());
            }
            for(Integer ll : m.keySet()){
                for(String s : m.get(ll)){
                    out.print(s + " ");
                }
            }
            out.println();
        }
        f.close();
    }
}
