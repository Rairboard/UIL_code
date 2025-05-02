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

public class hulin {
    public static void main(String[] args) throws Exception {
        new hulin().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("hulin").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        int maxPeople = 0;
        Map<Integer,Integer> m = new TreeMap<>();
        for (int asdf = 1; asdf <= times; asdf++) {
            for (int i = 0; i < 3; i++) {
                int a = f.nextInt(), b = f.nextInt();
                m.put(a,m.getOrDefault(a,0)+1);
                m.put(b+1,m.getOrDefault(b+1,0)-1);
            }
            int cur = 0;
            for(Integer t : m.keySet()){
                cur+=m.get(t);
                maxPeople = Math.max(maxPeople, cur);
            }
        }
        out.println(maxPeople);
        f.close();
    }
}
