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

public class coordinator {
    public static void main(String[] args) throws Exception {
//        out.println(1000000001 - Math.pow(10,9));
        new coordinator().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("coordinator").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            int n = f.nextInt(), m = f.nextInt();
            int[] room = new int[n];
            for (int i = 0; i < n; i++) {
                room[i] = f.nextInt();
            }
            Map<Integer,Integer> changes = new TreeMap<>();
            for (int i = 0; i < m; i++) {
                int s = f.nextInt(), e = f.nextInt(), g = f.nextInt();
//                out.println(s  +" "  + e + " "  + g);
                changes.putIfAbsent(s, 0);
                changes.put(s, changes.get(s) + g);
                changes.putIfAbsent(e, 0);
                changes.put(e, changes.get(e) - g);
            }
//            out.println(changes);
//            out.println(Arrays.toString(room));
            int current = 0, maxGuest = 0;
            for(Integer i : changes.keySet()){
                current += changes.get(i);
                maxGuest = Math.max(maxGuest, current);
            }
//            out.println(maxGuest);
            int minCap = (int)Math.pow(10,9);
            for (int i = 0; i < n; i++) {
                if(room[i] >= maxGuest){
                    minCap = Math.min(minCap, room[i]);
                }
            }
            TreeSet<Character> ts = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                if(room[i] == minCap){
                    ts.add((char)('A' + i));
                }
            }
            if(ts.isEmpty()){
                out.println("NOT POSSIBLE");
            }
            else{
                for(Character r : ts){
                    out.print(r + " " );
                }
                out.println();
            }
        }
        f.close();
    }
}
