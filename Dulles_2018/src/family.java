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

public class family {
    Map<String,List<String>> m;
    public static void main(String[] args) throws Exception {
        new family().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("family.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        m = new HashMap<>();
        while (times-- > 0) {
            String a = f.next(), b = f.next(), c =f.next();
            m.putIfAbsent(a,new ArrayList<>());
            m.putIfAbsent(c,new ArrayList<>());
            m.get(a).add(c);
            m.get(c).add(a);
        }
        times = f.nextInt();
        while(times-->0){
            String a = f.next(), b = f.next();
            Set<String> v = new HashSet<>();
            boolean one = recur(a,b,v);
            boolean two = recur(b,a,v);
            out.println(one||two?"Related":"Not Related");
        }
        f.close();
    }
    public boolean recur(String cur,String goal,Set<String> visited){
        visited.add(cur);
        if(m.get(cur)==null) return false;
        if(m.get(cur).contains(goal)) return true;
        for(String people : m.get(cur)){
            if (!visited.contains(people)) {
                if (recur(people, goal, visited)) {
                    return true;
                }
            }
        }
        visited.remove(cur);
        return false;
    }
}
