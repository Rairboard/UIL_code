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

public class permutations {
    public static void main(String[] args) throws Exception {
        new permutations().run();
    }

    public void run() throws Exception {
        List<Long> fact = new ArrayList<>();
        fact.add((long)1);
        long i = 1;
        while(true){
            if(fact.getLast()>= Math.pow(10,9)) break;
            fact.add(i * fact.get(fact.size()-1));
            i++;
        }
//        out.println(fact);
        Scanner f = new Scanner(new File(("permutations").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String ln = f.nextLine().trim();
            Map<Character,Integer> cnt = new HashMap<>();
            for (int j = 0; j < ln.length(); j++) {
                cnt.put(ln.charAt(j),cnt.getOrDefault(ln.charAt(j),0)+1);
            }
            int max = 1;
            for(Character c : cnt.keySet()){
                max *=   fact.get(cnt.get(c));
            }
            out.println(fact.get(ln.length()) / max);
        }
        f.close();
    }
}
