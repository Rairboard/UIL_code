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

public class cho {
    public static void main(String[] args) throws Exception {
        new cho().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("cho").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim().replaceAll("[^A-Za-z]","");
            Map<Character,Integer> m = new HashMap<>();
            for (int i = 0; i < ln.length(); i++) {
                if (m.containsKey(ln.charAt(i))) {
                    m.put(ln.charAt(i), m.get(ln.charAt(i))+1);
                }
                else{
                    m.put(ln.charAt(i),1);
                }
            }
            Map<Integer,List<Character>> tm = new TreeMap<>(Collections.reverseOrder());
            for(Character c : m.keySet()){
                tm.putIfAbsent(m.get(c), new ArrayList<>());
                tm.get(m.get(c)).add(c);
            }
            List<List<Character>> list = new ArrayList<>(tm.values());
            List<Character> mostFrequent = list.get(0);
            Collections.sort(mostFrequent);
            out.println(mostFrequent.get(0));
        }
        f.close();
    }
}
