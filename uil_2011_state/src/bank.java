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

public class bank {
    public static void main(String[] args) throws Exception {
        new bank().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("bank").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        Map<Integer,Map<Integer, Double>> record= new TreeMap<>();
        int sy, ey, sm, em;
        while(f.hasNext()){
            String[] date = f.next().split("-");
            double change = f.nextDouble();
            int y = Integer.parseInt(date[0]);
            int M = Integer.parseInt(date[1]);
            record.putIfAbsent(y, new TreeMap<>());
            record.get(y).put(M, record.get(y).getOrDefault(M, 0.0) + change);
        }
        List<Integer> year = new ArrayList<>(record.keySet());
        sy = year.getFirst();
        ey = year.getLast();
        sm = new ArrayList<>(record.get(sy).keySet()).getFirst();
        em = new ArrayList<>(record.get(ey).keySet()).getLast();
        double balance = 0;
        for(int y = sy; y<= ey;y++){
            for(int m = (y == sy ? sm: 1); m <= (y == ey ? em : 12);m++){
                balance *= 1.02;
                if (record.containsKey(y) && record.get(y).containsKey(m)) {
                    balance += record.get(y).get(m);
                }
            }
        }
        out.println("$" + (balance - balance%.01));
        f.close();
    }
}
