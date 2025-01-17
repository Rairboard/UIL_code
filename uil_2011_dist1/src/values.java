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

public class values {
    public static void main(String[] args) throws Exception {
        new values().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("values").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        Map<Integer,List<String>> m = new TreeMap<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("\\s+");
            int sum = 0;
            for (int i = 0; i < ln.length; i++) {
                for (int j = 0; j < ln[i].length(); j++) {
                    sum+=ln[i].charAt(j) - 64;
                }
            }
            m.putIfAbsent(sum, new ArrayList<>());
            m.get(sum).add(String.join(" ",ln));
        }
        for(Integer sum : m.keySet()){
            Collections.sort(m.get(sum));
            for(String s : m.get(sum)){
                out.println(sum + " " + s);
            }
        }
        f.close();
    }
}
