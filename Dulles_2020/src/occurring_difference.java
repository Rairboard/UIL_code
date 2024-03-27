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

public class occurring_difference {
    public static void main(String[] args) throws Exception {
        new occurring_difference().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("occurring_difference.dat"));
        //Scanner f = new Scanner(System.in);
        while(f.hasNext()){
            Map<Integer,Integer> m = new HashMap<>();
            Map<Integer,Integer> tm = new TreeMap<>();
            int max  = 0, min = Integer.MIN_VALUE;
            String[] l = f.nextLine().split("\\s+");
            for (int i = 0; i < l.length; i++) {
                int N = Integer.parseInt(l[i]);
                m.put(N,m.getOrDefault(N,0)+1);
            }
            Set<Num> s = new TreeSet<>();
            for(Integer i : m.keySet()){
                s.add(new Num(i,m.get(i)));
            }
            List<Num> al =new ArrayList<>(s);
            out.println("The difference is " +Math.abs(al.get(al.size()-1).N - al.get(0).N));
        }
        f.close();
    }
    class Num implements Comparable<Num>{
        int occur, N;
        public Num(int n , int o){
            N = n;
            occur = o;
        }
        public int compareTo(Num o){
            return occur > o.occur? 1 : -1;
        }
    }
}
