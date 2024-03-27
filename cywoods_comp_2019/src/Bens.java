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

public class Bens {
    public static void main(String[] args) throws Exception {
        new Bens().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("Bens").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        while (times-- > 0) {
            int n = f.nextInt();
            f.nextLine();
            Set<Ben>s = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                String[] ln = f.nextLine().split(" ");
                String name = ln[0] + " " + ln[1];
                double ap = Double.parseDouble(ln[2]);
                long vocal = Long.parseLong(ln[4]) - Long.parseLong(ln[3]);
                double femur = Double.parseDouble(ln[5]);
                s.add(new Ben(name,ap,vocal,femur));
            }
            List<Ben> al = new ArrayList<>(s);
            Collections.reverse(al);
            String ln = "";
            for(int i=0;i<al.size();i++){
                ln+=al.get(i).n;
                if(i<al.size()-1){
                    ln+=", ";
                }
            }
            out.println(ln);
        }
        f.close();
    }
    class Ben implements Comparable<Ben>{
        String n;
        double ap,femur;
        long vocal;
        public Ben(String name, double ap, long vocal, double femur){
            n = name;
            this.ap = ap;
            this.vocal = vocal;
            this.femur = femur;
        }
        public int compareTo(Ben o){
            if(o.ap!=ap){
                return ap < o.ap ? 1 : -1;
            }
            if(vocal!=o.vocal){
                return vocal < o.vocal? 1 : -1;
            }
            return  femur < o.femur ? 1 : -1;
        }
    }
}
