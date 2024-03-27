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

public class lisa {
    public static void main(String[] args) throws Exception {
        new lisa().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File(("lisa").toLowerCase() + ".dat"));
        //Scanner f = new Scanner(System.in);
        List<People> al = new ArrayList<>();
        int[] lim = new int[4];
        while(f.hasNext()){
            String ln = f.nextLine();
            int normal = 0;
            int upper = 0;
            int low = 0;
            for (int i = 0; i < ln.length(); i++) {
                if(i==0){
                    normal+=Character.toUpperCase(ln.charAt(i));
                    upper+=Character.toUpperCase(ln.charAt(i));
                    low+=Character.toLowerCase(ln.charAt(i));
                }
                else{
                    normal+=Character.toLowerCase(ln.charAt(i));
                    upper+=Character.toUpperCase(ln.charAt(i));
                    low+=Character.toLowerCase(ln.charAt(i));
                }
            }
            double average = (double)(normal+upper+low)/3/ln.length();
            al.add(new People(ln,normal,upper,low,average));
            lim[0] = Math.max(lim[0],Integer.toString(normal).length());
            lim[1] = Math.max(lim[1],Integer.toString(upper).length());
            lim[2] = Math.max(lim[2],Integer.toString(low).length());
            lim[3] = Math.max(lim[3],String.format("%.2f",average).length());
        }
        Collections.sort(al);
        for (int i = 0; i < al.size(); i++) {
            out.printf("%-10s%" + (lim[0]+1) + "d%" + (lim[1]+1) + "d%" + (lim[2]+1) + "d%" + (lim[3]+1) + ".2f\n",al.get(i).name,al.get(i).normal,al.get(i).up,al.get(i).low,al.get(i).avg);
        }
        f.close();
    }
    class People implements Comparable<People>{
        int normal,up,low;
        double avg;
        String name;
        public People(String n, int nor, int upper, int lower,double avg){
            name =n ;
            normal = nor;
            up = upper;
            low = lower;
            this.avg = avg;
        }
        public int compareTo(People o){
            return Double.compare(o.avg,avg);
        }
    }
}
