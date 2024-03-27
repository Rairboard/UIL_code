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

public class seema {
    public static void main(String[] args) throws Exception {
        new seema().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("seema").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        String[] ln = f.nextLine().split(",");
		Map<Integer,Set<String>> m = new TreeMap<>(Collections.reverseOrder());
		Map<String,Integer> tm = new HashMap<>();
		for (int i = 0; i < ln.length; i++) {
			tm.put(ln[i],tm.getOrDefault(ln[i],0)+1);
		}
		for(String s : tm.keySet()){
			m.putIfAbsent(tm.get(s), new TreeSet<>());
			m.get(tm.get(s)).add(s);
		}
		for(Integer i : m.keySet()){
			for(String s : m.get(i)){
				out.println(s +" " + i);
			}
		}
        f.close();
    }
}
