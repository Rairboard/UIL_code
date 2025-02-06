import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.*;
import java.math.*;
import java.util.Arrays;
import java.time.*;
import java.time.temporal.*;

import static java.lang.System.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Math.*;

public class grading {
    public static void main(String[] args) throws Exception {
        new grading().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("grading").toLowerCase() + ".dat"));
//        Scanner f = new Scanner(System.in);
        Map<String,List<Double>> m = new HashMap<>();
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            String key = f.next().trim();
            int n = f.nextInt();
            f.nextLine();
            for (int i = 0; i < n; i++) {
                String name = f.next().trim();
                String ans = f.next().trim();
                f.nextLine();
                m.putIfAbsent(name, new ArrayList<>());
                double score = 0;
                for (int j = 0; j < ans.length(); j++) {
                    if (ans.charAt(j) == key.charAt(j)) {
                        score++;
                    }
                }
                score/=key.length();
                m.get(name).add(score*100);
            }
        }
        Map<Double,String> rank = new TreeMap<>(Collections.reverseOrder());
        for(String name : m.keySet()){
            double sum = 0;
            for(Double d : m.get(name)){
                sum+=d;
            }
            sum/=m.get(name).size();
            sum*=100;
            rank.put(sum, name);
        }
        int cnt = 1;
        for(Double score : rank.keySet()){
            out.printf("#%d: %s,", cnt++, rank.get(score));
            Collections.sort(m.get(rank.get(score)));
            Collections.reverse(m.get(rank.get(score)));
            for(Double d : m.get(rank.get(score))){
                out.printf(" %.2f", d);
            }
            out.println();
        }
        f.close();
    }
}
