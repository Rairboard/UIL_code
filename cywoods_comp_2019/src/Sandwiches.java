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

public class Sandwiches {
    String[] ingre = "bread meat cheese".split(" ");
    public static void main(String[] args) throws Exception {
        new Sandwiches().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Sandwiches").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        Map<String,Stack<String>> m = new LinkedHashMap<>();
        for (int i = 0; i < ingre.length; i++) {
            m.put(ingre[i],new Stack<>());
        }
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            String[] ln = f.nextLine().split("-");
            m.get(ln[1]).push(ln[0]);
        }
        int min = Integer.MAX_VALUE;
        for(String p : m.keySet()){
            min = Math.min(min,m.get(p).size());
        }
        for (int i = 0; i < min; i++) {
            String ln = "";
            for (int j = 0; j < ingre.length; j++) {
                ln+=m.get(ingre[j]).pop()+", ";
            }
            out.println(ln.substring(0,ln.length()-2));
        }
        f.close();
    }
}
