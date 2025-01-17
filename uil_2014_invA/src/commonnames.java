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

public class commonnames {
    public static void main(String[] args) throws Exception {
        new commonnames().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("commonnames").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String[] ln = f.nextLine().trim().split("\\s+");
            Map<String,Integer> m = new HashMap<>();
            for (int i = 0; i < ln.length; i++) {
                m.put(ln[i], m.getOrDefault(ln[i], 0) + 1);
            }
            List<String> al = new ArrayList<>();
            List<Integer> count = new ArrayList<>(m.values());
            Collections.sort(count);
            int max = count.getLast();
            for(String s : m.keySet()){
                if(m.get(s) == max){
                    al.add(s);
                }
            }
            Collections.sort(al);
            al.forEach(e -> out.print(e+" "));
            out.println();
        }
        f.close();
    }
}
