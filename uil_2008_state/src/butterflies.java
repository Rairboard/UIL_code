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

public class butterflies {
    public static void main(String[] args) throws Exception {
        new butterflies().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("butterflies").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        Map<String,Set<String>> m = new HashMap<>();
        while (times-- > 0) {
			String[] ln = f.nextLine().split("\\s*,\\s+");
            m.putIfAbsent(ln[1],new TreeSet<>());
            m.get(ln[1]).add(ln[0]);
        }
        times = f.nextInt();
        f.nextLine();
        for (int i = 0; i < times; i++) {
            String ln = f.nextLine();
            out.println(ln+":");
            for(String s : m.get(ln)){
                out.println(s);
            }
            out.println();
        }
        f.close();
    }
}
