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

public class status {
    public static void main(String[] args) throws Exception {
        new status().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("status").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            long[] val = Arrays.stream(f.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
            int[] stat = new int[val.length];
            List<Num> al = new ArrayList<>();
            for (int i = 0; i < val.length; i++) {
                for (int j = 0; j < val.length; j++) {
                    if(i!=j&&val[j]<val[i]){
                       stat[i]++;
                    }
                }
                stat[i]+=i+1;
            }
            for (int i = 0; i < val.length; i++) {
                al.add(new Num(val[i],stat[i]));
            }
            Collections.sort(al);
            for (int i = 0; i < al.size(); i++) {
                out.print(al.get(i).number+" ");
            }
            out.println();
        }
        f.close();
    }
    class Num implements Comparable<Num>{
        long number;
        int status;
        public Num(long number,int status){
            this.number = number;
            this.status = status;
        }
        public int compareTo(Num o){
            if(status == o.status){
                return Long.compare(number,o.number);
            }
            return status - o.status;
        }
    }
}
