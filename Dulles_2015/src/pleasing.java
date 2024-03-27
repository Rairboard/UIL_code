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

public class pleasing {
    public static void main(String[] args) throws Exception {
        new pleasing().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("pleasing.in"));
//        Scanner f = new Scanner(System.in);
        List<String> word = new ArrayList<>();
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            word.add(f.nextLine());
        }
        times = f.nextInt();
        f.nextLine();
        while(times-->0){
            boolean solved = false;
            String st = f.nextLine();
            Set<String> ss = new TreeSet<>();
            for (int i = 0; i < word.size(); i++) {
                if (matched(st,word.get(i))) {
                    ss.add(word.get(i));
                    solved = true;
                }
            }
            if(solved){
                for(String s : ss){
                    out.print(s + " ");
                }
                out.println();
            }else{
                out.println("unsolvable");
            }
        }
        f.close();
    }
    public boolean matched(String a, String b){
        Map<String,Integer> m = new HashMap<>();
        Map<String,Integer> hm = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            m.putIfAbsent(a.substring(i,i+1),0);
            m.put(a.substring(i,i+1),m.get(a.substring(i,i+1))+1);
        }
        for (int i = 0; i < b.length(); i++) {
            hm.putIfAbsent(b.substring(i,i+1),0);
            hm.put(b.substring(i,i+1),hm.get(b.substring(i,i+1))+1);
        }
        List<Integer> c = new ArrayList<>(m.values()), d = new ArrayList<>(m.values());
        if(m.size()!=hm.size()) return false;
        if(!m.keySet().equals(hm.keySet())) return false;
        for(String s : m.keySet()){
            if(hm.get(s)!=m.get(s))
                return false;
        }
        return true;
    }
}
