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

public class costume {
    public static void main(String[] args) throws Exception {
        new costume().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("costume").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            Map<Integer,String> rank = new TreeMap<>(Collections.reverseOrder());
            int n = f.nextInt();
            f.nextLine();
            for (int i = 0; i < n; i++) {
                String name = f.nextLine().trim();
                int[] score = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int sum = 0;
                for (int j = 0; j < score.length; j++) {
                    sum+=score[j];
                }
                rank.put(sum, name);
            }
            int cnt = 1;
            for(Integer score : rank.keySet()){
                out.printf("%d. (%2d) - %s\n", cnt++, score, rank.get(score));
            }
            out.println("----------------");
        }
        f.close();
    }
}
