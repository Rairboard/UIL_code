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

public class fantasy {
    public static void main(String[] args) throws Exception {
        new fantasy().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("fantasy").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for (int asdf = 1; asdf <= times; asdf++) {
            List<Participant> al = new ArrayList<>();
            double[] stat = new double[11];
            String a = f.next(), b = f.next();
            int n = f.nextInt();
            f.nextLine();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 11; j++) {
                    stat[j] += f.nextInt();
                }
            }
            if(stat[1] == 0){
                stat[0] = 0;
            }
            else{
                stat[0]/=stat[1];
            }
            if(stat[3]==0){
                stat[2] =0;
            }
            else{
                stat[2]/=stat[3];
            }
            al.add(new Participant(stat,a));
            stat = new double[11];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 11; j++) {
                    stat[j] += f.nextInt();
                }
            }
            if(stat[1] == 0){
                stat[0] = 0;
            }
            else{
                stat[0]/=stat[1];
            }
            if(stat[3]==0){
                stat[2] =0;
            }
            else{
                stat[2]/=stat[3];
            }
            al.add(new Participant(stat, b));
            Collections.sort(al);
            if(al.getFirst().tie && al.getLast().tie){
                out.println("Tie.");
            }
            else{
                out.println(al.getFirst().name  +" wins!");
            }
        }
        f.close();
    }
    class Participant implements Comparable<Participant>{
        double[] stat;
        String name;
        boolean tie;
        public Participant(double[] st, String n){
            stat = st;
            name = n;
            tie = false;
        }
        public int compareTo(Participant o){
            int a =0, b = 0;
            for (int i = 0; i < stat.length; i++) {
                if(i==1 || i == 3) continue;
                if(i==stat.length-1){
                    if(stat[i] < o.stat[i]){
                        a++;
                    }
                    else if(o.stat[i] < stat[i]){
                        b++;
                    }
                }
                else{
                    if(stat[i] > o.stat[i]){
                        a++;
                    }
                    else if(o.stat[i] > stat[i]){
                        b++;
                    }
                }
            }
            if(a==b) {
                tie = true;
                o.tie = true;
            }
            return b-a;
        }
    }
}
