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

public class mostleast {
    public static void main(String[] args) throws Exception {
        new mostleast().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("mostleast").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            Map<String,Integer> w = new HashMap<>();
            Map<Integer,TreeSet<String>> m = new TreeMap<>();
            String[] ln = f.nextLine().split("[\\s.,?]");
            for (int i = 0; i < ln.length; i++) {
                if(!ln[i].isEmpty()){
                    w.put(ln[i],w.getOrDefault(ln[i],0)+1);
                }
            }
            for(String s : w.keySet()){
                m.putIfAbsent(w.get(s), new TreeSet<>());
                m.get(w.get(s)).add(s);
            }
            List<Integer> al = new ArrayList<>(m.keySet());
            List<String> low = new ArrayList<>(m.get(al.get(0)));
            List<String> high = new ArrayList<>(m.get(al.get(al.size()-1)));
            out.print(al.get(al.size()-1)+" ");
            for (int i = 0; i < high.size(); i++) {
                out.print(high.get(i)+" ");
            }
            out.println();
            out.print(al.get(0)+ " ");
            for (int i = 0; i < low.size(); i++) {
                out.print(low.get(i)+ " ");
            }
            out.println();
        }
        f.close();
    }
}
